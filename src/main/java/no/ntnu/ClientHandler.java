package no.ntnu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {
  private Socket socket;
  private BufferedReader reader;
  private PrintWriter writer;

  public ClientHandler(Socket socket) throws IOException {
    this.socket = socket;
    this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    this.writer = new PrintWriter(socket.getOutputStream(), true);
  }

  @Override
  public void run() {
    String message = null;
    try {
      message = this.reader.readLine();
    } catch (IOException e) {
      System.out.println("Failed to receive message: " + e.getMessage());
    }
  }
}

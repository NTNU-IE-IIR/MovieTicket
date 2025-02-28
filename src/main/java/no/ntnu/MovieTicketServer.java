package no.ntnu;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MovieTicketServer extends Thread {
  public static final int TCP_PORT = 1238;
  private boolean isRunning;

  public static void main(String[] args) {
  }

  public MovieTicketServer(String name, int tickets) {
    try (ServerSocket serverSocket = new ServerSocket(TCP_PORT)) {
      isRunning = true;
      while (isRunning) {
        Socket socket = serverSocket.accept();
        ClientHandler clientHandler = new ClientHandler(socket);
        try {
          clientHandler.start();
        } catch (IllegalThreadStateException e) {
          System.out.println("Failed to start the client handler: " + e.getMessage());
        }
      }
    } catch (IOException e) {
      System.out.println("Could not start the server.");
      e.printStackTrace();
    }
  }
}
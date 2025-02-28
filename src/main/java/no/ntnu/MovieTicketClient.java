package no.ntnu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MovieTicketClient extends Thread {
  private int availableTickets;
  private int ticketsToBook;
  private MovieTicketServer movieTicketServer;
  private String nameOfClient;

  public MovieTicketClient(MovieTicketServer movieTicketServer, String name, int numberOfTickets)  {
    this.movieTicketServer = movieTicketServer;
    this.ticketsToBook = numberOfTickets;
    this.nameOfClient = name;
  }

  @Override
  public void run() {
    movieTicketServer.bookTicket(ticketsToBook);
  }
}






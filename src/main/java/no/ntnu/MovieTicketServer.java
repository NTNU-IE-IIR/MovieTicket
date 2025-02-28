package no.ntnu;

public class MovieTicketServer extends Thread {
  private int availableTickets;
  private String movieName;

  public static void main(String[] args) {
  }

  public MovieTicketServer(String movieName, int tickets) {
    this.movieName = movieName;
    this.availableTickets = tickets;
  }

  public synchronized void bookTicket(int ticketsToBook) {
    if (this.availableTickets >= ticketsToBook) {
      availableTickets -= ticketsToBook;
      System.out.println(ticketsToBook + " tickets booked. Remaining tickets: " + availableTickets);
    } else {
      System.out.println("Not enough available tickets.");
    }
  }
}
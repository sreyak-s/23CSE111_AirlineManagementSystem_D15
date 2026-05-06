package com.airline.model.booking;
import com.airline.model.user.*;
import com.airline.model.flight.*;
import com.airline.model.payment.*;
public class Ticket {
    private Passenger passenger;
    private String PNR;
    private String ticketNumber;
    private String ticketStatus;
    private String flightid;
    private Payment payment;
    private double fare;
    public Ticket(Passenger passenger, String flightid, String ticketStatus, Payment payment, double fare) {
        this.passenger = passenger;
        this.flightid = flightid;
        this.ticketStatus = ticketStatus;
        this.payment = payment;
        this.fare=fare;
    }
    public void saveTicketToFile() {
        System.out.println("Saving tickets...");
    }
}
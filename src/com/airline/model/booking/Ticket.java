package com.airline.model.booking;
import java.io.FileWriter;
import java.io.IOException;
import com.airline.model.user.*;
import com.airline.model.flight.*;
import com.airline.model.payment.*;
public class Ticket {
    private Passenger passenger;
    private String PNR;
    private String ticketNumber;
    private String ticketStatus;
    private Flight flight;
    private Payment payment;
    public Ticket(Passenger passenger, Flight flight, String PNR,
                  String ticketNumber, String ticketStatus, Payment payment) {
        this.passenger = passenger;
        this.flight = flight;
        this.PNR = PNR;
        this.ticketNumber = ticketNumber;
        this.ticketStatus = ticketStatus;
        this.payment = payment;
    }
    public void saveTicketToFile() {
        
    }
}
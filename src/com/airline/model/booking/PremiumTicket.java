package com.airline.model.booking;

import com.airline.model.user.*;
import com.airline.model.flight.*;
import com.airline.model.payment.*;

public class PremiumTicket extends Ticket {
    private double extraCharge;
    public PremiumTicket(Passenger passenger, String flightid, String ticketStatus, Payment payment, double fare, double extraCharge) {
        super(passenger, flightid, ticketStatus, payment, fare);
        this.extraCharge = extraCharge;
    }
    public double getTotalFare(double baseFare) {
        return baseFare + extraCharge;
    }
    public void showPremiumDetails() {
        System.out.println("Premium Ticket Booked!");
        System.out.println("Extra Charge: " + extraCharge);
    }
    @Override
    public void saveTicketToFile() {
        System.out.println("Saving premium ticket with extra benefits...");
    }
}
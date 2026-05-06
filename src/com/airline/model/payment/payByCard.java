package com.airline.model.payment;

public interface payByCard {
    void payByCard(String cardNumber, String cardHolderName, String expiryDate, int cvv);
}


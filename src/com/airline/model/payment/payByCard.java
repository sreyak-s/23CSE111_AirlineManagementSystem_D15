package com.airline.model.payment;

public interface payByCard {
    void paybycard(String cardNumber, String cardHolderName, String expiryDate, int cvv);
}


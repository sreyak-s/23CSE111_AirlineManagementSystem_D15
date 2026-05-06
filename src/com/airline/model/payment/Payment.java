package com.airline.model.payment;
import java.util.Scanner;
public class Payment implements payByCard, payByUPI, payByNetBanking {
    private String paymentID;
    private String transactionID;
    private String sourceID;
    private double amount;
    private String paymentMethod;
    private String paymentStatus = "Pending";
    public Payment(double amount) {
        this.amount = amount;
    }
    public void payByCard(String cardNumber, String cardHolderName, String expiryDate, int cvv) {
        System.out.println("Processing card payment...");
        paymentMethod = "CARD";
        sourceID = cardNumber;
        paymentStatus = "Completed";
    }
    public void payByUPI(String upiID) {
        System.out.println("Processing UPI payment...");
        paymentMethod = "UPI";
        sourceID = upiID;
        paymentStatus = "Completed";
    }
    public void payByNetBanking(String bankName, String userID, String password) {
        System.out.println("Processing Net Banking payment...");
        paymentMethod = "Net Banking";
        sourceID = userID + "/" + bankName;
        paymentStatus = "Completed";
    }
    public String getPaymentStatus() {
        return paymentStatus;
    }
    public int process() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Credit/Debit");
        System.out.println("2. UPI");
        System.out.println("3. NetBanking");
        System.out.println("Choose your payment method 1-3");
        int ch = sc.nextInt();
        sc.nextLine();
        if (ch == 1) {
            System.out.println("Enter cardNumber:");
            String cardNumber = sc.nextLine();
            System.out.println("Enter card holder name:");
            String cardHolderName = sc.nextLine();
            System.out.println("Enter expiry date:");
            String expiryDate = sc.nextLine();
            System.out.println("Enter CVV:");
            int cvv = sc.nextInt();
            sc.nextLine();
            payByCard(cardNumber, cardHolderName, expiryDate, cvv);
        }
        else if (ch == 2) {
            System.out.println("Enter UPI ID:");
            String upiID = sc.nextLine();
            payByUPI(upiID);
        }
        else if (ch == 3) {
            System.out.println("Enter Bank Name:");
            String bankName = sc.nextLine();
            System.out.println("Enter User ID:");
            String userID = sc.nextLine();
            System.out.println("Enter Password:");
            String password = sc.nextLine();
            payByNetBanking(bankName, userID, password);
        }
        else {
            System.out.println("Invalid choice.");
            return 0;
        }
        System.out.println("Payment of amount " + amount + " via " + paymentMethod + " successful.");
        return 1;
    }
}
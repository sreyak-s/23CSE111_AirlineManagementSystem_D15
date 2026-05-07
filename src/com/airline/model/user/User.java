package com.airline.model.user;
import com.airline.model.booking.*;
import com.airline.model.admin.*;
import com.airline.model.payment.*;
import java.util.Scanner;
import java.io.*;
import com.airline.util.*;
public class User {
	public boolean createAccount() {
		String filepath = "src/database/passengerdata.csv";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your username: ");
		String username = sc.nextLine();
		while(true) {
			try {
				File userData = new File(filepath);
				Scanner users = new Scanner(userData);
				String data = "";
				boolean exists = false;
				while(users.hasNextLine()) {
				    data = users.nextLine();
				    String username1 = data.substring(0, data.indexOf(","));
				    if(username1.equals(username)) {
				        exists = true;
				        break;
				    }
				}
				if(exists) {
				    System.out.println("Username already taken. Try again.");
				    continue;
				}
				else {
				    FileWriter writer = new FileWriter(filepath, true);
				    System.out.println("Enter the password: ");
				    String password = sc.nextLine();
				    PassCheck passcheck = new PassCheck();
				    while(!passcheck.passvalid(password)) {
				        System.out.println("Invalid Password. Enter password again: ");
				        password = sc.nextLine();
				    }
				    System.out.println("Enter name: ");
				    String name = sc.nextLine();
				    System.out.println("Enter phone: ");
				    String phone = sc.nextLine();
				    System.out.println("Enter email: ");
				    String email = sc.nextLine();
				    writer.write(username+","+password+","+name+","+phone+","+email+"\n");
				    writer.close();
				    return true;
				}
			}
			catch(IOException ioe) {
				System.out.println("Error in Admin Database: "+ioe.getMessage());
			}
		}
	}
	public boolean authenticateUser() {
		String filepath = "src/database/passengerdata.csv";
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your username: ");
		String username = sc.nextLine();
		System.out.println("Enter your password: ");
		String password = sc.nextLine();
		try {
			File adminData = new File(filepath);
			Scanner admins = new Scanner(adminData);
			String data = "";
			while(admins.hasNextLine()) {
				data = admins.nextLine();
				String username1=data.substring(0,data.indexOf(","));
				if(username1.equals(username)) {
					data=data.substring(data.indexOf(",")+1);
					String password1=data.substring(0,data.indexOf(","));
					if(password.equals(password1)) {
						System.out.println("Access Granted.");
						return true;
					}
				}
			}
		}
		catch(IOException ioe) {
			System.out.println("Error in Admin Database: "+ioe.getMessage());
		}
		return false;
	}
	public void showFlight(){
		Admin obj = new Admin();
		obj.showFlights();
	}
	public void bookFlight() {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the Flight ID of the flight you wish to book [Enter 0 to view flight details again]: ");
	    String flightid = sc.nextLine();
	    if(flightid.equals("0")) {
	        showFlight();
	        System.out.println("Enter the Flight ID of the flight you wish to book: ");
	        flightid = sc.nextLine();
	    }
	    FlightCSVReader utility = new FlightCSVReader();
	    String data = utility.findFlightByID(flightid);
	    while(data.equals("0")) {
	        System.out.println("Flight not found. Enter a valid Flight ID: ");
	        flightid = sc.nextLine();
	        data = utility.findFlightByID(flightid);
	    }
	    int availableseats = Integer.parseInt(data.substring(data.lastIndexOf(',') + 1));
	    if(availableseats == 0) {
	        System.out.println("No seats available. Please try another flight.");
	        return;
	    }
	    System.out.print("Enter First Name: ");
	    String fname = sc.nextLine();
	    System.out.print("Enter Last Name: ");
	    String lname = sc.nextLine();
	    System.out.print("Enter Nationality: ");
	    String nationality = sc.nextLine();
	    System.out.print("Enter Phone: ");
	    String phone = sc.nextLine();
	    System.out.print("Enter Email: ");
	    String email = sc.nextLine();
	    System.out.print("Enter Age: ");
	    int age = sc.nextInt();
	    sc.nextLine();
	    System.out.print("Enter Passport Number: ");
	    String passport = sc.nextLine();
	    System.out.print("Enter Date of Birth: ");
	    String dob = sc.nextLine();
	    Passenger passenger = new Passenger(fname, lname, nationality, phone, email, age, passport, dob);
	    availableseats--;
	    GetFare getfareobj = new GetFare();
	    double fare = getfareobj.getfare(flightid);
	    double extra=0;
	    
	    System.out.println("Do you want Premium Ticket? (yes/no): ");
	    String choice = sc.nextLine();
	    if(choice.equalsIgnoreCase("yes")) {
	        extra = (10.0*fare)/100;
	        fare+=extra;
	    }
	    
	    
	    Payment payment = new Payment(fare);
	    payment.process();
	    try {
	        String filepath = "src/database/flightdata.csv";
	        File inputFile = new File(filepath);
	        File tempFile = new File("temp.csv");
	        Scanner reader = new Scanner(inputFile);
	        FileWriter writer = new FileWriter(tempFile);
	        while (reader.hasNextLine()) {
	            String line = reader.nextLine();
	            String[] parts = line.split(",");
	            if (parts[0].equals(flightid)) {
	                parts[10] = String.valueOf(availableseats);
	                line = String.join(",", parts);
	            }
	            writer.write(line + "\n");
	        }
	        reader.close();
	        writer.close();
	        if (inputFile.delete()) {
	            tempFile.renameTo(inputFile);
	        }
	        System.out.println("Seats updated successfully. Booking confirmed!");
	        if(extra==0) {
	        	Ticket ticket = new Ticket(passenger, flightid, "CONFIRMED", payment, fare);
	        }
	        else {
	        	PremiumTicket ticket = new PremiumTicket(passenger, flightid, "CONFIRMED", payment, fare, extra);
	        }
	    }
	    catch (Exception e) {
	        System.out.println("Error updating seats: " + e.getMessage());
	    }
	}
	
	public static void flow() {
	    User obj = new User();
	    Scanner sc = new Scanner(System.in);
	    int choice;
	    while(true) {
	        System.out.println("Enter: ");
	        System.out.println("1. Login");
	        System.out.println("2. Create Account");
	        System.out.println("0. Exit");
	        choice = sc.nextInt();
	        sc.nextLine();
	        if(choice == 1) {
	            if(obj.authenticateUser()) {
	                break;
	            } 
	            else {
	                System.out.println("Invalid details. Try again.");
	            }
	        }
	        else if(choice == 2) {
	            if(obj.createAccount()) {
	                System.out.println("Account created successfully. Logged in!");
	                break;
	            }
	        }
	        else if(choice == 0) {
	            return;
	        }
	        else {
	            System.out.println("Invalid input.");
	        }
	    }
	    while(true) {
	        System.out.println("\nEnter: ");
	        System.out.println("1. View flights");
	        System.out.println("2. Book flights");
	        System.out.println("0. Exit");
	        choice = sc.nextInt();
	        sc.nextLine();
	        if(choice == 1) {
	            obj.showFlight();
	        }
	        else if(choice == 2) {
	            obj.bookFlight();
	        }
	        else if(choice == 0) {
	            break;
	        }
	        else {
	            System.out.println("Invalid input.");
	        }
	    }
	}

}
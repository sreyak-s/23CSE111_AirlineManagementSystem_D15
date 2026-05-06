package com.airline.model.admin;

import com.airline.model.flight.*;
import java.util.Scanner;
import java.io.*;
public class Admin {
	public boolean authenticateAdmin() {
		String filepath = "src/com/airline/model/admin/admin.txt";
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
	public void addFlight() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Flight ID: ");
		String flightID = sc.nextLine();
		System.out.println("Enter Aircraft ID: ");
		String aircraftID = sc.nextLine();
		
		System.out.println("Enter Date of departure [DDMMYYY]: ");
		String datedep = sc.nextLine();
		System.out.println("Enter Time of departure [Hours:Minutes]: ");
		String timedep = sc.nextLine();
		System.out.println("Enter Date of arrival [DDMMYYY]: ");
		String datearr = sc.nextLine();
		System.out.println("Enter Time of arrival [Hours:Minutes]: ");
		String timearr = sc.nextLine();
		
		System.out.println("Enter the Total Number of Seats: ");
		int totalseats = sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the Airport Code of Departure Airport: ");
		String airportCode = sc.nextLine();
		System.out.println("Enter the City of Departure Airport: ");
		String city = sc.nextLine();
		System.out.println("Enter the Country of Departure Airport: ");
		String country = sc.nextLine();
		System.out.println("Enter the Gate Departure Airport: ");
		String gate = sc.nextLine();
		
		Airport dep = new Airport(airportCode, city, country, gate);
		
		System.out.println("Enter the Airport Code of Arrival Airport: ");
		airportCode = sc.nextLine();
		System.out.println("Enter the City of Arrival Airport: ");
		city = sc.nextLine();
		System.out.println("Enter the Country of Arrival Airport: ");
		country = sc.nextLine();
		System.out.println("Enter the Gate Arrival Airport: ");
		gate = sc.nextLine();
		
		Airport arr = new Airport(airportCode, city, country, gate);
		
		System.out.println("Enter the Ticket fare: ");
		double fare = sc.nextDouble();
		sc.nextLine();
		
		Flight flight = new Flight(flightID, aircraftID, datedep, timedep, datearr, timearr, dep, arr, totalseats, fare);
		flight.createFlight();
	}
	
	public void removeFlight() {
		String filepath = "src/database/flightdata.csv";
	    String tempFile = "temp.csv";
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter Flight ID to remove: ");
	    String flightID = sc.nextLine();
	    try {
	        File flightData = new File(filepath);
	        File temp = new File(tempFile);
	        Scanner reader = new Scanner(flightData);
	        FileWriter writer = new FileWriter(temp);
	        boolean found = false;
	        while (reader.hasNextLine()) {
	            String line = reader.nextLine();
	            String currentFlightID = line.substring(0, line.indexOf(","));
	            if (!currentFlightID.equals(flightID)) {
	                writer.write(line + "\n");
	            } 
	            else {
	                found = true;
	            }
	        }
	        writer.close();
	        reader.close();
	        if (flightData.delete()) {
	            temp.renameTo(flightData);
	        }
	        if(found) {
	            System.out.println("Flight removed successfully.");
	        } 
	        else {
	            System.out.println("Flight ID not found.");
	        }

	    }
	    catch (IOException e) {
	        System.out.println("Error: " + e.getMessage());
	    }
	}
	public void showFlights() {
		String filepath = "src/database/flightdata.csv";
		try {
			File myfile = new File(filepath);
			Scanner sc = new Scanner(myfile);
			String data;
			System.out.println("Flight : ");
			while(sc.hasNextLine()) {
				data = sc.nextLine();
				System.out.println(data);
			}
		}
		catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
	}
	public void modifyServices() {
		System.out.println("This feature is currently unavailable.");
		
	}
	public static int flow() {
		Admin obj = new Admin();
		while(!obj.authenticateAdmin()) {
			System.out.println("Authentication failed. Incorrect username or password. Please try again.");
		}
		Scanner sc = new Scanner(System.in);
		int choice = -1;
		while(true) {
			System.out.println();
			System.out.println("Enter:");
	        System.out.println("1. Add Flights");
	        System.out.println("2. Remove Flight");
	        System.out.println("3. View Flights");
	        System.out.println("4. Modify Services");
	        System.out.println("0. Terminate Session");
			choice = sc.nextInt();	
			switch(choice) {
				case 1: obj.addFlight();
					    break;
				case 2: obj.removeFlight();
			    		break;
				case 3: obj.showFlights();
						break;
				case 4: obj.modifyServices();
						break;
				case 0: return 0;
				default: System.out.println("Invalid Input");
				
			}
		}
	}
}

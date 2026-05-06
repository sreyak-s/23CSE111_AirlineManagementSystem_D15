package com.airline.model.flight;
import java.util.Scanner;
import java.io.*;
public class Flight{
  private String flightID;
  private String aircraftID;
  private String dateofdeparture;
  private String timeofdeparture;
  private String dateofarrival;
  private String timeofarrival;
  private Airport origin;
  private Airport destination;
  private double fare;
  private int totalseats;
  private int availableseats;
  public Flight(String flightID, String aircraftID,String dateofdeparture, String timeofdeparture,String dateofarrival,String timeofarrival, Airport origin, Airport destination, int totalseats, double fare) {
    this.flightID = flightID;
    this.aircraftID = aircraftID;
    this.dateofdeparture = dateofdeparture;
    this.timeofdeparture = timeofdeparture;
    this.dateofarrival = dateofarrival;
    this.timeofarrival = timeofarrival;
    this.origin = origin;
    this.destination = destination;
    this.totalseats = totalseats;
    availableseats = totalseats;
    this.fare=fare;
  }
 
  public void createFlight() {
	  String filepath="src/database/flightdata.csv";
	  try {
		  	
			Scanner sc = new Scanner(System.in);
			FileWriter writer = new FileWriter(filepath, true);
			String data = flightID + "," + aircraftID + "," +  dateofdeparture + "," + timeofdeparture + "," +dateofarrival+ "," +timeofarrival +","+ origin.airportCode+"," + destination.airportCode + "," + totalseats +"," +fare+","+ availableseats;
			writer.write(data+"\n");
			writer.close();
			System.out.println("Flight Details added successfuly. ");
		}
		catch(IOException ioe) {
			System.out.println("Error in file operation:" +ioe.getMessage());
		}

  }
}

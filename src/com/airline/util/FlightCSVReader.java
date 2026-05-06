package com.airline.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class FlightCSVReader {
    public String findFlightByID(String flightID) {
    	String filepath = "src/database/flightdata.csv";
        try {
            Scanner sc = new Scanner(new File(filepath));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                if (line.startsWith(flightID + ",")) {
                    sc.close();
                    return line;
                }
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
        return "0";
    }
}

package com.airline.model.payment;

import java.util.Scanner;
import java.io.*;
public class GetFare{
  String filepath = "src/database/flightdata.csv";
  public double getfare(String flightID){
    try {
      File myfile = new File(filepath);
      Scanner sc = new Scanner(myfile);
      while (sc.hasNextLine()){
        String line = sc.nextLine();
        if (line.startsWith(flightID + ",")){
          int lComma = line.lastIndexOf(',');
          int slComma = line.lastIndexOf(',',lComma - 1);
          String fareStr = line.substring(slComma + 1, lComma);
          return (Double.parseDouble(fareStr));
        }
      }
    } 
    catch (IOException e) {
      System.out.println("Error" + e.getMessage());
    }
    return -1.0;
  }
}

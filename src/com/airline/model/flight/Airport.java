package com.airline.model.flight;

public class Airport{
  public String airportCode;
  private String city;
  private String country;
  private String gate;
  public Airport(String airportCode, String city, String country, String gate){
    this.airportCode = airportCode;
    this.city = city;
    this.country=country;
    this.gate=gate;
  }
  public void getairportCode(){
    System.out.println(airportCode); 
  }
  public void getcity(){
    System.out.println(city);
  }
}

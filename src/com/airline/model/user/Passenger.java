package com.airline.model.user;

public class Passenger {
	private String fname;
	private String lname;
	private String nationality;
	private String phone;
	private String email;
	private int age;
	private String passport;
	private String dob;
	private String seat;
	private String clas;
	public Passenger(String fname, String lname, String nationality, String phone, String email, int age, String passport, String dob){
		this.fname=fname;
		this.lname=lname;
		this.nationality=nationality;
		this.phone=phone;
		this.email=email;
		this.age=age;
		this.passport=passport;
		this.dob=dob;
	}
	
}

package com.airline.main;

import com.airline.model.admin.*;
import com.airline.model.user.*;
import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		Admin admin = new Admin();
		User user = new User();
		while(true) {
			System.out.println("Enter: ");
			System.out.println("1. User");
			System.out.println("2. Admin");
			System.out.println("0. Exit");
			int choice = sc.nextInt();
			sc.nextLine();
			if(choice==0) {
				System.exit(0);
			}
			else if(choice==1) {
				user.flow();
			}
			else if(choice==2) {
				admin.flow();
			}
			else {
				System.out.println("Invalid Input. Enter: ");
				System.out.println("1. User");
				System.out.println("2. Admin");
				System.out.println("0. Exit");
			}
		}
	}

}

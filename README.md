

# **D15: Airline Management System (Java)**

## **Overview**

This is a **console-based Airline Management System** developed using Java.  
The system simulates real-world airline operations including **flight management, booking, passenger handling, and payments** using structured object-oriented design.

---

## **Team Members & Roles**

| Name | Role | Responsibilities |
| ----- | ----- | ----- |
| **Sreyak S** | **Backend Developer & Debugging** | **Developed core system logic, booking module, and payment integration and helped in debugging and error fixing.** |
| **Dhananjayan Sreeraj** | **Backend Developer** | **Developed core system logic, booking module, and payment integration** |
| **Hari Sankar V** | **Documentation & Diagram Specialist** | **Ensured consistency between design and implementation**  |
| **Tharak Gopal** | **System Designer (UML & Architecture)** | **Designed UML diagrams (Class, Use Case, Sequence)** |

## ---

## **Features**

### **User Features**

* Register and manage passenger details  
* Search available flights  
* Book tickets  
* View booking details  
* Make payments using multiple methods

### **Flight Management**

* Store flight details (departure, arrival, timings)  
* Manage airports and routes  
* Track seat availability

### **Booking System**

* Generate tickets  
* Store booking records in CSV  
* Associate passengers with flights

### **Payment System**

Supports multiple payment methods:

* Card Payment  
* UPI  
* Net Banking

### **Admin Features**

* Manage system data  
* Access admin credentials (admin.txt)

---

## **Project Structure**

src/  
│  
├── com.airline.main  
│   └── Main.java  
│  
├── com.airline.model.admin  
│   ├── Admin.java  
│   └── admin.txt  
│  
├── com.airline.model.booking  
│   └── Ticket.java  
│  
├── com.airline.model.flight  
│   ├── Airport.java  
│   └── Flight.java  
│  
├── com.airline.model.payment  
│   ├── Payment.java  
│   ├── payByCard.java  
│   ├── payByUPI.java  
│   └── payByNetBanking.java  
│  
├── com.airline.model.user  
│   ├── Passenger.java  
│   └── User.java  
│  
├── com.airline.util  
│   ├── FlightCSVReader.java  
│   └── PassCheck.java  
│  
└── database/  
    ├── bookingdata.csv  
    ├── flightdata.csv  
    └── passengerdata.csv

---

## **Data Storage**

The system uses **CSV files** as a lightweight database:

| File | Purpose |
| ----- | ----- |
| flightdata.csv | Stores flight details |
| passengerdata.csv | Stores passenger information |
| bookingdata.csv | Stores booking records |

---

## **Sample Input/Output**

## Enter:

## 1\. User

## 2\. Admin

## 0\. Exit

## 1

## Enter:

## 1\. Login

## 2\. Create Account

## 0\. Exit

## 1

## Enter your username:

## sreyaks

## Enter your password:

## Trivandrum@69

## Access Granted.

## Enter:

## 1\. View flights

## 2\. Book flights

## 0\. Exit

## 1

## Flight :

## CD101,A350-300-001,15052026,01:28,15052026,13:58,TRV,LHR,448,29999.99,447

## CD103,A350-300-450,17052026,04:58,17052026,16:58,TRV,EBB,448,45999.99,445

## Enter:

## 1\. View flights

## 2\. Book flights

## 0\. Exit

## 2

## Enter the Flight ID of the flight you wish to book \[Enter 0 to view flight details again\]:

## CD101

## Enter First Name: Sreyak

## Enter Last Name: S

## Enter Nationality: Indian

## Enter Phone: 8281951793

## Enter Email: sreyak@sreyak.com

## Enter Age: 19

## Enter Passport Number: QWERTYUIOP

## Enter Date of Birth: 03042007

## 1\. Credit/Debit

## 2\. UPI

## 3\. NetBanking

## Choose your payment method 1-3

## 1

## Enter cardNumber:

## 123456789012

## Enter card holder name:

## Sreyak

## Enter expiry date:

## 03/28

## Enter CVV:

## 134

## Processing card payment...

## Payment of amount 29999.99 via CARD successful.

## Seats updated successfully. Booking confirmed\!

## Enter:

## 1\. View flights

## 2\. Book flights

## 0\. Exit

## 0

## Enter:

## 1\. User

## 2\. Admin

## 0\. Exit

## 0

## 

## ---

## **Technologies Used**

* Java (JDK 21\)  
* Object-Oriented Programming (OOP)  
* File Handling (CSV)  
* Scanner (User Input)

---

## **How to Run**

1. Clone or download the project  
2. Open project in **Eclipse / IntelliJ / VS Code**  
3. Ensure JDK 21 is configured  
4. Navigate to:  
   ***com.airline.main.Main.java***  
5. Run the file

---

## **Key Concepts Implemented**

* Interfaces (Payment methods)  
* Encapsulation (Model classes)  
* File I/O (CSV handling)  
* Exception Handling  
* Modular package structure

---

## **Future Improvements**

* GUI (JavaFX / Swing)  
* Database integration (MySQL)  
* Online payment gateway simulation  
* Seat selection visualization  
* Email ticket generation  
* Food and other services  
* Baggage related services

---

## **License**

This project is for educational purposes.

---


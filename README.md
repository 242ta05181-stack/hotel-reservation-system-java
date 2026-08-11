# Hotel Reservation System

A console-based **Hotel Reservation System** developed using **Java, Object-Oriented Programming, and File I/O**.

The system allows users to search for hotel rooms, view room categories, make reservations, simulate payments, cancel bookings, and view booking details.

Room availability and reservation information are stored in text files so that data can be maintained between program executions.

---

## Repository Name

```text
hotel-reservation-system-java
```

---

## Project Structure

```text
hotel-reservation-system-java/
│
├── src/
│   ├── Main.java
│   ├── Hotel.java
│   ├── Room.java
│   ├── Reservation.java
│   └── FileManager.java
│
├── data/
│   ├── rooms.txt
│
├── README.md

```

---

# Project Objective

The objective of this project is to design and implement a basic hotel reservation system using Java.

The system provides functionality to:

* Search hotel rooms
* Categorize rooms
* Display room availability
* Book hotel rooms
* Cancel reservations
* Simulate payment
* Generate reservation IDs
* View booking details
* Display all reservations
* Store room and reservation data using File I/O

---

# Room Categories

The hotel provides three room categories.

| Category | Example Price |
| -------- | ------------: |
| Standard |  ₹1,500/night |
| Deluxe   |  ₹2,500/night |
| Suite    |  ₹4,000/night |

The prices can easily be changed in `FileManager.java`.

---

# Features

## 1. Room Search

Users can search for available rooms by category.

Available categories:

* Standard
* Deluxe
* Suite

---

## 2. Room Availability

Every room has an availability status.

Example:

```text
Room 101 | Category: Standard | Price: ₹1500.0 | Available: Yes
```

After a successful reservation:

```text
Room 101 | Category: Standard | Price: ₹1500.0 | Available: No
```

When the reservation is cancelled, the room becomes available again.

---

## 3. Make Reservation

The user provides:

* Room number
* Customer name
* Phone number
* Number of nights

The system calculates the total amount.

Formula:

```text
Total Amount = Room Price × Number of Nights
```

For example:

```text
Room Price = ₹2500
Nights = 3

Total = ₹2500 × 3

Total = ₹7500
```

---

## 4. Payment Simulation

The system includes a simple payment simulation.

The user is asked:

```text
Proceed with payment? (yes/no):
```

If the user enters:

```text
yes
```

the system displays:

```text
Processing payment...
Payment successful!
```

The payment status is stored as:

```text
PAID
```

This is only a simulation and does not process real payments.

---

## 5. Cancel Reservation

Users can cancel a reservation by entering the reservation ID.

Example:

```text
Enter reservation ID: RES1001
```

The reservation status changes to:

```text
CANCELLED
```

The associated room becomes available again.

---

## 6. Booking Details

Users can enter their reservation ID to view complete booking details.

The system displays:

* Reservation ID
* Customer name
* Phone number
* Room number
* Room category
* Number of nights
* Total amount
* Payment status
* Reservation status

---

# Object-Oriented Programming

The project uses several classes, each with a specific responsibility.

## Room Class

`Room.java` represents a hotel room.

It stores:

```text
Room Number
Category
Price
Availability
```

Example:

```java
Room room = new Room(
    101,
    "Standard",
    1500
);
```

---

## Reservation Class

`Reservation.java` represents a customer booking.

It stores:

```text
Reservation ID
Customer Name
Phone Number
Room Number
Room Category
Number of Nights
Total Amount
Payment Status
Reservation Status
```

---

## Hotel Class

`Hotel.java` manages the main hotel operations.

It handles:

* Room searching
* Reservations
* Cancellation
* Booking details
* Room availability
* Payment simulation

---

## FileManager Class

`FileManager.java` manages File I/O.

It is responsible for:

* Saving rooms
* Loading rooms
* Saving reservations
* Loading reservations

This separates file-handling logic from the hotel business logic.

---

## Main Class

`Main.java` provides the console menu and accepts user input.

---

# File I/O

The application stores data in the `data` directory.

## rooms.txt

Example:

```text
101|Standard|1500.0|true
102|Standard|1500.0|true
201|Deluxe|2500.0|true
202|Deluxe|2500.0|true
301|Suite|4000.0|true
302|Suite|4000.0|true
```

The fields are separated using `|`.

The format is:

```text
roomNumber|category|price|availability
```

---

## reservations.txt

Reservations are stored using the following format:

```text
reservationId|customerName|phone|roomNumber|category|nights|total|paymentStatus|reservationStatus
```

Example:

```text
RES1001|John|9876543210|201|Deluxe|3|7500.0|PAID|CONFIRMED
```

---

# Algorithm

```text
START
   |
   v
Load rooms from rooms.txt
   |
   v
Load reservations from reservations.txt
   |
   v
Display Main Menu
   |
   v
User selects an option
   |
   +-------------------------------+
   |                               |
   v                               v
Search Rooms                 Make Reservation
   |                               |
   v                               v
Display Available Rooms     Select Available Room
                                   |
                                   v
                           Enter Customer Details
                                   |
                                   v
                            Calculate Total Price
                                   |
                                   v
                             Payment Simulation
                                   |
                                   v
                            Create Reservation
                                   |
                                   v
                          Mark Room Unavailable
                                   |
                                   v
                         Save Data to Files
   |
   +-------------------------------+
   |
   v
Cancel Reservation
   |
   v
Find Reservation ID
   |
   v
Mark Reservation Cancelled
   |
   v
Make Room Available
   |
   v
Save Updated Data
   |
   +-------------------------------+
   |
   v
View Booking Details
   |
   v
Search Reservation ID
   |
   v
Display Booking Information
   |
   v
Exit
```

---

# Detailed Algorithm

### Step 1: Start

Start the Java application.

### Step 2: Load Data

Read existing room and reservation data from the `data` directory.

### Step 3: Display Menu

Display options for:

```text
1. Display All Rooms
2. Search Standard Rooms
3. Search Deluxe Rooms
4. Search Suite Rooms
5. Make Reservation
6. Cancel Reservation
7. View Booking Details
8. Display All Reservations
9. Exit
```

### Step 4: Search Rooms

The user selects a room category.

The system checks every room and displays rooms where:

```text
Category = requested category
AND
Available = true
```

### Step 5: Make Reservation

The user selects an available room.

The system collects:

```text
Customer name
Phone number
Number of nights
```

### Step 6: Calculate Price

The system calculates:

```text
total = room price × number of nights
```

### Step 7: Payment

The system asks the user whether to proceed with payment.

If the user confirms, payment status becomes:

```text
PAID
```

### Step 8: Create Reservation

A unique reservation ID is generated.

Example:

```text
RES1001
```

The reservation status is set to:

```text
CONFIRMED
```

### Step 9: Update Room

The selected room is marked:

```text
Available = false
```

### Step 10: Save Data

Room and reservation information are written to the files.

### Step 11: Cancellation

If the user cancels a reservation, its status becomes:

```text
CANCELLED
```

The room becomes available again.

### Step 12: View Booking

The user enters a reservation ID.

The system searches the reservation list and displays its details.

### Step 13: Exit

The application closes.

---

# Sample Output

## Program Start

```text
================================
     HOTEL RESERVATION SYSTEM
================================
1. Display All Rooms
2. Search Standard Rooms
3. Search Deluxe Rooms
4. Search Suite Rooms
5. Make Reservation
6. Cancel Reservation
7. View Booking Details
8. Display All Reservations
9. Exit

Enter your choice:
```

---

# Output: Display Rooms

```text
========== ALL ROOMS ==========

Room 101 | Category: Standard | Price: ₹1500.0 | Available: Yes
Room 102 | Category: Standard | Price: ₹1500.0 | Available: Yes
Room 201 | Category: Deluxe | Price: ₹2500.0 | Available: Yes
Room 202 | Category: Deluxe | Price: ₹2500.0 | Available: Yes
Room 301 | Category: Suite | Price: ₹4000.0 | Available: Yes
Room 302 | Category: Suite | Price: ₹4000.0 | Available: Yes
```

---

# Output: Search Deluxe Rooms

```text
====== AVAILABLE DELUXE ROOMS ======

Room 201 | Category: Deluxe | Price: ₹2500.0 | Available: Yes
Room 202 | Category: Deluxe | Price: ₹2500.0 | Available: Yes
```

---

# Output: Make Reservation

```text
====== HOTEL RESERVATION SYSTEM ======

Enter your choice: 5

========== ALL ROOMS ==========

Room 101 | Category: Standard | Price: ₹1500.0 | Available: Yes
Room 102 | Category: Standard | Price: ₹1500.0 | Available: Yes
Room 201 | Category: Deluxe | Price: ₹2500.0 | Available: Yes
Room 202 | Category: Deluxe | Price: ₹2500.0 | Available: Yes
Room 301 | Category: Suite | Price: ₹4000.0 | Available: Yes
Room 302 | Category: Suite | Price: ₹4000.0 | Available: Yes

Enter room number: 201
Enter customer name: Rahul
Enter phone number: 9876543210
Enter number of nights: 3

Total Amount: ₹7500.0

Proceed with payment? (yes/no): yes

Processing payment...
Payment successful!

Booking successful!

------------------------------
Reservation ID : RES1001
Customer Name   : Rahul
Phone Number    : 9876543210
Room Number     : 201
Room Category   : Deluxe
Number of Nights: 3
Total Amount    : ₹7500.0
Payment Status  : PAID
Booking Status  : CONFIRMED
------------------------------
```

---

# Output: View Booking

```text
Enter reservation ID: RES1001

------------------------------
Reservation ID : RES1001
Customer Name   : Rahul
Phone Number    : 9876543210
Room Number     : 201
Room Category   : Deluxe
Number of Nights: 3
Total Amount    : ₹7500.0
Payment Status  : PAID
Booking Status  : CONFIRMED
------------------------------
```

---

# Output: Cancel Booking

```text
Enter reservation ID: RES1001

Reservation cancelled successfully.
Room 201 is now available.
```

After cancellation:

```text
Room 201 | Category: Deluxe | Price: ₹2500.0 | Available: Yes
```

---

# How to Run

## Requirements

Install:

* Java JDK 11 or later
* Git
* Any Java IDE or terminal

Check Java:

```bash
java -version
```

Check the compiler:

```bash
javac -version
```

---

## Compile

From the project root directory:

```bash
mkdir out
javac -d out src/*.java
```

---

## Run

```bash
java -cp out Main
```

The application will display:

```text
================================
     HOTEL RESERVATION SYSTEM
================================
```

---

# GitHub Upload

Create a GitHub repository named:

```text
hotel-reservation-system-java
```

Then execute:

```bash
git init
git add .
git commit -m "Initial commit - Hotel Reservation System"
git branch -M main
git remote add origin https://github.com/yourusername/hotel-reservation-system-java.git
git push -u origin main
```

Replace `yourusername` with your GitHub username.

---

# OOP Concepts Demonstrated

This project demonstrates:

* Classes and objects
* Encapsulation
* Constructors
* Private fields
* Getters and setters
* Methods
* Object composition
* Separation of responsibilities
* Java Collections

---

# File I/O Concepts Demonstrated

The project uses:

```java
File
FileReader
FileWriter
BufferedReader
PrintWriter
```

These are used to persist room and reservation information.

Therefore, reservations are not lost when the application is closed, provided the `data` files are retained.

---

# Payment Simulation

This project does not process real payments.

The payment system simply simulates a successful payment when the user confirms:

```text
Proceed with payment? (yes/no): yes
```

The reservation is then marked:

```text
Payment Status: PAID
```

A real application would require a secure payment gateway and appropriate security controls.

---

# Limitations

This is an educational project and has some limitations:

* Console-based interface
* File-based storage instead of a database
* No real payment gateway
* No user authentication
* No check-in/check-out dates
* Basic room availability management
* Basic reservation ID generation
* No concurrent booking protection

---

# Future Enhancements

The project can be improved by adding:

* JavaFX graphical interface
* Login and registration
* MySQL or SQLite database
* Check-in and check-out dates
* Date-based room availability
* Multiple hotels
* Admin dashboard
* Customer dashboard
* Real payment gateway integration
* Email booking confirmation
* PDF invoice generation
* Room image display
* Advanced room search
* Discount and coupon system
* Automatic reservation ID generation
* Booking history
* Guest reviews and ratings

---

# Learning Outcomes

After completing this project, you can demonstrate knowledge of:

* Java programming
* Object-Oriented Programming
* File I/O
* Collections
* Exception handling
* Console application development
* Data persistence
* CRUD-style operations
* Reservation management
* Basic payment simulation
* Git and GitHub

---

# Conclusion

The Hotel Reservation System provides a simple implementation of hotel room management using Java.

It combines **OOP for system design** with **File I/O for persistent storage** and provides essential features such as room searching, room categorization, reservations, cancellations, payment simulation, and booking details.

The project can later be extended into a complete hotel management application using JavaFX, a relational database, authentication, and real payment services.

---

# Author

K.Anu Ananda

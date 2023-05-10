# HabeebHotel HabeebReservation System

The HabeebHotel HabeebReservation System is a Java application that allows users to manage hotel bookings and reservations. It provides functionality for making reservations, checking in guests, checking out guests, and canceling reservations.

## Features

- Create and manage hotel rooms
- Make reservations for guests
- Check-in and check-out guests
- Cancel reservations
- View and manage guest information
- Calculate reservation costs

## Technologies Used

- Java programming language
- Object-oriented design principles
- Data structures: Lists, Queues, and Binary Trees
- Exception handling
- File I/O
- UML diagrams

## Getting Started

To run the HabeebHotel HabeebReservation System, follow these steps:

1.Navigate to the project directory: `cd hotel-reservation-system`
2.Compile the Java source files: `javac Main.java`
3.Run the application: `java Main`

## Input
````
rooms.add(new HabeebRoom("101", AdnanRoomType.SINGLE));
rooms.add(new HabeebRoom("102", AdnanRoomType.DOUBLE));
rooms.add(new HabeebRoom("103", AdnanRoomType.SUITE));
````

##Output

````
HabeebReservation made: AdnanHotelReservation@404b9385
HabeebGuest checked-in to room 101
HabeebGuest checked-out from room 101
Cancellation is not allowed for reservation 1001 as the check-in date has already passed.
````

## Usage

1. Initialize the hotel rooms and set up the application.
2. Perform operations such as making reservations, checking in guests, checking out guests, and canceling reservations.
3. View and manage guest information.

## Future Enhancements

- Integration with a payment system for handling room charges and payments.
- Development of a mobile application for easy access to the reservation system.
- Integration with an online booking platform for real-time availability and bookings.

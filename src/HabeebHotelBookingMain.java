import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HabeebHotelBookingMain {
    public static void main(String[] args) {
        // Step 1: Instantiate and initialize objects, set up the application
        List<HabeebRoom> rooms = initializeRooms(); // Initialize rooms
        HabeebHotel hotel = new CS420QueueADTHotelImpl(rooms);

        // Step 2: Perform operations and interactions with the booking and reservation system
        // Example: make reservations, check-in guests, check-out guests, etc.

        // Make a reservation
        LocalDate checkInDate = LocalDate.now();
        LocalDate checkOutDate = LocalDate.now().plusDays(3);
        HabeebRoom room = getAvailableRoom(hotel, checkInDate, checkOutDate);
        if (room != null) {
            HabeebGuest guest = new AdnanHotelGuest("John Doe", "8728884122","john.doe@example.com"); // Create a guest
            int reservationNumber = 1001;
            HabeebReservation reservation = makeReservation(reservationNumber, room, guest, checkInDate, checkOutDate);
            System.out.println("Reservation made: " + reservation);

            // Check-in a guest
            checkInGuest(room, reservation);

            // Check-out a guest
            checkOutGuest(room);

            // Cancel a reservation
            cancelReservation(reservation);
        } else {
            System.out.println("No available rooms for the specified dates.");
        }
    }

    private static List<HabeebRoom> initializeRooms() {
        // Initialize and return a list of rooms
        // Example: Create Room objects and add them to the list
        List<HabeebRoom> rooms = new ArrayList<>();
        rooms.add(new AdnanHotelRoom("101", "SINGLE"));
        rooms.add(new AdnanHotelRoom("102", "DOUBLE"));
        rooms.add(new AdnanHotelRoom("103", "SUITE"));
        return rooms;
    }

    private static HabeebRoom getAvailableRoom(HabeebHotel hotel, LocalDate checkInDate, LocalDate checkOutDate) {
        // Implement the logic to get an available room for the specified dates
        List<HabeebRoom> availableRooms = hotel.getAvailableRooms(checkInDate, checkOutDate);
        if (!availableRooms.isEmpty()) {
            return availableRooms.get(0);
        }
        return null;
    }

    private static HabeebReservation makeReservation(int reservationNumber, HabeebRoom room, HabeebGuest guest, LocalDate checkInDate, LocalDate checkOutDate) {
        // Implement the logic to make a reservation
        AdnanHotelReservation reservation = new AdnanHotelReservation(reservationNumber,room, guest, checkInDate, checkOutDate);

            // Perform necessary operations
        return reservation;
    }

    private static void checkInGuest(HabeebRoom room, HabeebReservation reservation) {
        if (!room.isOccupied()) {
            room.setOccupied(true);
            reservation.setCheckInDate(LocalDate.now());
            System.out.println("Guest checked-in to room " + room.getRoomNumber());
        } else {
            System.out.println("Room " + room.getRoomNumber() + " is already occupied.");
        }
    }

    private static void checkOutGuest(HabeebRoom room) {
        if (room.isOccupied()) {
            room.setOccupied(false);
            System.out.println("Guest checked-out from room " + room.getRoomNumber());
        } else {
            System.out.println("Room " + room.getRoomNumber() + " is not occupied.");
        }
    }

    private static void cancelReservation(HabeebReservation reservation) {
        if (reservation.getCheckInDate().isAfter(LocalDate.now())) {
            System.out.println("Cancellation is allowed for reservation " + reservation.getReservationNumber());
            // Implement necessary cancellation logic
        } else {
            System.out.println("Cancellation is not allowed for reservation " + reservation.getReservationNumber()
                    + " as the check-in date has already passed.");
        }
    }

}

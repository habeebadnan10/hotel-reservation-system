import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CS420QueueADTHotelImpl implements HabeebHotel {
    private List<HabeebRoom> rooms;
    private List<HabeebReservation> reservations;
    private CS420GuestQueueADT guestQueue;
    private int counterForReservationNumber = 0;

    public CS420QueueADTHotelImpl(List<HabeebRoom> rooms) {
        this.rooms = rooms;
        this.reservations = new ArrayList<>();
        this.guestQueue = new CS420GuestQueueADT();
    }

    // Implementation to retrieve available rooms for a specific date range
    public List<HabeebRoom> getAvailableRooms(LocalDate checkInDate, LocalDate checkOutDate) {
        List<HabeebRoom> availableRooms = new ArrayList<>();
        for (HabeebRoom room : rooms) {
            if (isRoomAvailable(room, checkInDate, checkOutDate)) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    // Check if a room is available for a specific date range
    private boolean isRoomAvailable(HabeebRoom room, LocalDate checkInDate, LocalDate checkOutDate) {
        for (HabeebReservation reservation : reservations) {
            if (reservation.getRoom().equals(room) && isOverlappingDates(checkInDate, checkOutDate, reservation.getCheckInDate(), reservation.getCheckOutDate())) {
                return false;
            }
        }
        return true;
    }

    // Check if two date ranges overlap
    private boolean isOverlappingDates(LocalDate start1, LocalDate end1, LocalDate start2, LocalDate end2) {
        return start1.isBefore(end2) && start2.isBefore(end1);
    }

    // Implementation to make a reservation
    public HabeebReservation makeReservation(HabeebRoom room, HabeebGuest guest, LocalDate checkInDate, LocalDate checkOutDate) {
        if (!isRoomAvailable(room, checkInDate, checkOutDate)) {
            throw new IllegalArgumentException("The room is not available for the selected dates.");
        }
        int reservationNumber = generateReservationNumber();
        HabeebReservation reservation = new AdnanHotelReservation(reservationNumber, room, guest, checkInDate, checkOutDate);
        reservations.add(reservation);
        room.setOccupied(false);

        // Serve the next guest from the queue if available
        if (!guestQueue.isEmpty()) {
            HabeebGuest nextGuest = guestQueue.dequeue();
            // Process the next guest and assign a room
            // Example: makeReservation(room, nextGuest, checkInDate, checkOutDate);
        }

        return reservation;
    }

    public void addGuestToQueue(HabeebGuest guest) {
        guestQueue.enqueue(guest);
    }

    // Implementation to cancel a reservation
    public boolean cancelReservation(int reservationNumber) {
        HabeebReservation reservation = findReservation(reservationNumber);
        if (reservation != null) {
            reservations.remove(reservation);
            reservation.getRoom().setOccupied(true);
            return true;
        }
        return false;
    }

    // Find a reservation by reservation number
    private HabeebReservation findReservation(int reservationNumber) {
        for (HabeebReservation reservation : reservations) {
            if (reservation.getReservationNumber() == reservationNumber) {
                return reservation;
            }
        }
        return null;
    }

    // Generate a unique reservation number
    private int generateReservationNumber() {
        // Implementation to generate a unique reservation number
        // You can use a timestamp or a counter, for example
        return counterForReservationNumber + 1;
    }
}


import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class AdnanHotelReservation implements HabeebReservation {
    private int reservationNumber;
    private HabeebRoom room;
    private HabeebGuest guest;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    public AdnanHotelReservation(int reservationNumber, HabeebRoom room, HabeebGuest guest, LocalDate checkInDate, LocalDate checkOutDate) {
        this.reservationNumber = reservationNumber;
        this.room = room;
        this.guest = guest;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public HabeebRoom getRoom() {
        return room;
    }

    public HabeebGuest getGuest() {
        return guest;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public int getTotalNights() {
        return (int) ChronoUnit.DAYS.between(checkInDate, checkOutDate);
    }

    public double getTotalCost() {
        return getTotalNights() * room.getCapacity() * 100; // Assume $100 per night per person
    }

    @Override
    public void setCheckInDate(LocalDate now) {
        checkInDate = now;
    }
}

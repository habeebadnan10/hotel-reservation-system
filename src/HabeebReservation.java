import java.time.LocalDate;

public interface HabeebReservation {
    int getReservationNumber();
    HabeebRoom getRoom();
    HabeebGuest getGuest();
    LocalDate getCheckInDate();
    LocalDate getCheckOutDate();
    int getTotalNights();
    double getTotalCost();
    void setCheckInDate(LocalDate now);
}

import java.time.LocalDate;
import java.util.List;

public interface HabeebHotel {
    List<HabeebRoom> getAvailableRooms(LocalDate checkInDate, LocalDate checkOutDate);
    HabeebReservation makeReservation(HabeebRoom room, HabeebGuest guest, LocalDate checkInDate, LocalDate checkOutDate);
    boolean cancelReservation(int reservationNumber);
}

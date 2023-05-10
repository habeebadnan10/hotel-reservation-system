public class AdnanHotelRoom implements HabeebRoom {
    private String roomNumber;
    private String roomType;
    private boolean isOccupied;

    public AdnanHotelRoom(String roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.isOccupied = false; // Room is initially not occupied
    }


    public String getRoomNumber() {
        return roomNumber;
    }

    public String getRoomType() {
        return roomType;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    @Override
    public int getCapacity() {
        return 0;
    }

    // Other getter and setter methods

    // Other methods and logic for the Room class
}

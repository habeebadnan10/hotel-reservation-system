public interface HabeebRoom {
    String getRoomNumber();
    String getRoomType();
    boolean isOccupied();
    void setOccupied(boolean occupied);
    int getCapacity();
}
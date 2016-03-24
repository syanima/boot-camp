package parking;

public interface ParkingArea {
    void park(Vehicle vehicle) throws ParkingLotFullException;
    boolean isFull();
    int getCapacity();
}

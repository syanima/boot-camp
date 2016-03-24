package parking;

public class ParkingLotFullException extends Throwable {
    public ParkingLotFullException() {
        super("No more space in parking lot");
    }
}

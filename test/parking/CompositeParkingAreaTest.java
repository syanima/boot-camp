package parking;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CompositeParkingAreaTest {
    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void throw_exception_when_all_lots_are_full() throws ParkingLotFullException {
        thrown.expect(ParkingLotFullException.class);
        CompositeParkingArea parkingLot = new CompositeParkingArea();
        parkingLot.add(new CarParkingArea(1));
        parkingLot.park(new Car());
        parkingLot.park(new Car());
    }
}
package parking;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ParkingLotTest {
    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void throw_exception_when_the_lot_is_full() throws ParkingLotFullException {
        thrown.expect(ParkingLotFullException.class);
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.expand(new CarParkingArea(1));
        parkingLot.park(new Car());
//        parkingLot.park(new Car());
    }
}
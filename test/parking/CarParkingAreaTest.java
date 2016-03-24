package parking;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CarParkingAreaTest {
    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void parkingLot_can_park_a_vehicle() throws ParkingLotFullException {
        CarParkingArea carParkingLot = new CarParkingArea(2);
        carParkingLot.park(new Car());
        assertEquals(1, carParkingLot.size());

    }

    @Test
    public void should_throw_exception_when_lot_is_full() throws ParkingLotFullException {
        thrown.expect(ParkingLotFullException.class);
        thrown.expectMessage(CoreMatchers.is("No more space in parking lot"));
        CarParkingArea carParkingLot = new CarParkingArea(1);
        carParkingLot.park(new Car());
        carParkingLot.park((new Car()));
    }

    @Test
    public void parking_lot_can_tell_whether_the_lot_is_full_or_not() throws ParkingLotFullException {
        CarParkingArea carParkingLot = new CarParkingArea(1);
        carParkingLot.park(new Car());
        assertTrue(carParkingLot.isFull());

    }

    @Test
    public void parking_lot_can_tell_if_the_size_is_above_80_percentage() throws ParkingLotFullException {
        CarParkingArea carParkingLot = new CarParkingArea(5);
        carParkingLot.park(new Car());
        carParkingLot.park(new Car());
        carParkingLot.park(new Car());
        carParkingLot.park(new Car());
    }
}
package parking;

import java.util.ArrayList;

public class CarParkingArea implements ParkingArea {
    private int capacity;
    private ArrayList<Vehicle> vehicles;

    public CarParkingArea(int capacity) {
        this.capacity = capacity;
        vehicles = new ArrayList<>();
    }

    @Override
    public void park(Vehicle vehicle) throws ParkingLotFullException {
        if (isFull()) throw new ParkingLotFullException();
        vehicles.add(vehicle);
    }

    public int size() {
        return vehicles.size();
    }

    @Override
    public boolean isFull() {
        return capacity == size();
    }

    @Override
    public int getCapacity() {
        return capacity;
    }
}

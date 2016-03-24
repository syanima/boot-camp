package parking;

import java.util.ArrayList;

public class CompositeParkingArea implements ParkingArea{


    private ArrayList<ParkingArea> parkingAreas;


    private ParkingArea getParkingArea() throws ParkingLotFullException {
        for (ParkingArea parkingArea : parkingAreas) {
            if (!parkingArea.isFull()) return parkingArea;
        }
        throw new ParkingLotFullException();
    }

    @Override
    public void park(Vehicle vehicle) throws ParkingLotFullException {
        ParkingArea parkingArea = getParkingArea();
        parkingArea.park(vehicle);
    }

    @Override
    public boolean isFull() {
        for (ParkingArea parkingArea : parkingAreas)
            if (!parkingArea.isFull()) return false;
        return true;
    }

    public int size() {
        return parkingAreas.size();
    }

    public boolean add(ParkingArea parkingArea) {
        return parkingAreas.add(parkingArea);
    }

    public double getSizeInPercentFactor(){
        return size() / getCapacity();
    }

    public int getCapacity() {
        int capacity = 0;
        for (ParkingArea parkingArea : parkingAreas) {
            capacity += parkingArea.getCapacity();
        }
        return capacity;
    }
}

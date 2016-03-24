package parking;

import parking.observers.ParkingLotObserver;

import java.util.ArrayList;

public class ParkingLot {

    private final CompositeParkingArea parkingAreas;
    private ArrayList<ParkingLotObserver> observers;

    public ParkingLot() {
        parkingAreas = new CompositeParkingArea();
    }

    public void addObserver(ParkingLotObserver observer) {
        observers.add(observer);
    }


    public void park(Vehicle vehicle) throws ParkingLotFullException {
        parkingAreas.park(vehicle);

        for (ParkingLotObserver observer : observers) {
            if (isSizeAbove(.8)) observer.sizeAbove80Percent();
            if(isSizeBelow(.2)) observer.sizeLessThan20Percent();
        }
    }

    private boolean isSizeAbove(double factor) {
        return parkingAreas.getSizeInPercentFactor() >= factor;
    }

    private boolean isSizeBelow(double factor) {
        return parkingAreas.getSizeInPercentFactor() >= factor;
    }

    public void expand(ParkingArea parkingArea) {
        parkingAreas.add(parkingArea);
    }

    public boolean isFull() {
        return parkingAreas.isFull();
    }
}

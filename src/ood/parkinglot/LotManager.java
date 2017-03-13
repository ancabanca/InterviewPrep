package com.github.ancabanca.interviewprep.ood.parkinglot;

public class LotManager {
    private Lot lot;

    public LotManager(Lot lot) {
        this.lot = lot;
    }

    // returns null if no free spot available
    public Spot getFreeSpot(String type) {
        type = type.toLowerCase();
        Spot.validateType(type);
        return lot.getFreeSpot(type);
    }

    public Spot park(Spot spot) {
        if(spot == null)
            throw new NullPointerException();
        lot.setOccupied(spot);
        return spot;
    }

    public Spot park(String type) throws NoSpotsForGivenTypeException, ParkingLotFullException {
        if(lot.isFull())
            throw new ParkingLotFullException("Parking lot is full");
        Spot spot = getFreeSpot(type);
        if(spot == null)
            throw new NoSpotsForGivenTypeException("No spots free for type " + type);
        park(spot);
        return spot;
    }

    public void freeSpot(Spot s) {
        lot.freeSpot(s);
    }
}
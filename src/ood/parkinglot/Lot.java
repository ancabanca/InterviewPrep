package com.github.ancabanca.interviewprep.ood.parkinglot;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Lot {
    private List<Spot> spots;
    private final int capacity;
    /* package private */ int occupiedSpots;
    private HashMap<String,List<Spot>> freeSpots;

    public Lot() {
        this.capacity = 5;
        spots = new LinkedList<Spot>();
        freeSpots = new HashMap<String,List<Spot>>();
        for(String type : Spot.types)
            freeSpots.put(type, new LinkedList<Spot>());

        Spot s;

        s = new Spot("small", 1);
        spots.add(s);
        freeSpots.get("small").add(s);
        
        s = new Spot("medium", 2);
        spots.add(s);
        freeSpots.get("medium").add(s);
        
        s = new Spot("medium", 3);
        spots.add(s);
        freeSpots.get("medium").add(s);
        
        s = new Spot("large", 4);
        spots.add(s);
        freeSpots.get("large").add(s);
        
        s = new Spot("motorcycle", 5);
        spots.add(s);
        freeSpots.get("motorcycle").add(s);
    }

    public boolean isFull() {
        if(occupiedSpots == capacity)
            return true;
        return false;
    }

    public int freeSpotsCount() {
        return capacity - occupiedSpots;
    }

    public Spot getFreeSpot(String type) {
        if(freeSpots.get(type).isEmpty())
            return null;
        return freeSpots.get(type).get(0);
    }

    public void setOccupied(Spot s) {
        freeSpots.get(s.getType()).remove(s);
        occupiedSpots++;
    }

    public void freeSpot(Spot s) {
        freeSpots.get(s.getType()).add(s);
        occupiedSpots--;
    }
}
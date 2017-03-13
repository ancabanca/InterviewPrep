package com.github.ancabanca.interviewprep.ood.parkinglot;

import java.util.HashSet;
import java.util.Set;

public class Spot {
    private final int id;
    private final String type;
    private boolean occupied; // is it still needed? now in Lot -> freeSpots

    // TODO: refactor type to be enum, rather than String
    public static Set<String> types;
    static {
        types = new HashSet<String>();
        types.add("small");
        types.add("medium");
        types.add("large");
        types.add("motorcycle");
    }

    public Spot(String type, int id) {
        validateType(type);
        this.type = type;
        this.id = id;
        this.occupied = false;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public String getType() {
        return type;
    }

    public void setOccupied(boolean b) {
        this.occupied = b;
    }

    public static void validateType(String type) throws NullPointerException, IllegalArgumentException {
        if(type == null)
            throw new NullPointerException("Parking spot type is null");
        if(!types.contains(type.toLowerCase())) {
            throw new IllegalArgumentException("Illegal parking spot type: " + type);
        }
    }
}
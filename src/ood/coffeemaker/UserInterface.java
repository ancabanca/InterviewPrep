package com.github.ancabanca.interviewprep.ood.coffeemaker;

public abstract class UserInterface {
    private Boiler boiler;
    private Pot    pot;

    public void initialize(Boiler b, Pot p) {
        this.boiler = b;
        this.pot    = p;
    }

    public void startBrewing() {
        if(boiler.isReady() && pot.isReady()) {
            start();
            boiler.start();
            pot.start();
        }
    }

    public abstract void start();
    public abstract void brewComplete();
    public abstract void completeBrewingCycle();
}
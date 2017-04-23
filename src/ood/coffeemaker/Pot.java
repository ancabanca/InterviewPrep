package com.github.ancabanca.interviewprep.ood.coffeemaker;

public abstract class Pot {
    protected UserInterface ui;
    protected Boiler        boiler;

    public void initialize(UserInterface u, Boiler b) {
        this.ui     = u;
        this.boiler = b;
    }

    public abstract boolean isReady();
    public abstract void    start();
    public abstract void    brewComplete();
}
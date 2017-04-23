package com.github.ancabanca.interviewprep.ood.coffeemaker;

public abstract class Boiler {
    UserInterface ui;
    Pot           pot;

    public void initialize(UserInterface u, Pot p) {
        this.ui  = u;
        this.pot = p;
    }

    public abstract boolean isReady();
    public abstract void    start();
    public abstract void    stop();
}
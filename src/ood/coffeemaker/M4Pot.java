package com.github.ancabanca.interviewprep.ood.coffeemaker;

public class M4Pot extends Pot implements Pollable {
    private M4CoffeeMakerAPI api;

    private boolean isBrewing;
    private boolean pausedBrewing;
    // in brewing cycle if coffee is brewing OR (brewing complete AND there is coffee in the pot)
    private boolean inBrewingCycle;

    public M4Pot(M4CoffeeMakerAPI api) {
        this.api = api;
    }

    public boolean isReady() {
        return api.getPotState() == api.POT_EMPTY;
    }

    public void start() {
        api.setWarmerPlateState(api.PLATE_WARMER_ON);
        isBrewing = true;
        inBrewingCycle = true;
    }

    public void brewComplete() {
        isBrewing = false;
    }

    private void turnOffPlateWarmer() {
        api.setWarmerPlateState(api.PLATE_WARMER_OFF);
    }

    public void poll() {
        int potState = api.getPotState();
        // only poll warmer plate if inside a brewing cycle
        if(inBrewingCycle) {
            if(potState == api.NO_POT) {
                if(isBrewing) {
                    boiler.stop();
                    turnOffPlateWarmer();
                    pausedBrewing = true;
                }
                else {
                    turnOffPlateWarmer();
                }
            }
            else { 
                if(pausedBrewing) {
                    boiler.start();
                    api.setWarmerPlateState(api.PLATE_WARMER_ON);
                    pausedBrewing = false;
                }
                // if brewing is complete and there is still coffee in the pot
                if(!isBrewing && potState == api.POT_NOT_EMPTY) {
                    api.setWarmerPlateState(api.PLATE_WARMER_ON);
                }
                // if brewing is complete and all coffee has been poured out of the pot
                if(!isBrewing && potState == api.POT_EMPTY) {
                    turnOffPlateWarmer();
                    ui.completeBrewingCycle();
                    inBrewingCycle = false;
                }
            }
        }
    }
}
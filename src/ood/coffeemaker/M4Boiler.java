package com.github.ancabanca.interviewprep.ood.coffeemaker;

public class M4Boiler extends Boiler implements Pollable {
    private M4CoffeeMakerAPI api;
    private boolean isBrewing;

    public M4Boiler(M4CoffeeMakerAPI api) {
        this.api = api;
    }

    @Override
    public boolean isReady() {
        return api.getBoilerWaterState() == api.BOILER_NOT_EMPTY;
    }

    @Override
    public void start() {
        api.setBoilerState(api.BOILER_ON);
        isBrewing = true;
    }

    @Override
    public void stop() {
        api.setBoilerState(api.BOILER_OFF);
        isBrewing = false;
    }

    public void poll() {
        // only poll the water source while brewing
        if(isBrewing)
            if(api.getBoilerWaterState() == api.BOILER_EMPTY) {
                stop();
                ui.brewComplete();
                pot.brewComplete();
            }
    }
}
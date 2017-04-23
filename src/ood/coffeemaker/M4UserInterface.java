package com.github.ancabanca.interviewprep.ood.coffeemaker;

public class M4UserInterface extends UserInterface implements Pollable {
    private M4CoffeeMakerAPI api;
    // true if coffee is brewing or there is coffee in the pot and light is on
    private boolean inBrewingCycle;
    
    public M4UserInterface(M4CoffeeMakerAPI api) {
        this.api = api;
    }

    public void start() {
        inBrewingCycle = true;
    }

    public void brewComplete() {
        api.setLightState(api.LIGHT_ON);
    }

    public void completeBrewingCycle() {
        api.setLightState(api.LIGHT_OFF);
        inBrewingCycle = false;
    }

    public void poll() {
        // only check if button was pushed outside a brewing cycle
        if(!inBrewingCycle)
            if(api.getButtonState() == api.BUTTON_PUSHED)
                startBrewing();
    }
}
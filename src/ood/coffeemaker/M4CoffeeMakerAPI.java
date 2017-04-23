package com.github.ancabanca.interviewprep.ood.coffeemaker;

public class M4CoffeeMakerAPI implements CoffeeMakerAPI {
    public final int BOILER_OFF = 0;
    public final int BOILER_ON  = 1;
    
    public final int BOILER_EMPTY     = 0;
    public final int BOILER_NOT_EMPTY = 1;

    public final int NO_POT         = 0;
    public final int POT_EMPTY      = 1;
    public final int POT_NOT_EMPTY  = 2;

    public final int PLATE_WARMER_OFF = 0;
    public final int PLATE_WARMER_ON  = 1;

    public final int BUTTON_NOT_PUSHED = 0;
    public final int BUTTON_PUSHED     = 1;
    
    public final int LIGHT_OFF = 0;
    public final int LIGHT_ON  = 1;

    private int boilerState;
    private int boilerWaterState;
    private int potState;
    private int warmerPlateState;
    private int buttonState;
    private int lightState;

    public M4CoffeeMakerAPI() {
        this.boilerState      = BOILER_OFF;
        this.boilerWaterState = BOILER_EMPTY;
        this.potState         = NO_POT;
        this.warmerPlateState = PLATE_WARMER_OFF;
        this.buttonState      = BUTTON_NOT_PUSHED;
        this.lightState       = LIGHT_OFF;
    }

    // boiler is BOILER_ON (heating the water) or BOILER_OFF
    public int getBoilerState() {
        return boilerState;
    }

    public void setBoilerState(int boilerState) {
        this.boilerState = boilerState;
    }

    // boiler is BOILER_NOT_EMPTY (has water) or BOILER_EMPTY
    public int getBoilerWaterState() {
        return boilerWaterState;
    }

    public void setBoilerWaterState(int boilerWaterState) {
        this.boilerWaterState = boilerWaterState;
    }

    // NO_POT (pot not on the plate), POT_EMPTY (pot on plate and empty) or POT_NOT_EMPTY
    public int getPotState() {
        return potState;
    }

    public void setPotState(int potState) {
        this.potState = potState;
    }

    // water plate is PLATE_WARMER_ON (plate is warm) or PLATE_WARMER_OFF
    public int getWarmerPlateState() {
        return warmerPlateState;
    }

    public void setWarmerPlateState(int warmerPlateState) {
        this.warmerPlateState = warmerPlateState;
    }

    // button is BUTTON_PUSHED (start brewing) or BUTTON_NOT_PUSHED
    public int getButtonState() {
        if(buttonState == BUTTON_PUSHED) {
            buttonState = BUTTON_NOT_PUSHED;
            return BUTTON_PUSHED;
        }
        return buttonState;
    }

    public void setButtonState(int buttonState) {
        this.buttonState = buttonState;
    }

    // light is LIGHT_ON (brew is complete and there is cofee in the pot) or LIGHT_OFF
    public int getLightState() {
        return lightState;
    }

    public void setLightState(int lightState) {
        this.lightState = lightState;
    }

    @Override
    public String toString() {
        String s = "";
        // controlled by user or sensors
        s += ("\tButton state:       " + (buttonState == BUTTON_PUSHED ? "PUSHED" : "NOT PUSHED") + "\n");
        s +=  "\tPot state:          ";
        if(potState == POT_EMPTY)          s += "EMPTY\n";
        else if(potState == POT_NOT_EMPTY) s += "NOT EMPTY\n";
        else                               s += "NO POT\n";
        s += ("\tBoiler water state: " + (boilerWaterState == BOILER_EMPTY ? "EMPTY" : "NOT EMPTY") + "\n");
        // controlled by program
        s += ("\tBoiler state:       " + (boilerState == BOILER_OFF ? "OFF" : "ON") + "\n");
        s += ("\tWarmer plate state: " + (warmerPlateState == PLATE_WARMER_ON ? "ON" : "OFF") + "\n");
        s += ("\tLight state:        " + (lightState == LIGHT_ON ? "ON" : "OFF") + "\n\n");
        return s;
    }
}
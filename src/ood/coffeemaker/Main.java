package com.github.ancabanca.interviewprep.ood.coffeemaker;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        M4CoffeeMakerAPI api = new M4CoffeeMakerAPI();
        
        M4UserInterface ui     = new M4UserInterface(api);
        M4Boiler        boiler = new M4Boiler(api);
        M4Pot           pot    = new M4Pot(api);

        ui.initialize(boiler,pot);
        boiler.initialize(ui,pot);
        pot.initialize(ui,boiler);

        while(true) {
            System.out.println(api);
            if(!readInput(api))
                break;
            ui.poll();
            boiler.poll();
            pot.poll();
        }
    }

    public static boolean readInput(M4CoffeeMakerAPI api) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        // user interaction
        if(input.equals("push button"))
            api.setButtonState(api.BUTTON_PUSHED);
        if(input.equals("take pot"))
            api.setPotState(api.NO_POT);
        if(input.equals("put pot full"))
            api.setPotState(api.POT_NOT_EMPTY);
        if(input.equals("put pot empty"))
            api.setPotState(api.POT_EMPTY);
        // sensors
        if(input.equals("water full"))
            api.setBoilerWaterState(api.BOILER_NOT_EMPTY);
        if(input.equals("water empty"))
            api.setBoilerWaterState(api.BOILER_EMPTY);
        if(input.equals("exit"))
            return false;
        return true;
    }
}
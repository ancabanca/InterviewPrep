package com.github.ancabanca.interviewprep.ood.vm;

public class DisplayManager {
    private VendingMachine vm;
    private String errorMessage = "";
    
    public DisplayManager(VendingMachine vm) {
        this.vm = vm;
    }

    public void initialize() {

    }

    public void refreshDisplay() {
        System.out.print(this.errorMessage);
        System.out.println("DISPLAY: Available funds: " + vm.getCurrentFunds());
    }

    public void setErrorMessage(String message) {
        this.errorMessage = "ERROR: " + message + "\n";
        refreshDisplay();
        this.errorMessage = "";
    }
}
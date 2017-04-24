package com.github.ancabanca.interviewprep.ood.vm;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class VendingMachine {
    private final int id;
    private int totalMoney;

    private int     currentFunds;
    private Integer moneyInserted;
    private Integer productChosen;
    private boolean changeRequested;
    private String  displayMessage;

    public VendingMachine(int id){
        this.id = id;
    }

    // current funds
    public int getCurrentFunds() {
        return this.currentFunds;
    }

    public void setCurrentFunds(int f) {
        this.currentFunds = f;
    }

    // money inserted
    public Integer getMoneyInserted() {
        if(this.moneyInserted != null) {
            Integer result = this.moneyInserted;
            this.moneyInserted = null;
            return result;
        }
        return this.moneyInserted;
    }

    public void setMoneyInserted(Integer m) {
        this.moneyInserted = m;
    }

    // product chosen id, null if none
    public Integer getProductChosen() {
        if(this.productChosen != null) {
            Integer result = this.productChosen;
            this.productChosen = null;
            return result;
        }
        return this.productChosen;
    }

    public void setProductChosen(Integer p) {
        this.productChosen = p;
    }

    // change requested
    public boolean getChangeRequested() {
        if(this.changeRequested) {
            this.changeRequested = false;
            return true;
        }
        return this.changeRequested;
    }

    public void setChangeRequested(boolean c) {
        this.changeRequested = c;
    }

    // display
    public void setDisplayMessage(String s) {
        this.displayMessage = s;
    }

    // give product
    public void giveProduct(int i) {
        // physically release product with id from vm
        System.out.println("Giving product with id: " + i);
    }

    public void giveChange(int c) {
        // physically releasechange c from vm
        System.out.println("Giving change: " + c);
    }
}
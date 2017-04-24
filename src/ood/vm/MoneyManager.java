package com.github.ancabanca.interviewprep.ood.vm;

public class MoneyManager {
    private VendingMachine vm;
    private ProductManager pm;
    private DisplayManager dm;

    private boolean moneyInserted;
    
    public MoneyManager(VendingMachine vm) {
        this.vm = vm;
    }

    public void initialize(ProductManager pm, DisplayManager dm) {
        this.pm = pm;
        this.dm = dm;
    }

    public void startSession() {
        this.moneyInserted = true;
        pm.startListening();
    }

    public void endSession() {
        int change = vm.getCurrentFunds();
        if(change > 0)
            vm.giveChange(change);
        vm.setCurrentFunds(0);
        this.moneyInserted = false;
        pm.stopListening();
        return;
    }

    // polling for money all the time
    public void poll() {
        Integer moneyInserted = vm.getMoneyInserted();
        if(moneyInserted != null) {
            vm.setCurrentFunds(vm.getCurrentFunds() + moneyInserted);
            dm.refreshDisplay();
            if(!this.moneyInserted) {
                this.startSession();
            }
            return;
        }

        if(vm.getChangeRequested()) {
            dm.refreshDisplay();
            this.endSession();
        }
    }
}
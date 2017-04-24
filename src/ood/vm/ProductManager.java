package com.github.ancabanca.interviewprep.ood.vm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class ProductManager implements Pollable {
    private VendingMachine vm;
    private MoneyManager   mm;
    private DisplayManager dm;
    
    private boolean moneyInserted;

    private HashMap<Integer /*product id*/,Integer /*price*/> prices;
    private HashMap<Integer /*product id*/,Integer /*count*/> stock;
    private Integer productChosen;

    public ProductManager(VendingMachine vm, String filename) throws Exception, FileNotFoundException {
        this.vm = vm;

        prices = new HashMap<Integer,Integer>();
        stock  = new HashMap<Integer,Integer>();
        this.stockUp(filename);
    }

    public void initialize(MoneyManager mm, DisplayManager dm) {
        this.mm = mm;
        this.dm = dm;
    }

    public void stockUp(String filename) throws Exception, FileNotFoundException {
        // file format: id,price,count
        Scanner s = new Scanner(new File(filename));
        while(s.hasNextLine()) {
            String[] item = s.nextLine().split("\\s+");
            if(item.length != 3)
                throw new Exception("Bad format for input file");
            int id    = Integer.parseInt(item[0]);
            int price = Integer.parseInt(item[1]);
            int count = Integer.parseInt(item[2]);
            prices.put(id, price);
            stock.put (id, count);
        }
    }

    private void removeProduct(int id, int count) {
        int currentCount = stock.get(id);
        stock.put(id, currentCount - count);
    }

    public void startListening() {
        this.moneyInserted = true;
    }

    public void stopListening() {
        this.moneyInserted = false;
    }

    public void poll() {
        Integer id = vm.getProductChosen();
        // if a product was chosen
        if(id != null) {
            if(stock.get(id) == null)
                this.dm.setErrorMessage("Incorrect product chosen");
            else if(stock.get(id) == 0)
                this.dm.setErrorMessage("Product not in stock");
            else if(vm.getCurrentFunds() < prices.get(id))
                this.dm.setErrorMessage("Insufficient funds");
            else {
                vm.setCurrentFunds(vm.getCurrentFunds() - prices.get(id));
                vm.giveProduct(id);
                removeProduct(id,1);
                dm.refreshDisplay();
                if(vm.getCurrentFunds() == 0)
                    mm.endSession();
            }
        }
    }
}
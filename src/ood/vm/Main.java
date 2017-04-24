package com.github.ancabanca.interviewprep.ood.vm;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception, FileNotFoundException {
        VendingMachine vm = new VendingMachine(1);

        MoneyManager   mm = new MoneyManager(vm);
        ProductManager pm = new ProductManager(vm, "input.txt");
        DisplayManager dm = new DisplayManager(vm);

        mm.initialize(pm,dm);
        pm.initialize(mm,dm);
        dm.initialize();

        while(true) {
            if(!readInput(vm))
                break;
            mm.poll();
            pm.poll();
        }
    }

    private static boolean readInput(VendingMachine vm) {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        if(input.equals("exit"))
            return false;
        String[] tokens = input.split(" ");
        if(tokens[0].equals("put"))
            vm.setMoneyInserted(Integer.parseInt(tokens[1]));
        else if(tokens[0].equals("get"))
            vm.setProductChosen(Integer.parseInt(tokens[1]));
        else if(tokens[0].equals("change"))
            vm.setChangeRequested(true);
        return true;
    }
}
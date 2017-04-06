package com.github.ancabanca.interviewprep.problems;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TaxicabNumbers {
    public static List<Integer> getSumsOfCubes(int n) {
        List<Integer> list = new LinkedList<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 1; Math.pow(i, 3) < n; i++) {
            double r = Math.cbrt(n - Math.pow(i, 3));
            if((double)(int)r == r && !set.contains(i)) {
                list.add(i);
                list.add((int)r);
                set.add(i);
                set.add((int)r);
            }
        }
        return list;
    }

    public static List<Integer> getTaxicabValuesSmallerThan(int n) {
        List<Integer> values = new LinkedList<Integer>();
        for(int i = 1; i < n; i++) {
            List<Integer> sumsOfCubes = getSumsOfCubes(i);
            if(sumsOfCubes != null && sumsOfCubes.size() >= 4) // at least 2 pairs
                values.add(i);
        }
        return values;
    }
}
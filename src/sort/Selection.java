package com.github.ancabanca.interviewprep.sort;

import java.util.Arrays;

public class Selection {
    @SuppressWarnings("unchecked") // Comparable is used raw
    public static void sort(Comparable[] array) {
        for(int i = 0; i < array.length-1; i++) {
            int min = i;
            for(int j = i+1; j < array.length; j++) {
                if(less(array[j], array[min]))
                    min = j;
            }
            exchange(array,i,min);
        }
    }

    @SuppressWarnings("unchecked") // Comparable is used raw
    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    @SuppressWarnings("unchecked") // Comparable is used raw
    private static void exchange(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    public static void main(String[] args) {
        Integer[] array = {7,2,4,9,5,3,7};
        System.out.println(Arrays.toString(array));
        Selection.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
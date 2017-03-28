package com.github.ancabanca.interviewprep.util;

import java.util.Arrays;
import java.util.Random;

public class Sort {
    @SuppressWarnings("unchecked") // Comparable is used raw
    public static void selectionSort(Comparable[] array) {
        for(int i = 0; i < array.length-1; i++) {
            int min = i;
            for(int j = i+1; j < array.length; j++) {
                if(less(array[j], array[min]))
                    min = j;
            }
            exchange(array,i,min);
        }
    }

    public static void insertionSort(Comparable[] array) {
        hSort(array, 1);
    }

    public static void shellSort(Comparable[] array) {
        int h = 1;
        while(3 * h + 1 < array.length)
            h = 3 * h + 1;

        while(h >= 1) {
            hSort(array, h);
            h = h / 3;
        }
    }

    // sort an array of 0s, 1s and 2s (aka the Dutch National Flag problem)
    public static void threeWayPartition(Integer[] array) {
        int low = 0;
        int mid = 0;
        int high = array.length - 1;

        while(mid <= high) {
            if(array[mid] == 0)
                exchange(array, mid++, low++);
            else if(array[mid] == 1)
                mid++;
            else
                exchange(array, mid, high--);
        }
    }

    public static void shuffle(Comparable[] array) {
        Random r = new Random();
        for(int i = 0; i < array.length; i++) {
            exchange(array, i, r.nextInt(i+1));
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

    // Used in Shell sort. Insertion sort is an hSort with h = 1.
    private static void hSort(Comparable[] array, int h) {
        for(int i = h; i < array.length; i++) {
            for(int j = i; j-h >= 0; j--)
                if(less(array[j], array[j-h]))
                    exchange(array, j, j-h);
                else break;
        }
    }
}
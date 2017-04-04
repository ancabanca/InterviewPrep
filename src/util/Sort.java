package com.github.ancabanca.interviewprep.util;

import java.util.Arrays;
import java.util.Random;

public class Sort {
    private static final int MERGESORT_CUTOFF = 7;
    private static final int QUICKSORT_CUTOFF = 10;

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
        hSort(array, 1, 0, array.length-1);
    }

    public static void shellSort(Comparable[] array) {
        int h = 1;
        while(3 * h + 1 < array.length)
            h = 3 * h + 1;

        while(h >= 1) {
            hSort(array, h, 0, array.length-1);
            h = h / 3;
        }
    }

    // Used in Shell sort. Insertion sort is an hSort with h = 1.
    private static void hSort(Comparable[] array, int h, int lo, int hi) {
        for(int i = h; i <= hi; i++) {
            for(int j = i; j-h >= lo; j--)
                if(less(array[j], array[j-h]))
                    exchange(array, j, j-h);
                else break;
        }
    }

    public static void mergesort(Comparable[] array) {
        Comparable[] aux = new Comparable[array.length];
        mergesort(array, aux, 0, array.length - 1);
    }

    private static void mergesort(Comparable[] array, Comparable[] aux, int low, int high) {
        if(low == high)
            return;
        
        // use insertion sort on small arrays
        if(high - low <= MERGESORT_CUTOFF) {
            hSort(array, 1, low, high);
            return;
        }

        int mid = (low + high) / 2;
        mergesort(array, aux, low,   mid);
        mergesort(array, aux, mid+1, high);
        
        // if the two halves are already in the right order, skip merge step
        if(!less(array[mid], array[mid+1]))
            merge(array, aux, low, mid, high);
    }

    private static void merge(Comparable[] array, Comparable[] aux, int low, int mid, int high) {
        for(int k = low; k <= high; k++)
            aux[k] = array[k];

        int i = low;
        int j = mid + 1;
        int k = low;
        while(k <= high) {
            if(i > mid)                  array[k++] = aux[j++];
            else if(j > high)            array[k++] = aux[i++];
            else if(less(aux[i],aux[j])) array[k++] = aux[i++];
            else                         array[k++] = aux[j++];
        }
    }

    public static void quicksort(Comparable[] array) {
        shuffle(array);
        quicksort(array, 0, array.length-1);
    }

    private static void quicksort(Comparable[] array, int lo, int hi) {
        // after cutoff, I can just return, then do one last insertion sort at the end
        if(hi - lo <= QUICKSORT_CUTOFF)
            hSort(array, 1, lo, hi);
        else {
            int pivot = partition(array, lo, hi);
            quicksort(array, lo, pivot-1);
            quicksort(array, pivot+1, hi);
        }
    }

    private static int partition(Comparable[] array, int lo, int hi) {
        int pivot = medianOf3(array, lo, hi);
        exchange(array, lo++, pivot);
        pivot = lo - 1;
        while(lo <= hi) {
            while(lo <= hi && (less(array[lo], array[pivot])))
                lo++;
            while(less(array[pivot], array[hi]))
                hi--;
            if(lo <= hi)
                exchange(array, lo++, hi--);
        }
        exchange(array, pivot, hi);
        return hi;
    }

    private static int medianOf3(Comparable[] array, int lo, int hi) {
        Comparable a = array[lo];
        Comparable b = array[hi];
        int mid = lo + (hi-lo)/2;
        Comparable c = array[mid];
        if(less(a, b))
            if(less(b, c))
                return hi;
            else if(less(c, a))
                return lo;
            else
                return mid;
        else
            if(less(a, c))
                return lo;
            else if(less(c, b))
                return hi;
            else
                return mid;
    }

    public static Comparable quickselect(Comparable[] array, int k) {
        shuffle(array);
        if(k < 0 || k > array.length-1)
            throw new IllegalArgumentException("k is out of bounds.");

        int lo = 0;
        int hi = array.length-1;
        
        while(hi > lo) {
            int i = partition(array, lo, hi);
            if(k == i)
                return array[i];
            else if(k < i)
                hi = i-1;
            else
                lo = i+1;
        }
        // this should never be reached, since k is within (0, array.length-1)
        return array[k];
    }

    // Sort an array of 0s, 1s and 2s (aka the Dutch National Flag problem).
    // Also used in quicksort, sort is faster when there are many duplicates.
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
}
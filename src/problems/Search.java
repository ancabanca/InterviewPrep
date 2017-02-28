package com.github.ancabanca.interviewprep.problems;

import java.util.Arrays;

/**
 * An array is bitonic if it is comprised of an increasing sequence of integers
 *  followed immediately by a decreasing sequence of integers.
 */
public class Search {
    
    /**
     * Searches integer x in the bitonic array.
     * Assumption: all integers in the array are distinct.
     */
    public static boolean bitonicSearch(int x, int[] array) {
        int peak = getPeakPosition(array);
        if(x > array[peak])
            return false;
        return x == array[peak] ||
            binarySearch(x,0,peak-1,array) ||
            binarySearchReverse(x,peak+1,array.length-1,array);
    }

    private static int getPeakPosition(int[] array) {
        return getPeakPosition(0, array.length-1, array);
    }

    private static int getPeakPosition(int lo, int hi, int[] array) {
        int mid = lo + (hi - lo)/2;
        if(array[mid-1] < array[mid] && array[mid] > array[mid+1])
            return mid;
        else if(array[mid-1] < array[mid])
            return getPeakPosition(mid+1, hi, array);
        else
            return getPeakPosition(lo, mid-1, array);
    }

    public static boolean binarySearch(int x, int[] array) {
        return binarySearch(x,0,array.length-1, array);
    }

    private static boolean binarySearch(int x, int lo, int hi, int[] array) {
        int mid = lo + (hi - lo)/2;
        if(lo > hi)
            return false;
        if(x < array[mid])
            return binarySearch(x, lo, mid-1, array);
        else if (x > array[mid])
            return binarySearch(x, mid+1, hi, array);
        else
            return true;
    }

    // Performs binary search in an array sorted descendingly.
    // TODO: is there a way to parametrize the main binary search algorithm to do this?
    private static boolean binarySearchReverse(int x, int lo, int hi, int[] array) {
        int mid = lo + (hi - lo)/2;
        if(lo > hi)
            return false;
        if(x > array[mid])
            return binarySearchReverse(x, lo, mid-1, array);
        else if (x < array[mid])
            return binarySearchReverse(x, mid+1, hi, array);
        else
            return true;
    }
}
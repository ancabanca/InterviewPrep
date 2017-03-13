import static org.junit.Assert.*;

import com.github.ancabanca.interviewprep.problems.Search;
import org.junit.Test;

public class SearchTest {
    private int[] sortedArrayOdd  = {1,3,5,6,7,8,9};
    private int[] sortedArrayEven = {0,2,3,5,6,7,8,10};
    
    private int[] bitonicArrayOdd  = {1,3,5,6,8,4,2};
    private int[] bitonicArrayEven = {0,20,10,6,4,3,2,1};
    
    // Tests for binary search
    @Test
    public void testBinarySearchOddTrue() {
        assertTrue(Search.binarySearch(5, sortedArrayOdd));
    }

    @Test
    public void testBinarySearchOddTrueFirst() {
        assertTrue(Search.binarySearch(1, sortedArrayOdd));
    }

    @Test
    public void testBinarySearchOddTrueLast() {
        assertTrue(Search.binarySearch(9, sortedArrayOdd));
    }

    @Test
    public void testBinarySearchOddFalse() {
        assertFalse(Search.binarySearch(4, sortedArrayOdd));
    }

    @Test
    public void testBinarySearchOddFalseBeforeFirst() {
        assertFalse(Search.binarySearch(0, sortedArrayOdd));
    }

    @Test
    public void testBinarySearchOddFalseAfterLast() {
        assertFalse(Search.binarySearch(11, sortedArrayOdd));
    }

    // array {0,2,3,5,6,7,8,10}
     @Test
    public void testBinarySearchEvenTrue() {
        assertTrue(Search.binarySearch(8, sortedArrayEven));
    }

    @Test
    public void testBinarySearchEvenTrueFirst() {
        assertTrue(Search.binarySearch(0, sortedArrayEven));
    }

    @Test
    public void testBinarySearchEvenTrueLast() {
        assertTrue(Search.binarySearch(10, sortedArrayEven));
    }

    @Test
    public void testBinarySearchEvenFalse() {
        assertFalse(Search.binarySearch(9, sortedArrayEven));
    }

    @Test
    public void testBinarySearchEvenFalseBeforeFirst() {
        assertFalse(Search.binarySearch(-1, sortedArrayEven));
    }

    @Test
    public void testBinarySearchEvenFalseAfterLast() {
        assertFalse(Search.binarySearch(14, sortedArrayEven));
    }

    
    // Tests for bitonic search
    @Test
    public void testBitonicSearchOddTrue() {
        assertTrue(Search.bitonicSearch(4, bitonicArrayOdd));
    }

    @Test
    public void testBitonicSearchOddTruePeak() {
        assertTrue(Search.bitonicSearch(8, bitonicArrayOdd));
    }

    @Test
    public void testBitonicSearchOddTrueFirst() {
        assertTrue(Search.bitonicSearch(1, bitonicArrayOdd));
    }

    @Test
    public void testBitonicSearchOddTrueLast() {
        assertTrue(Search.bitonicSearch(2, bitonicArrayOdd));
    }

    @Test
    public void testBitonicSearchOddFalse() {
        assertFalse(Search.bitonicSearch(7, bitonicArrayOdd));
    }

    @Test
    public void testBitonicSearchOddFalseTooSmall() {
        assertFalse(Search.bitonicSearch(0, bitonicArrayOdd));
    }

    @Test
    public void testBitonicSearchOddFalseTooBig() {
        assertFalse(Search.bitonicSearch(20, bitonicArrayOdd));
    }

    // array {0,20,10,6,4,3,2,1};
    @Test
    public void testBitonicSearchEvenTrue() {
        assertTrue(Search.bitonicSearch(4, bitonicArrayEven));
    }

    @Test
    public void testBitonicSearchEvenTruePeak() {
        assertTrue(Search.bitonicSearch(20, bitonicArrayEven));
    }

    @Test
    public void testBitonicSearchEvenTrueFirst() {
        assertTrue(Search.bitonicSearch(0, bitonicArrayEven));
    }

    @Test
    public void testBitonicSearchEvenTrueLast() {
        assertTrue(Search.bitonicSearch(1, bitonicArrayEven));
    }

    @Test
    public void testBitonicSearchEvenFalse() {
        assertFalse(Search.bitonicSearch(15, bitonicArrayEven));
    }

    @Test
    public void testBitonicSearchEvenFalseTooSmall() {
        assertFalse(Search.bitonicSearch(-1, bitonicArrayEven));
    }

    @Test
    public void testBitonicSearchEvenFalseTooBig() {
        assertFalse(Search.bitonicSearch(21, bitonicArrayEven));
    }
}
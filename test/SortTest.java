import static org.junit.Assert.*;

import com.github.ancabanca.interviewprep.util.Sort;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import org.junit.Test;
import org.junit.BeforeClass;

public class SortTest {
    private static Integer[] randomArray;
    private static Integer[] sortedArray;

    @BeforeClass
    public static void setup() throws java.io.IOException {
        randomArray = new Integer[500];
        Scanner s = new Scanner(new File("test/input/randomInts500.txt"));
        
        int i = 0;
        while(s.hasNextLine()) {
            randomArray[i++] = Integer.parseInt(s.nextLine().trim());
        }

        sortedArray = new Integer[500];
        s = new Scanner(new File("test/input/randomInts500sorted.txt"));
        
        i = 0;
        while(s.hasNextLine()) {
            sortedArray[i++] = Integer.parseInt(s.nextLine().trim());
        }
    }

    // selection sort
    @Test
    public void testSelection() {
        Integer[] array = {7,2,4,9,5,3,7};
        Sort.selectionSort(array);
        assertArrayEquals(new Integer[] {2,3,4,5,7,7,9}, array);
    }

    @Test
    public void testSelectionFromFile() throws java.io.IOException {
        Integer[] randomArrayCopy = Arrays.copyOf(randomArray, randomArray.length);        
        Sort.selectionSort(randomArrayCopy);
        assertArrayEquals(sortedArray, randomArrayCopy);
    }

    // insertion sort
    @Test
    public void testInsertion() {
        Integer[] array = {7,2,4,9,5,3,7};
        Sort.insertionSort(array);
        assertArrayEquals(new Integer[] {2,3,4,5,7,7,9}, array);
    }

    @Test
    public void testInsertionFromFile() throws java.io.IOException {
        Integer[] randomArrayCopy = Arrays.copyOf(randomArray, randomArray.length);        
        Sort.insertionSort(randomArrayCopy);
        assertArrayEquals(sortedArray, randomArrayCopy);
    }

    // Shell sort
    @Test
    public void testShellsort() {
        Integer[] array = {7,2,4,9,5,3,7};
        Sort.shellSort(array);
        assertArrayEquals(new Integer[] {2,3,4,5,7,7,9}, array);
    }

    @Test
    public void testShellsortFromFile() throws java.io.IOException {
        Integer[] randomArrayCopy = Arrays.copyOf(randomArray, randomArray.length);
        Sort.shellSort(randomArrayCopy);
        assertArrayEquals(sortedArray, randomArrayCopy);
    }

    // mergesort
    @Test
    public void testMergesort() {
        Integer[] array = {7,2,4,9,5,3,7,10,1};
        Sort.mergesort(array);
        assertArrayEquals(new Integer[] {1,2,3,4,5,7,7,9,10}, array);
    }

    @Test
    public void testMergesortFromFile() throws java.io.IOException {
        Integer[] randomArrayCopy = Arrays.copyOf(randomArray, randomArray.length);        
        Sort.mergesort(randomArrayCopy);
        assertArrayEquals(sortedArray, randomArrayCopy);
    }

    // quicksort
    @Test
    public void testQuicksort() {
        Integer[] array = {7,2,4,9,5,3,7,10,1};
        Sort.quicksort(array);
        assertArrayEquals(new Integer[] {1,2,3,4,5,7,7,9,10}, array);
    }

    @Test
    public void testQuicksortDuplicates() {
        Integer[] array = new Integer[] {0,2,0,0,1,1,2,0,2,1,0};
        Sort.quicksort(array);
        assertArrayEquals(new Integer[] {0,0,0,0,0,1,1,1,2,2,2}, array);
    }

    @Test
    public void testQuicksortFromFile() throws java.io.IOException {
        Integer[] randomArrayCopy = Arrays.copyOf(randomArray, randomArray.length);
        Sort.quicksort(randomArrayCopy);
        assertArrayEquals(sortedArray, randomArrayCopy);
    }

    @Test
    public void testQuicksortFromFileSortedArray() throws java.io.IOException {
        Integer[] sortedArrayCopy = Arrays.copyOf(sortedArray, sortedArray.length);
        Sort.quicksort(sortedArrayCopy);
        assertArrayEquals(sortedArray, sortedArrayCopy);
    }

    // heapsort
    @Test
    public void testHeapsort() {
        Integer[] array = {7,2,4,9,5,3,7,10,1};
        Sort.heapsort(array);
        assertArrayEquals(new Integer[] {1,2,3,4,5,7,7,9,10}, array);
    }

    @Test
    public void testHeapsortDuplicates() {
        Integer[] array = new Integer[] {0,2,0,0,1,1,2,0,2,1,0};
        Sort.heapsort(array);
        assertArrayEquals(new Integer[] {0,0,0,0,0,1,1,1,2,2,2}, array);
    }

    @Test
    public void testHeapsortFromFile() throws java.io.IOException {
        Integer[] randomArrayCopy = Arrays.copyOf(randomArray, randomArray.length);
        Sort.heapsort(randomArrayCopy);
        assertArrayEquals(sortedArray, randomArrayCopy);
    }

    @Test
    public void testHeapsortFromFileSortedArray() throws java.io.IOException {
        Integer[] sortedArrayCopy = Arrays.copyOf(sortedArray, sortedArray.length);
        Sort.heapsort(sortedArrayCopy);
        assertArrayEquals(sortedArray, sortedArrayCopy);
    }

    // quickselect
    @Test
    public void testQuickselect() {
        Integer[] array = {7,2,4,9,5,3,7,10,1};
        Comparable answer = Sort.quickselect(array, 0);
        assertEquals(new Integer(1), answer);
    }

    @Test
    public void testQuickselectDuplicates() {
        Integer[] array = new Integer[] {0,2,0,0,1,1,2,0,2,1,0};
        Comparable answer = Sort.quickselect(array, 7);
        assertEquals(new Integer(1), answer);
    }

    @Test
    public void testQuickselectFromFile() throws java.io.IOException {
        Integer[] randomArrayCopy = Arrays.copyOf(randomArray, randomArray.length);
        Comparable answer = Sort.quickselect(randomArrayCopy, 233);
        assertEquals(new Integer(2231), answer);
    }

    @Test
    public void testQuickselectFromFileSortedArray() throws java.io.IOException {
        Integer[] sortedArrayCopy = Arrays.copyOf(sortedArray, sortedArray.length);
        Comparable answer = Sort.quickselect(sortedArrayCopy, 40);
        assertEquals(new Integer(378), answer);
    }

    // shuffle
    @Test
    public void testShuffleFromFile() throws java.io.IOException {
        Integer[] sortedArrayCopy = Arrays.copyOf(sortedArray, sortedArray.length);
        Sort.shuffle(sortedArrayCopy);
        assertFalse(Arrays.equals(sortedArray, sortedArrayCopy));
    }


    private void generateRandomInts() throws java.io.IOException {
        OutputStreamWriter fw = new OutputStreamWriter
                (new FileOutputStream("test/input/randomInts500.txt"), "utf-8");
        Random r = new Random();
        for (int i = 0; i < 500; i++)
            fw.write(r.nextInt(5000) + "\n");
        fw.close();
    }

    // three way partition
    @Test
    public void testThreeWayPartitionSorted() {
        Integer[] array = new Integer[] {0,0,1,1,2,2};
        Sort.threeWayPartition(array);
        assertArrayEquals(new Integer[] {0,0,1,1,2,2}, array);
    }

    @Test
    public void testThreeWayPartitionNotSorted1() {
        Integer[] array = new Integer[] {0,2,0,0,1,1,2,0,2,1,0};
        Sort.threeWayPartition(array);
        assertArrayEquals(new Integer[] {0,0,0,0,0,1,1,1,2,2,2}, array);
    }

    @Test
    public void testThreeWayPartitionNotSorted2() {
        Integer[] array = new Integer[] {0,1,2,0,1,1,2,2,0,1};
        Sort.threeWayPartition(array);
        assertArrayEquals(new Integer[] {0,0,0,1,1,1,1,2,2,2}, array);
    }

    @Test
    public void testThreeWayPartitionNoTwosSorted() {
        Integer[] array = new Integer[] {0,0,0,1,1};
        Sort.threeWayPartition(array);
        assertArrayEquals(new Integer[] {0,0,0,1,1}, array);
    }

    @Test
    public void testThreeWayPartitionNoTwosUnsorted() {
        Integer[] array = new Integer[] {0,1,0,1,0};
        Sort.threeWayPartition(array);
        assertArrayEquals(new Integer[] {0,0,0,1,1}, array);
    }
}
import static org.junit.Assert.*;

import com.github.ancabanca.interviewprep.util.BST;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.BeforeClass;
import org.junit.Test;

public class BSTTest {
    private static BST<String,Integer> bstSmall;
    private static BST<String,Integer> bst2DigitInts;

    @BeforeClass
    public static void setup() throws FileNotFoundException {
        bstSmall = new BST<String,Integer>();
        String[] strings = "searchexample".split("");
        Integer[] ints = new Integer[] {7,2,4,9,5,3,7,10,1,6,2,9,12};
        for(int i = 0; i < ints.length; i++) {
            bstSmall.put(strings[i], ints[i]);
        }

        bst2DigitInts = new BST<String,Integer>();
        Scanner s = new Scanner(new File("test/input/2DigitInts500.txt"));
        while(s.hasNextLine()) {
            String key = s.nextLine();
            Integer count = bst2DigitInts.get(key);
            if(count == null)
                bst2DigitInts.put(key, 1);
            else
                bst2DigitInts.put(key, count+1);
        }
        s.close();
    }

    // empty tree
    @Test
    public void testBSTEmptyTree() {
        BST<String,Integer> bst = new BST<String,Integer>();
        assertNull(bst.get("s"));
    }

    @Test
    public void testBSTInsertEmptyTree() {
        BST<String,Integer> bst = new BST<String,Integer>();
        bst.put("s",5);
        assertEquals(5, (int)bst.get("s"));
    }

    // basic operations: put and get
    @Test
    public void testBSTPutGetSmallTree() {
        assertEquals(7, (int)bstSmall.get("s"));
        assertEquals(1, (int)bstSmall.get("a"));
        assertEquals(12, (int)bstSmall.get("e"));
    }

    @Test
    public void testBSTPutGetRandomInts() {
        assertEquals(11, (int)bst2DigitInts.get("13"));
        assertEquals( 4, (int)bst2DigitInts.get("72"));
        assertNull(bst2DigitInts.get("7"));
    }

    // min and max
    @Test
    public void testBSTMinSmallTree() {
        assertEquals("a", bstSmall.min());
    }

    @Test
    public void testBSTMinRandomInts() {
        assertEquals("10", bst2DigitInts.min());
    }

    @Test
    public void testBSTSmallTreeMax() {
        assertEquals("x", bstSmall.max());
    }

    @Test
    public void testBSTRandomIntsMax() {
        assertEquals("99", bst2DigitInts.max());
    }

    // floor, size, rank
    @Test
    public void testBSTRandomIntsFloor() {
        assertEquals("55", bst2DigitInts.floor("56"));
    }

    @Test
    public void testBSTRandomIntsSize() {
        assertEquals(71, bst2DigitInts.size()); // FAILS
    }

    @Test
    public void testBSTRandomIntsRank() {
        assertEquals(40, bst2DigitInts.rank("52"));
    }

    // inorder traversal
    @Test
    public void testBSTSmallTreeInorder() {
        String[] strings = "acehlmprsx".split("");
        Iterable<String> keys = bstSmall.keys();
        int i = 0;
        for(String k : keys) {
            assertEquals(strings[i++], k);
        }
        assertEquals(strings.length, i);
    }
}
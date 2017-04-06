import static org.junit.Assert.*;

import com.github.ancabanca.interviewprep.util.BST;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.Test;

public class BSTTest {
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

    @Test
    public void testBSTPutGetSmallTree() {
        BST<String,Integer> bst = new BST<String,Integer>();
        String[] strings = "searchexample".split("");
        Integer[] ints = new Integer[] {7,2,4,9,5,3,7,10,1,6,2,9,12};
        for(int i = 0; i < ints.length; i++) {
            bst.put(strings[i], ints[i]);
        }
        assertEquals(7, (int)bst.get("s"));
        assertEquals(1, (int)bst.get("a"));
        assertEquals(12, (int)bst.get("e"));
    }

    @Test
    public void testBSTPutGetRandomInts() throws FileNotFoundException {
        BST<String,Integer> bst = new BST<String,Integer>();
        Scanner s = new Scanner(new File("test/input/randomInts500.txt"));
        while(s.hasNextLine()) {
            String key = s.nextLine();
            if(key.length() < 2)
                continue;
            key = key.substring(0,2);
            Integer count = bst.get(key);
            if(count == null)
                bst.put(key, 1);
            else
                bst.put(key, count+1);
        }
        assertEquals(11, (int)bst.get("13"));
        assertEquals( 4, (int)bst.get("72"));
        assertNull(bst.get("7"));
    }

    // @Test
    // public void testBSTInsertEmptyTree() {
    //     BST<String,Integer> bst = new BST<String,Integer>();
    //     bst.put("s",5);
    //     assertEquals(5, (int)bst.get("s"));
    // }
}
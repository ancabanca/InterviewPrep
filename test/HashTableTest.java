import static org.junit.Assert.*;

import com.github.ancabanca.interviewprep.util.HashTable;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.BeforeClass;
import org.junit.Test;

public class HashTableTest {
    @Test
    public void testHashTable() {
        HashTable<String,Integer> table = new HashTable<String,Integer>();
        table.put("a",1);
        assertEquals(1, (int)table.get("a"));
    }

    @Test
    public void testHashTableInts500() throws FileNotFoundException {
        HashTable<String,Integer> table = new HashTable<String,Integer>();
        Scanner s = new Scanner(new File("test/input/2DigitInts500.txt"));
        while(s.hasNextLine()) {
            String key = s.nextLine();
            Integer value = table.get(key);
            if(value != null)
                table.put(key, value+1);
            else
                table.put(key, 1);
        }
        assertEquals(7, (int)table.get("28"));
    }
}
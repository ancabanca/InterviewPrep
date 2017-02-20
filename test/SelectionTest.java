import org.junit.Test;

import static org.junit.Assert.*;

public class SelectionTest {
    @Test
    public void test() {
        Integer[] array = {7,2,4,9,5,3,7};
        Selection.sort(array);
        assertArrayEquals(new Integer[] {2,3,4,5,7,7,9}, array);
    }
}
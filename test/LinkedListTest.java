import static org.junit.Assert.*;

import com.github.ancabanca.interviewprep.util.LinkedList;
import java.util.NoSuchElementException;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {
    LinkedList<Integer> list;

    @Before
    public void setup() {
        list = new LinkedList<Integer>();
    }

    // add
    @Test
    public void testLinkedList_AddOne() {
        list.add(45);
        assertEquals(45, (int)list.getFirst());
        assertEquals( 1, list.size());
    }

    @Test
    public void testLinkedList_AddTwo() {
        list.add(45);
        list.add(23);
        assertEquals(45, (int)list.getFirst());
        assertEquals(23, (int)list.getLast());
        assertEquals( 2, list.size());
    }

    @Test
    public void testLinkedList_AddFive() {
        list.add(45);
        list.add(23);
        list.add(9);
        list.add(10);
        list.add(78);
        assertEquals(45, (int)list.getFirst());
        assertEquals(78, (int)list.getLast());
        assertEquals( 5, list.size());
    }

    @Test(expected = NullPointerException.class)
    public void testLinkedList_AddNull() {
        list.add(null);
    }

    // remove
    @Test
    public void testLinkedList_RemoveNotFound() {
        list.add(45);
        list.add(13);
        assertNull(list.remove(10));
    }

    @Test
    public void testLinkedList_RemoveFirstElement() {
        list.add(45);
        list.add(13);
        assertNull  (list.remove(10));
    }

    @Test(expected = NullPointerException.class)
    public void testLinkedList_RemoveNull() {
        list.remove(null);
    }

    // removeFirst
    @Test(expected = NoSuchElementException.class)
    public void testLinkedList_RemoveFirstEmpty() {
        list.removeFirst();
    }

    @Test
    public void testLinkedList_RemoveFirstOneElement() {
        list.add(45);
        assertEquals(45, (int)list.removeFirst());
        assertEquals(0,  list.size());
    }

    @Test
    public void testLinkedList_RemoveFirstMultipleElement() {
        list.add(12);
        list.add(9);
        list.add(45);
        assertEquals(12, (int)list.removeFirst());
        assertEquals(2,  list.size());
    }

    // removeDuplicates
    @Test
    public void testRemoveDuplicates_NoElements() {
        boolean hasDuplicates = list.removeDuplicates();
        assertFalse(hasDuplicates);
        assertEquals("", list.toString());
    }

    @Test
    public void testRemoveDuplicates_OneElement() {
        list.add(5);
        boolean hasDuplicates = list.removeDuplicates();
        assertFalse(hasDuplicates);
        assertEquals(1, list.size());
        assertEquals("5", list.toString());
    }

    @Test
    public void testRemoveDuplicates_NoDuplicates() {
        list.add(5);
        list.add(4);
        list.add(9);
        boolean hasDuplicates = list.removeDuplicates();
        assertFalse(hasDuplicates);
        assertEquals("5 4 9", list.toString());
    }

    @Test
    public void testRemoveDuplicates_HasDuplicates1() {
        list.add(5);
        list.add(2);
        list.add(5);
        list.add(3);
        list.add(2);
        assertTrue(list.removeDuplicates());
        assertEquals("5 2 3", list.toString());
    }

    @Test
    public void testRemoveDuplicates_HasDuplicates2() {
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(2);
        list.add(2);
        assertTrue(list.removeDuplicates());
        assertEquals("5 2", list.toString());
    }

    @Test
    public void testRemoveDuplicates_HasOnlyDuplicates() {
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        list.add(5);
        assertTrue(list.removeDuplicates());
        assertEquals("5", list.toString());
    }

    // toString
    @Test
    public void testToString_Empty() {
        assertEquals("", list.toString());
    }

    @Test
    public void testToString_OneElement() {
        list.add(2);
        assertEquals("2", list.toString());
    }

    @Test
    public void testToString_MultipleElements() {
        list.add(2);
        list.add(9);
        list.add(10);
        list.add(300);
        assertEquals("2 9 10 300", list.toString());
    }
}
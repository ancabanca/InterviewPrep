import static org.junit.Assert.*;

import com.github.ancabanca.interviewprep.ood.parkinglot.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ParkingLotTest {

    private Lot lot;
    private LotManager lm;

    @BeforeClass
    public static void setup() {
        
    }

    @Before
    public void setupTest() {
        lot = new Lot();
        lm = new LotManager(lot);
    }

    // Test method: Spot getFreeSpot(String type)
    @Test
    public void testGetFreeSpot_Success() {
        lm.getFreeSpot("Medium");
        assertEquals(5, lot.freeSpotsCount());
    }

    @Test
    public void testGetFreeSpot_Null() throws ParkingLotFullException, NoSpotsForGivenTypeException {
        lm.park("small");
        assertNull(lm.getFreeSpot("small"));
        assertEquals(4, lot.freeSpotsCount());
    }    

    @Test(expected = IllegalArgumentException.class)
    public void testGetFreeSpot_IllegalArgumentException() {
        lm.getFreeSpot("huge");
    }
    
    // Test method: void park(Spot spot)
    @Test(expected = NullPointerException.class)
    public void testPark_SpotNullPointerException() throws ParkingLotFullException, NoSpotsForGivenTypeException {
        Spot s = null;
        lm.park(s);
    }    

    // Test method: void park(String type)
    @Test
    public void testPark_Successful() throws ParkingLotFullException, NoSpotsForGivenTypeException {
        lm.park("medium");
        assertFalse(lot.isFull());
        assertEquals(4, lot.freeSpotsCount());
    }
    
    @Test(expected = NullPointerException.class)
    public void testPark_StringNullPointerException() throws ParkingLotFullException, NoSpotsForGivenTypeException {
        String s = null;
        lm.park(s);
    }    

    @Test(expected = IllegalArgumentException.class)
    public void testPark_IllegalArgumentException() throws ParkingLotFullException, NoSpotsForGivenTypeException {
        lm.park("huge");
    }

    @Test(expected = NoSpotsForGivenTypeException.class)
    public void testPark_NoSpotsForGivenTypeException() throws ParkingLotFullException, NoSpotsForGivenTypeException {
        lm.park("medium");
        lm.park("medium");
        lm.park("medium");
    }

    @Test(expected = ParkingLotFullException.class)
    public void testPark_ParkingLotFullException() throws ParkingLotFullException, NoSpotsForGivenTypeException {
        lm.park("medium");
        lm.park("medium");
        lm.park("small");
        lm.park("large");
        lm.park("motorcycle");
        assertEquals(0, lot.freeSpotsCount());
        lm.park("small");
    }

    // Test method: void free(Spot s)
    @Test
    public void testFreeSpot_Success() throws ParkingLotFullException, NoSpotsForGivenTypeException {
        Spot s = lm.park("medium");
        assertEquals(4, lot.freeSpotsCount());
        lm.freeSpot(s);
        assertEquals(5, lot.freeSpotsCount());
    }
}
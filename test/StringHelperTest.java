import static org.junit.Assert.*;

import com.github.ancabanca.interviewprep.problems.StringHelper;
import org.junit.Test;

public class StringHelperTest {
    
    @Test
    public void testHasAllUniqueCharacters1_True() {
        assertTrue(StringHelper.hasAllUniqueCharacters1("joe mulvEy", 255));
    }

    @Test
    public void testHasAllUniqueCharacters1_False() {
        assertFalse(StringHelper.hasAllUniqueCharacters1("Anca Burducea", 255));
    }

    @Test
    public void testHasAllUniqueCharacters2_True() {
        assertTrue(StringHelper.hasAllUniqueCharacters2("joe mulvEy", 255));
    }

    @Test
    public void testHasAllUniqueCharacters2_False() {
        assertFalse(StringHelper.hasAllUniqueCharacters2("Anca Burducea", 255));
    }
}
import static org.junit.Assert.*;

import com.github.ancabanca.interviewprep.problems.TaxicabNumbers;
import java.util.List;
import org.junit.Test;

public class TaxicabNumbersTest {
    @Test
    public void testTaxicabNumbers() {
        List<Integer> list = TaxicabNumbers.getTaxicabValuesSmallerThan(10000);
        assertEquals(1729, (int)list.get(0));
        assertEquals(4104, (int)list.get(1));
        assertEquals(2, list.size());
    }
}
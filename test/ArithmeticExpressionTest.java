import org.junit.Test;
import static org.junit.Assert.*;

import com.github.ancabanca.interviewprep.problems.ArithmeticExpression;

public class ArithmeticExpressionTest {
    
    @Test
    public void test() {
        String s = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        ArithmeticExpression ae = new ArithmeticExpression(s);
        int result = ae.evaluate();
        assertEquals(101, result);
    }
}
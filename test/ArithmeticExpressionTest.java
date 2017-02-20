import org.junit.Test;
import static org.junit.Assert.*;

public class ArithmeticExpressionTest {
    
    @Test
    public void test() {
        String s = "( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )";
        ArithmeticExpression ae = new ArithmeticExpression(s);
        int result = ae.evaluate();
        assertEquals(101, result);
    }
}
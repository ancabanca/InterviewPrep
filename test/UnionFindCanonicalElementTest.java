import org.junit.Test;
import static org.junit.Assert.*;

import com.github.ancabanca.interviewprep.problems.UnionFindCanonicalElement;

public class UnionFindCanonicalElementTest {
    @Test
    public void test() {
        UnionFindCanonicalElement uf = new UnionFindCanonicalElement(6);
        uf.union(1,2);
        uf.union(5,1);
        uf.union(0,4);
        assertEquals(4,uf.find(4));
        assertEquals(4,uf.find(0));
        assertEquals(5,uf.find(1));
        uf.union(2,3);
        assertEquals(5,uf.find(3));
        assertEquals(5,uf.find(2));
    }
}
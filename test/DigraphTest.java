import static org.junit.Assert.*;

//import com.github.ancabanca.interviewprep.util.graph.CC;
import com.github.ancabanca.interviewprep.util.graph.Digraph;
import com.github.ancabanca.interviewprep.util.graph.DigraphBFSPaths;
import com.github.ancabanca.interviewprep.util.graph.DigraphDFSPaths;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.BeforeClass;
import org.junit.Test;

public class DigraphTest {
    private static Digraph         digraph1;
    private static DigraphDFSPaths digraph1DFSPaths;
    private static DigraphBFSPaths digraph1BFSPaths;
    //private static CC cc;

    private static Digraph         digraph2;
    private static DigraphDFSPaths digraph2DFSPaths;

    @BeforeClass
    public static void setup() {
        digraph1 = new Digraph(6);
        digraph1.addEdge(1,2);
        digraph1.addEdge(1,5);
        digraph1.addEdge(1,3);
        digraph1.addEdge(3,4);
        digraph1.addEdge(4,5);

        digraph1DFSPaths = new DigraphDFSPaths(digraph1, 1);
        digraph1BFSPaths = new DigraphBFSPaths(digraph1, 1);
        //cc = new CC(digraph1);

        digraph2 = new Digraph(7);
        digraph2.addEdge(0,5);
        digraph2.addEdge(0,2);
        digraph2.addEdge(0,1);
        digraph2.addEdge(3,6);
        digraph2.addEdge(3,5);
        digraph2.addEdge(3,4);
        digraph2.addEdge(5,2);
        digraph2.addEdge(6,4);
        digraph2.addEdge(6,0);
        digraph2.addEdge(3,2);
        digraph2.addEdge(1,4);
        digraph2DFSPaths = new DigraphDFSPaths(digraph2, 1);
    }

    @Test
    public void testDigraph1() {
        int[] a = new int[]{2,5,3};
        int i = 0;
        for(int v : digraph1.adjacent(1)) {
            assertEquals(a[i++], v);
        }
    }

    @Test
    public void testDigraph1HasPathDFS() {
        assertTrue(digraph1DFSPaths.hasPathTo(2));
        assertTrue(digraph1DFSPaths.hasPathTo(4));
        assertFalse(digraph1DFSPaths.hasPathTo(0));
    }

    @Test
    public void testDigraph1PathToDFS() {
        int[] a = new int[]{1,5};
        int i = 0;
        Iterable<Integer> path = digraph1DFSPaths.pathTo(5);
        for(int p : path)
            assertEquals(a[i++], p);
    }

    @Test
    public void testDigraph1ShortestPathBFS() {
        int[] a = new int[]{1,3,4,5};
        int i = 0;
        Iterable<Integer> path = digraph1BFSPaths.shortestPathTo(5);
        for(int p : path)
            assertEquals(a[i++], p);
    }

    @Test
    public void testDigraph2TopologicalSort() {
        int[] order = new int[]{3,6,0,1,4,5,2};
        int i = 0;
        for(int v : digraph2DFSPaths.topologicalSort())
            assertEquals(order[i++], v);
    }

    // @Test
    // public void testGraphCC() {
    //     assertEquals(2, cc.count());
    //     assertTrue (cc.connected(1,3));
    //     assertFalse(cc.connected(1,0));
    // }
}
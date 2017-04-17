import static org.junit.Assert.*;

import com.github.ancabanca.interviewprep.util.graph.CC;
import com.github.ancabanca.interviewprep.util.graph.DFSPaths;
import com.github.ancabanca.interviewprep.util.graph.Graph;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import org.junit.BeforeClass;
import org.junit.Test;

public class GraphTest {
    private static Graph    simpleGraph;
    private static DFSPaths simpleGraphPaths;
    private static CC cc;

    @BeforeClass
    public static void setup() {
        simpleGraph = new Graph(6);
        simpleGraph.addEdge(1,2);
        simpleGraph.addEdge(1,3);
        simpleGraph.addEdge(1,5);
        simpleGraph.addEdge(3,4);
        simpleGraph.addEdge(4,5);

        simpleGraphPaths = new DFSPaths(simpleGraph, 1);

        cc = new CC(simpleGraph);
    }

    @Test
    public void testGraphSimple1() {
        int[] a = new int[]{2,3,5};
        int i = 0;
        for(int v : simpleGraph.adjacent(1)) {
            assertEquals(a[i++], v);
        }
    }

    @Test
    public void testGraphSimpleHasPathDFS() {
        assertTrue(simpleGraphPaths.hasPathTo(2));
        assertTrue(simpleGraphPaths.hasPathTo(4));
        assertFalse(simpleGraphPaths.hasPathTo(0));
    }

    @Test
    public void testGraphSimplePathToDFS() {
        int[] a = new int[]{1,3,4,5};
        int i = 0;
        Iterable<Integer> path = simpleGraphPaths.pathTo(5);
        for(int p : path)
            assertEquals(a[i++], p);
    }

    @Test
    public void testGraphCC() {
        assertEquals(2, cc.count());
        assertTrue (cc.connected(1,3));
        assertFalse(cc.connected(1,0));
    }
}
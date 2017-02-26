import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import com.github.ancabanca.interviewprep.problems.SocialNetwork;

public class SocialNetworkTest {

    @Test
    public void test() {
        String testfile = "test/input/socialNetwork.txt";
        SocialNetwork sn = new SocialNetwork();
        assertEquals(29, sn.checkWhenConnected(testfile));
    }

    private void generateTestFile(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);
            int range = 10;

            Random r = new Random();
            int N = r.nextInt(range) + range; // e.g. 1000 <= N < 2000;
            fw.write(N + "\n");
            for(int i = 0; i < 3*N; i++) {
                int x = r.nextInt(N);
                int y = r.nextInt(N);
                if(x == y)
                    continue;
                fw.write(String.format("%d\t%d\t%d\n", i, x, y));
            }
            fw.close();
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }
}
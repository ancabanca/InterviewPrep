import static org.junit.Assert.*;

import com.github.ancabanca.interviewprep.problems.SocialNetwork;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;
import org.junit.Test;

public class SocialNetworkTest {

    @Test
    public void test() {
        String testfile = "test/input/socialNetwork.txt";
        SocialNetwork sn = new SocialNetwork();
        assertEquals(29, sn.checkWhenConnected(testfile));
    }

    private void generateTestFile(String filename) {
        try {
            OutputStreamWriter fw = new OutputStreamWriter(new FileOutputStream(filename), "utf-8");
            int range = 10;

            Random r = new Random();
            int n = r.nextInt(range) + range; // e.g. 1000 <= N < 2000;
            fw.write(n + "\n");
            for(int i = 0; i < 3*n; i++) {
                int x = r.nextInt(n);
                int y = r.nextInt(n);
                if(x == y)
                    continue;
                fw.write(String.format("%d\t%d\t%d%n", i, x, y));
            }
            fw.close();
        }
        catch(IOException e) {
            System.out.println(e);
        }
    }
}
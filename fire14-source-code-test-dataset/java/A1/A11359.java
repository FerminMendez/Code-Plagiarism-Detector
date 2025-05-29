package y2012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class DancingWiththeGooglers {
    static public void main(String args[]) throws IOException {
        // System.setIn(new FileInputStream("src/y2012/B-large.in"));
        System.setIn(new FileInputStream("src/y2012/B-small-attempt0.in"));
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter wr = new BufferedWriter(new FileWriter("src/y2012/B-large.out"));
        BufferedWriter wr = new BufferedWriter(new FileWriter("src/y2012/B-small-attempt0.out"));
        int nTests = Integer.valueOf(cin.readLine());
        String line;
        int tid = 0;
        while ((line = cin.readLine()) != null) {
            String[] sa = line.split("\\s+");
            int N = Integer.parseInt(sa[0]);
            int S = Integer.parseInt(sa[1]);
            int p = Integer.parseInt(sa[2]);
            int rlst = 0, a1 = 0, a2 = 0;
            for (int i = 0; i < N; i++) {
                int tii = Integer.parseInt(sa[i + 3]);
                if (tii >= p)
                    if (tii >= 3 * p + 5)
                        rlst++;
                    else if (tii <= 3 * p + 4 && tii >= 3 * p - 2)
                        a1++;
                    else if (tii == 3 * p - 3 || tii == 3 * p - 4)
                        a2++;
            }
            rlst += a1;
            rlst += Math.min(S, a2);
            ++tid;
            wr.write("Case #" + tid + ": " + rlst + "\n");
        }
        wr.close();
        cin.close();
    }
}
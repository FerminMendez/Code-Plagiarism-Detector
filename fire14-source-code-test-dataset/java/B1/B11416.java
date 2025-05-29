package y2012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.Set;

public class RecycledNumbers {
    static public void main(String args[]) throws IOException {
        // System.setIn(new FileInputStream("src/y2012/C-large.in"));
        // System.setIn(new FileInputStream("src/y2012/RecycledNumbers.in"));
        System.setIn(new FileInputStream("src/y2012/C-small-attempt0.in"));
        BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter wr = new BufferedWriter(new FileWriter("src/y2012/C-large.out"));
        BufferedWriter wr = new BufferedWriter(new FileWriter("src/y2012/C-small-attempt0.out"));
        int nTests = Integer.valueOf(cin.readLine());
        String line;
        int tid = 0;
        while ((line = cin.readLine()) != null) {
            String[] sa = line.split("\\s+");
            int A = Integer.parseInt(sa[0]);
            int B = Integer.parseInt(sa[1]);
            int rlst = 0;
            BitSet bits = new BitSet(B);
            for (int i = A; i <= B; i++)
                bits.set(i, true);
            for (int i = A; i <= B; i++) {
                if (bits.get(i)) {
                    char cs[] = new String().valueOf(i).toCharArray();
                    int n = cs.length;
                    Set<Integer> set = new HashSet<Integer>();
                    set.add(i);
                    for (int j = 0; j < n - 1; j++) {
                        String s = new String(Arrays.copyOfRange(cs, 1, n)) + cs[0];
                        cs = s.toCharArray();
                        int k = Integer.valueOf(s);
                        if (s.charAt(0) != 0 && A <= k && k <= B) {
                            set.add(k);
                            bits.set(k, false);
                        }
                    }
                    rlst += set.size() * (set.size() - 1) / 2;
                }
            }
            ++tid;
            wr.write("Case #" + tid + ": " + rlst + "\n");
        }
        wr.close();
        cin.close();
    }
}
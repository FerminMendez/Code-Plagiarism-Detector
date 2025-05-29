package codejam;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Dmitry Korolev
 */
public class Task3 {

    public static void main(String[] args) throws IOException {
        Reader inputReader = new FileReader("C-small-attempt0.in");
        Writer outputWriter = new FileWriter("C-small-attempt0.out");
        BufferedReader in = new BufferedReader(inputReader);
        BufferedWriter out = new BufferedWriter(outputWriter);
        String numStr = in.readLine();
        int n = Integer.parseInt(numStr);
        for (int i = 0; i < n; i++) {
            String line = in.readLine();
            String[] strs = line.split("\\s");
            int a = Integer.valueOf(strs[0]);
            int b = Integer.valueOf(strs[1]);
            out.write("Case #" + (i+1) + ": " + count(a, b) + "\n");
        }
        in.close();
        out.close();

        assert count(1, 9) == 0;
        assert count(10, 40) == 3;
        assert count(100, 500) == 156;
        assert count(1111, 2222) == 287;
    }

    private static int count(int a, int b) {
        int length = Integer.toString(a).length();

        Set<Long> pairs = new HashSet<>();
        for (int x = a; x < b; x++) {
            for (int n = 1; n < length; n++) {
                int r = rotate(x, n);
                if (r > x && r <= b) {
                    pairs.add((long) (x * 3000000 + r));
                }
            }
        }
        return pairs.size();
    }

    private static int rotate(int a, int n) {
        String number = Integer.toString(a);
        String head = number.substring(0, n);
        String tail = number.substring(n);
        return Integer.parseInt(tail + head);
    }
}

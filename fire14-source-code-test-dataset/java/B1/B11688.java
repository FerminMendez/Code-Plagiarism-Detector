package codejam;

import java.io.File;
import java.util.Scanner;
import java.io.FileWriter;
import java.util.Arrays;

/**
 *
 * @author Abiosoft
 */
public class Recycler {

    public static void main(String[] a) throws Exception {
        process("Recycler.in");
    }

    public static void process(String filename) throws Exception {
        File file = new File(filename);
        Scanner in = new Scanner(file);
        numberOfCase = Integer.parseInt(in.nextLine());
        String[] results = new String[numberOfCase];
        for (int i = 0; i < numberOfCase; i++) {
            String[] row = in.nextLine().split(" ");
            results[i] = "" + solve(row);
        }
        in.close();
        output(results);
    }

    public static void output(String[] results) throws Exception {
        File file = new File("Recycler.out");
        FileWriter out = new FileWriter(file);
        for (int i = 0; i < results.length; i++) {
            out.write("Case #" + (i + 1) + ": " + results[i]);
            out.write(i < results.length - 1 ? "\n" : "");
        }
        out.close();
    }

    public static int solve(String[] row) {
        int n1 = Integer.parseInt(row[0]);
        int n2 = Integer.parseInt(row[1]);
        char[] r1;
        char[] r2;
        String s1;
        String s2;
        int count = 0;
        for (int i = n1; i < n2; i++) {
            for (int j = i + 1; j <= n2; j++) {
                r1 = (i + "").toCharArray();
                r2 = (j + "").toCharArray();
                s1 = new String(r1);
                s2 = new String(r2);
                Arrays.sort(r1);
                Arrays.sort(r2);
                if (Arrays.equals(r1, r2)) {
                    count += testRecycle(s1, s2);
                }
            }
        }
        return count;
    }

    public static int testRecycle(String n, String m) {
        int count = 0;
        for (int i = 1; i < n.length(); i++) {
            String nn = n.substring(i);
            int index = m.indexOf(nn);
            if (index < 0) {
                continue;
            }
            String s = nn + n.substring(0, i);
            if (s.equals(m)) {
                return 1;
            }
        }
        return count;
    }
    public static int numberOfCase = 0;
}

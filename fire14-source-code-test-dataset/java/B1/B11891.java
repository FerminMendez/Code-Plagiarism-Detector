package gcj2012.qualification;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class C_Recycled_Numbers {

    private static boolean SMALL = true;
    private static String PROBLEM = "C";

    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(new File(String.format("%s-%s.in", PROBLEM, (SMALL ? "small" : "large"))));
            PrintWriter pw = new PrintWriter(new File(String.format("%s-%s.out", PROBLEM, (SMALL ? "small" : "large"))));

            int NUM_CASES = scan.nextInt();
            scan.nextLine();
            System.out.println(String.format("%d test cases:", NUM_CASES));
            long start = System.currentTimeMillis(), t1, left;
            for (int CASE = 1; CASE <= NUM_CASES; ++CASE) {
                t1 = System.currentTimeMillis();
                System.out.print(String.format("%d.[%s] ", CASE, new SimpleDateFormat("HH:mm:ss.SSS").format(new Date(t1))));

                final int A = scan.nextInt(), B = scan.nextInt();
                int cnt = 0, pow1, pow2, l, m;
                final Set<String> pairs = new HashSet<String>();
                for (int n = A; n < B; ++n) {
                    l = String.valueOf(n).length();
                    pow1 = (int)Math.pow(10, l);
                    pow2 = 1;
                    pairs.clear();
                    for (int j = 1; j < l; ++j) {
                        pow1 /= 10;
                        pow2 *= 10;
                        m = ((n % pow1) * pow2 + n / pow1);
                        if (m <= B && m > n && pairs.add(n + " " + m)) {
                            cnt++;
                        }
                    }
                }

                String res = String.format("%d", cnt);
                pw.println(String.format("Case #%d: %s", CASE, res));
                left = (System.currentTimeMillis() - start) * (NUM_CASES - CASE) / CASE;
                System.out.println(String.format("%s (%dms, ~%dms left)", res, (System.currentTimeMillis() - t1), left));
            }
            pw.close();
            scan.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

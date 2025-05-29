package gcj2012.qualification;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class B_Dancing_With_the_Googlers {

    private static boolean SMALL = true;
    private static String PROBLEM = "B";

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

                final int N = scan.nextInt(), S = scan.nextInt(), p = scan.nextInt();
                int cntGreat = 0, cntOK = 0;
                for (int i = 0; i < N; ++i) {
                    final int t = scan.nextInt();
                    if ((t - p) >= 0 && (t - p) / 2 >= p - 1) {
                        cntGreat++;
                    } else if (p - 2 >= 0 && (t - p - (p - 2)) >= p - 2) {
                        cntOK++;
                    }
                }

                String res = String.format("%d", cntGreat + Math.min(S, cntOK));
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

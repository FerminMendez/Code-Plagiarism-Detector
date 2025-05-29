import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Recycled implements Runnable {
    final Scanner in;
    final PrintWriter out;

    public Recycled() throws FileNotFoundException {
        out = new PrintWriter(getClass().getName().toLowerCase() + ".out");
        in = new Scanner(new File(getClass().getName().toLowerCase() + ".in"));
    }

    public static void main(String[] args) {
        try {
            new Recycled().run();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        int tests = in.nextInt();
        for (int testcase = 1; testcase <= tests; testcase++) {
            out.print("Case #" + testcase + ": ");

            int a = in.nextInt();
            int b = in.nextInt();

            int res = 0;
            HashSet<Integer> met = new HashSet<Integer>();

            for (int i = a; i <= b; i++) {
                String istr = String.valueOf(i);

                met.clear();
                for (int len = 1; len < istr.length(); len++) {
                    String rec = istr.substring(len) + istr.substring(0, len);
                    if (rec.startsWith("0")) {
                        continue;
                    }
                    int x = Integer.parseInt(rec);
                    if (x >= a && x <= b && i < x) {
                        met.add(x);
                    }
                }
                res += met.size();
                //System.out.println(istr + "-> " + met);
            }
            out.println(res);
        }

        out.close();
        in.close();
    }
}

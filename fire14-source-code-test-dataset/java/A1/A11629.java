import java.io.*;
import java.util.*;

public class B {
    public final static String FILE_IN = "B-small-attempt0.in";
    public final static String FILE_OUT = "B-small-attempt0.out";

    public static class Case {
        public int n, s, p;
        public int[] t;

        public String toString() {
            return "" + n + "," + s + "," + p + ":" + Arrays.toString(t);
        }
    }

    public static Case readCase(BufferedReader r) throws IOException {
        Case c = new Case();

        String[] tk = r.readLine().split(" ");
        c.n = Integer.parseInt(tk[0]);
        c.s = Integer.parseInt(tk[1]);
        c.p = Integer.parseInt(tk[2]);
        c.t = new int[c.n];
        for (int i=0; i<c.n; i++) {
            c.t[i] = Integer.parseInt(tk[3+i]);
        }

        return c;
    }


    public static void solveCase(Case c, BufferedWriter w, int index) throws IOException {
        int t = 0;
        int sr = c.s;
        for (int i=0; i<c.t.length; i++) {
            int q = c.t[i] / 3;
            int r = c.t[i] % 3;

            if (r == 0) {
                if (q >= c.p) {
                    t++;
                }
                else if (q > 0 && q + 1 >= c.p && sr > 0) {
                    t++;
                    sr--;
                }
            }
            else if (r == 1) {
                if (q+1 >= c.p) {
                    t++;
                }
            }
            else {
                if (q+1 >= c.p) {
                    t++;
                }
                else if (q+2 >= c.p && sr > 0) {
                    t++;
                    sr--;
                }
            }
        }

        w.write("Case #" + (index+1) + ": " + t);
        w.newLine();
    }

    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new FileReader(FILE_IN));
        BufferedWriter w = new BufferedWriter(new FileWriter(FILE_OUT));
        int num = Integer.parseInt(r.readLine());
        for (int i=0; i<num; i++) {
            Case c = readCase(r);
            solveCase(c, w, i);
        }

        w.close();
        r.close();
    }
}
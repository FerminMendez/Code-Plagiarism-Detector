import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class main {

    main() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("B-small-attempt0.in"));
        PrintWriter out = new PrintWriter("result.txt");
        int tests = sc.nextInt();
        for (int t = 1; t <= tests; t++) {
            int n = sc.nextInt();
            int s = sc.nextInt();
            int p = sc.nextInt();
            Map<Integer, ArrayList<D>> map = new TreeMap<>();
            ArrayList<Integer> scores = new ArrayList<>();

            for (int m = 0; m < n; m++) {
                int g = sc.nextInt();
                scores.add(g);
                map.put(g, dec(g));
            }

            int ww = 0;
            int w = 0;
            int cw = 0;
            for (int i = 0; i < n; i++) {
                if (isDecomposeThere(map.get(scores.get(i)), p, true) && isDecomposeThere(map.get(scores.get(i)), p, false)) {
                    ww++;
                } else if (isDecomposeThere(map.get(scores.get(i)), p, true)) {
                    w++;
                } else if (isDecomposeThere(map.get(scores.get(i)), p, false)) {
                    cw++;
                }
            }
            out.printf("Case #%d: %d\n", t, (w >= s) ? (s + cw + ww) : (w + ww + cw));
        }
        out.flush();
    }

    public static void main(String[] args) throws FileNotFoundException {
        main m = new main();
    }

    public boolean isDecomposeThere(ArrayList<D> ds, int p, boolean surprise) {
        for (D dec : ds) {
            if (dec.a >= p && dec.surprise == surprise) return true;
        }
        return false;
    }

    public ArrayList<D> dec(int n) {
        ArrayList<D> list = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= i; j++) {
                for (int k = 0; k <= j; k++) {
                    if (i - j <= 2 && j - k <= 2 && i - k <= 2 && i + j + k == n) {
                        boolean surprise = (i - j == 2 || j - k == 2 || i - k == 2);
                        list.add(new D(i, j, k, surprise));
                    }
                }
            }
        }
        return list;
    }

    class D {
        int a, b, c;
        boolean surprise;

        public D(int a, int b, int c, boolean surprise) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.surprise = surprise;
        }

        @Override
        public String toString() {
            return "" + a + " " + b + " " + c + " " + surprise;
        }
    }

}
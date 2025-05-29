import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class main {

    static int numberPeriod(int n, int len) {
        if (len == 2 && n / 10 == n % 10) return 1;
        if (len == 4 && n % 100 == n / 100) return 2;
        if (len == 6 && n % 100 == n / 10000 && n % 100 == n / 100 % 100) return 2;
        if (len == 6 && n % 1000 == n / 1000) return 3;
        return len;
    }

    static int numberLength(int n) {
        int len = 0;
        while (n > 0) {
            n /= 10;
            len++;
        }
        return len;
    }

    main() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("B-small-attempt0.in"));
        PrintWriter out = new PrintWriter("result.txt");
        int tests = sc.nextInt();
        for (int t = 1; t <= tests; t++) {
            int n = sc.nextInt();
            int s = sc.nextInt();
            int p = sc.nextInt();
            Map<Integer, ArrayList<Decompose>> map = new TreeMap<>();
            ArrayList<Integer> scores = new ArrayList<>();

            for (int m = 0; m < n; m++) {
                int g = sc.nextInt();
                scores.add(g);
                map.put(g, dec(g));
                //out.println(dec(g).toString());
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

            if (w >= s) {
                out.printf("Case #%d: %d\n", t, s + cw + ww);
            } else {
                //s -= w;
                out.printf("Case #%d: %d\n", t, w + ww + cw);
            }
        }
        out.flush();
    }

    public static void main(String[] args) throws FileNotFoundException {
        main m = new main();
    }

    public boolean isDecomposeThere(ArrayList<Decompose> decomposes, int p, boolean surprise) {
        for (Decompose dec : decomposes) {
            if (dec.a >= p && dec.surprise == surprise) return true;
        }
        return false;
    }

    public ArrayList<Decompose> dec(int n) {
        ArrayList<Decompose> list = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= i; j++) {
                for (int k = 0; k <= j; k++) {
                    if (i - j <= 2 && j - k <= 2 && i - k <= 2 && i + j + k == n) {
                        boolean surprise = (i - j == 2 || j - k == 2 || i - k == 2);
                        list.add(new Decompose(i, j, k, surprise));
                    }
                }
            }
        }
        return list;
    }

    class Decompose {
        int a, b, c;
        boolean surprise;

        public Decompose(int a, int b, int c, boolean surprise) {
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
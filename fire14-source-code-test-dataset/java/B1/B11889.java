import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class main {

    int numberPeriod(int n, int len) {
        if (len == 2 && n / 10 == n % 10) return 1;
        if (len == 4 && n % 100 == n / 100) return 2;
        if (len == 6 && n % 100 == n / 10000 && n % 100 == n / 100 % 100) return 2;
        if (len == 6 && n % 1000 == n / 1000) return 3;
        return len;
    }

    int numberLength(int n) {
        int len = 0;
        while (n > 0) {
            n /= 10;
            len++;
        }
        return len;
    }

    main() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("C-small-attempt0.in"));
        PrintWriter out = new PrintWriter("result.txt");
        int tests = sc.nextInt();
        for (int t = 1; t <= tests; t++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int l = numberLength(a);
            int tt = (int) Math.pow(10, l - 1);
            int r = 0;
            for (int j = a; j <= b; j++) {
                int cr = j;
                int val = j;
                int per = numberPeriod(j, l);


                for (int k = 0; k < per; k++) {
                    int c = val % 10;
                    val = val / 10 + c * tt;
                    if (val > cr && val <= b) {
                        r++;
                    }
                }
            }
            out.printf("Case #%d: %d\n", t, r);
        }
        out.flush();
    }

    public static void main(String[] args) {
        try {
            main m = new main();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
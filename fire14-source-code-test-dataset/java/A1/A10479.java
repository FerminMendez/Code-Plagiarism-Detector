import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(new FileReader("in.txt"));
            PrintWriter out = new PrintWriter(new FileWriter("out.txt"), true);

            int t = in.nextInt();

            for (int i = 1; i <= t; i++) {
                int res = 0;
                int n = in.nextInt();
                int s = in.nextInt();
                int p = in.nextInt();
                int tt[] = new int[n];
                for (int j = 0; j < n; j++) {
                    tt[j] = in.nextInt();
                }
                if (p == 0) {
                    res = n;
                } else {
                    int min = 3 * p - 2;
                    for (int j = 0; j < n; j++) {
                        if (min <= tt[j]) res++;
                    }
                    int ttt[] = new int[n - res];
                    int itr = 0;
                    for (int j = 0; j < n; j++) {
                        if (min > tt[j]) ttt[itr++] = tt[j];
                    }
                    int minCrazy = 3 * p - 5;
                    int ress = 0;
                    for (int j = 0; j < itr; j++) {
                        if (minCrazy <= ttt[j] && ttt[j] != 0) ress++;
                    }
                    if (ress <= s) {
                        res += ress;
                    } else {
                        res += s;
                    }
                }

                out.println("Case #" + i + ": " + res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
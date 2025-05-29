package codejam;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Problem3 {
    
    private static final int POWERS_OF_TEN[] = new int[] {
        1,
        10,
        100,
        1000,
        10000,
        100000,
        1000000
    };

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File(args[0]));
        int cases = scanner.nextInt();
        PrintWriter printWriter = new PrintWriter(new File(args[1]));
        for (int i = 0; i < cases; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            printWriter.write("Case #" + (i+1) + ": " + solve(a,b) + "\n");
        }
        printWriter.close();
        scanner.close();
    }
    
    private static int solve(int a, int b) {
        int c = 0;
        int t[] = new int[6];
        for (int n = a; n <= b; n++) {
            // calc 'd' as number of digits
            int d = 0;
            int nn = n;
            while (nn > 0) { d++; nn /= 10; }
            // fill 't' with rotated numbers
            for (int i = 1; i < d; i++) {
                t[i - 1] = (n % POWERS_OF_TEN[i]) * POWERS_OF_TEN[d-i] + (n / POWERS_OF_TEN[i]);
            }
            // see how many of numbers from 't' form a pair
            for (int i = 0; i < d - 1; i++) {
                if (t[i] > n && t[i] <= b) {
                    boolean alreadyIncluded = false;
                    for (int j=0;j<i;j++) {
                        if (t[j]==t[i]) {
                            alreadyIncluded = true;
                            break;
                        }
                    }
                    if (!alreadyIncluded) {
                        c++;
                    }
                }
            }
        }
        return c;
    }
}

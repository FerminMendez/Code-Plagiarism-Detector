package codejam;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Problem2 {
    
    private static int [] MAX_NO_SURPRISE; 
    private static int [] MAX_WITH_SURPRISE; 
    
    public static void main(String[] args) throws IOException {
        
        MAX_NO_SURPRISE = calcArray(1);
        MAX_WITH_SURPRISE = calcArray(2);
        
        Scanner scanner = new Scanner(new File(args[0]));
        int cases = scanner.nextInt();
        PrintWriter printWriter = new PrintWriter(new File(args[1]));
        for (int i = 0; i < cases; i++) {
            int n = scanner.nextInt();
            int s = scanner.nextInt();
            int p = scanner.nextInt();
            int t[] = new int[n];
            for (int k = 0; k < n; k++) {
                t[k] = scanner.nextInt();
            }
            printWriter.write("Case #" + (i + 1) + ": " + solve(n,s,p,t) + "\n");
        }
        printWriter.close();
        scanner.close();
    }

    private static int[] calcArray(int d) {
        int t[] = new int[31]; 
        for (int i = 0; i <= 30; i++) {
            int max = 0;
            for (int a1=0;a1<=10;a1++) {
                for (int a2=0;a2<=10;a2++) {
                    for (int a3=0;a3<=10;a3++) {
                        if (a1+a2+a3 == i && Math.abs(a1-a2) <= d && Math.abs(a2-a3) <= d
                                && Math.abs(a1-a3) <= d) {
                            if (a1 > max) { max = a1; }
                            if (a2 > max) { max = a2; }
                            if (a3 > max) { max = a3; }
                        }
                    }
                }
            }
            t[i] = max;
        }
        return t;
    }

    private static int solve(int n, int s, int p, int[] t) {
        int r[][] = new int[n + 1][s + 1];
        for (int i = 0; i <= s; i++) {
            r[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            r[i][0] = ((MAX_NO_SURPRISE[t[i - 1]] >= p) ? 1 : 0) + r[i - 1][0];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= s; j++) {
                r[i][j] = Math.max(
                        r[i - 1][j] + ((MAX_NO_SURPRISE[t[i - 1]] >= p) ? 1 : 0),
                        r[i - 1][j - 1] + ((MAX_WITH_SURPRISE[t[i - 1]] >= p) ? 1 : 0));
            }
        }
        return r[n][s];
    }
}

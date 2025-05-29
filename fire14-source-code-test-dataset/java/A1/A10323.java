
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author megaterik
 */
public class B {

    public static void main(String[] args) throws FileNotFoundException {
        new B().solve();
    }

    void solve() throws FileNotFoundException {
        Scanner in = new Scanner(new FileReader("src/input.txt"));
        PrintWriter out = new PrintWriter(new FileOutputStream("src/output.txt"));
        int testCases = in.nextInt();
        for (int t = 1; t <= testCases; t++) {
            int n = in.nextInt();
            int surprise = in.nextInt();
            int required = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            Arrays.sort(a);
            int res = 0;
            for (int i = a.length - 1; i >= 0; i--) {
                if (a[i] >= required + 2 * (required - 1)) {
                    res++;
                } else if (surprise > 0 && a[i] >= required + 2 * Math.max(0, required - 2)) {
                    res++;
                    surprise--;
                } else {
                    break;
                }
            }
            out.println("Case #" + t + ": " + res);
        }
        in.close();
        out.close();
    }
}

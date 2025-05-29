import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Andrey Zarubin
 */
public class Dancing {
    public static void main(String... args) throws IOException {
        String fileName = args[0];
        BufferedReader r = new BufferedReader(new FileReader(fileName));
        PrintWriter w = new PrintWriter(fileName.split("\\.")[0] + ".out.txt");
        int T = Integer.parseInt(r.readLine());
        for (int x = 0; x < T; x++) {
            Scanner sc = new Scanner(r.readLine());
            int n = sc.nextInt();
            int s = sc.nextInt();
            int p = sc.nextInt();
            int[] t = new int[n];
            for (int i = 0; i < n; i++)
                t[i] = sc.nextInt();
            Arrays.sort(t);
            int y = 0;
            if (p == 0) {
                w.println("Case #" + (x + 1) + ": " + n);
                continue;
            }
            for (int i = n - 1; i >= 0; i--) {
                if (t[i] == 0)
                    break;
                if (t[i] == 1) {
                    if (p > 1)
                        break;
                    y++;
                    continue;
                }
                if ((t[i] - 1) / 3 + 1 >= p) {
                    y++;
                    continue;
                }
                if (s > 0 && (t[i] - 2) / 3 + 2 >= p) {
                    s--;
                    y++;
                    continue;
                }
                break;
            }
            w.println("Case #" + (x + 1) + ": " + y);
        }
        r.close();
        w.close();
    }
}

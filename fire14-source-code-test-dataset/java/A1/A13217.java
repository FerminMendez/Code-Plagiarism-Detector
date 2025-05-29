import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class B {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("B-small-attempt0.in"));
        PrintWriter printer = new PrintWriter(new File("a.out"));
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int s = scanner.nextInt();
            int p = scanner.nextInt();
            int ans = 0;
            for (int j = 0; j < n; j++) {
                int tmp = scanner.nextInt();
                if (tmp >= p + 2 * Math.max(p - 1, 0)) {
                    ans++;
                } else if (s > 0 && tmp >= p + 2 * Math.max(p - 2, 0)) {
                    ans++;
                    s--;
                }
            }
            printer.println("Case #" + (i + 1) + ": " + ans);
        }
        printer.flush();
        printer.close();
    }
}

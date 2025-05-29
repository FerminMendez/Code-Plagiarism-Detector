import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: akim
 * Date: 4/14/12
 * Time: 7:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class B {

    void solve() throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new FileOutputStream("output.txt"));
        Scanner in = new Scanner(new FileInputStream("input.txt"));
        int t = Integer.parseInt(in.nextLine());
        System.err.println(t);
        for (int i = 0; i < t; ++i) {
            out.print("Case #" + (i+1) + ": ");
            int n = in.nextInt();
            int s = in.nextInt();
            int p = in.nextInt();
            int ans = 0;
            for (int j = 0; j < n; ++j) {
                int r = in.nextInt();
                boolean ok = false;
                for (int A = 0; A <= 10; ++A)
                    for (int B = A; B <= A + 1; ++B)
                        for (int C = B; C <= A + 1; ++C)
                            if (A + B + C == r && C >= p) {
                                ok = true;
                            }
                if (!ok && s > 0) {
                    for (int A = 0; A <= 10; ++A)
                        for (int B = A; B <= A + 2; ++B)
                            for (int C = B; C <= A + 2; ++C)
                                if (A + B + C == r && C >= p) {
                                    ok = true;
                                }
                    if (ok) --s;
                }
                if (ok) ++ans;
            }
            out.println(ans);
            System.out.println((i+1) + " " + ans);
        }
        out.flush();
        out.close();
    }


    public static void main(String[] args) throws FileNotFoundException {
        new B().solve();
    }
}

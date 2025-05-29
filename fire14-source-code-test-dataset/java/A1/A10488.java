import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: vors
 * Date: 4/14/12
 * Time: 6:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class B {
    public static void main(String[] args) throws Exception {
        B b = new B();
        b.go();
    }

    private void go() throws Exception {
        Scanner in = new Scanner(new File("b.in"));
        PrintWriter out = new PrintWriter(new File("b.out"));
        int T = in.nextInt();
        for (int cas=1; cas<=T; cas++) {
            int N = in.nextInt();
            int S = in.nextInt();
            int p = in.nextInt();
            int[] t = new int[N];
            int res = 0;
            for (int i=0; i<N; i++) {
                int x = t[i] = in.nextInt();
                switch (x % 3) {
                    case 0 : {
                        if (x / 3 >= p) {
                            res++;
                            break;
                        }
                        if (x / 3 + 1 >= p && x / 3 > 0 && S > 0) {
                            S--;
                            res++;
                            break;
                        }
                        break;
                    }
                    case 1 : {
                        if (x / 3 + 1 >= p) {
                            res++;
                            break;
                        }
                        break;
                    }
                    case 2 : {
                        if (x / 3 + 1 >= p) {
                            res++;
                            break;
                        }
                        if (x / 3 + 2 >= p && x / 3 > 0 && S > 0) {
                            S--;
                            res++;
                            break;
                        }
                        break;
                    }
                    default: throw new RuntimeException("Unreachable " + x % 3);
                }
            }
            out.printf("Case #%d: %d\n", cas, res);
        }
        out.close();
    }
}

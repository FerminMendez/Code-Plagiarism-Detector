
import java.util.Scanner;

public class CodeJam12B {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int zz = 1; zz <= T; zz++) {
            int N = in.nextInt();
            int S = in.nextInt();
            int p = in.nextInt();

            int[] t = new int[N];
            int out = 0;

            for (int i = 0; i < N; i++) {
                t[i] = in.nextInt();
                t[i] = t[i] - p;
                if (t[i] >= 0) {
                    if (t[i] >= 2 * (p - 1)) {
                        out++;
                    } else if (t[i] >= 2 * (p - 2) && S > 0) {
                        S--;
                        out++;
                    }
                }
            }
            System.out.format("Case #%d: %d\n", zz, out);
        }
    }
}

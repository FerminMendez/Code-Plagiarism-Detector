import java.util.*;

public class C {
    static int[] ten;

    static {
        ten = new int[10];
        ten[0] = 1;
        for (int i = 1; i < ten.length; ++i) {
            ten[i] = ten[i - 1] * 10;
        }
    }

    static int max(int x) {
        int n = 0;
        while (ten[n + 1] <= x) {
            ++n;
        }
        int y = x;
        for (int i = 0; i < n; ++i) {
            x = x / 10 + x % 10 * ten[n];
            y = Math.max(x, y);
        }
        return y;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int re = in.nextInt();
        int[] c = new int[10000000];
        for (int ri = 1; ri <= re; ++ri) {
            int a = in.nextInt();
            int b = in.nextInt();
            Arrays.fill(c, 0);
            for (int i = a; i <= b; ++i) {
                ++c[max(i)];
            }
            long s = 0;
            for (int i: c) {
                s += i * (i - 1) / 2;
            }
            System.out.println("Case #" + ri + ": " + s);
        }
    }
}


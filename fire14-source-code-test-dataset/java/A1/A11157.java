import java.util.Scanner;

public class B {
    static boolean attainableWithoutSurprises(int best, int total) {
        return best + 2 * Math.max(0, best - 1) <= total;
    }

    static boolean attainableWithSurprises(int best, int total) {
        return best + 2 * Math.max(0, best - 2) <= total;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; ++t) {
            int N = sc.nextInt(), S = sc.nextInt(), p = sc.nextInt(), count = 0;
            for (int i = 0; i < N; ++i) {
                int total = sc.nextInt();
                if (attainableWithoutSurprises(p, total))
                    ++count;
                else if (attainableWithSurprises(p, total) && S-- > 0)
                    ++count;
            }
            System.out.printf("Case #%d: %d\n", t, count);
        }
    }
}

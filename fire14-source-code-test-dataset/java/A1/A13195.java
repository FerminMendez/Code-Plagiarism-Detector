import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Dmitry Levshunov (levshunov.d@gmail.com)
 */
public class TaskB {
    private static final int INF = 1000 * 1000 * 1000;

    private static final int[] BEST_NON_SURPRISING = new int[31];
    private static final int[] BEST_SURPRISING = new int[31];

    private static int n;
    private static int p;
    private static int[] scores = new int[100];
    private static int[][] dp = new int[100][101];

    public static void main(String[] args) throws Exception {
        init();

        Scanner scanner = new Scanner(System.in);

        int tests = Integer.parseInt(scanner.nextLine().trim());

        for (int test = 1; test <= tests; test++) {
            n = scanner.nextInt();
            int s = scanner.nextInt();
            p = scanner.nextInt();

            for (int i = 0; i < n; i++) {
                scores[i] = scanner.nextInt();
            }

            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1);
            }

            System.out.printf("Case #%d: %s", test, get(0, s));
            System.out.println();
        }

        scanner.close();
    }

    private static void init() {
        for (int i1 = 0; i1 <= 10; i1++) {
            for (int i2 = i1; i2 <= 10 && i2 - i1 <= 2; i2++) {
                for (int i3 = i2; i3 <= 10 && i3 - i1 <= 2; i3++) {
                    int sum = i1 + i2 + i3;

                    if (i3 - i1 == 2) {
                        BEST_SURPRISING[sum] = Math.max(BEST_SURPRISING[sum], i3);
                    } else {
                        BEST_NON_SURPRISING[sum] = Math.max(BEST_NON_SURPRISING[sum], i3);
                    }
                }
            }
        }
    }

    private static int get(int pos, int s) {
        if (s < 0) {
            return -INF;
        }

        if (pos == n) {
            return s == 0 ? 0 : -INF;
        }

        if (dp[pos][s] != -1) {
            return dp[pos][s];
        }

        int bestNonSurprising = BEST_NON_SURPRISING[scores[pos]];
        int bestSurprising = BEST_SURPRISING[scores[pos]];

        int result = get(pos + 1, s) + (bestNonSurprising >= p ? 1 : 0);
        if (bestSurprising != -1) {
            result = Math.max(result, get(pos + 1, s - 1) + (bestSurprising >= p ? 1 : 0));
        }

        return dp[pos][s] = result;
    }
}

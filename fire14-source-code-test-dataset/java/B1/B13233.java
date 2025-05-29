import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Dmitry Levshunov (levshunov.d@gmail.com)
 */
public class TaskC {
    private static boolean[] used = new boolean[2000001];
    private static int length;
    private static int pow;

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        int tests = Integer.parseInt(scanner.nextLine().trim());

        for (int test = 1; test <= tests; test++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            System.out.printf("Case #%d: %s", test, solve(a, b));
            System.out.println();
        }

        scanner.close();
    }

    private static long solve(int a, int b) {
        Arrays.fill(used, false);

        length = Integer.toString(a).length();
        pow = 1;
        for (int i = 0; i < length - 1; i++) {
            pow *= 10;
        }

        long result = 0;

        for (int x = a; x <= b; x++) {
            long shiftCount = processShifts(x, a, b);
            result += shiftCount * (shiftCount - 1) / 2;
        }

        return result;
    }

    private static int processShifts(int x, int a, int b) {
        if (used[x]) {
            return 0;
        }

        int result = 0;

        for (int i = 0; i < length; i++) {
            x = (x % 10) * pow + x / 10;
            if (a <= x && x <= b && !used[x]) {
                used[x] = true;
                result++;
            }
        }

        return result;
    }
}

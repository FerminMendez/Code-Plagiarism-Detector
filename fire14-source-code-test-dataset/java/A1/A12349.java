/**
 * User: avokin
 * Date: 4/14/12
 */
public class ProblemB {
    private static int solve(int n, int s, int p, int[] t) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (t[i] % 3 == 0) {
                int a = t[i] / 3;
                if (a >= p) {
                    result++;
                } else {
                    if (a > 0 && a + 1 == p && s > 0) {
                        s--;
                        result++;
                    }
                }
            } else if (t[i] % 3 == 1) {
                int a = t[i] / 3 + 1;
                if (a >= p) {
                    result++;
                }
            } else {
                int a = t[i] / 3 + 1;
                if (a >= p) {
                    result++;
                } else {
                    if (a + 1 == p && s > 0) {
                        s--;
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String input = "100\n" +
                "3 1 5 15 13 11\n" +
                "3 0 8 23 22 21\n" +
                "2 2 10 18 3\n" +
                "1 0 0 28\n" +
                "1 0 8 21\n" +
                "2 0 0 28 4\n" +
                "1 0 7 17\n" +
                "2 0 10 26 12\n" +
                "3 0 4 11 8 8\n" +
                "2 2 3 14 25\n" +
                "3 0 10 30 30 30\n" +
                "1 0 0 4\n" +
                "3 1 4 8 9 4\n" +
                "1 0 8 12\n" +
                "2 2 9 3 11\n" +
                "3 0 6 13 15 20\n" +
                "3 1 7 19 26 9\n" +
                "1 0 6 15\n" +
                "3 1 4 9 8 9\n" +
                "1 0 3 6\n" +
                "3 0 4 11 28 8\n" +
                "2 0 4 11 9\n" +
                "1 0 5 12\n" +
                "1 0 4 25\n" +
                "1 0 3 5\n" +
                "1 0 3 21\n" +
                "2 0 0 30 30\n" +
                "2 1 4 8 8\n" +
                "1 0 7 19\n" +
                "3 3 8 14 19 20\n" +
                "1 1 9 22\n" +
                "1 0 9 24\n" +
                "3 0 5 11 12 1\n" +
                "3 3 5 25 7 16\n" +
                "2 0 7 17 18\n" +
                "3 2 4 2 2 12\n" +
                "3 3 5 2 12 27\n" +
                "3 0 1 16 4 17\n" +
                "1 0 7 4\n" +
                "1 0 5 11\n" +
                "3 1 7 12 25 9\n" +
                "3 3 5 3 4 12\n" +
                "1 0 3 1\n" +
                "1 0 1 0\n" +
                "3 0 9 18 19 30\n" +
                "3 0 6 15 29 26\n" +
                "2 0 9 7 4\n" +
                "1 0 6 5\n" +
                "3 0 8 28 21 21\n" +
                "2 2 7 9 10\n" +
                "1 0 4 8\n" +
                "1 0 10 26\n" +
                "2 2 4 2 17\n" +
                "3 0 10 0 0 26\n" +
                "1 0 10 15\n" +
                "2 0 4 30 8\n" +
                "3 0 2 4 22 27\n" +
                "1 1 8 25\n" +
                "3 2 7 29 2 27\n" +
                "2 0 2 22 25\n" +
                "3 0 4 9 30 9\n" +
                "2 0 3 5 6\n" +
                "2 0 3 30 30\n" +
                "2 0 1 0 0\n" +
                "3 0 4 24 3 17\n" +
                "3 3 0 14 16 4\n" +
                "2 0 6 27 16\n" +
                "2 1 10 16 24\n" +
                "1 0 4 27\n" +
                "1 1 4 10\n" +
                "2 1 1 3 17\n" +
                "1 0 8 21\n" +
                "3 0 9 23 22 24\n" +
                "1 0 9 2\n" +
                "3 0 1 25 2 29\n" +
                "3 0 7 17 18 17\n" +
                "3 0 6 3 14 13\n" +
                "1 0 10 6\n" +
                "3 2 9 23 24 23\n" +
                "2 1 3 5 5\n" +
                "3 2 1 23 0 11\n" +
                "2 2 3 18 10\n" +
                "2 1 8 25 21\n" +
                "2 1 9 7 23\n" +
                "1 1 0 19\n" +
                "1 0 8 20\n" +
                "3 1 6 10 15 15\n" +
                "3 1 0 8 4 1\n" +
                "2 2 6 8 20\n" +
                "3 0 9 22 21 12\n" +
                "3 3 0 11 11 2\n" +
                "1 1 10 19\n" +
                "2 2 0 4 3\n" +
                "1 0 8 20\n" +
                "3 1 8 20 16 21\n" +
                "2 0 10 26 27\n" +
                "3 0 0 0 0 0\n" +
                "1 1 8 14\n" +
                "2 1 10 26 27\n" +
                "1 1 6 12\n";

        String[] lines = input.split("\n");
        int T = Integer.parseInt(lines[0]);
        for (int i = 1; i <= T; i++) {
            String line = lines[i];
            String[] items = line.split(" ");
            int n = Integer.parseInt(items[0]);
            int s = Integer.parseInt(items[1]);
            int p = Integer.parseInt(items[2]);

            int[] t = new int[n];
            for (int j = 0; j < n; j++) {
                t[j] = Integer.parseInt(items[3 + j]);
            }

            int solution = solve(n, s, p, t);
            System.out.println("Case #" + i + ": " + solution);
        }
    }
}

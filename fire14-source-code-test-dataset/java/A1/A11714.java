package codejam;

import java.io.*;
import java.util.Arrays;

/**
 * @author Dmitry Korolev
 */
public class Task2 {

    public static void main(String[] args) throws IOException {
        Reader inputReader = /*new InputStreamReader(System.in);*/ new FileReader("B-small-attempt0.in");
        Writer outputWriter = /*new OutputStreamWriter(System.out);*/ new FileWriter("B-small-attempt0.out");
        BufferedReader in = new BufferedReader(inputReader);
        BufferedWriter out = new BufferedWriter(outputWriter);
        String tStr = in.readLine();
        int tests = Integer.parseInt(tStr);
        for (int i = 0; i < tests; i++) {
            String line = in.readLine();
            String[] strs = line.split("\\s");
            int[] nums = new int[strs.length];
            for (int j = 0; j < strs.length; j++) {
                nums[j] = Integer.parseInt(strs[j]);
            }
            int s = nums[1];
            int p = nums[2];
            int[] t = Arrays.copyOfRange(nums, 3, nums.length);
            out.write("Case #" + (i + 1) + ": " + solve(0, s, p, t) + "\n");
        }
        in.close();
        out.close();

        assert solve(3, 1, 5, 15, 13, 11) == 3;
        assert solve(3, 0, 8, 23, 22, 21) == 2;
        assert solve(2, 1, 1, 8, 0) == 1;
        assert solve(6, 2, 8, 29, 20, 8, 18, 18, 21) == 3;
    }

    private static int solve(int n, int s, int p, int... t) {
        Arrays.sort(t);
        int surprisingCount = 0;
        int result = 0;
        for (int i = t.length - 1; i >= 0; i--) {
            int total = t[i];
            int score = getMaxScore(total);
            if (surprisingCount < s && canBeSurprising(total)) {
                int surprisingScore = getMaxSurprisingScore(total);
                if (score < p && surprisingScore >= p) {
                    surprisingCount++;
                    score = surprisingScore;
                }
            }
            if (score >= p) {
                result++;
            }
        }
        return result;
    }

    private static boolean canBeSurprising(int total) {
        return (total >= 2) && (total <= 28);
    }

    private static int getMaxScore(int total) {
        return (total + 2) / 3;
    }

    private static int getMaxSurprisingScore(int total) {
        return (total + 4) / 3;
    }
}

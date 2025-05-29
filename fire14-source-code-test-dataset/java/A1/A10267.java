import java.io.*;
import java.util.StringTokenizer;

public class Dancing {

    public static void main(String[] args) {
        try {
            BufferedReader in = new BufferedReader(new FileReader("B-small-attempt0.in"));
            PrintWriter out = new PrintWriter(new FileWriter("B-small-attempt0.out"));

            Integer cases = Integer.valueOf(in.readLine().trim());
            for (int i = 0; i < cases; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine().trim());
                int dancers = Integer.valueOf(st.nextToken().trim());
                int surprising = Integer.valueOf(st.nextToken().trim());
                int minScore = Integer.valueOf(st.nextToken().trim());
                int[] scoreTotals = new int[dancers];
                for (int j = 0; j < scoreTotals.length; j++) {
                    scoreTotals[j] = Integer.valueOf(st.nextToken().trim());
                }
                int maxDancers = solve(surprising, 0, minScore, scoreTotals, 0);
                out.println(String.format("Case #%d: %d", i+1, maxDancers));
            }

            out.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int solve(int maxSurprising, int numSurprising, int minScore, int[] scoreTotals, int totalIndex) {
        int maxDancers = 0;
        if (totalIndex < scoreTotals.length) {
            int totalScore = scoreTotals[totalIndex];
            for (int i = (int)Math.ceil(totalScore/3); i <= (int)Math.min(totalScore,Math.ceil((totalScore+4)/3)); i++) {
                for (int j = Math.max(i-2,0); j <= i; j++) {
                    int k = totalScore - i - j;
                    if ((i - k > 2) || (i - k < 0)) continue;
                    boolean isSurprising = Math.abs(i - j) == 2 || Math.abs(i - k) == 2 || Math.abs(j - k) == 2;
                    if (isSurprising && maxSurprising == numSurprising) continue;
                    int dancers = (i >= minScore ? 1 : 0) + solve(maxSurprising, numSurprising + (isSurprising ? 1 : 0), minScore, scoreTotals, totalIndex+1);
                    maxDancers = Math.max(maxDancers, dancers);
                }
            }
        }
        return maxDancers;
    }
}

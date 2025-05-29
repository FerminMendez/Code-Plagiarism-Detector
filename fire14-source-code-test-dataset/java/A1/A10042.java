import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class GoogleDancers {
    static BufferedWriter bw = null;
    static long time = System.currentTimeMillis();

    public static void main(String[] args) throws Exception {
        try {
            Scanner sc = new Scanner(new File("B-small-attempt0.in"));
            bw = new BufferedWriter(new FileWriter("output.txt"));
            long totalCases = sc.nextLong();
            for (int i = 1; i <= totalCases; i++) {
                long numContestants = sc.nextLong();
                long numSurprises = sc.nextLong();
                long maxScore = sc.nextLong();
                long minSurpriseTotalScore = maxScore + getMinimumScore(maxScore, 2) + getMinimumScore(maxScore, 2);
                long minTotalScore = maxScore + getMinimumScore(maxScore, 1) + getMinimumScore(maxScore, 1);
                long qualifiers = 0;
                for (int j = 0; j < numContestants; j++) {
                    long nextScore = sc.nextLong();
                    if ((nextScore >= minTotalScore)) {
                        qualifiers++;
                    } else if (((nextScore < minTotalScore) && ((nextScore >= minSurpriseTotalScore) && (numSurprises > 0)))) {
                        qualifiers++;
                        numSurprises--;
                    }
                }
                bw.append("Case #" + i + ": ");
                bw.append(String.valueOf(qualifiers));
                bw.append("\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            bw.flush();
            bw.close();
            System.out.println((System.currentTimeMillis() - time) / 1000);
        }

    }

    private static long getMinimumScore(long maxScore, long subtract) {
        return (maxScore - subtract) < 0 ? 0 : (maxScore - subtract);
    }

}

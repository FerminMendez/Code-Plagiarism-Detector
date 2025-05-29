import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class SecondQuestions {
    
	
	private static long getLeastScore(long maxScore, long subtract) {
        return (maxScore - subtract) < 0 ? 0 : (maxScore - subtract);
    }

    public static void main(String[] args) throws Exception {
        try {
            Scanner sc = new Scanner(new File("large.in"));
            BufferedWriter bufferedWriter = null;
            bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));
            long totalCases = sc.nextLong();
            for (int i = 1; i <= totalCases; i++) {
                long numContestants = sc.nextLong();
                long numSurprises = sc.nextLong();
                long maxScore = sc.nextLong();
                long minSurpriseTotalScore = maxScore + getLeastScore(maxScore, 2) + getLeastScore(maxScore, 2);
                long minTotalScore = maxScore + getLeastScore(maxScore, 1) + getLeastScore(maxScore, 1);
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
                bufferedWriter.append("Case #" + i + ": ");
                bufferedWriter.append(String.valueOf(qualifiers));
                bufferedWriter.append("\n");
            }
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

    

}

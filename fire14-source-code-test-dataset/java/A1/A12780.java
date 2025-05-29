/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dancingwiththegooglers;

/**
 *
 * @author James
 */
public class ScoreAnalyzer {

    private int targetBestResultScore;
    private int surprisingScores;
    private int[] totalScores;

    public ScoreAnalyzer(int[] data) {
        surprisingScores = data[1];
        targetBestResultScore = data[2];

        totalScores = new int[data[0]];
        for (int i = 0; i < data[0]; i++) {
            totalScores[i] = data[i+3];
        }
    }

    public int getMaxNumOfHighScoringDancers() {
        int result = 0;

        int avgTotal = targetBestResultScore * 3;

        if (avgTotal == 0) {
            return totalScores.length; // all competitors got at least 0.
        }

        for (int i = 0; i < totalScores.length; i++) {
            if (totalScores[i] != 0) {
                if (totalScores[i] >= (avgTotal-2)) {
                    // score set is at least
                    // target-1 target-1 target
                    result++;
                } else if ((totalScores[i] >= (avgTotal-4)) && (surprisingScores > 0)) {
                    // score is at least
                    // target-2 target-2 target
                    // and this result may be a surprising score
                    result++;
                    surprisingScores--; // remove a surprising score
                } // else it cannot possibly have a sufficiently high max score
            }
        }
        return result;
    }

}

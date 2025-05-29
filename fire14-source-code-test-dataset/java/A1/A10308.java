package googlecodejam;

import java.util.ArrayList;

/**
 *
 * @author Matej
 */
public class ProblemB {

    int googlers;
    int surprises;
    int targetScore;
    ArrayList<Integer> scores = new ArrayList<>();

    public ProblemB(int g, int s, int t, ArrayList<Integer> l) {
        googlers = g;
        surprises = s;
        scores = l;
        targetScore = t;
    }

    public int solve() {
        int result = 0;
        for (int score : scores) {
            int last2scores = score - targetScore;
            if (last2scores >= 0) {
                if (last2scores >= (targetScore - 1) * 2) {
                    result++;
                } else if (surprises > 0 && last2scores >= (targetScore - 2) * 2) {
                    surprises--;
                    result++;
                }
            }
        }

        return result;
    }
}

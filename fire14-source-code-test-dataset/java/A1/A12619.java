
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dancing {

    static int[] max_surprising = new int[31];
    static int[] max_no_surprising = new int[31];

    public static void main(String[] args) throws IOException {

        max_surprising[0] = 0;
        max_no_surprising[0] = 0;
        max_surprising[1] = 0;
        max_no_surprising[1] = 0;
        for (int i = 2; i < 29; i++) {

            int remainder = i % 3;
            int quotient = i / 3;
            if (remainder == 0) {
                max_no_surprising[i] = quotient;
                max_surprising[i] = quotient + 1;
            } else if (remainder == 1) {
                max_no_surprising[i] = quotient + 1;
                max_surprising[i] = quotient + 1;
            } else {
                max_no_surprising[i] = quotient + 1;
                max_surprising[i] = quotient + 2;
            }
        }
        max_no_surprising[29] = 10;
        max_surprising[29] = 10;
        max_no_surprising[30] = 10;
        max_surprising[30] = 10;

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(in.readLine());
        for (int i = 0; i < cases; i++) {
            String[] inp = in.readLine().split(" ");
            int surprisesLeft = Integer.parseInt(inp[1]);
            int target = Integer.parseInt(inp[2]);
            String[] scores = new String[inp.length - 3];
            for(int j = 0; j < scores.length; j++)
                scores[j] = inp[j+3];
             int answer = calculate(scores, surprisesLeft, target);
             System.out.println("Case #" + (i+1) + ": " + answer);

        }



    }

    public static int calculate(String[] scoresRemaining, int surprisesLeft, int target) {
        int count = 0;

        if (scoresRemaining.length == surprisesLeft) {
            for (int i = 0; i < scoresRemaining.length; i++) {
                if (max_surprising[Integer.parseInt(scoresRemaining[i])] >= target) {
                    count++;
                }
            }
            return count;
        } else if (surprisesLeft == 0) {

            for (int i = 0; i < scoresRemaining.length; i++) {
                if (max_no_surprising[Integer.parseInt(scoresRemaining[i])] >= target) {
                    count++;
                }
            }
            return count;

        } else {
            int score = Integer.parseInt(scoresRemaining[0]);
            String[] temp = new String[scoresRemaining.length - 1];
            for (int i = 0; i < temp.length; i++) {
                temp[i] = scoresRemaining[i + 1];
            }
            if (max_no_surprising[score] >= target) {
                return 1 + calculate(temp, surprisesLeft, target);
            } else if (max_surprising[score] >= target) {
                return 1 + calculate(temp, surprisesLeft - 1, target);
            } else {
                return calculate(temp, surprisesLeft, target);
            }

        }
    }
}

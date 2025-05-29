import java.util.Arrays;
import java.util.Scanner;


public class Q2 {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for (int i = 0; i < T; i++) {
            int N = s.nextInt();
            int S = s.nextInt();
            int P = s.nextInt();
            int[] scores = new int[N];
            for (int j = 0; j < N; j++) {
                scores[j] = s.nextInt();
            }
            System.out.println("Case #" + (i + 1) + ": " + numAboveMax(scores, S, P));
        }
    }

    private static int numAboveMax(int[] scores, int S, int P) {
        Arrays.sort(scores);
        int surprises = 0;
        int result = 0;
        if (P > 1) {
            for (int i = scores.length - 1; i >= 0; i--) {
                if (scores[i] > (3 * P - 3)) {
                    result++;
                } else if ((scores[i] > (3 * P - 5)) && (surprises < S)) {
                    result++;
                    surprises++;
                }
            }
            return result;
        } else if (P == 1) {
            for (int i = scores.length - 1; i >= 0; i--) {
                if (scores[i] > 0) {
                    result++;
                }
            }
            return result;
        } else {
            return scores.length;
        }
    }
}

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Gcj12B {
    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.err.println("Missing input filename as argument.");
            System.exit(1);
        }
        final BufferedReader in = new BufferedReader(new FileReader(args[0]));
        final PrintWriter out =
            new PrintWriter(new BufferedOutputStream(System.out));

        final int nbrTestCases = Integer.parseInt(in.readLine());
        for (int testCase = 1; testCase <= nbrTestCases; testCase++) {
            final StringTokenizer st1 = new StringTokenizer(in.readLine());
            final int n = Integer.parseInt(st1.nextToken());
            final int s = Integer.parseInt(st1.nextToken());
            final int p = Integer.parseInt(st1.nextToken());
            final int[] totalScores = new int[n];
            for (int i = 0; i < n; i++) {
                totalScores[i] = Integer.parseInt(st1.nextToken());
            }

            final int[][] scores = new int[n][3];
            final int scoreCutoff = p*3;
            final ArrayList<Integer> surprises = new ArrayList<Integer>(s);
            final ArrayList<Integer> canSurprise = new ArrayList<Integer>(s);

            //System.err.println("scores 1");
            for (int i = 0; i < n; i++) {
                final int totalScore = totalScores[i];
                final int avg = totalScore / 3;
                final int m = totalScore % 3;
                scores[i][0] = avg;
                scores[i][1] = avg;
                scores[i][2] = avg;
                if (m >= 1) {
                    scores[i][2]++;
                }
                if (m == 2) {
                    scores[i][1]++;
                }
                if (totalScore >= (scoreCutoff - 4) && totalScore <= (scoreCutoff - 3) && totalScore >= 2) {
                    surprises.add(i);
                } else if (totalScore >= 2 && totalScore <= 28) {
                    canSurprise.add(i);
                }
                //System.err.println(Arrays.toString(scores[i]));
            }

            int surprisesLeft = s;
            int k = 0;
            while (surprisesLeft > 0 && k < surprises.size()) {
                final int googler = surprises.get(k);
                final int totalScore = totalScores[googler];
                final int m = totalScore % 3;
                switch (m) {
                case 0:
                    scores[googler][0]--;
                    scores[googler][2]++;
                    break;
                case 2:
                    scores[googler][1]--;
                    scores[googler][2]++;
                    break;
                default:
                    assert false;
                    break;
                }
                surprisesLeft--;
                k++;
            }
            /*System.err.println("scores 2");
            for (int i = 0; i < n; i++) {
                System.err.println(Arrays.toString(scores[i]));
            }*/

            k = 0;
            while (surprisesLeft > 0) {
                final int googler = canSurprise.get(k);
                final int totalScore = totalScores[googler];
                final int m = totalScore % 3;
                switch (m) {
                case 0:
                    scores[googler][0]--;
                    scores[googler][2]++;
                    break;
                case 1:
                    scores[googler][0]--;
                    scores[googler][1]++;
                    break;
                case 2:
                    scores[googler][1]--;
                    scores[googler][2]++;
                    break;
                default:
                    assert false;
                    break;
                }
                surprisesLeft--;
                k++;
            }
            /*System.err.println("scores 3");
            for (int i = 0; i < n; i++) {
                System.err.println(Arrays.toString(scores[i]));
            }*/

            int nbrGreater = 0;
            for (int i = 0; i < n; i++) {
                boolean isGreater = false;
                for (int j = 0; j < 3; j++) {
                    isGreater |= scores[i][j] >= p;
                }
                if (isGreater) {
                    nbrGreater++;
                }
            }
            out.printf("Case #%d: ", testCase);
            out.println(nbrGreater);
        }

        out.flush();
    }
}

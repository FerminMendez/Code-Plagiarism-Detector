
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PB {

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length != 1) {
            System.exit(1);
        }
        File inFile = new File(args[0]);
        Scanner sc = new Scanner(inFile);
        int T = sc.nextInt();
        try (PrintWriter out = new PrintWriter("out.txt")) {
            for (int i = 0; i < T; i++) {
                int N = sc.nextInt();
                int S = sc.nextInt();
                int p = sc.nextInt();
                int[] t = new int[N];
                for (int j = 0; j < N; j++) {
                    t[j] = sc.nextInt();
                }
                int[][] scores = new int[N][3];
                for (int j = 0; j < N; j++) {
                    scores[j][0] = t[j] / 3;
                    scores[j][1] = (t[j] - scores[j][0]) / 2;
                    scores[j][2] = t[j] - scores[j][0] - scores[j][1];
                }
                int count = 0;
                for (int j = 0; j < N; j++) {
                    boolean isSurprise = false;
                    if (scores[j][2] - scores[j][0] == 2) {
                        S--;
                        isSurprise = true;
                    }
                    if (scores[j][2] >= p) {
                        count++;
                    } else {
                        if (S > 0 && !isSurprise && (p - scores[j][2]) == 1 && scores[j][1] > 0) {
                            S--;
                            scores[j][1]--;
                            scores[j][2]++;
                            count++;
                        }
                    }
                }
                out.println("Case #" + (i + 1) + ": " + count);
            }
        }
        System.out.println("Completed");
    }
}

import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class go2 {

    public static final String IN_FILE = "B-small-attempt0.in";
    public static final String OUT_FILE = "out.txt";


    public static void main(String[] args) throws Throwable {

        try (LineNumberReader reader = new LineNumberReader(new FileReader(IN_FILE))) {
            try (PrintWriter writer = new PrintWriter(OUT_FILE)) {

                int T = Integer.parseInt(reader.readLine());

                //Tests
                for (int t = 1; t <= T; t++) {
                    Scanner scanner = new Scanner(reader.readLine());
                    int N = scanner.nextInt();
                    int S = scanner.nextInt();
                    int P = scanner.nextInt();

                    int result = 0;
                    int bothSurprisingAndNotSurprising = 0;

                    for (int i = 0; i < N; i++) {
                        int currentScore = scanner.nextInt();
                        if (currentScore == 0) {
                            if (P == 0) {
                                result++;
                            }
                        } else if (currentScore == 1) {
                            if (P == 0 || P == 1) {
                                result++;
                            }
                        } else if (currentScore == 30) {
                            result++;
                        } else if (currentScore == 29) {
                            result++;
                        }
                        // 2 <= currentScore <= 28
                        else {
                            int bestSurprising;
                            int bestNotSurprising;

                            if ((currentScore % 3 == 0)) {
                                bestSurprising = (currentScore / 3) + 1;
                                bestNotSurprising = (currentScore / 3);
                            }
                            else if ((currentScore % 3 == 1)) {
                                bestNotSurprising = bestSurprising = (currentScore / 3) + 1;
                            }
                            else {
                                bestSurprising = (currentScore / 3) + 2;
                                bestNotSurprising = (currentScore / 3) + 1;
                            }

                            if(bestNotSurprising < P && bestSurprising == P){
                                if(S > 0) {
                                    S--;
                                    result++;
                                }
                            }
                            else if(bestNotSurprising >= P){
                                bothSurprisingAndNotSurprising++;
                            }
                        }
                    }

                    result += bothSurprisingAndNotSurprising;

                    writer.printf("Case #%d: %d\n", t, result);
                }
            }
        }
    }
}


package R0;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Rohit
 */
public class QB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int Tcases = s.nextInt();
        s.nextLine();
        for (int i = 0; i < Tcases; i++) {
            int Ngooglers = s.nextInt();
            int Ssurprising = s.nextInt();
            int Paim = s.nextInt();
            int score[] = new int[Ngooglers];
            for (int j = 0; j < Ngooglers; j++) {
                score[j] = s.nextInt();
            }
            /*
             * if score is <2, surprisingNotPossible,
             * if score is >=2 and <3*Paim - 4 surprisingPossible but bestNotPossible
             * if score is >=3*Paim-4 and <3*Paim-2 bestPossible only using surprising
             * if score is >=3*Paim-2 and <29 bestPossible and surprisingPossible
             * if score is >=29 bestPossible and surprisingNotPossible
             */
            int maxBest = 0;
            if (Paim == 0) {
                maxBest = Ngooglers;
            }
            if (Paim == 1) {
                for (int j = 0; j < Ngooglers; j++) {
                    if (score[j] >= 1) {
                        maxBest++;
                    }
                }
            }
            if (Paim > 1) {
                for (int j = 0; j < Ngooglers; j++) {
                    if (score[j] >= 3 * Paim - 4) {
                        if (score[j] < 3 * Paim - 2) {
                            if (Ssurprising > 0) {
                                maxBest++;
                                Ssurprising--;
                            }
                        } else {
                            maxBest++;
                        }
                    }
                }
            }
            //printing the output
            System.out.println("Case #" + (i + 1) + ": " + maxBest);

        }
    }
}

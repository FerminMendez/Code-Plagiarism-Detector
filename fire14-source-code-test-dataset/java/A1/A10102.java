package googlecodejam;

/**
 *
 * @author ffreakk
 */

import java.util.Scanner;
import java.lang.Math;
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for (int t=1; t<=T; t++){
            int N = in.nextInt();
            int S = in.nextInt();
            int p = in.nextInt();
            int nSurprises = 0;
            int result = 0;
            int surpriseScore = 3*p - 4;
            int okScore = 3*p - 2;

            int scoreArray[] = new int[N];
            for (int n=0; n<N; n++) {
                scoreArray[n] = in.nextInt();
            }

            for (int i=0; i<N; i++) {
                if (scoreArray[i] >= okScore)
                    result++;
                else if (scoreArray[i] >= surpriseScore && scoreArray[i]>0)
                    nSurprises++;
            }

            result += Math.min(nSurprises, S);
            System.out.println("Case #" +t+ ": " + result);
        }
    }

}

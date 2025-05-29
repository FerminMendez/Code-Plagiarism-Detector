package codejam2012;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 *
 * @author devashish
 */
public class ProblemB {

    public static void main(String[] args) {
        StringTokenizer st = null;
        BufferedReader in;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new FileReader(new File("E:/b.in")));
            out = new PrintWriter(new FileWriter(new File("E:/b.out")));

            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(in.readLine());
            }
            int t = Integer.parseInt(st.nextToken());
            for (int i = 1; i <= t; i++) {
                while (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(in.readLine());
                }

                int N = Integer.parseInt(st.nextToken());
                int S = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                int[] T = new int[N];
                for (int j = 0; j < N; j++) {
                    T[j] = Integer.parseInt(st.nextToken());
                }

                int outputLine = maxGooglers(N, S, p, T);

                out.print("Case #" + i + ": " + outputLine + "\n");
            }
        } catch (IOException e) {
        }
        out.flush();
    }

    private static int maxGooglers(int N, int S, int p, int[] T) {
        int output = 0;

        int surprisingMinScore = Math.max(3 * p - 4, 0) ;
        int nonSurprisingMinScore = Math.max(3 * p - 2, 0);
        int countSurprise = 0;
        
       // System.out.println(surprisingMinScore);
       // System.out.println(nonSurprisingMinScore);

        for (int i = 0; i < T.length; i++) {
            //    System.out.println(T[i]);            
         //   System.out.println("T[i]: " + T[i]);
            if (T[i] < surprisingMinScore) {
                continue;
            } else if (T[i] >= surprisingMinScore && T[i] < nonSurprisingMinScore) {
                //either surprising or low scores
                //countSurprise += findPossibleSurprisingScoresWithBestResult(T[i], p);
                if (S > 0 && T[i] >= 2) {
                    countSurprise += findPossibleSurprisingScoresWithBestResult(T[i], p);
           //         System.out.println("#countSurprise: " + countSurprise);
                    //output += findPossibleSurprisingScoresWithBestResult(T[i], p);
                }                
            } else if (T[i] >= nonSurprisingMinScore) {
                //Non surprising score
                //System.out.println("non surprising score.");
                output++;
            }          
        }
        
        //System.out.println("#output: " + output);
        //System.out.println((countSurprise < S ? countSurprise : S));
        return output + (countSurprise < S ? countSurprise : S);
    }
    
    private static int findPossibleSurprisingScoresWithBestResult(int t, int p) {
        int count = 0;
        int a = t/3;
        int b = ((t + 4)/3);

        if (p >= a && p <=b) {
            count++;
        }
        //System.out.println("#count:" + count);
        return count;
    }
}

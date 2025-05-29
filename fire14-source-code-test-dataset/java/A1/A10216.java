/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gcj.base;

import java.util.regex.Pattern;

/**
 *
 * @author jalves
 */
public class ProbB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new ProbB(args).DoIt();
    }

    Console io;
    private ProbB(String[] args) {
        boolean ovwr = false;
        String in = null;
        String out = null;

        for (int i = 0; i < args.length; i++) {
            if (args[i].startsWith("-i")) {
                in = args[i].substring(2);
                if (in.length() == 0) {
                    in = args[++i];
                }
            } else if (args[i].startsWith("-o")) {
                out = args[i].substring(2);
                if (out.length() == 0) {
                    out = args[++i];
                }
            } if (args[i].equals("-f")) {
                ovwr = true;
            }
        }

        io = new Console(in, out, ovwr);
    }

    private void DoIt()  {
        long startTime, remain;
        long nCases;
        io.logt("Starting...");
        try {
            nCases = io.getLong();
            io.log("There are " + nCases + " cases to process\n");
            startTime = System.currentTimeMillis();
            remain = 20000; // just some value
            for (long i = 1; i <= nCases; i++) {
                io.log("\rProcessing test case " + i + "/" + nCases + " : Remaining " + String.format("%.2fs      ", remain/1000.0));

                DoCase(i);

                remain = (long)((System.currentTimeMillis() - startTime) * ((double)nCases/(double)i - 1));
            }
            io.log("\n");
        } catch (Exception ex) {
            io.logt("\n\nERROR: " + ex);
            throw new RuntimeException("Error while executing main loop", ex);
        }
        io.logt("Done!");
    }

    private void DoCase(long caseNum) throws Exception {
        String input;
        int result;
        
        io.print("Case #" + caseNum + ": ");

        int N = (int)io.getLong();
        int surprising = (int)io.getLong();
        int bestScore = (int)io.getLong();
        
        if (bestScore == 0) {
            result = N;
            for (int i = 0; i < N; i++) {
                io.getLong();
            }
        } else {
            result = 0;
            
            int regularThreshold = bestScore * 3 - 3;
            if (regularThreshold < 0) {
                regularThreshold = 0;
            }
            int surpriseThreshold = regularThreshold - 2;
            if (surpriseThreshold < 1) {
                surpriseThreshold = 1;
            }
            
            int score;
            for (int i = 0; i < N; i++) {
                score = (int)io.getLong();
                if (score > regularThreshold) {
                    result++;
                } else if (score > surpriseThreshold) {
                    if (surprising > 0) {
                        surprising--;
                        result++;
                    }
                }
            }
        }

        io.println(String.valueOf(result));
    }
}

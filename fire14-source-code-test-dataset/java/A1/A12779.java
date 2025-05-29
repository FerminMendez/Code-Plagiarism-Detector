package cj2;

import dancingwiththegooglers.ScoreAnalyzer;
import edu.uwec.cs.genacje.codejam.speakingintongues.GooglereseTranslator;
import edu.uwec.cs.genacje.codejam.utilities.objects.IoMgr;
import edu.uwec.cs.genacje.codejam.utilities.objects.StringFormatter;

/**
 *
 * @author James Genac
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        long totalTime = System.currentTimeMillis();
        solveDancingWithTheGooglers();
       System.out.println("Total time to solve: " + (System.currentTimeMillis() - totalTime) + " ms.");

    }

    private static void solveDancingWithTheGooglers() {
        IoMgr io = new IoMgr("B-small-attempt0.in");

        int linecount = 1;
        long start = 0;
        io.rls(); // eat first line

        ScoreAnalyzer scoreAnalyzer = null;

        while (io.ready()) {
            scoreAnalyzer = new ScoreAnalyzer(io.rlia(" "));


            start = System.currentTimeMillis();

            io.wlf("Case #"+linecount+": " + scoreAnalyzer.getMaxNumOfHighScoringDancers());
            System.out.println("Case " + linecount + " took " + (System.currentTimeMillis()-start) + " ms.");
            linecount++;
        }


       io.close();
    }

    private static void solveSpeakingInTongues() {
        IoMgr io = new IoMgr("A-small-attempt0.in");

            int linecount = 1;
            long start = 0;
            io.rls(); // eat first line
            String in = "";
            long totalTime = System.currentTimeMillis();

            while (io.ready()) {
                in = io.rls();


                start = System.currentTimeMillis();

                io.wlf("Case #"+linecount+": " + GooglereseTranslator.translateString(in));
                System.out.println("Case " + linecount + " took " + (System.currentTimeMillis()-start) + " ms.");
                linecount++;
            }


           io.close();
    }
}



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dancingwiththegooglers;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 * @author arjun
 */
public class DancingWiththeGooglers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
        System.setOut(out);
        parseAndTranslate();
    }

    private static void parseAndTranslate() {
        try {
            // Open the file that is the first 
            // command line parameter
            FileInputStream fstream = new FileInputStream("B-small-attempt0.in");
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine = br.readLine();
            if (null != strLine) {
                int count = new Integer(strLine);
                //Read File Line By Line
                int lineNo = 0;
                while ((strLine = br.readLine()) != null) {
                    lineNo++;
                    doOp(strLine, lineNo);
                }
                //Close the input stream
            }
            in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void doOp(String strLine, int lineNo) {

        StringTokenizer st = new StringTokenizer(strLine);

        String temp = st.nextToken();
        int noOfGooglers = new Integer(temp);

        temp = st.nextToken();
        int surprisingTriplets = new Integer(temp);

        temp = st.nextToken();
        int bestScore = new Integer(temp);
        //System.out.println("Goog: " + noOfGooglers + " surp: " + surprisingTriplets
          //    + " bestScore: " + bestScore + " ");
        int nthNo = 0;
        Map<Integer, List<Integer>> iSet = new HashMap<Integer, List<Integer>>();
        while (st.hasMoreTokens()) {
            nthNo++;
            String pts = st.nextElement().toString();
            int pt = new Integer(pts);
            //System.out.print(" " + pt);
            boolean SurpUsed = compute(pt, bestScore, surprisingTriplets, iSet, nthNo);
            if (SurpUsed) {
                surprisingTriplets -= 1;
            }
        }

        int topScores = 0;
        for (Integer pointNo : iSet.keySet()) {              
            List<Integer> points = iSet.get(pointNo);
            //System.out.print("\nNo: " + pointNo + ", Scores: ");
            boolean topScoreFoundAlready = false;
            for (Integer p : points) {
                if (p >= bestScore && !topScoreFoundAlready) {
                    topScores++;
                    topScoreFoundAlready = true;
                }
                //System.out.print(" " + p);
            }
            //System.out.println();
        }
        System.out.println("Case #" + lineNo + ": " + topScores);
    }

    private static boolean compute(int pt, int bestScore, int surprisingTriplets,
            Map<Integer, List<Integer>> iSet, int nthNo) {
        List<Integer> points = new ArrayList<Integer>();
        boolean surpUsed = false;

        int no1 = 0, no2 = 0, no3 = 0;
        int mean = Math.round(pt / 3);
        int rem = pt % 3;

        if (0 == rem) {
            if (mean < bestScore) {
                if (surprisingTriplets > 0 && (mean + 1) >= bestScore 
                        && (mean - 1) >= 0 && (mean + 1) <= 10) {
                    surpUsed = true;
                    no1 = mean;
                    no2 = mean + 1;
                    no3 = mean - 1;
                } else {
                    no1 = mean;
                    no2 = mean;
                    no3 = mean;
                }
            } else {
                no1 = mean;
                no2 = mean;
                no3 = mean;
            }
        } else if (1 == rem) {
            no1 = mean + 1;
            no2 = mean;
            no3 = mean;
        } else if (2 == rem) {
            if ((mean + 1) < bestScore) {
                if (surprisingTriplets > 0 && (mean + 2) >= bestScore
                        && (mean + 2) <= 10) {
                    surpUsed = true;
                    no1 = mean + 2;
                    no2 = mean;
                    no3 = mean;
                } else {
                    no1 = mean + 1;
                    no2 = mean + 1;
                    no3 = mean;
                }
            } else {
                no1 = mean + 1;
                no2 = mean + 1;
                no3 = mean;
            }
        }


        points.add(no1);
        points.add(no2);
        points.add(no3);
        iSet.put(nthNo, points);
        return surpUsed;
    }
}

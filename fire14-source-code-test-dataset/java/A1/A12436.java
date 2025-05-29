/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package codejam2012;

import java.io.*;

/**
 *
 * @author BUDDHIMA
 */
public class codejamQB {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("B-small-attempt0.in"));
        BufferedWriter out = new BufferedWriter(new FileWriter(new File("outputB-small.txt")));

        int tests = Integer.parseInt(br.readLine());

        for (int testIndex = 1; testIndex <= tests; testIndex++) {

            String[] lineParts = br.readLine().split(" ");

            int googlers = Integer.parseInt(lineParts[0]);
            int suptrip = Integer.parseInt(lineParts[1]);
            int bestVal = Integer.parseInt(lineParts[2]);

            int count = 0;

            int[] totals = new int[googlers];

            // Fill googler total array
            for (int n = 0; n < googlers; n++) {

                totals[n] = Integer.parseInt(lineParts[3 + n]);

            }


            for (int index = 0; index < totals.length; index++) {

                int full = totals[index] / 3;
                int deci = totals[index] % 3;

                if (totals[index] < bestVal) {
                } else if ((full == bestVal - 2 && deci == 2) || (full == (bestVal - 1) && deci == 0)) { // chance to waste supprising values
                    if (suptrip > 0) {
                        suptrip--;
                        count++;
                    }
                } else if (full >= bestVal - 1) { // can compose triplets without using supprising values

                    count++;

                }


            }


            System.out.println(count);

            
            if(testIndex==tests)
            out.write("Case #" + testIndex + ": " + count );
            else out.write("Case #" + testIndex + ": " + count + "\n");



        }




        out.close();
    }
}

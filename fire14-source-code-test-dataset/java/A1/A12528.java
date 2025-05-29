/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gcjqual;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author greg
 */
public class GCJQual2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GCJQual2 g = new GCJQual2();
        g.run();
    }

    private void run() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        String eachLine;
        int count = 1;
        try {
            br = new BufferedReader(new FileReader("input2.txt"));
//            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw = new BufferedWriter(new FileWriter("output2.txt"));
            String numTests = br.readLine();
            while ((eachLine = br.readLine()) != null) {
                bw.write("Case #" + count + ": ");
                bw.write(solve(eachLine));
                bw.newLine();
                count++;
            }
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(GCJQual1.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(GCJQual1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private String solve(String eachLine) {
        String[] params = eachLine.split(" ");
        int N = Integer.valueOf(params[0]);
        int S = Integer.valueOf(params[1]);
        int p = Integer.valueOf(params[2]);
        
        int minScore = Math.max(p * 3 - 2, p);
        int minSurprise = Math.max(p * 3 - 4, p);
                
//        ArrayList t = new ArrayList();
        int dancerPassed = 0;
        int dancerSurprise = 0;
        
        for (int i=0; i<N; i++) {
            int score = Integer.valueOf(params[i+3]);
            if ( score >= minScore) {
                dancerPassed++;
            } else if (score >= minSurprise ) {
                dancerSurprise++;
            }
        }
        
        if ( dancerSurprise > S ) {
            dancerSurprise = S;
        }
        
        
        return "" + (dancerPassed + dancerSurprise);
    }
}

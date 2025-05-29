/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gcjqual;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author greg
 */
public class GCJQual3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GCJQual3 g = new GCJQual3();
        g.run();
    }

    private void run() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        String eachLine;
        int count = 1;
        try {
            br = new BufferedReader(new FileReader("input3.txt"));
//            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw = new BufferedWriter(new FileWriter("output3.txt"));
            String numTests = br.readLine();
            System.out.println(numTests);
            while ((eachLine = br.readLine()) != null) {
                bw.write("Case #" + count + ": ");
                bw.write(solve(eachLine));
                bw.newLine();
                count++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
            Logger.getLogger(GCJQual3.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                bw.close();
                br.close();
            } catch (IOException ex) {
                Logger.getLogger(GCJQual3.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private String solve(String eachLine) {
        String[] params = eachLine.split(" ");
        int A = Integer.valueOf(params[0]);
        int B = Integer.valueOf(params[1]);
        int recycledCount = 0;
        
        for (int n=A; n<=B; n++) {
            Set<Integer> possible = getRecycled(n);
            for (int m:possible) {
                if (m <= B) {
                    recycledCount++;
                }
            }
        }
        return "" + recycledCount;
    }

    private Set<Integer> getRecycled(int n) {
        Set<Integer> possible = new HashSet<Integer> ();
        int shift = 2;
        if ( n > 11 ) { // no single or 10 or 11
            if ( n >= 1000000) {
                shift = 7;
            } else if ( n >= 100000) {
                shift = 6;
            } else if ( n >= 10000) {
                shift = 5;
            } else if ( n >= 1000) {
                shift = 4;
            } else if ( n >= 100 ) {
                shift = 3;
            }
            int newNum = n;
            for ( int i =0; i< shift-1; i++) {
                int last = newNum % 10;
                newNum = (int) (newNum / 10 + (Math.pow(10, shift-1)*last));
                if ( newNum > n ) {
                    possible.add(newNum);
                }
            }
        }
        // Cache possible
        return possible;
    }
    
}


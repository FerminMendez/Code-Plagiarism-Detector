/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package google2012;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author g
 */
public class Google2012 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String line;
            int numCases = Integer.parseInt(reader.readLine());
            for (int i=0; i<numCases; i++) {
                line = reader.readLine();
                String[] tokens = line.split(" ");
                int dancers = Integer.parseInt(tokens[0]);
                int special = Integer.parseInt(tokens[1]);
                int maxScore = Integer.parseInt(tokens[2]);
                int minSumWithoutSpecial = maxScore+Math.max((maxScore-1),0)+Math.max(maxScore-1,0);
                int minSumWithSpecials = maxScore+Math.max(maxScore-2,0)+Math.max(maxScore-2,0);
                int counter=0;
                for (int j=0; j<dancers; j++) {
                    int sum = Integer.parseInt(tokens[3+j]);
                    if (sum >= minSumWithoutSpecial) {
                        counter++;
                        continue;
                    }
                    if (sum >= minSumWithSpecials && special > 0) {
                        counter++;
                        special--;
                        continue;                       
                    }
                }
                System.out.println("Case #" + (i+1) + ": " + counter);
            }
        } catch (IOException ex) {
            Logger.getLogger(Google2012.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}

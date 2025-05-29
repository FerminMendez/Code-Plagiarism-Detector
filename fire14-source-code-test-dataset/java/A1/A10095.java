/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package googlecodejam;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author Tobi
 */
public class GoogleCodeJam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        for(int t = 1; t <= T; t++) {
            int N = s.nextInt(); //number of googlers
            int S = s.nextInt(); //number of surprising results
            int p = s.nextInt(); //number of target-best result
            int[] points = new int[N];
            for(int i = 0; i < N; i++)
                points[i] = s.nextInt();
            
            int matches = 0;
            for(int i = 0; i < N; i++) {
                if((points[i] / 3) + 2 < p) //skip results that are too low
                    continue;
                int a = points[i] / 3;
                int b = (points[i] - a) / 2;
                int c = (points[i] - a - b);
                int max = Math.max(Math.max(a, b), c);
                int delta = Math.max(Math.max(Math.abs(b - c), Math.abs(a - b)), Math.abs(a - c));
                
                if(max >= p) {
                    if(delta == 2 && S > 0) { //enough points, but surprising, surprises left?
                        S--;
                        matches++;
                        continue;
                    } else if (delta < 2) { //enough points, no surprise
                        matches++;
                        continue;
                    }
                }
                
                if((max + 1 >= p) && (delta < 2)) {
                    if((S > 0) && (delta == 0) && max > 0) { //can shift one point up and one down -> delta == 2 -> surprise left?
                        S--;
                        matches++;
                    } else if (S > 0 && delta == 1 && ((a == b && a == max) || (a == c && a == max) || (b == c && b == max))) { //can shift one point up, one down, but delta 
                        S--;
                        matches++;
                    }
                }
            }
            System.out.println("Case #" + t + ": " + matches);
        }
    }
}

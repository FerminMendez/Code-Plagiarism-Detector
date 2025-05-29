/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package qual_b;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bart
 */
public class Qual_B {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String file = "B-small-attempt0";
            Scanner scanner = new Scanner(new FileInputStream(file + ".in"));
            Formatter formatter = new Formatter(new File(file + ".out"));

            int numberOfCases = scanner.nextInt();
            System.out.println("Number of cases: " + numberOfCases);

            for (int caseNr = 0; caseNr < numberOfCases; caseNr++) {
                // ** Code Here ** //
                int n = scanner.nextInt();
                int nSpecialCases = scanner.nextInt();
                int max =scanner.nextInt();
                int[] numbers = new int[n];
                System.out.println("n: " + n);
                for(int i=0;i<n;i++){
                    numbers[i] = scanner.nextInt();
                }
                int minAccepted = max + (max-1)*2;
                int maxAccepted = max*3;
                int minSpecial = max + (max-2)*2;
                if (minSpecial <= 0)
                    minSpecial = 1;
                System.out.printf("[%d, %d] (%d)%n", minAccepted, maxAccepted, minSpecial);
                
                int score=0;
                for(int i: numbers){
                    if(i>=minAccepted){
                        System.out.println("Binnen grens: " + i);
                        score++;
                    }
                    else if(nSpecialCases >0 && i>=minSpecial){
                        System.out.println("Binnen grens(speciaal)");
                        score++;
                        nSpecialCases--;
                    }
                }
                
                System.out.println("Score: " + score);
                
                formatter.format("Case #%d: %d%n", caseNr + 1, score);
            }
            formatter.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Qual_B.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

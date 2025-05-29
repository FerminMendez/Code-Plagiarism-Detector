/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mohamedmohideenebrahim
 */
public class Codejam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(new File(args[0]));
            int testCaseNum = scanner.nextInt();
            scanner.nextLine();
            for (int i = 0; i < testCaseNum; i++) {
                System.out.println("Case #" + (i + 1) + ": " + getString(scanner.nextLine()));
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Codejam.class.getName()).log(Level.SEVERE, null, ex);
        }



    }

    public static int getString(String input) {
        String[] inputArray = input.split(" ");
        //System.out.println(input);
        int noOfSurprise = Integer.parseInt(inputArray[1]);
        int minMark = Integer.parseInt(inputArray[2]);

        int countedSurprise = 0;
        int countedMinMark = 0;

        for (int i = 3; i < inputArray.length; i++) {
            int mark = Integer.parseInt(inputArray[i]);
            int remainder = mark % 3;
            int quotient = mark / 3;
            
            if(remainder == 0)
            {
                //System.out.println(quotient+","+quotient+","+quotient);
                //System.out.println((quotient-1)+","+quotient+","+(quotient+1));
                if(quotient >= minMark)
                {
                    countedMinMark++;
                    //System.out.println("Matched "+quotient+","+quotient+","+quotient);
                }
                else if(mark > 2 && countedSurprise != noOfSurprise && (quotient+1) >= minMark)
                {
                    //System.out.println("Matched "+(quotient-1)+","+quotient+","+(quotient+1));
                    countedMinMark++;
                    countedSurprise++;
                }
                //System.out.println();
            }
            else if(remainder == 1)
            {
                //System.out.println(quotient+","+quotient+","+(quotient+1));
                if(quotient+1 >= minMark)
                {
                    //System.out.println("Matched "+quotient+","+quotient+","+(quotient+1));
                    countedMinMark++;
                }
                //System.out.println();
            }
            else if(remainder == 2)
            {
                //System.out.println((quotient+1)+","+quotient+","+(quotient+1));
                //System.out.println(quotient+","+quotient+","+(quotient+2));
                if(quotient+1 >= minMark)
                {
                    //System.out.println("Matched "+(quotient+1)+","+quotient+","+(quotient+1));
                    countedMinMark++;
                }
                else if(mark > 2 && countedSurprise != noOfSurprise && (quotient+2) >= minMark)
                {
                    countedMinMark++;
                    countedSurprise++;
                    //System.out.println("Matched "+quotient+","+quotient+","+(quotient+2));
                }
                //System.out.println();
                
            }
            //System.out.println("Mark " + mark + " Quotient " + quotient
             //       + " Counted MinMark " + countedMinMark + " counted surprise " + countedSurprise);
            //System.out.println();
        }
        return countedMinMark;

    }
}

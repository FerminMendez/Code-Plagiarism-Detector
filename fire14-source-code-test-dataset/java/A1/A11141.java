package CodeJam2;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Ivan du Toit <s29363412>
 */
public class CodeJam2 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader fIn = null;
        PrintWriter fOut = null;
        try {
            fIn = new BufferedReader(new FileReader("in.txt"));
            fOut = new PrintWriter(new FileWriter("out.txt"));
            
        } catch (IOException e) {
            System.out.println("Invalid file given for output.");     
            System.exit(200);
        }
        
        Scanner in = new Scanner(fIn);
        int numberOfCases = Integer.parseInt(in.nextLine());
        
        for (int c=0; c<numberOfCases; c++) {
            fOut.print("Case #" + (c+1) + ": ");
            int numGoogs = in.nextInt();
            int numSuprises = in.nextInt();
            int bestScore = in.nextInt();
            int result = 0;
            for (int pos=0; pos<numGoogs; pos++) {
                int total = in.nextInt();
                int num = (int) Math.floor(total/3);
                int res = total % 3;
                //res = (res  > 1) ? 1 : res; 
                //boolean resBiggerThan1 = (res  > 1);
                boolean resLessThan1 = (res < 1);
                if (num >= bestScore)
                    result++;
                else if ((!resLessThan1) && (num + 1 >= bestScore))
                    result++;
                else if ((numSuprises > 0) && (num > 0) && ((resLessThan1 && (num + 1 >= bestScore)) || (!resLessThan1 && (num + res >= bestScore)))) {
                    numSuprises--;
                    result++;
                }
                else if ((numSuprises > 0) && (!resLessThan1 && (num + res >= bestScore))) {
                    numSuprises--;
                    result++;
                }
            }
            in.nextLine();
            fOut.println(result);
        }
        fOut.flush();
    }
    
    
}

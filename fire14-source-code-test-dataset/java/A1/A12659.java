package googledancing;




/**
 *
 * @author Zvi Ehrman
 * @version 1 @date 14/04/2012
 *
 * Problem B. Dancing With the Googlers
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class GoogleDancing {
    
    static int numberOfCases = 0;
    private static FileWriter outFile;
    private static String answersFile = "../answerForB.out";
    private static String questionFile = "../q.in";
    private static File aFile = new File(answersFile);
    private static int caseNum = 0;
    private static int numberOfGooglers = 0;
    private static int numberOfS = 0;
    private static int theP = 0;

    public static void main(String[] args) throws IOException {
        outFile = new FileWriter(aFile);

        loadInput(questionFile);

    }

    public static void loadInput(String fileName) throws IOException {

        Scanner input;
        try {
            input = new Scanner(new File(fileName));
            while (input.hasNext()) {

                numberOfCases = input.nextInt();
                input.nextLine();
                
                for (int i = 0; i < numberOfCases; i++) {
                    numberOfGooglers = input.nextInt();
                    numberOfS = input.nextInt();
                    theP = input.nextInt();
                    
                    ArrayList<Integer> scores = new ArrayList<Integer>();
                    
                    for (int j = 0; j < numberOfGooglers; j++) {
                        scores.add(input.nextInt());
                    }

                    findAnswer(scores);

                }

            }
            input.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Oh no couldn't open the file? :(");
        }
    }

    static private void findAnswer(ArrayList<Integer> arr) throws IOException {
        
        caseNum++;
        int sum = 0;
        int usedS = 0;

        outFile.write("Case #" + caseNum + ": ");
        System.out.print("Case #" + caseNum + ": ");

        for (Integer integer : arr) {
                if(integer>=theP)
                {
                if(integer >= (theP*3)-2)
                    sum++;
                else if(usedS<numberOfS && (integer >=(theP*3)-4))
                {
                    sum++;
                    usedS++;
                }
                }
        }
        
        outFile.write("" + sum);
        System.out.print("" + sum);
            
        
        outFile.write("\n");
        System.out.println("\n");
        outFile.flush();

    }
    
   
}

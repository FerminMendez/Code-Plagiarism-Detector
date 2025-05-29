/*
 * Gabriel Shaw
 * 4/13/12
 */
import java.io.File;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Scanner;
public class DancingWithTheGooglers 
{
    public static void main(String[] args) throws IOException
    {
        File file = new File("B-small-attempt1.in");
        PrintWriter outfile = new PrintWriter("B-small.out");
        Scanner infile = new Scanner(file);
        int numberOfCases;
        int numberOfGooglers;
        int desiredScore;
        int numberOfSuprisingCases;
        int numberOfGoodScores;
        numberOfCases = infile.nextInt();
        infile.nextLine();
        
        for(int i=0 ; i<numberOfCases ; i++)
        {
            numberOfGooglers = infile.nextInt();
            numberOfSuprisingCases = infile.nextInt();
            desiredScore = infile.nextInt();
            numberOfGoodScores = 0;
            for(int j=0 ; j<numberOfGooglers ; j++)
            {
                int totalScore = infile.nextInt();
                System.out.println(j +" " +(totalScore - desiredScore - (desiredScore - 1) - (desiredScore - 1)));
                if(desiredScore <= 1)
                {
                    if(desiredScore == 1)
                    {
                        if(totalScore - desiredScore >= 0)
                        {
                            numberOfGoodScores++;
                        }//end of if(totalScore - desiredScore >= 0)
                    }//end of if(desiredScore == 1)
                    if(desiredScore == 0)
                    {
                        if(totalScore >= 0)
                        {
                            numberOfGoodScores++;
                        }
                    }
                }
                if(!(desiredScore <= 1) && (totalScore - desiredScore - (desiredScore - 1) - (desiredScore - 1)) >= 0)
                {
                    numberOfGoodScores++;
                }else
                {
                    if(!(desiredScore <= 1) && (numberOfSuprisingCases > 0) && (totalScore -desiredScore - (desiredScore - 2) - (desiredScore - 2)) >= 0)
                    {
                        numberOfGoodScores++;
                        numberOfSuprisingCases--;
                    }//end of if((numberOfSuprisingCases > 0) && (totalScore -desiredScore - 2*(desiredScore - 2)) >= 0)
                }//end of else
            }//end of for(int j=0 ; j<numberOfGooglers ; j++)
            outfile.println("Case #" +(i+1) +": " +numberOfGoodScores);
            if(infile.hasNext())
            {
                infile.nextLine();
            }
        }//end of for(int i=0 ; i<numberOfCases ; i++)
        outfile.close();
    }//end of public static void main(String[] args) throws IOException
}//end of public class DancingWithTheGooglers 

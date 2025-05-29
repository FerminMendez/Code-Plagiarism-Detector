
package gcj;
 
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

/**
 *
 * @author Mervin.Lavin
 */
public class Gcj
{

    public static void main
        (String[] args)
        throws Exception
    {
        doProb2( "B-small-attempt0.in", "output.txt" );
    }
    
    private static void doProb2
        ( String inputFileName, String outputFileName )
        throws Exception
    {
        File inputFile = new File( inputFileName );
        Scanner scanner = null;
        scanner = new Scanner( inputFile );
        File outputFile = new File( outputFileName );
        BufferedWriter output = new BufferedWriter( new FileWriter( outputFile ) );
        
        int contestants, surpriseScores, minBestScore;
        int totalScore, aveScore, passedContestants;
        int testCases = scanner.nextInt();
        for ( int caseNum = 1; caseNum <= testCases; caseNum++ )
        {
          contestants = scanner.nextInt();
          surpriseScores = scanner.nextInt();
          minBestScore = scanner.nextInt();
          passedContestants = 0;
          for ( int contestant = 0; contestant < contestants; contestant++ )
          {
            totalScore = scanner.nextInt();
            aveScore = totalScore / 3;
            switch ( totalScore % 3 )
            {
                case 0:
                    if ( aveScore >= minBestScore )
                    {
                        passedContestants++;
                    }
                    else if ( ( surpriseScores > 0 )
                        && ( ( aveScore + 1 ) >= minBestScore ) 
                        && ( ( aveScore + 1 ) <= totalScore ))
                    {
                        passedContestants++;
                        surpriseScores--;
                    }
                    break;
                case 1:
                    if ( ( aveScore + 1 ) >= minBestScore )
                    {
                        passedContestants++;
                    }
                    break;
                case 2:
                    if ( ( aveScore + 1 ) >= minBestScore )
                    {
                        passedContestants++;
                    }
                    else if ( ( surpriseScores > 0 )
                        && ( ( aveScore + 2 ) >= minBestScore )
                        && ( ( aveScore + 2 ) <= totalScore ) )
                    {
                        passedContestants++;
                        surpriseScores--;
                    }
                    break;
            }
          }          
          output.append( "Case #" + caseNum + ": " + passedContestants );
          output.newLine();
        }
        scanner.close();
        output.close();
    }
}

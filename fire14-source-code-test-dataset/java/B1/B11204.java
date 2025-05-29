
package gcj;
 
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
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
        doProb3( "C-small-attempt1.in", "output.txt" );
    }
    
    private static void doProb3
        ( String inputFileName, String outputFileName )
        throws Exception
    {
        File inputFile = new File( inputFileName );
        Scanner scanner = null;
        scanner = new Scanner( inputFile );
        File outputFile = new File( outputFileName );
        BufferedWriter output = new BufferedWriter( new FileWriter( outputFile ) );
        
        int a, b, otherPairs;
        HashMap<Integer,Integer> distinctPairs;
        int testCases = scanner.nextInt();
        for ( int caseNum = 1; caseNum <= testCases; caseNum++ )
        {
          a = scanner.nextInt();
          b = scanner.nextInt();
          distinctPairs = new HashMap<Integer,Integer>();
          otherPairs = 0;
          for ( int n = a; n < b; n++ )
          {
              String stringN = Integer.toString(n);
              if ( stringN.length() == 1 )
              {
                  continue;
              }
              for ( int index = 1; index < stringN.length(); index++ )
              {
                  String stringM = 
                      stringN.substring( index, stringN.length() ) 
                      + stringN.substring( 0, index );
                  int m = Integer.parseInt( stringM );
                  if ( ( !stringN.equals( stringM ) )
                      && ( n < m ) && ( m <= b ) )
                  {
                      if ( distinctPairs.containsKey( n ) && !distinctPairs.containsValue( m ) )
                      {
                          otherPairs++;
                      }
                      else 
                      {
                          distinctPairs.put( n, m );
                      }
                  }
              }
          }
          output.append( "Case #" + caseNum + ": " +  ( distinctPairs.size() + otherPairs ) );
          output.newLine();
        }
        scanner.close();
        output.close();
    }
}

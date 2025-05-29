package aao;

import java.io.*;
import java.util.regex.Pattern;

/**
 * @author aoboturov
 */
public class DansingWithGooglers {

    public LineNumberReader lineNumberReader;

    public DansingWithGooglers(final String inputFileName) throws Exception {
        lineNumberReader = new LineNumberReader(
                new BufferedReader(
                        new InputStreamReader(
                                getClass().getClassLoader().getResourceAsStream(inputFileName)
                        )
                ));
    }

    public int readNumberOfTestCases() throws Exception {
        return Integer.parseInt(lineNumberReader.readLine());
    }

    public void solve(final String outputFileName) throws Exception {
        final FileOutputStream fos = new FileOutputStream(new File(outputFileName));

        final int numberOfTestCases = readNumberOfTestCases();
        final Pattern pattern = Pattern.compile("[\\s]+");
        for ( int caseNumber = 1; caseNumber <= numberOfTestCases; caseNumber++) {
            // Init of counters.
            int guaranteedNumberOfGooglersHavingBestResult = 0;
            int holdOutNumberOfGooglersHavingBestResult = 0;
            // Init of base parameters.
            final String[] splitInput = pattern.split(lineNumberReader.readLine());
            final int numberOfGooglers = Integer.parseInt(splitInput[0]);
            final int numberOfSurprises = Integer.parseInt(splitInput[1]);
            final int requiredBestResult = Integer.parseInt(splitInput[2]);
            // Compute required values.
            for ( int googler = 0; googler < numberOfGooglers; googler++) {
                final int googlerScore = Integer.parseInt(splitInput[3 + googler]);
                // Filter evident cases:
                if ( googlerScore >= 3*requiredBestResult) {
                    guaranteedNumberOfGooglersHavingBestResult++;
                    continue;
                }
                if ( googlerScore <= (3*requiredBestResult - 5)) {
                    continue;
                }
                // case p=k,k,k
                if ( googlerScore == (3*requiredBestResult - 0)) {
                    guaranteedNumberOfGooglersHavingBestResult++;
                    continue;
                }
                // case p=k,k+1,k+1
                if ( googlerScore == (3*requiredBestResult - 1) && (googlerScore - 2) >= 0) {
                    guaranteedNumberOfGooglersHavingBestResult++;
                    continue;
                }
                // case p=k,k,k+1
                if ( googlerScore == (3*requiredBestResult - 2) && (googlerScore - 1) >= 0) {
                    guaranteedNumberOfGooglersHavingBestResult++;
                    continue;
                }
                // case p=k,k+1,k+2
                if ( googlerScore == (3*requiredBestResult - 3) && (googlerScore - 3) >= 0) {
                    holdOutNumberOfGooglersHavingBestResult++;
                    continue;
                }
                // case p=k,k+2,k+2
                if ( googlerScore == (3*requiredBestResult - 4) && (googlerScore - 2) >= 0) {
                    holdOutNumberOfGooglersHavingBestResult++;
                    continue;
                }
            }
            final StringBuilder sb = new StringBuilder("Case #").append(caseNumber).append(": ")
                    .append(guaranteedNumberOfGooglersHavingBestResult+Math.min(holdOutNumberOfGooglersHavingBestResult, numberOfSurprises))
                    .append("\n");
            System.out.print(sb.toString());
            fos.write(sb.toString().getBytes());
        }
    }


    public static void main(String args[]) throws Exception {
        new DansingWithGooglers("B-small-attempt0.in.txt").solve("output.xml");
    }
}

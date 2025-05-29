package com.google.codejam.googlers;

import java.util.List;

/**
 * Main class used for DancingWithGooglers.
 * @author Sushant
 */
public class DancingWithGooglers {
    /**
     * Main method from where application start execution.
     *
     * @param args String []
     */
    public static void main(final String[] args) {
        if (args.length != 1) {
            System.out.println("Problem with the command used for execution");
            System.out.println("Usage: java com.google.codejam.googlers.DancingWithGooglers <Path to input file>");
            System.exit(1);
        }

        final List<TestCase> testCases = InputReader.prepareTestCases(args[0]);
        if (testCases != null && testCases.size() != 0) {
            long startTime = System.currentTimeMillis();
            System.out.println("Test Cases execution start time " + startTime);
            for (TestCase testcase : testCases) {
                executeTestCase(testcase);
            }
            OutputRecorder.generateTestReport(testCases, args[0] + ".out");
            long endTime = System.currentTimeMillis();
            System.out.print("Test cases execution end time " + endTime);
            System.out.println("Total Execution Time " + (endTime - startTime) + " milliseconds");
        }

    }

    /**
     * Method to execute test cases.
     *
     * @param testcase TestCase
     */
    private static void executeTestCase(final TestCase testcase) {
        int bestResultCount = 0;
        final int noOfGooglers = testcase.getNoOfGooglers();
        int noSurpriseScores = testcase.getNoOfurprisingTriplets();
        final int bestResult = testcase.getBestResult();
        final int[] scores = testcase.getScores();
        for (int i = 0; i < noOfGooglers; i++) {
            int[] triplets = new int[3];
            int score = scores[i];
            if(score == 0) {
               triplets[0] = triplets[1] = triplets[2] = 0; 
            } else  if (score % 3 == 0) {
                int tempScore = score / 3;
                triplets[0] = tempScore;
                if (noSurpriseScores != 0 && (Math.abs(triplets[0] - bestResult) == 1 )) {
                    triplets[1] = tempScore + 1;
                    triplets[2] = tempScore - 1;
                    noSurpriseScores = noSurpriseScores - 1;
                } else {
                    triplets[1] = tempScore;
                    triplets[2] = tempScore;
                }
            } else {
                triplets[0] = score / 3;
                int remainingScore = score - triplets[0];
                triplets[1] = remainingScore / 2;
                triplets[2] = score - (triplets[0] + triplets[1]);
                if(noSurpriseScores != 0) {
                    if((triplets[1] != 10 && triplets[2] != 10)
                            && (Math.abs(triplets[2] - bestResult)== 1)) {
                        triplets[1] = triplets[1] + 1;
                        triplets[2] = triplets[2] - 1;
                        noSurpriseScores = noSurpriseScores - 1;
                    }
                }
            }
            boolean isBest = isBestTriplet(triplets, bestResult);
            if(isBest) {
                bestResultCount = bestResultCount + 1;
            }

        }
        testcase.setOutput(new TestResult(bestResultCount));
    }

    /**
     * Method to check whether given triplet is best or not.
     * @param triplets int []
     * @param bestResult int
     * @return boolean
     */
    private static boolean isBestTriplet(final int[] triplets, final int bestResult) {
        for(int i = 0; i < triplets.length; i++) {
            if(triplets[i] >= bestResult) {
                return true;
            }
        }
        return false;
    }
}

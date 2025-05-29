package com.google.codejam.googlers;

/**
 * Class to represent each test case.
 * It will hold details like test case no, input to be operated and TestResult.
 * @author Sushant Deshpande
 *
 */
public class TestCase {

    /**
     * Variable to hold value for test case number.
     */
    private int caseNo;

    /**
     * Variable to hold lower limit.
     */
    private int noOfGooglers;

    /**
     * Variable to hold upper limit.
     */
    private int noOfurprisingTriplets;

    /**
     * Variable to hold value of best result.
     */
    private int bestResult;

    /**
     * Array to hold googlers score.

     */
    private int [] scores;

    /**
     * Variable holding test case result.
     */
    private TestResult output;

    /**
     * Constructor for creating TestCase with case no.
     * @param caseNo int
     * @param noOfGooglers int
     * @param surprisingTriplets int
     */
    public TestCase(final int caseNo, final int noOfGooglers, final int surprisingTriplets,
                    final int bestResult, final int [] scores) {
        this.caseNo = caseNo;
        this.noOfGooglers = noOfGooglers;
        this.noOfurprisingTriplets = surprisingTriplets;
        this.bestResult = bestResult;
        this.scores = scores;
    }

    /**
     * Settter method for TestResult.
     * @param output TestResult
     */
    public final void setOutput(final TestResult output) {
        this.output = output;
    }

    public final int getNoOfurprisingTriplets() {
        return noOfurprisingTriplets;
    }

    public final int getNoOfGooglers() {
        return noOfGooglers;
    }

    /**
     * Getter method for best result.
     * @return int
     */
    public final int getBestResult() {
        return bestResult;
    }

    /**
     * Method for getting scores.
     * @return int []
     */
    public final int[] getScores() {
        return scores;
    }

    /**
     * Method to format the test output for printing in the report.
     * @return String formatted output for the given input.
     */
    public final String printTestResult() {
        StringBuilder resultBuilder = new StringBuilder("Case #");
        resultBuilder.append(caseNo).append(": ");
        resultBuilder.append(output.getTestOutput()).append("\n");
        return resultBuilder.toString();
    }
}
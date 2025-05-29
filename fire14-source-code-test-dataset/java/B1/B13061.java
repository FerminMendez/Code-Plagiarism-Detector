package com.google.codejam.recycle;

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
    private int low;

    /**
     * Variable to hold upper limit.
     */
    private int high;

    /**
     * Variable holding test case result.
     */
    private TestResult output;

    /**
     * Constructor for creating TestCase with case no.
     * @param caseNo int
     * @param low int
     * @param high int
     */
    public TestCase(final int caseNo, final int low, final int high) {
        this.caseNo = caseNo;
        this.low = low;
        this.high = high;
    }

    /**
     * Settter method for TestResult.
     * @param output TestResult
     */
    public final void setOutput(final TestResult output) {
        this.output = output;
    }

    public int getHigh() {
        return high;
    }

    public int getLow() {
        return low;
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
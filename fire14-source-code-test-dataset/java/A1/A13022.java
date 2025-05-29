package com.google.codejam.googlers;

/**
 * Class to hold the result of given test case.
 * @author Sushant Deshpande
 */
public class TestResult {

    /**
     * variable to represent testOutput.
     */
    private int testOutput;


    /**
     * Constructor to create TestResult with testOutput.
     * @param testOutput   String
     */
    public TestResult(final int testOutput) {
        this.testOutput = testOutput;
    }

    /**
     * Getter method for test output.
     * @return String
     */
    public  final int getTestOutput() {
        return testOutput;
    }

}
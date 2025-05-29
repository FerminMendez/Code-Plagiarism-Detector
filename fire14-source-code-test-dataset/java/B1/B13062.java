package com.google.codejam.recycle;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sushant
 * Date: 14 Apr, 2012
 * Time: 11:13:34 AM
 * To change this template use File | Settings | File Templates.
 */
public class RecycledNumbers {
    /**
     * Main method from where application start execution.
     *
     * @param args String []
     */
    public static void main(final String[] args) {
        if (args.length != 1)  {
            System.out.println("Problem with the command used for execution");
            System.out.println("Usage: java com.google.codejam.googlerese.RecycledNmbers <Path to input file>");
            System.exit(1);
        }

        final List<TestCase> testCases = InputReader.prepareTestCases(args[0]);
        if (testCases != null && testCases.size() != 0)  {
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
     * @param testcase     TestCase
     */
    private static void executeTestCase(final TestCase testcase) {
        int recycleNumberCount = 0;
        final int low = testcase.getLow();
        final int high = testcase.getHigh();
        final int length = Integer.toString(low).length();
        for(int i = low; i <= high; i++) {
            int previoudNumber = 0;
            for(int j = 1; j < length; j++) {
                int divisor = getDivisor(length - j);
                int mod = i % divisor;
                int result = i / divisor;
                int recycleNumber = Integer.parseInt("" + mod + result);
                if(previoudNumber != recycleNumber && recycleNumber > i && recycleNumber <= high) {
                      previoudNumber = recycleNumber;
                    recycleNumberCount =  recycleNumberCount + 1;
                }
            }
        }
        testcase.setOutput(new TestResult(recycleNumberCount));
    }

    private static int getDivisor(int noOfZeros) {
        StringBuilder builder = new StringBuilder().append(1);
        for(int i = 0; i < noOfZeros; i++) {
            builder.append(0);
        }
        return Integer.parseInt(builder.toString());
    }
}



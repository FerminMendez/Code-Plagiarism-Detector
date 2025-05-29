package com.google.codejam.recycle;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.LinkedList;
import java.util.List;


/**
 * Class to read input file and prepare list of test cases.
 * @author Sushant Deshpande
 */
public class InputReader {
    /**
     * Method for preparing List of Test Cases.
     * @param inputFilePath String
     * @return List<TestCase>
     */
    public static List<TestCase> prepareTestCases(final String inputFilePath)  {
        final List<TestCase> testCases = new LinkedList<TestCase>();
        LineNumberReader lineReader = null;
        try {
            lineReader = new LineNumberReader(new FileReader(inputFilePath));
            final String line = lineReader.readLine();
            final int noOfTCs = Integer.parseInt(line);
            for(int i = 0; i < noOfTCs; i++) {
                String [] inputLine = lineReader.readLine().split(" ");
                int low = Integer.parseInt(inputLine[0]);
                int high = Integer.parseInt(inputLine[1]);
                TestCase testCase = new TestCase(i + 1, low, high);
                testCases.add(testCase);
            }
        } catch(IOException ie) {
              System.out.println("Problem occured while reading input file. " + ie.getMessage());
        } finally {
            if(lineReader != null) {
                try {
                    lineReader.close();
                } catch(IOException ie) {
                    System.out.println("Some problem occured while closing input file reader " + ie.getMessage() );
                }
            }
        }
        return testCases;
    }
}
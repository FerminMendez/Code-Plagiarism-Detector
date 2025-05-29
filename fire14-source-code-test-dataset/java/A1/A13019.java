package com.google.codejam.googlers;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.Arrays;
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
                final String [] inputLine = lineReader.readLine().split(" ");
                final int noOfGooglers = Integer.parseInt(inputLine[0]);
                final int surprisingTriplets = Integer.parseInt(inputLine[1]);
                final int bestScore = Integer.parseInt(inputLine[2]);
                final String [] scoreArray =  Arrays.copyOfRange(inputLine, 3, inputLine.length);
                final int [] scores = populateScores(scoreArray);
                TestCase testCase = new TestCase(i + 1, noOfGooglers, surprisingTriplets, bestScore, scores);
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

    /**
     * Method to populate score integer array from scores read from the input file.
     * @param scoreArray String[] scoreArray
     * @return int [] integer array containing scores.
     */
    private static int [] populateScores(String[] scoreArray) {
       final int [] scores = new int[scoreArray.length];
       for(int i = 0; i < scoreArray.length; i++) {
           scores[i] = Integer.parseInt(scoreArray[i]);           
       }
       return scores;
    }
}
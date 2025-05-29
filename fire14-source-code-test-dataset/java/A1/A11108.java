/**
 * $Id$
 * $Author$
 * $Date$
 * Copyright (c) 2011 Amazon.com, Inc.  All rights reserved.
 *
 * Owner: softlines-amazon-dev@
 */

package com.coding.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author madhava
 * 
 */
public class B {

    private static final int MAX_SCORE = 10;
    private static final int MIN_SCORE = 0;
    private static final int MAX_DIFFERENCE = 2;
    private static int[][] dp = new int[100][101];
    static {
    }

    /**
     * @param args
     * @throws IOException
     * @throws NumberFormatException
     */
    public static void main(final String[] args) throws NumberFormatException, IOException {

        String inputFileName = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
        String outputFileName = inputFileName + "_output";
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));
        int noOfTestCases = getInteger(reader);
        int loopCounter = 1;
        while (noOfTestCases-- != 0) {
            initialize();
            List<Integer> input = getArray(reader);
            int noOfGooglers = input.get(0);
            int noOfSurprisingTriplets = input.get(1);
            int bestResult = input.get(2);
            List<Integer> scores = new ArrayList<Integer>(noOfGooglers);
            for (int i = 0; i < noOfGooglers; i++) {
                scores.add(input.get(i + 3));
            }

            int result = maxNoOfGooglers(scores, 0, noOfSurprisingTriplets, bestResult);
            writer.write("Case #" + loopCounter + ": " + result + "\n");
            System.out.println("Case #" + loopCounter + ": " + result);
            loopCounter++;
        }
        writer.close();
    }

    /**
    																											   * 
    																											   */
    private static void initialize() {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }

        }

    }

    /**
     * @param scores
     * @param index
     * @param noOfSurprisingTriplets
     * @param bestResult
     * @return
     */
    private static int maxNoOfGooglers(final List<Integer> scores, final int index,
            final int noOfSurprisingTriplets, final int bestResult) {

        if (noOfSurprisingTriplets < 0) {
            return -(scores.size() + 1);
        }
        if (index == scores.size()) {
            return noOfSurprisingTriplets == 0 ? 0 : -(scores.size() + 1);
        }
        int result = dp[index][noOfSurprisingTriplets];
        if (result != -1) {
            return result;
        } else {
            result = 0;
            for (int maxScore = MAX_SCORE; maxScore >= MIN_SCORE; maxScore--) {

                for (int i = 0; i <= MAX_DIFFERENCE; i++) {
                    int secondMaxScore = maxScore - i;
                    int thirdMaxScore = scores.get(index) - secondMaxScore - maxScore;
                    if ((thirdMaxScore > secondMaxScore) || (thirdMaxScore < 0)
                            || (maxScore - thirdMaxScore > MAX_DIFFERENCE)) {
                        continue;
                    }
                    result = Math.max(
                            maxNoOfGooglers(scores, index + 1,
                                    noOfSurprisingTriplets - isTripletSuprising(maxScore, thirdMaxScore),
                                    bestResult) + toInteger(maxScore >= bestResult), result);
                }
            }
            dp[index][noOfSurprisingTriplets] = result;
            return result;
        }
    }

    /**
     * @param b
     * @return
     */
    private static int toInteger(final boolean b) {
        if (b) {
            return 1;
        } else {
            return 0;
        }

    }

    /**
     * @param maxScore
     * @param thirdMaxScore
     * @return
     */
    private static Integer isTripletSuprising(final int maxScore, final int thirdMaxScore) {
        return toInteger(maxScore - thirdMaxScore == MAX_DIFFERENCE);

    }

    /**
     * @param reader
     * @return
     * @throws IOException
     * @throws NumberFormatException
     */
    private static int getInteger(final BufferedReader reader) throws NumberFormatException, IOException {
        return Integer.parseInt(reader.readLine());
    }

    private static List<Integer> getArray(final BufferedReader reader) throws IOException {
        String[] line = reader.readLine().split(" ");
        List<Integer> numbers = new ArrayList<Integer>();
        for (String input : line) {
            numbers.add(Integer.parseInt(input));
        }
        return numbers;
    }
}

package com.googlecode.contest.dancing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DancingGooglers {

    public static void main(String[] args) throws Exception {
        File outputFile = new File("dancing_googlers_output.txt");
        FileOutputStream fos = new FileOutputStream(outputFile);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fos));
        FileInputStream fis = new FileInputStream(args[0]);
        final String preface = "Case #";
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fis));
        String numberOfTestCasesString = bufferedReader.readLine();
        int numberOfTestCases = Integer.parseInt(numberOfTestCasesString);
        for (int i = 1; i <= numberOfTestCases; i++) {
            DancingTestCase testCase = parseString(i, bufferedReader.readLine());
            solveTestCase(testCase);
            System.out.println(preface + i + ": " + testCase.getAnswer());
            bufferedWriter.write(preface + i + ": " + testCase.getAnswer() );
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }

    }

    public static void solveTestCase(DancingTestCase testCase) {
        int possibleGooglers = 0;
        int target = testCase.scoreToBeat;
        int usedSurprises = 0;

        //short circuit for the easiest case
        if (target == 0) {
            testCase.setAnswer(testCase.numberOfDancers);
            return;
        }

        for (String score : testCase.totalScores) {
            int tripletScore = Integer.parseInt(score);
            int quotient = tripletScore/3;
            int modulus = tripletScore%3;
            if (quotient >= testCase.scoreToBeat) {
                System.out.println("1 processing score: " + score);
                possibleGooglers++;
            } else if (tripletScore ==  0 && testCase.scoreToBeat> 0) {
                //continue;
                System.out.println("2 processing score: " + score);
            } else if (quotient + 2 < testCase.scoreToBeat) {
                //continue;
                System.out.println("3 processing score: " + score);
            } else if (quotient + 2 == testCase.scoreToBeat && modulus == 2 && usedSurprises < testCase.surprises) {
                possibleGooglers++;
                usedSurprises++;
                System.out.println("3A processing score: " + score);
            } else if (quotient + 2 == testCase.scoreToBeat ) {
                //continue
                System.out.println("4 processing score: " + score);
            } else if (modulus > 0) {
                possibleGooglers++;
                System.out.println("5 processing score: " + score);
            } else if (modulus == 0 && usedSurprises < testCase.surprises) {
                possibleGooglers++;
                usedSurprises++;
                System.out.println("6 processing score: " + score);
            } else if (modulus == 0 && usedSurprises >= testCase.surprises) {
               //continue
                System.out.println("7 processing score: " + score);
            } else {
                throw new IllegalArgumentException("couldn't handle score: " + score);
            }
        }

        testCase.setAnswer(possibleGooglers);
    }

    public static DancingTestCase parseString(final int testCaseNumber, final String s) {
        StringTokenizer tokenizer = new StringTokenizer(s);
        String dancerString = tokenizer.nextToken();
        int numberOfDancers = Integer.parseInt(dancerString);
        String surpriseString = tokenizer.nextToken();
        int surprises = Integer.parseInt(surpriseString);
        String scoreString = tokenizer.nextToken();
        int scoreToBeat = Integer.parseInt(scoreString);
        ArrayList<String> scores = new ArrayList<String>(numberOfDancers);
        while (tokenizer.hasMoreTokens()) {
            scores.add(tokenizer.nextToken());
        }
        return new DancingTestCase(testCaseNumber, numberOfDancers, surprises, scoreToBeat, scores );
    }


    static class DancingTestCase implements Comparable {
        final int testCaseNumber;
        final int numberOfDancers;
        final int surprises;
        final int scoreToBeat;
        final List<String> totalScores;
        private int answer;

        public DancingTestCase(int testCaseNumber, int numberOfDancers, int surprises, int scoreToBeat, List<String> totalScores) {
            this.testCaseNumber = testCaseNumber;
            this.numberOfDancers = numberOfDancers;
            this.surprises = surprises;
            this.scoreToBeat = scoreToBeat;

            this.totalScores = totalScores;
        }

        public int compareTo(Object o) {
            return 0;
        }

        public int getAnswer() {
            return answer;
        }

        public void setAnswer(int answer) {
            this.answer = answer;
        }
    }
}

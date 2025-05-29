package com.codegem.zaidansari;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Pair {

    int n, m;

    public Pair(int n, int m) {
        super();
        this.n = n;
        this.m = m;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * (m + n);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Pair other = (Pair) obj;
        if ((m == other.m && n == other.n) || (m == other.n && n == other.m)) return true;
        return false;
    }

    @Override
    public String toString() {
        return "Pair [n=" + n + ", m=" + m + "]";
    }
}

public class ProblemC {

    Set<Pair> pairs = new HashSet<Pair>();
    int startRange, endRange;

    private boolean isInRange(int value) {
        return value >= startRange && value <= endRange;
    }

    private int processRange() {
        for (int value = startRange; value <= endRange; value++) {
            List<Integer> possiblePairValues = getPossiblePairValue(value);
            for (int pairValue : possiblePairValues) {
                pairs.add(new Pair(value, pairValue));
            }
        }
        return pairs.size();
    }

    private List<Integer> getPossiblePairValue(int value) {
        String valueStr = String.valueOf(value);
        int valueStrLength = valueStr.length();
        List<Integer> possiblePairs = new ArrayList<Integer>();
        int pairValue;
        for (int index = 0; index < valueStrLength; index++) {
            String pairValueStr = valueStr.substring(valueStrLength - index - 1) + valueStr.substring(0, (valueStrLength - index - 1));
            if (pairValueStr.charAt(0) != '0') {
                pairValue = Integer.parseInt(pairValueStr);
                if ((pairValue != value) && (isInRange(pairValue))) {
                    possiblePairs.add(pairValue);
                }
            }
        }
        return possiblePairs;
    }

    public ProblemC(int startRange, int endRange) {
        super();
        this.startRange = startRange;
        this.endRange = endRange;
    }

    public static void main(String[] args) {

        File file = new File("/Users/zaansari/Desktop/CodeGem2012/InputFiles/ProblemC-Small.txt");
        List<String> inputData = CodeGemUtil.getInputValues(file);
        int noOfInputs = Integer.parseInt(inputData.get(0));
        inputData.remove(0);

        List<String> outputData = new ArrayList<String>();
        for (int index = 0; index < noOfInputs; index++) {
            String[] inputArray = inputData.get(index).split(" ");
            outputData.add("" + new ProblemC(Integer.parseInt(inputArray[0]), Integer.parseInt(inputArray[1])).processRange());
        }
        boolean createdOutputFile = CodeGemUtil.createOutputFile(outputData, "ProblemC-Small-Output.txt");
        if (createdOutputFile) {
            System.out.println("Successfully created output file");
        } else {
            System.out.println("Failed to create output file");
        }
    }
}

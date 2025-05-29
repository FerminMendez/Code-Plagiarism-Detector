package qual2012.C;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;

public class RecycledNumbers {

    //private static String inputFileName = "sample.in";
    private static String inputFileName = "C-small-attempt0.in";
    // private static String inputFileName = "large.in";
    //private static String outputFileName = "sample.out";
    private static String outputFileName = "C-small.out";
    // private static String outputFileName = "large.out";

    private static int nbrOfTests;
    private static String inputFolder = "input/";
    private static String outputFolder = "output/";

    /**
     * @param args
     */
    public static void main(String[] args) {

        RecycledNumbers mainDefault = new RecycledNumbers();

        MyTestCase[] input = mainDefault.readInputCodeJam(inputFileName);
        StringBuffer output = mainDefault.createOutput(input);
        printToFile(output, outputFileName);
    }

    public MyTestCase[] readInputCodeJam(String fileName) {
        MyTestCase[] testCases = null;
        File file = new File(inputFolder + fileName);
        try {
            Scanner scanner = new Scanner(file);

            nbrOfTests = Integer.valueOf(scanner.nextLine());
            testCases = new MyTestCase[nbrOfTests];

            for (int i = 0; i < nbrOfTests; i++) {
                String tmp = scanner.nextLine();

                String[] testCaseInput = tmp.split(" ");
                MyTestCase obj = new MyTestCase(testCaseInput);

                testCases[i] = obj;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return testCases;
    }

    public StringBuffer createOutput(MyTestCase[] myTestCases) {
        StringBuffer buffer = new StringBuffer();
        int count = 1;
        for (int i = 0; i < nbrOfTests; i++) {
            buffer.append("Case #" + count++ + ": ");

            MyTestCase myTestCase = myTestCases[i];
            buffer.append(myTestCase.getAnswer());

            buffer.append("\n");
        }
        return buffer;
    }

    public static void printToFile(StringBuffer output, String fileName) {
        try {
            FileWriter fstream = new FileWriter(outputFolder + fileName);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write(output.toString());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    class MyTestCase {
        private String answer;
        private BigInteger second;
        private BigInteger first;

        public MyTestCase(String[] input) {
            first = new BigInteger(input[0]);
            second = new BigInteger(input[1]);
            int sum = 0;
            BigInteger value = first;
            while (value.compareTo(second) <= 0) {
                sum += solve(value);
                value = value.add(BigInteger.ONE);
            }
            answer = String.valueOf(sum);
        }

        public String getAnswer() {
            return answer;
        }

        private int solve(BigInteger value) {
            HashSet<String> uniquePairs = new HashSet<String>();
            String inputValue = value.toString();
            if (inputValue.length() <= 1) {
                return 0;
            }
            for (int i = 1; i < inputValue.length(); i++) {
                String tmp = inputValue;
                int split = i;
                String firstPart = tmp.substring(0, split);
                String secondPart = tmp.substring(split);
                String connected = secondPart + firstPart;
                if (inputValue.compareTo(connected) < 0) {
                    BigInteger tmp2 = new BigInteger(connected);
                    if (tmp2.compareTo(second) <= 0) {
                        // System.out.println(inputValue + " => " + connected);
                        uniquePairs.add(inputValue + connected);
                    }
                }
            }
            return uniquePairs.size();
        }
    }
}

package qual2012.B;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainDefault2 {

    //private static String inputFileName = "sample.in";
    private static String inputFileName = "B-small-attempt1.in";
    // private static String inputFileName = "large.in";
    //private static String outputFileName = "sample.out";
    private static String outputFileName = "B-small-1.out";
    // private static String outputFileName = "large.out";

    private static int nbrOfTests;
    private static String inputFolder = "input/";
    private static String outputFolder = "output/";

    /**
     * @param args
     */
    public static void main(String[] args) {

        MainDefault2 mainDefault = new MainDefault2();

        MyTestCase[] input = mainDefault.readInputCodeJam(inputFileName);
        StringBuffer output = mainDefault.createOutput(input);
        printToFile(output, outputFileName);
    }

    public MainDefault2() {
        // TODO if anything should be prepared for all testcases
    }

    public MyTestCase[] readInputCodeJam(String fileName) {
        MyTestCase[] testCases = null;
        File file = new File(inputFolder + fileName);
        try {
            Scanner scanner = new Scanner(file);

            nbrOfTests = Integer.valueOf(scanner.nextLine());
            testCases = new MyTestCase[nbrOfTests];

            for (int i = 0; i < nbrOfTests; i++) {
                // TODO line(s) / testcase
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
        private int nbrOfGooglers;
        private int nbrOfSuprises;
        private int bestResult;
        private int[] totalPoints;

        public MyTestCase(String[] input) {
            nbrOfGooglers = Integer.valueOf(input[0]);
            nbrOfSuprises = Integer.valueOf(input[1]);
            bestResult = Integer.valueOf(input[2]);

            totalPoints = new int[nbrOfGooglers];
            for (int i = 0; i < nbrOfGooglers; i++) {
                totalPoints[i] = Integer.valueOf(input[3 + i]);
            }
            if(bestResult == 0) {
                answer = String.valueOf(nbrOfGooglers);
            } else if(bestResult == 1) {
                int atLeastCount = 0;
                for(int oneTot : totalPoints) {
                    if(oneTot != 0) {
                        atLeastCount++;
                    }
                }
                answer = String.valueOf(atLeastCount);
            } else {
                solve();
            }
        }

        private void solve() {
            //System.out.println("nbrOf: " + nbrOfGooglers + ", suprises: " + nbrOfSuprises + ", bestResult: " + bestResult);
            int count = 0;
            for(int oneTot : totalPoints) {
                //System.out.println("oneTot: " + oneTot);
                int limitNbr = 3*bestResult;
                int inclNbr = limitNbr - 2;
                int supNbr = limitNbr - 4;
                if(oneTot >= inclNbr) {
                    count++;
                } else if (oneTot >= supNbr) {
                    if(nbrOfSuprises > 0) {
                        nbrOfSuprises--;
                        count++;
                    }
                }
            }
            answer = String.valueOf(count);
        }
        
        private void solve2() {
            int count = 0;
            for (int tot : totalPoints) {
                int avgNbr = tot / 3;
                //System.out.println("tot: " + tot + " avg: " + avgNbr + " bestResult: " + bestResult);
                if (avgNbr == 0) {
                    if(bestResult <= tot) {
                        //System.out.println("small");
                        count++;
                    }
                } else if (avgNbr >= bestResult) {
                    count++;
                    //System.out.println(count);
                } else if (avgNbr + 1 >= bestResult) {
                    int oneExtra = tot % 3;
                    if (oneExtra > 0) {
                        count++;
                        //System.out.println("one: " + count);
                    } else {
                        if (nbrOfSuprises > 0) {
                            nbrOfSuprises--;
                            count++;
                            //System.out.println("two: " + count);
                        }
                    }
                } else if (avgNbr + 2 >= bestResult) {
                    int twoExtra = tot % 3;
                    if (twoExtra == 2 && nbrOfSuprises > 0) {
                        nbrOfSuprises--;
                        count++;
                        //System.out.println("three: " + count);
                    }
                }
            }
            System.out.println("finish: " + count);
            System.out.println("nbrOfSuprises left: " + nbrOfSuprises);
            answer = String.valueOf(count);
        }

        public String getAnswer() {
            return answer;
        }
    }
}

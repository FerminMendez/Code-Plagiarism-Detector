package com.google.codejam.recycle;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 *
 * Class to generate Test Report.
 * @author Sushant Deshpande
 */
public class OutputRecorder {

    /**
     * Method for generating Test Report.
     * @param testCases List<TestCase> list of test cases for report is to be generated.
     * @param outputFile String output file for writing TestReport.
     */
    public static void generateTestReport(final List<TestCase> testCases, final  String outputFile) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new PrintWriter(outputFile));
            for(TestCase testCase : testCases) {
                writer.write(testCase.printTestResult());
                writer.flush();
            }
            writer.flush();
        } catch(IOException ie) {
            System.out.println("Some error occured while generating test report " + ie.getMessage());
            System.out.println("Printing result to standard output");
            for(TestCase testCase : testCases) {
                System.out.println(testCase.printTestResult());
            }
        } finally {
            if(writer != null) {
                try {
                    writer.close();
                } catch(IOException ie) {
                    System.out.println("Some error occured while closing output stream");
                }
            }
        }
    }

}
package codejam.dancing;

import codejam.is.TestRunner;

/**
 * Created with IntelliJ IDEA.
 * User: ofer
 * Date: 4/14/12
 * Time: 4:54 AM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    private static final String path = "C:\\Users\\his\\Desktop\\codejam\\files\\";
    private static final String filePrefix = "test";

    private static final String inputFile = path + filePrefix + ".in";
    private static final String outputFile = path + filePrefix + ".out";


    public static void main(String[] args){


        TestRunner testRunner = new TestRunner();
        testRunner.runTests(inputFile, outputFile, DancingTest.class);

    }
}

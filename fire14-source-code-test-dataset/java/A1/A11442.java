package com.google.codejam;

import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

import org.apache.commons.lang.ArrayUtils;

// Libraries used: http://commons.apache.org/lang/, http://commons.apache.org/collections/
public class B {

    private static boolean debugAllowed = true;
    private static Scanner scanner;
    private static int numberOfCases;
    private static int N;
    private static int[] t;
    private static long S;
    private static long p;

    private static void parseCase(int caseNumber) {
        debug("Case #" + caseNumber);

        N = scanner.nextInt();
        debug("    N: " + N);
        S = scanner.nextLong();
        debug("    S: " + S);
        p = scanner.nextLong();
        debug("    p: " + p);

        t = new int[N];
        for (int i = 0; i < N; i++) {
            t[i] = scanner.nextInt();
        }
        debug("    t: " + Arrays.asList(ArrayUtils.toObject(t)));
    }

    private static String solveCase() {
        int solution = 0;
        for (int i = 0; i < N; i++) {
            int base = (t[i] - 1) / 3;
            int remainder = (t[i] - 1) % 3 + 1;
            debug("    t[i]: " + t[i] + "\t base: " + base + "\t remainder: " + remainder);
            if (base * 3 + remainder != t[i]) {
                throw new RuntimeException();
            }

            if (remainder == 0) {
                if (base >= p) {
                    solution++;
                }
                debug("        " + base + ", " + base + ", " + base + "    (a)");
            } else if (remainder == 1) {
                if (base + 1 >= p) {
                    solution++;
                }
                debug("        " + base + ", " + base + ", " + (base + 1) + "    (b)");
            } else {
                if (base + 1 >= p) {
                    solution++;
                    if (remainder == 2) {
                        debug("        " + base + ", " + (base + 1) + ", " + (base + 1) + "    (c2)");
                    } else {
                        debug("        " + (base + 1) + ", " + (base + 1) + ", " + (base + 1) + "    (c3)");
                    }
                } else {
                    if (base + 2 >= p & S > 0) {
                        solution++;
                        S--;
                        if (remainder == 2) {
                            debug("        " + base + ", " + base + ", " + (base + 2) + "    (d2)");
                        } else {
                            debug("        " + base + ", " + (base + 1) + ", " + (base + 2) + "    (d2)");
                        }
                    } else {
                        if (remainder == 2) {
                            debug("        " + base + ", " + (base + 1) + ", " + (base + 1) + "    (e2)");
                        } else {
                            debug("        " + (base + 1) + ", " + (base + 1) + ", " + (base + 1) + "    (e3)");
                        }
                    }
                }
            }
        }

        return String.valueOf(solution);
    }

    public static void main(String[] args) throws Exception {
        File inputFile = new File(args[0]);
        String outputFileName = inputFile.getParent() + File.separator + inputFile.getName().replace(".in", ".out");
        PrintStream out = new PrintStream(outputFileName);

        scanner = new Scanner(inputFile);
        numberOfCases = Integer.valueOf(scanner.nextLine());
        debug(numberOfCases + " cases");

        long startTime = System.currentTimeMillis();
        for (int caseNumber = 1; caseNumber <= numberOfCases; caseNumber++) {
            parseCase(caseNumber);

            String solution = solveCase();

            String resultString = "Case #" + caseNumber + ": " + solution;
            out.println(resultString);
            debug("Solution for " + resultString);

            debug("");
        }
        long time = System.currentTimeMillis() - startTime;
        debug("Time: " + time + " ms (" + time / numberOfCases + " ms / case)");

        out.close();
    }

    private static void debug(String text) {
        if (debugAllowed) {
            System.out.println(text);
        }
    }
}

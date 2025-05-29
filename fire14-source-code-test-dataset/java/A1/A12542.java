package fr.lcwi.googlecodejam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * For Google Code Jam 2012
 */
public class ProblemB {

    private static Scanner scanner;
    private static int nbCases;

    public static void main(String[] args) throws IOException {
        String filename = args[0];
        scanner = new Scanner(ProblemB.class.getClassLoader().getResourceAsStream(filename + ".in"));

        nbCases = Integer.valueOf(scanner.nextLine());

        try (BufferedWriter bWriter = new BufferedWriter(new FileWriter(filename + ".out"))) {
            for (int i = 1; i <= nbCases; i++) {
                resolveCase(i, bWriter);
            }
        }
    }

    private static void resolveCase(int caseNb, BufferedWriter bWriter) throws IOException {
        int nbGooglers = scanner.nextInt();
        int nbSurprises = scanner.nextInt();
        int minScore = scanner.nextInt();

        int result = 0;
        if (minScore == 0) {
            result = nbGooglers;
            for (int i = 0; i < nbGooglers; i++) {
                scanner.nextInt();
            }

        } else {
            for (int i = 0; i < nbGooglers; i++) {
                int totalScore = scanner.nextInt();

                if (totalScore > 0) {
                    if (totalScore >= minScore * 3 - 2) {
                        result++;
                    } else {
                        if (totalScore >= minScore * 3 - 4 && nbSurprises > 0) {
                            result++;
                            nbSurprises--;
                        }
                    }
                }
            }

        }

        bWriter.write("Case #" + caseNb + ": " + result);
        if (caseNb < nbCases) {
            bWriter.newLine();
        }
    }
}

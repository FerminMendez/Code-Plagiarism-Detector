package fr.lcwi.googlecodejam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * For Google Code Jam 2012
 */
public class ProblemC {

    private static Scanner scanner;
    private static int nbCases;

    public static void main(String[] args) throws IOException {
        String filename = args[0];
        scanner = new Scanner(ProblemC.class.getClassLoader().getResourceAsStream(filename + ".in"));

        nbCases = Integer.valueOf(scanner.nextLine());

        BufferedWriter bWriter = null;
        try {
            bWriter = new BufferedWriter(new FileWriter(filename + ".out"));
            for (int i = 1; i <= nbCases; i++) {
                resolveCase(i, bWriter);
            }
        } finally {
            if (bWriter != null) {
                bWriter.close();
            }
        }
    }

    private static void resolveCase(int caseNb, BufferedWriter bWriter) throws IOException {
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int result = 0;

        for (int n = A; n < B; n++) {
            Set<Integer> ms = new HashSet<Integer>();
            int length = (int) Math.floor(Math.log10(n)) + 1;

            if (length > 1) {
                for (int i = 0; i < length - 1; i++) {
                    int puissanceA = (int) Math.pow(10, length - i - 1);
                    int puissanceB = (int) Math.pow(10, i + 1);
                    int digitsToMove = n % puissanceB;
                    int ma = digitsToMove * puissanceA;
                    if (ma >= puissanceB) {
                        int mb = n / puissanceB;
                        int m = ma + mb;
                        if (n < m && m < B+1 && !ms.contains(m)) {
                            result++;
                            ms.add(m);
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

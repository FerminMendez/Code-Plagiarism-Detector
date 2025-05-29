package com.codejam.y2012.qual;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class B {

    public static void main(String[] args) throws Exception {
        String file = "src/com/codejam/y2012/qual/B-small-attempt0.in";
        Scanner scanner = new Scanner(new FileReader(file));
        StringBuilder sb = new StringBuilder();
        int caseCount = scanner.nextInt();
        scanner.nextLine();
        for (int caseNum = 1; caseNum <= caseCount; caseNum++) {
            sb.append("Case #").append(caseNum).append(": ");
            solve(scanner, sb);
            sb.append("\n");
        }

        PrintWriter pw = new PrintWriter(new FileWriter(file.replace("in", "out")));
        String output = sb.toString();
        System.err.println(output);
        pw.write(output);
        pw.flush();
        pw.close();
        scanner.close();
    }

    private static void solve(Scanner sc, StringBuilder sb) {
        int count = sc.nextInt();
        int surprise = sc.nextInt();
        int p = sc.nextInt();
        int answer = 0;
        for (int i = 0; i < count; i++) {
            int goog = sc.nextInt();
            if (p == 0) {
                answer++;
                continue;
            }
            int min = goog / 3;
            int rest = goog % 3;
            if (min >= p) {
                answer++;
                continue;
            } else if (goog == 0) {
                continue;
            } else if (min + 1 == p && rest > 0) {
                answer++;
                continue;
            } else if (min + 1 == p && rest == 0 && surprise > 0) {
                surprise--;
                answer++;
                continue;
            } else if (min + 2 == p && rest == 2 && surprise > 0) {
                surprise--;
                answer++;
            }
        }
        sb.append(answer);
    }
}

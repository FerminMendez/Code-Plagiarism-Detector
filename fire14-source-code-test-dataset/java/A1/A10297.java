package com.palantir;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Googlers {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numTests = s.nextInt();
        for (int i = 1; i <= numTests; ++i) {
            System.out.println("Case #" + i + ": " + solve(s));
        }
    }

    private static int solve(Scanner s) {
        int numGooglers = s.nextInt();
        int numSurprising = s.nextInt();
        int maxScore = s.nextInt();
        List<Integer> scores = new ArrayList<Integer>();
        for (int i = 0; i < numGooglers; ++i) scores.add(s.nextInt());
        int lowestGoodScore = (maxScore * 3) - 2;
        int lowestSurpriseScore = (maxScore * 3) - 4;
        if (maxScore == 0) {
            lowestGoodScore = 0;
            lowestSurpriseScore = 0;
        } else if (maxScore == 1) {
            lowestGoodScore = 1;
            lowestSurpriseScore = 1;
        }
        int goodScores = 0, surpriseScores = 0;
        for (int score : scores) {
            if (score >= lowestGoodScore) ++goodScores;
            else if (score >= lowestSurpriseScore) ++ surpriseScores;
        }
        if (numSurprising < surpriseScores) surpriseScores = numSurprising;
        return goodScores + surpriseScores;
    }
}

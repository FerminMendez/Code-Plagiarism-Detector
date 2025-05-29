package ru.sidorkevich.google.jam.qualification.b;

import com.sun.org.apache.bcel.internal.generic.FieldOrMethod;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TripletGenerator {

    private static int MIN_SCORE = 0;
    private static int MAX_SCORE = 10;

    public static List<Triplet> generateTriples(int sum) {
        List<Triplet> result = new ArrayList<Triplet>();

        for (int score1 = MIN_SCORE; score1 <= MAX_SCORE; score1++) {
            for (int score2 = MIN_SCORE; score2 <= MAX_SCORE; score2++) {
                for (int score3 = MIN_SCORE; score3 <= MAX_SCORE; score3++) {
                    if (score1 + score2 + score3 == sum && isCorrect(score1, score2, score3)) {
                        Triplet newTriplet = new Triplet(score1, score2, score3);
                        if (!result.contains(newTriplet)) {
                            result.add(newTriplet);
                        }
                    }
                }
            }
        }

        return result;
    }

    private static boolean isCorrect(int score1, int score2, int score3) {
        return Math.abs(score1 - score2) <= Triplet.MAX_DISTANCE && Math.abs(score1 - score3) <= Triplet.MAX_DISTANCE && Math.abs(score2 - score3) <= Triplet.MAX_DISTANCE;
    }
}

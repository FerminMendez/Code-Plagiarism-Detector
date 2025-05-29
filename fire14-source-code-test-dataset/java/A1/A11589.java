package ru.sidorkevich.google.jam.qualification.b;

import java.util.HashSet;
import java.util.Set;

public class Triplet {

    public static int MAX_DISTANCE = 2;

    private int score1;
    private int score2;
    private int score3;

    public Triplet(int score1, int score2, int score3) {
        this.score1 = score1;
        this.score2 = score2;
        this.score3 = score3;
    }

    public int getScore1() {
        return score1;
    }

    public int getScore2() {
        return score2;
    }

    public int getScore3() {
        return score3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Triplet triplet = (Triplet) o;

        Set<Integer> set1 = new HashSet<Integer>();
        set1.add(score1);
        set1.add(score2);
        set1.add(score3);

        Set<Integer> set2 = new HashSet<Integer>();
        set2.add(triplet.score1);
        set2.add(triplet.score2);
        set2.add(triplet.score3);

        return set1.equals(set2);
    }

    @Override
    public int hashCode() {
        int result = score1;
        result = 31 * result + score2;
        result = 31 * result + score3;
        return result;
    }

    @Override
    public String toString() {
        return score1 + " " + score2 + " " + score3;
    }

    public boolean isSurprising() {
        return Math.abs(score1 - score2) == MAX_DISTANCE || Math.abs(score1 - score3) == MAX_DISTANCE ||
                Math.abs(score2 - score3) == MAX_DISTANCE;
    }

    public int bestScore() {
        return Math.max(Math.max(score1, score2), score3);
    }
}

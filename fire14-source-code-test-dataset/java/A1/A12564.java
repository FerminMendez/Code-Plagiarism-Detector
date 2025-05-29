package com.monochromeiguana.codejam;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class Main {

    static BufferedReader in;
    static BufferedWriter out;
    static String inputFile = "in.txt";
    static String outputFile = "outfile.txt";

    private static class Parser {

        public final int numDancers;
        public final int numSurprises;
        public final int minScore;
        public final int index;
        public final int answer;

        public Parser(String line, int ix) {
            index = ix;
            List<String> parts = Lists.newArrayList(Arrays.asList(line.split(" ")));
            numDancers = Integer.parseInt(parts.remove(0));
            numSurprises = Integer.parseInt(parts.remove(0));
            minScore = Integer.parseInt(parts.remove(0));
            
            Iterable<Dancer> dancers = Iterables.transform(parts, new Function<String, Dancer>() {

                public Dancer apply(String f) {
                    return new Dancer(Integer.parseInt(f), minScore);
                }
            });

            int winners = Iterables.size(Iterables.filter(dancers, new Predicate<Dancer>() {

                public boolean apply(Dancer t) {
                    return t.win();
                }
            }));

            int surprises = Math.min(Iterables.size(Iterables.filter(dancers, new Predicate<Dancer>() {

                public boolean apply(Dancer t) {
                    return t.possibleSurprise();
                }
            })), numSurprises);
                        
            answer = winners + surprises;
        }

        public String output() {
            return "Case #" + index + ": " + answer;
        }
    }

    private static class Dancer {

        public final int score;
        public final int minScore;
        public final int remainder;
        public final int average;

        public Dancer(int scr, int min) {
            score = scr;
            minScore = min;
            remainder = scr % 3;
            average = scr / 3;
        }

        // If remainder = 0, we either have 3 * avg or avg - 1 & avg & avg + 1 (surprising)
        // If remainder = 1, we either have avg-1 & 2 * avg+1 (surprising) or 2 * avg & avg + 1
        // If remainder = 2, we either have 2 * avg & avg + 2 (surprising) or avg & 2 * avg + 1
        public boolean win() {
            if (remainder == 0) {
                return average >= minScore;
            } else {
                return average >= minScore - 1;
            }
        }

        public boolean possibleSurprise() {
            if (win()) {
                return false;
            }
            if (remainder == 0) {
                return average > 0 && average == minScore - 1;
            } else if (remainder == 1) {
                return false;
            } else {
                return average == minScore - 2;
            }
        }
    }

    public static void main(String[] args) throws Exception {

        in = new BufferedReader(new FileReader(inputFile));
        out = new BufferedWriter(new FileWriter(outputFile));
        try {
            String line = in.readLine();
            int nbCases = Integer.parseInt(line);
            int index = 0;
            while ((line = in.readLine()) != null) {
                index++;
                Parser p = new Parser(line, index);
                out.write(p.output());
                out.newLine();
            }
        } finally {
            in.close();
        }
        out.flush();
    }
}

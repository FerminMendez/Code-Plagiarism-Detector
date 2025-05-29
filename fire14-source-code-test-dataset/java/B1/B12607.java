package com.monochromeiguana.codejam;

import com.google.common.collect.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

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

        public final int index;
        public final int answer;
        public final int lBound;
        public final int uBound;

        public Parser(String line, int ix) {
            index = ix;
            List<String> parts = Arrays.asList(line.split(" "));
            lBound = Integer.parseInt(parts.get(0));
            uBound = Integer.parseInt(parts.get(1));

            Multimap<String, String> out = ArrayListMultimap.create();
            for (int l = lBound; l < uBound; l++) {
                String thing = String.valueOf(l);
                Set<String> friends = Sets.newHashSet();
                for (int offset = 1; offset < thing.length(); offset++) {
                    String friend = thing.substring(offset).concat(thing.substring(0, offset));
                    if (friend.startsWith("0")) {
                        continue;
                    }
                    
                    int friendly = Integer.parseInt(friend);
                    if (friendly <= l || friendly > uBound) {
                        continue;
                    }
                    friends.add(friend);
                }
                out.putAll(thing, friends);
            }
            answer = out.values().size();
        }

        public String output() {
            return "Case #" + index + ": " + answer;
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

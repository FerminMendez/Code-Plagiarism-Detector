package ru.sidorkevich.google.jam.qualification.b;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Task> tasks = parseInputFile("B-small-attempt0.in");

        List<Integer> results = new ArrayList<Integer>();

        for (Task task : tasks) {
            results.add(solve(task));
        }

        writeOutputFile("b_output.txt", results);
    }

    private static void writeOutputFile(String fileName, List<Integer> results) throws IOException {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(fileName));

            int i = 1;
            for (Integer result : results) {
                bw.write("Case #" + i++ + ": " + result + "\n");
            }
        } finally {
            if (bw != null) {
                bw.close();
            }
        }
    }

    private static List<Task> parseInputFile(String fileName) throws IOException {
        List<Task> result = new ArrayList<Task>();

        BufferedReader bf = null;

        try {
            bf = new BufferedReader(new FileReader(fileName));

            int numberOfStrings = Integer.parseInt(bf.readLine());

            String line = bf.readLine();

            while (line != null) {
                String[] tokens = line.split("\\s");

                int n = Integer.valueOf(tokens[0]);
                int s = Integer.valueOf(tokens[1]);
                int p = Integer.valueOf(tokens[2]);

                List<Integer> t = new ArrayList<Integer>();

                for (int i = 3; i < tokens.length; i++) {
                    t.add(Integer.valueOf(tokens[i]));
                }

                result.add(new Task(n, s, p, t));

                line = bf.readLine();
            }

            if (result.size() != numberOfStrings) {
                throw new RuntimeException("Incorrect input file. Expected number of strings = " + numberOfStrings + ", actual number of strings = " + result.size());
            }
        } finally {
            if (bf != null) {
                bf.close();
            }
        }

        return result;
    }

    private static int solve(Task task) {
        List<List<Triplet>> listOfPossibleTriplets = new ArrayList<List<Triplet>>();

        for (Integer ti : task.getT()) {
            listOfPossibleTriplets.add(TripletGenerator.generateTriples(ti));
        }

        int s = 0;
        int result = 0;

        for (List<Triplet> possibleTriplets : listOfPossibleTriplets) {
            if (possibleTriplets.size() > 1) {
                if (possibleTriplets.get(1).bestScore() >= task.getP()) {
                    result++;
                } else if (possibleTriplets.get(0).bestScore() >= task.getP() && s < task.getS()) {
                    result++;
                    s++;
                }
            } else {
                if (possibleTriplets.get(0).bestScore() >= task.getP()) {
                    result++;
                }
            }
        }

        return result;
    }
}

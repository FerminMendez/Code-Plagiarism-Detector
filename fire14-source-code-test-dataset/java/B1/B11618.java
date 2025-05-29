package ru.sidorkevich.google.jam.qualification.c;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        List<Task> tasks = parseInputFile("C-small-attempt0.in");
        List<Integer> results = new ArrayList<Integer>();

        for (Task task : tasks) {
            List<Pair> result = new ArrayList<Pair>();

            for (int i = task.getA(); i <= task.getB(); i++) {
                generateRecycledNumbers(result, i, task.getB());
            }

            results.add(result.size());
        }

        writeOutputFile(results, "c_output.txt");
    }

    private static void writeOutputFile(List<Integer> results, String fileName) throws IOException {
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

                int a = Integer.valueOf(tokens[0]);
                int b = Integer.valueOf(tokens[1]);

                result.add(new Task(a, b));

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

    private static void generateRecycledNumbers(List<Pair> result, int number, int max) {
        if (number <= 11) {
            return;
        }

        String str = Integer.toString(number);

        for (int i = 1; i < str.length(); i++) {
            String begin = str.substring(0, i);
            String end = str.substring(i);

            int newNumber = Integer.valueOf(end + begin);

            if (newNumber > number && newNumber <= max) {
                Pair newPair = new Pair(number, newNumber);
                if (!result.contains(newPair)) {
                    result.add(newPair);
                }
            }
        }
    }

    private static class Task {
        int a;
        int b;

        private Task(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public int getB() {
            return b;
        }
    }

    private static class Pair {
        int n;
        int m;

        private Pair(int n, int m) {
            this.n = n;
            this.m = m;
        }

        public int getN() {
            return n;
        }

        public int getM() {
            return m;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            return n == pair.getN() && m == pair.getM() || n == pair.getM() && m == pair.getN();
        }

        @Override
        public int hashCode() {
            int result = n;
            result = 31 * result + m;
            return result;
        }
    }
}

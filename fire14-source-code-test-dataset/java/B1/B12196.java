package qualification;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class C {
    private static abstract class Solver {
        public abstract String solveCase(String input);
    }

    public static void main(String[] args) throws IOException {
        solveTasks("C-small-attempt1", new Solver() {
            @Override
            public String solveCase(String input) {
                String[] parts = input.split(" ");
                int from = Integer.parseInt(parts[0]);
                int to = Integer.parseInt(parts[1]);
                int count = countRecycledBetween(from, to);
                return Integer.toString(count);
            }
        });
    }

    private static void solveTasks(String name, Solver bTest)
            throws FileNotFoundException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(name
                + ".in"));
        FileWriter outputWriter = new FileWriter(name + ".out");
        int inputLength = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < inputLength; i++) {
            String inputLine = bufferedReader.readLine();
            String output = bTest.solveCase(inputLine);
            String answer = "Case #" + (i + 1) + ": " + output;
            outputWriter.append(answer);
            outputWriter.append('\n');
            System.out.println(answer);
        }
        bufferedReader.close();
        outputWriter.close();
    }

    private static int countRecycledBetween(int a, int b) {
        int recycled = 0;
        for (int i = a; i < b; i++) {
            for (int j = i + 1; j <= b; j++) {
                if (isRecycled(i, j)) {
                    recycled++;
                }
            }
        }
        return recycled;
    }

    private static boolean isRecycled(int aInt, int bInt) {
        String aString = Integer.toString(aInt);
        String bString = Integer.toString(bInt);
        int lengthDiff = aString.length() - bString.length();
        if (lengthDiff > 0) {
            bString = appendZeroes(lengthDiff, bString);
        } else if (lengthDiff < 0) {
            aString = appendZeroes(-lengthDiff, aString);
        }
        for (int i = 1; i < aString.length(); i++) {
            String shifted = shiftString(bString, i);
            if (aString.equals(shifted)) {
                return true;
            }
        }
        return false;
    }

    private static String appendZeroes(int zeroes, String base) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < zeroes; i++) {
            stringBuilder.append('0');
        }
        stringBuilder.append(base);
        return stringBuilder.toString();
    }

    private static String shiftString(String input, int steps) {
        StringBuilder builder = new StringBuilder();
        builder.append(input.substring(steps));
        builder.append(input.substring(0, steps));
        return builder.toString();
    }

    private static int[] splitDigits(int number) {
        String string = Integer.toString(number);
        int[] digits = new int[string.length()];
        for (int i = 0; i < digits.length; i++) {
            digits[i] = string.charAt(i) - '0';
        }
        return digits;
    }
}

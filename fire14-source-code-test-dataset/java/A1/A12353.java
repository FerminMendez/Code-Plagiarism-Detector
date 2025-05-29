import java.io.*;
import java.util.*;

/**
 * @author: Ignat Alexeyenko
 * Date: 4/14/12
 */
public class DancingWithGooglersMain {

    public static final int MAX_LENGTH = 80;

    public static void main(String[] args) {
        DancingWithGooglersMain main = new DancingWithGooglersMain();
        main.runConsoleApp(System.in, System.out);
    }

    public void runConsoleApp(InputStream inputStream, OutputStream outputStream) {
        final String s = readLn(inputStream, MAX_LENGTH);
        Integer cases = Integer.valueOf(s);
        Writer writer = new OutputStreamWriter(outputStream);
        for (int i= 0; i < cases; i++) {
            String rawLine = readLn(inputStream, MAX_LENGTH);

            try {
                writer.write("Case #" + (i + 1) + ": " + runFunction(rawLine) + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private long runFunction(String rawLine) {
        String[] edgesArr = rawLine.split(" ");

        int numOfGooglers = Integer.valueOf(edgesArr[0]);
        int surprises = Integer.valueOf(edgesArr[1]);
        int minScoreP = Integer.valueOf(edgesArr[2]);

        List<Integer> marksT = new ArrayList<Integer>(numOfGooglers);
        for (int t = 0; t < numOfGooglers; t++) {
            marksT.add(Integer.valueOf(edgesArr[t + 3]));
        }

        return caclulateAmountOfGooglersThatExceedScoreP(surprises, minScoreP, marksT);
    }

    private int caclulateAmountOfGooglersThatExceedScoreP(int surprises, int minScoreP, List<Integer> marksT) {
        Map<Integer, Set<Mark>> sumToPermutations = new HashMap<Integer, Set<Mark>>(marksT.size());

        for (Integer theSum : marksT) {
            Set<Mark> allPossiblePermutations = getAllPossiblePermutations(theSum, minScoreP);
            sumToPermutations.put(theSum, allPossiblePermutations);
        }

        int exceedsWithoutSurprises = 0;
        int exceedsOnlyWithSurprises = 0;
        for (Integer theSum : marksT) {
            Set<Mark> marksPermutations = sumToPermutations.get(theSum);
            
            boolean exceeded = false;
            boolean needSurprise = true;
            for (Mark marksPermutation : marksPermutations) {
                if (marksPermutation.exceedsScore) {
                    exceeded = true;
                    if (!marksPermutation.surprise && needSurprise) {
                        needSurprise = false;
                    }
                }
            }
            
            if (exceeded && needSurprise) {
                exceedsOnlyWithSurprises++;
            }
            if (exceeded && !needSurprise) {
                exceedsWithoutSurprises++;
            }
        }

        return exceedsWithoutSurprises + Math.min(exceedsOnlyWithSurprises, surprises);
    }

    Set<Mark> getAllPossiblePermutations(int sum, int minScoreP) {
        Set<Mark> markList = new LinkedHashSet<Mark>(5);
        final int start = Math.max(sum / 3 - 2, 0);
        final int stop = sum / 3 + 2;
        for (int i = start; i <= stop; i++) {
            for (int j = start; j <= stop; j++) {
                for (int k = start; k <= stop; k++) {
                    final int divergence = Math.abs(max(i, j, k) - min(i, j, k));
                    if ((i + j + k == sum) && divergence <= 2) {
                        boolean exceedsScore = i >= minScoreP || j >= minScoreP || k >= minScoreP;
                        markList.add(new Mark(i, j, k, divergence == 2, exceedsScore));
                    }
                }
            }
        }
        return markList;
    }

    private static int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    private static int max(int a, int b, int c) {
        return Math.max(Math.max(a, b), c);
    }


    private String readLn(InputStream inputStream, int maxLength) {  // utility function to read from stdin,
        // Provided by Programming-challenges, edit for style only
        byte line[] = new byte[maxLength];
        int length = 0;
        int input = -1;
        try {
            while (length < maxLength) {//Read untill maxlength
                input = inputStream.read();
                if ((input < 0) || (input == '\n')) break; //or untill end of line ninput
                line[length++] += input;
            }

            if ((input < 0) && (length == 0)) return null;  // eof
            return new String(line, 0, length);
        } catch (IOException e) {
            return null;
        }
    }

    static class Mark {
        // array represents marks, always are sorted
        private List<Integer> marks;

        private boolean surprise;
        private boolean exceedsScore;

        Mark(int m0, int m1, int m2, boolean surprise, boolean exceedsScore) {
            this.marks = new ArrayList<Integer>(3);
            this.marks.add(m1);
            this.marks.add(m0);
            this.marks.add(m2);
            this.surprise = surprise;
            this.exceedsScore = exceedsScore;
            // todo: possibly just put elements in the list in a right order
            Collections.sort(this.marks);
            Collections.reverse(this.marks);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Mark mark = (Mark) o;

            if (exceedsScore != mark.exceedsScore) return false;
            if (surprise != mark.surprise) return false;
            if (marks != null ? !marks.equals(mark.marks) : mark.marks != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = marks != null ? marks.hashCode() : 0;
            result = 31 * result + (surprise ? 1 : 0);
            result = 31 * result + (exceedsScore ? 1 : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Mark{" +
                    "marks=" + marks +
                    ", surprise=" + surprise +
                    ", exceedsScore=" + exceedsScore +
                    '}';
        }
    }
}

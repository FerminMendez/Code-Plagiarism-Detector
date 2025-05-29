import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

import junit.framework.Assert;

/**
 * Problem B - Dancing With The Googlers
 * 
 * @author nhancvu@gmail.com
 */
public class ProblemB {
    private static final boolean DEBUG = false;

    private static final int MAX_TEST_CASES = 100;
    private static final int MAX_RESULT = 10;
    private static final int MAX_TOTAL_POINT = 30;

    public static void main(String[] args) {
        if (DEBUG) {
            int result1 = processTestCase("3 1 5 15 13 11");
            int result2 = processTestCase("3 0 8 23 22 21");
            int result3 = processTestCase("2 1 1 8 0");
            int result4 = processTestCase("6 2 8 29 20 8 18 18 21");
            int result5 = processTestCase("1 0 4 8");

            Assert.assertEquals(3, result1);
            Assert.assertEquals(2, result2);
            Assert.assertEquals(1, result3);
            Assert.assertEquals(3, result4);
            Assert.assertEquals(0, result5);
        }

        int numberOfTestCases;
        int results[];

        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));

            String input = bufferRead.readLine();
            if (null != input) {
                numberOfTestCases = Math.min(Integer.valueOf(input), MAX_TEST_CASES);
                results = new int[numberOfTestCases];
                for (int i = 0; i < numberOfTestCases; i++) {
                    input = bufferRead.readLine();
                    if (null != input) {
                        results[i] = processTestCase(input);
                    }
                }

                for (int i = 0; i < numberOfTestCases; i++) {
                    System.out.println("Case #" + (i + 1) + ": " + results[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int processTestCase(String testCase) {
        int maxNumGooglers = 0;

        StringTokenizer tokenizer = new StringTokenizer(testCase, " ");

        int numOfGooglers = (tokenizer.hasMoreTokens() ? Integer.valueOf(tokenizer.nextToken()) : 0);
        int numOfSurprisingTripletsOfScores = (tokenizer.hasMoreTokens() ? Integer.valueOf(tokenizer.nextToken()) : 0);
        int bestResult = (tokenizer.hasMoreTokens() ? Integer.valueOf(tokenizer.nextToken()) : 0);

        if (numOfSurprisingTripletsOfScores > numOfGooglers) return maxNumGooglers;
        if (0 > bestResult || bestResult > MAX_RESULT) return maxNumGooglers;

        List<Googler> googlers = new ArrayList<Googler> ();
        int totalPointPerGooglers[] = new int[numOfGooglers];
        for (int i = 0; i < numOfGooglers; i++) {
            totalPointPerGooglers[i] = (tokenizer.hasMoreTokens() ? Integer.valueOf(tokenizer.nextToken()) : 0);

            if (0 > totalPointPerGooglers[i] || totalPointPerGooglers[i] > MAX_TOTAL_POINT) return maxNumGooglers;

            googlers.add(new Googler(i, getAllPossibleScores(totalPointPerGooglers[i])));
        }

        maxNumGooglers = getMaxNumGooglersWithAtLeastBestScore(googlers, numOfSurprisingTripletsOfScores, bestResult);

        return maxNumGooglers;
    }

    public static int getMaxNumGooglersWithAtLeastBestScore(List<Googler> googlers, int numOfSurprisingTripletsOfScores, int bestResult) {
        int bestMaxNumGooglers = 0;

        int googlerIndex = 0;

        List<PossibleTripletScores> possibleTripletScoresList = new ArrayList<PossibleTripletScores>();
        PossibleTripletScores runningTallyPossibleScores;
        PossibleTripletScores possibleScores;

        Stack<Googler> state = new Stack<Googler>();
        state.push(googlers.get(googlerIndex++));

        Googler currentGoogler;
        do {
            if (googlerIndex < googlers.size()) {
                state.push(googlers.get(googlerIndex++));
            } else {
                currentGoogler = (Googler) state.pop();
                googlerIndex--;

                runningTallyPossibleScores = new PossibleTripletScores();
                for (Googler googler : state) {
                    runningTallyPossibleScores.addTripletScores(googler.getCurrentTripletScores());
                }

                currentGoogler.firstTripletScores();
                do {
                    possibleScores = new PossibleTripletScores(runningTallyPossibleScores);
                    possibleScores.addTripletScores(currentGoogler.getCurrentTripletScores());
                    possibleTripletScoresList.add(possibleScores);

                    currentGoogler.nextTripletScores();
                } while (currentGoogler.hasMoreTripletScores());

                if (!state.isEmpty()) {
                    do {
                        currentGoogler = (Googler) state.peek();
                        if (currentGoogler.hasMoreTripletScores()) {
                            currentGoogler.nextTripletScores();
                            break;
                        } else {
                            currentGoogler = (Googler) state.pop();
                            currentGoogler.firstTripletScores();
    
                            googlerIndex--;    
                        }
                    } while (!state.isEmpty());
                }
            }
        } while (!state.isEmpty());

        for (PossibleTripletScores possibleTripletScores : possibleTripletScoresList) {
            if (possibleTripletScores.getSuprisingTripletScoreCount() == numOfSurprisingTripletsOfScores) {
                bestMaxNumGooglers = Math.max(bestMaxNumGooglers, possibleTripletScores.getHasAtLeastBestScoreCount(bestResult));
            }
        }

        return bestMaxNumGooglers;
    }

    public static List<TripletScores> getAllPossibleScores(int googlerTotalPoint) {
        List<TripletScores> list = new ArrayList<TripletScores>();

        for (int firstJudgeScore = MAX_RESULT; firstJudgeScore >= 0; firstJudgeScore--) {
            if (firstJudgeScore > googlerTotalPoint) continue;

            for (int secondJudgeScore = Math.min(MAX_RESULT, googlerTotalPoint - firstJudgeScore); secondJudgeScore >= 0; secondJudgeScore--) {
                if (Math.abs(firstJudgeScore - secondJudgeScore) > 2) continue;

                int thirdJudgeScore = googlerTotalPoint - (secondJudgeScore + firstJudgeScore);
                if (Math.abs(thirdJudgeScore - secondJudgeScore) > 2) continue;
                if (Math.abs(thirdJudgeScore - firstJudgeScore) > 2) continue;

                list.add(new TripletScores(firstJudgeScore, secondJudgeScore, thirdJudgeScore));
            }
        }

        return list;
    }

    public static class PossibleTripletScores {
        private List<TripletScores> scores;

        public PossibleTripletScores() {
            this.scores = new ArrayList<TripletScores>();
        }

        public PossibleTripletScores(PossibleTripletScores another) {
            this.scores = new ArrayList<TripletScores>(another.getScores());
        }

        public List<TripletScores> getScores() {
            return this.scores;
        }

        public void addTripletScores(TripletScores score) {
            this.scores.add(score);
        }

        public int getHasAtLeastBestScoreCount(int bestScore) {
            int count = 0;

            for (TripletScores score : scores) {
                if (score.hasAtLeastBestScore(bestScore)) {
                    count++;
                }
            }

            return count;
        }

        public int getSuprisingTripletScoreCount() {
            int count = 0;

            for (TripletScores score : scores) {
                if (score.isSurprising()) {
                    count++;
                }
            }

            return count;
        }

        public String toString() {
            StringBuilder s = new StringBuilder();

            s.append("Possible TripletScores: ");
            for (TripletScores score : scores) {
                s.append(score);
                s.append(" ");
            }

            return s.toString();
        }
    }

    public static class Googler {
        private int googlerIndex;
        private List<TripletScores> possibleTripletScores;
        private int tripletScoresIndex;

        public Googler(int googlerIndex, List<TripletScores> possibleTripletScores) {
            this.googlerIndex = googlerIndex;
            this.possibleTripletScores = possibleTripletScores;
            this.tripletScoresIndex = 0;
        }

        public final int getGooglerIndex() {
            return googlerIndex;
        }

        public void firstTripletScores() {
            tripletScoresIndex = 0;
        }

        public void nextTripletScores() {
            tripletScoresIndex++;
        }

        public TripletScores getCurrentTripletScores() {
            return possibleTripletScores.get(tripletScoresIndex);
        }

        public boolean hasMoreTripletScores() {
            return (this.tripletScoresIndex < possibleTripletScores.size() - 1);
        }
        
        public String toString() {
            StringBuilder s = new StringBuilder();
            
            s.append("Googler [");
            s.append(this.googlerIndex);
            s.append("] ");
            s.append(this.tripletScoresIndex);
            s.append(" ");
            for (TripletScores score : this.possibleTripletScores) {
                s.append(score);
                s.append(" ");
            }

            return s.toString();
        }
    }

    public static class TripletScores {
        private int s1;
        private int s2;
        private int s3;

        public TripletScores(int s1, int s2, int s3) {
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
        }

        public boolean isSurprising() {
            return (Math.abs(this.s1 - this.s2) >= 2) ||
                   (Math.abs(this.s1 - this.s3) >= 2) ||
                   (Math.abs(this.s2 - this.s3) >= 2);
        }
        
        public boolean hasAtLeastBestScore(int bestScore) {
            return (this.s1 >= bestScore || this.s2 >= bestScore || this.s3 >= bestScore);
        }
        
        public String toString() {
            StringBuilder s = new StringBuilder();

            s.append("(");
            s.append(this.s1);
            s.append(", ");
            s.append(this.s2);
            s.append(", ");
            s.append(this.s3);
            s.append(")");

            return s.toString();
        }
    }
}
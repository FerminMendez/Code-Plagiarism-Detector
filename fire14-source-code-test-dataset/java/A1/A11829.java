import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: vikash
 * Date: 14/04/12
 * Time: 9:51 AM
 * To change this template use File | Settings | File Templates.
 */
public class DancingGooglers {

    static int[][] getPossibleCombinations(int totalPoints) {
        int averagePoint = totalPoints / 3;
        int remainder = totalPoints % 3;
        int[][] possibleCombinations;
        if (totalPoints >= 2 && totalPoints <= 28) {
            possibleCombinations = new int[2][3];
            if (remainder == 0) {
                possibleCombinations[1] = new int[]{averagePoint, averagePoint, averagePoint};
                possibleCombinations[0] = new int[]{averagePoint + 1, averagePoint, averagePoint - 1};
            } else if (remainder == 1) {
                possibleCombinations[1] = new int[]{averagePoint + 1, averagePoint, averagePoint};
                possibleCombinations[0] = new int[]{averagePoint + 1, averagePoint + 1, averagePoint - 1};
            } else { //remainder == 2
                possibleCombinations[1] = new int[]{averagePoint + 1, averagePoint + 1, averagePoint};
                possibleCombinations[0] = new int[]{averagePoint + 2, averagePoint, averagePoint};
            }
        } else {
            possibleCombinations = new int[1][3];
            if (totalPoints == 0) {
                possibleCombinations[0] = new int[]{0, 0, 0};
            } else if (totalPoints == 1) {
                possibleCombinations[0] = new int[]{1, 0, 0};
            } else if (totalPoints == 29) {
                possibleCombinations[0] = new int[]{10, 10, 9};
            } else if (totalPoints == 30) {
                possibleCombinations[0] = new int[]{10, 10, 10};
            }
        }
        return possibleCombinations;
    }

    static boolean isBestScoreMet(int[] possibleCombination, int bestScore) {
        for (int i = 0; i < possibleCombination.length; i++) {
            return possibleCombination[i] >= bestScore;
        }
        return false;
    }

    static boolean isSurprisingTriplet(int[] possibleCombination) {
        for (int i = 0; i < possibleCombination.length; i++) {
            for (int j = i + 1; j < possibleCombination.length; j++) {
                return Math.abs(possibleCombination[i] - possibleCombination[j]) == 2;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("/Users/vikash/DancingGooglersIn.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("/Users/vikash/DancingGooglersOut.txt"));
        int testCases = Integer.parseInt(br.readLine());
        int currentTest = 1;
        while (currentTest <= testCases) {
            String[] numbers = br.readLine().split(" ");
            int numberOfGooglers = Integer.parseInt(numbers[0]);
            int numberOfSurprisingTriplets = Integer.parseInt(numbers[1]);
            int minBestResult = Integer.parseInt(numbers[2]);
            int[] googlersTotalScore = new int[numberOfGooglers];
            for (int i = 3; i < numbers.length; i++) {
                googlersTotalScore[i - 3] = Integer.parseInt(numbers[i]);
            }
            Arrays.sort(googlersTotalScore);
            int qualifyingGooglers = 0;
            boolean minConditionMet = false;
            int optionalSurprisingTriplets = 0;
            for (int i = 0; i < googlersTotalScore.length; i++) {
//                if (minConditionMet) {
//                    qualifyingGooglers++;
//                } else {
                    int[][] possibleCombinations = getPossibleCombinations(googlersTotalScore[i]);
                    boolean isBestResultMet = isBestScoreMet(possibleCombinations[0], minBestResult);
                    if (isBestResultMet && numberOfSurprisingTriplets <= 0 && optionalSurprisingTriplets == 0) {
                        if (possibleCombinations.length == 2) {
                            isBestResultMet = isBestScoreMet(possibleCombinations[1], minBestResult);
                        }
                    }
                    if (isBestResultMet) {
                        if(numberOfSurprisingTriplets<=0) {
                            optionalSurprisingTriplets--;
                        }
                        qualifyingGooglers++;
                        if (googlersTotalScore[i]/3 >= minBestResult) {
                            minConditionMet = true;
                        }
                    }
                    if (possibleCombinations.length == 2 && numberOfSurprisingTriplets > 0) {
                        numberOfSurprisingTriplets--;
                        if(!isBestResultMet) {
                            optionalSurprisingTriplets++;
                        }
                    }
//                }
            }
            bw.write("Case #" + currentTest + ": " + qualifyingGooglers);
            bw.newLine();
            currentTest++;
        }
        bw.close();
        br.close();
    }
}

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DancingWithGooglers {


    public static void main(String[] args) throws IOException {
        File in = new File("c:\\temp\\input.txt");
        File out = new File("c:\\temp\\output.txt");
        BufferedWriter w = new BufferedWriter(new FileWriter(out));
        Scanner sc = new Scanner(in);
        int testCases = Utils.readIntegerLine(sc);
        for (int i = 1; i <= testCases; i++) {
            int googlers =  Utils.readInteger(sc);
            int surprising = Utils.readInteger(sc);
            int minBestResult = Utils.readInteger(sc);
            int[] totalPoints = new int[googlers];
            for(int j = 0; j < googlers; j++) {
                totalPoints[j] = Utils.readInteger(sc);
            }
            int maxGooglersWithBestResults = solve(googlers, surprising, minBestResult, totalPoints);
            String result = String.format("Case #%d: %d", i, maxGooglersWithBestResults);
            w.write(result);
            System.err.println(result);
            w.newLine();
        }
        w.close();

    }

    static int minTotalPointsForBestScore(int b, boolean s) {
        switch (b) {
        case 0: return s ? 2 : 0;
        case 1: return s ? 2 : 1;
        default: return s ? Math.max(2, b + b - 2 + b - 2) : b + b - 1 + b - 1;
        }
    }

    static int maxTotalPointsForBestScore(int b, boolean s) {
        return s ? 28 : 30;
    }


    static boolean canBeSurprising(int total) {
        return total >= 2 && total <= 28;
    }


    private static int solve(int googlers, int surprising, int minBestResult,
            int[] totalPoints) {
        int n = googlers;
       // Arrays.sort(totalPoints);

        Set<Integer> canBeSurprising = new HashSet<Integer>();
        Set<Integer> okIfSurprising = new HashSet<Integer>();
        Set<Integer> okIfNotSurprising = new HashSet<Integer>();
        Set<Integer> areSurprising = new HashSet<Integer>();
        int i = 0;
       for (int points : totalPoints) {
           int minPoints = 0;
           int maxPoints = 0;
            if (canBeSurprising(points)) {
                canBeSurprising.add(i);
                // assume surprising
                minPoints = minTotalPointsForBestScore(minBestResult, true);
                maxPoints = maxTotalPointsForBestScore(minBestResult, true);
                if (points >= minPoints && points <= maxPoints) {
                    okIfSurprising.add(i);
                }
            }


            // assume not surprising
            minPoints = minTotalPointsForBestScore(minBestResult, false);
            maxPoints = maxTotalPointsForBestScore(minBestResult, false);
            if (points >= minPoints && points <= maxPoints) {
                okIfNotSurprising.add(i);
            }
            i++;
        }


        int count = 0;
        _outer:

        while (surprising > 0) {
            for(int j = 0; j < googlers; j++) {
                if (canBeSurprising.contains(j)) {
                    if (okIfSurprising.contains(j) && !okIfNotSurprising.contains(j)) {
                        surprising--;
                        areSurprising.add(j);
                        canBeSurprising.remove(j);
                        continue _outer;
                    }
                }
            }
            for(int j = 0; j < googlers; j++) {
                if (canBeSurprising.contains(j)) {
                    if (!okIfSurprising.contains(j) && okIfNotSurprising.contains(j)) {
                        surprising--;
                        areSurprising.add(j);
                        canBeSurprising.remove(j);
                        continue _outer;
                    }
                }
            }
            for(int j = 0; j < googlers; j++) {
                if (canBeSurprising.contains(j)) {
                    if (okIfSurprising.contains(j)) {
                        surprising--;
                        areSurprising.add(j);
                        canBeSurprising.remove(j);
                        continue _outer;
                    }
                }
            }
            for(int j = 0; j < googlers; j++) {
                if (canBeSurprising.contains(j)) {
                        surprising--;
                        areSurprising.add(j);
                        canBeSurprising.remove(j);
                        continue _outer;
                }
            }
        }

        for(int j = 0; j < googlers; j++) {
                if (okIfSurprising.contains(j) && areSurprising.contains(j)) {
                    count++;
                } else
                if (okIfNotSurprising.contains(j) && !areSurprising.contains(j)) {
                    count++;
                }
        }

        return count;
    }

}


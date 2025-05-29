/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Luis Carlos
 */
public class DancingGooglers {

    private static String caseString = "Case #%d: %s";
    private static int max;
    private static int count;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader bf = new BufferedReader(new FileReader("small.in"));
        int testCase = Integer.parseInt(bf.readLine());
        for (int i = 1; i <= testCase; i++) {
            String[] parameters = bf.readLine().split(" ");
            int N = Integer.parseInt(parameters[0]);
            int S = Integer.parseInt(parameters[1]);
            int p = Integer.parseInt(parameters[2]);
            int[][][] detailedPosibleScores = new int[N][][];
            for (int j = 3; j < N + 3; j++) {
                for (int k = 0; k < detailedPosibleScores.length; k++) {
                    detailedPosibleScores[k] = getPossibleTripplets(Integer.parseInt(parameters[k + 3]));
                }
            }
            int[] combination = new int[N];
            visitar(0, combination, detailedPosibleScores, S, 0, p);
            System.out.println(String.format(caseString, i, count));
            count = 0;
        }
    }

    public static int[][] getPossibleTripplets(int score) {
        if (score == 0) {
            return new int[][]{{0, 0, 0}, {0, 0, 0}};
        }
        if (score == 1) {
            return new int[][]{{0, 0, 1}, {0, 0, 1}};
        }
        int m = score / 3;
        int r = score % 3;
        if (r == 0) {
            return new int[][]{{m - 1, m, m + 1}, {m, m, m}};
        }
        if (r == 1) {
            return new int[][]{{m, m, m + 1}, {m + 1, m + 1, m - 1}};
        }
        if (m + 2 > 10) {
            return new int[][]{{m + 1, m + 1, m}, {m + 1, m + 1, m}};
        }
        return new int[][]{{m, m, m + 2}, {m + 1, m + 1, m}};
    }

    public static boolean isSurprising(int[] tripplet) {
        return Math.abs(tripplet[0] - tripplet[1]) == 2 || Math.abs(tripplet[0] - tripplet[2]) == 2 || Math.abs(tripplet[1] - tripplet[2]) == 2;
    }

    public static void visitar(int pos, int[] comb, int[][][] combs, int S, int s, int p) {
        if (pos < comb.length) {
            for (int i = 0; i < 2; i++) {
                comb[pos] = i;
                visitar(pos + 1, comb, combs, S, s, p);
            }
        } else {
            mostrar(comb, combs, p, S);
        }
    }

    public static void mostrar(int[] combination, int[][][] combs, int p, int S) {
        int s = 0, countTmp = 0;
        for (int i = 0; i < combination.length; i++) {
            int[] tripplet = combs[i][combination[i]];
            if(isSurprising(tripplet)){
                if(++s>S){
                    return;
                }
            }
            max = max(tripplet);
            if (max >= p) {
                countTmp++;
            }
        }
        if(countTmp > count){
            count = countTmp;
        }
    }

    public static int max(int... number) {
        int max = 0;
        for (int i : number) {
            if (i == 10) {
                return 10;
            }
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
}

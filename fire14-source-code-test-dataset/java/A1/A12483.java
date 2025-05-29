
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JY
 */
public class ProblemB4Test {

    private static int testNum;
    private static int[][] scores;

    public static void main(String[] args) {
        input();
        int[] result = calc();
        output(testNum, result);
    }

    private static void input() {
        Scanner in = null;

        String file = "B-small-attempt0.in";

        try {
            in = new Scanner(new FileInputStream(file));
        } catch (FileNotFoundException ex) {
            System.out.println("Error reading file.");
            System.exit(0);
        }

        //in = new Scanner(System.in);
        testNum = Integer.parseInt(in.nextLine());
        scores = new int[testNum][];
        for (int i = 0; i < testNum; i++) {
            String line = in.nextLine();
            String[] nums = line.split(" ");
            int n = Integer.parseInt(nums[0]);
            scores[i] = new int[n + 3];
            for (int j = 0; j < n + 3; j++) {
                scores[i][j] = Integer.parseInt(nums[j]);
            }
        }
    }

    private static int[] calc() {
        int[] res = new int[testNum];
        for (int i = 0; i < testNum; i++) {
            int result = 0;
            int[] scoreLine = scores[i];
            int n = scoreLine[0];
            int s = scoreLine[1];
            int p = scoreLine[2];
            for (int j = 0; j < n; j++) {
                int currentScore = scoreLine[j + 3];
                if ((currentScore + 2) >= 3 * p) {
                    result++;
                } else if (s > 0 && (currentScore + 4) >= 3 * p && (currentScore + 4) / 3 >= 2) {
                    result++;
                    s--;
                }
            }
            res[i] = result;
        }
        return res;
    }

    private static void output(int testNum, int[] res) {
        for (int i = 0; i < testNum; i++) {
            System.out.printf("Case #%d: %s\n", i + 1, res[i]);
        }
    }

    private static void prt(int[] c) {
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }
        System.out.println("");
    }
}

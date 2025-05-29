
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author JY
 */
public class ProblemC4Test {

    private static int testNum;
    private static int[][] data;
    private static final int EQUAL = 0;
    private static final int LESS = 1;
    private static final int LARGER = 2;

    public static void main(String[] args) {
        input();
        int[] result = calc();
        output(testNum, result);
    }

    private static void input() {
        Scanner in = null;

        String file = "C-small-attempt0.in";
        try {
            in = new Scanner(new FileInputStream(file));
        } catch (FileNotFoundException ex) {
            System.out.println("Error reading file.");
            System.exit(0);
        }

        //in = new Scanner(System.in);
        testNum = Integer.parseInt(in.nextLine());
        data = new int[testNum][];
        for (int i = 0; i < testNum; i++) {
            String line = in.nextLine();
            String[] nums = line.split(" ");
            data[i] = new int[2];
            data[i][0] = Integer.parseInt(nums[0]);
            data[i][1] = Integer.parseInt(nums[1]);
        }
    }

    private static int[] calc() {
        HashSet<Integer> hs = new HashSet<Integer>();
        int[] res = new int[testNum];
        for (int i = 0; i < testNum; i++) {
            int result = 0;
            int a = data[i][0];
            int b = data[i][1];
            int length = getLength(b);;
            for (int number = a; number <= b; number++) {
                hs.clear();
                for (int shifts = 1; shifts < length; shifts++) {
                    int shiftnum = shift(number, shifts);
                    if (shiftnum <= b && shiftnum > number && !hs.contains(shiftnum)) {
                        result++;
                        hs.add(shiftnum);
                    }
                }
            }
            res[i] = result;
        }
        return res;
    }

    private static int getLength(int n) {
        return String.valueOf(n).length();
    }

    private static int shift(int num, int shift) {
        String numS = String.valueOf(num);
        int len = numS.length();
        numS = reverse(numS, 0, len - shift - 1);
        numS = reverse(numS, len - shift, len - 1);
        numS = reverse(numS, 0, len - 1);
        return Integer.parseInt(numS);
    }

    private static String reverse(String target, int start, int end) {
        char[] tar = target.toCharArray();
        while (start < end) {
            char tmp = tar[start];
            tar[start] = tar[end];
            tar[end] = tmp;
            start++;
            end--;
        }
        return new String(tar);
    }

    private static void output(int testNum, int[] res) {
        for (int i = 0; i < testNum; i++) {
            System.out.printf("Case #%d: %s\n", i + 1, res[i]);
        }
    }
}

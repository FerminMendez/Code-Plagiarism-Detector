import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Author: Andriy Gusyev
 * Date: 14.04.12
 */
public class Task2 {

    static private int[] multiplers = {0, 0, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 10000000};

    static private int cases;

    static private int[] lowerBounds;

    static private int[] upperBounds;

    static private int[] results;

    private static void readBounds(String s, int index) {
        s = s.trim();
        String[] arr = s.split(" ");
        lowerBounds[index] = Integer.parseInt(arr[0]);
        upperBounds[index] = Integer.parseInt(arr[1]);
    }

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(new File("d:/codejam/2/small"), "UTF-8");
        cases = Integer.parseInt(sc.nextLine());
        lowerBounds = new int[cases];
        upperBounds = new int[cases];
        results = new int[cases];
        for (int i = 0; i < cases; i++) {
            readBounds(sc.nextLine(), i);
        }
        System.out.println(cases);
        System.out.println(Arrays.toString(lowerBounds));
        System.out.println(Arrays.toString(upperBounds));

        for (int i = 0; i < cases; i++) {
            results[i] = calcRecycled(i);
        }
        System.out.println(Arrays.toString(results));
        FileWriter fw = new FileWriter(new File("d:/codejam/2/small_out"));
        int k = 0;
        for (int i : results) {
            k++;
            fw.write(String.format("Case #%s: %s\n", String.valueOf(k), String.valueOf(i)));
        }
        fw.close();
    }

    private static int calcRecycled(int index) {
        int result = 0;
        int lower = lowerBounds[index];
        int upper = upperBounds[index];
        for (int i = lower; i <= upper; i++) {
            System.out.println(i);
            int[] possibles = getPossibleRecycled(i);
            for (int j : possibles) {
                if (i < j  && j <= upper && areRecycled(i, j)) {
                    result++;
                }
            }
        }

        return result;
    }

    private static boolean areRecycled(int i, int j) {
//        if (!Arrays.equals(toSortedChars(i), toSortedChars(j))) {
//            return false;
//        }
        int digits = String.valueOf(i).length();
        int initialI = i;
        int initialJ = j;
        for (int p = 0; p < digits; p++) {
            i = changeValue(i, digits);
            if (i == j) {
                return true;
            }
        }
        ;
        return false;
    }

    private static int[] getPossibleRecycled(int i) {
        //        if (!Arrays.equals(toSortedChars(i), toSortedChars(j))) {
        //            return false;
        //        }
        int digits = String.valueOf(i).length();
        int possibles[] = new int[digits];
        for (int p = 0; p < digits; p++) {
            int candidate = changeValue(i, digits);
            i = candidate;
            if (isInArray(candidate, possibles)) {
                possibles[p] = 0;
            } else {
                possibles[p] = candidate;
            }
        }
        return possibles;
    }
    
    private static boolean isInArray(int c, int[] array) {
        for (int i : array) {
            if (i == c) {
                return true;
            }
        }
        return false;
    }

    private static int changeValue(int i, int digits) {
        if (i < 10) {
            return i;
        } else {
            //get last digit
            int last = i % 10;
            //cut last digit
            i = i / 10;
            // add last digit to the front
            i = multiplers[digits] * last + i;
            return i;
        }
    }

    private static char[] toSortedChars(int i) {
        char[] chars = String.valueOf(i).toCharArray();
        Arrays.sort(chars);
        return chars;
    }

}
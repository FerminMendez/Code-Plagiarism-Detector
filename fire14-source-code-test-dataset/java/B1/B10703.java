import java.io.*;
import java.util.Collections;

public class C {

    public static void main (String[] args) { 
        int[][] numbers = new int[1001][5];
        
        try {        
            BufferedReader reader = new BufferedReader (new InputStreamReader(System.in));
            String line = reader.readLine();
            int testCases = Integer.parseInt (line.trim());

            for (int i = 0; i < testCases; i++) {
                numbers = new int[1001][5];
                line = reader.readLine();
                line.trim();
                String[] nums = line.split (" ");
                int a = Integer.parseInt(nums[0]);
                int b = Integer.parseInt(nums[1]);

                for (int j = a; j <= b; j++) {
                    String str = Integer.toString(j);
//System.out.print (str + " ");
                    int numDigits = str.length();
                    char[] digits = str.toCharArray();
                    reverseSort (digits);
                    String sortedStr = new String (digits);
                    int sortedInt = Integer.parseInt (sortedStr);
                    numbers[sortedInt][numDigits] ++;
                }

                int numFound = 0;
                for (int j = 0; j < 1001; j++) {
                    for (int k = 0; k < 5; k++) {
                        if (numbers[j][k] > 1) {
//System.out.println (" found one at " + numbers[j][k] + " comb is " + getCombination (numbers[j][k]));
//System.out.println ("j is " + j + " k is " + k);
                            numFound += getCombination(numbers[j][k]);
                        }
                    }
                }
                System.out.println ("Case #" + (i+1) + ": " + numFound);
            }

        } catch (Exception e) {
System.out.println (e);
        }
    }

    static void reverseSort (char[] digits) {
        int indexLargest = 0;
        for (int i = 1; i < digits.length; i++) {
            if (digits[i] > digits[indexLargest]) {
                indexLargest = i;
            }
        }

        while (indexLargest != 0) {
            shift (digits);
            indexLargest--;
        }
        if (digits.length == 3 && (digits[0] == digits[2])) {
            swap (digits, 2, 1);
        }
    }

    public static void shift (char[] digits) {
        char temp = digits[0];
        for (int i = 0; i < digits.length-1; i++) {
            digits[i] = digits[i+1];
        }
        digits[digits.length - 1] = temp;
    }

    public static void swap (char[] digits, int i, int j) {
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }  

    public static int getCombination (int a) {
// replace with factorials?
        int numCombinations = 0;
        if (a == 2) {
            numCombinations = 1;
        } else if (a == 3) {
            numCombinations = 3;
        } else if (a == 4) {
            numCombinations = 6;
        }
        return numCombinations;
    }

}

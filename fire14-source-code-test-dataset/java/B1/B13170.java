import java.io.*;
import java.util.Scanner;
import java.util.Arrays;

public class RecycleNums {

    public static void main(String[] args) throws FileNotFoundException {
		File input = new File(args[0]);
        Scanner scan = new Scanner(input);
		PrintStream output = new PrintStream(new File("C-small.out"));
		
		int cases = scan.nextInt();
		
		for (int i = 0; i < cases; i++) {
			int first = scan.nextInt();
			int second = scan.nextInt();
			int result = checkRange(first, second);
			output.print("Case #" + (i + 1) + ": " + result);
			if (i != cases - 1) output.println();
		} // for
		
    } // main

	public static int checkRange(int min, int max) {
		int count = 0;
		
		for (int i = min; i < max; i++) {
			for (int j = i + 1; j <= max; j++) {
				if (isRecycleNums(i, j)) count++;
			} // for
		} // for
		
		return count;
		
	} // checkRange
	
	public static boolean isRecycleNums(int a, int b) {
		char[] first = Integer.toString(a).toCharArray();
		char[] second = Integer.toString(b).toCharArray();
		
		if (first.equals(second)) return true;
		
		for (int i = 0; i < first.length; i++) {
			rotateArray(first);
			if (Arrays.equals(first, second)) return true;
		} // for
		
		return false;
		
	} // isRecycleNums
	
	public static void rotateArray(char[] myChars) {
		char first = myChars[0];
		for (int i = 0; i < myChars.length - 1; i++) {
			myChars[i] = myChars[i+1];
		} // for
		myChars[myChars.length - 1] = first;
	} // rotateArray

} // RecycleNums
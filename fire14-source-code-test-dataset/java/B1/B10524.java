package dom.zar.jam.qualifications;

import java.util.Scanner;

public class RecycledNumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int inputLines = in.nextInt();
		for (int i = 0; i < inputLines;) {
			int a = in.nextInt();
			int b = in.nextInt();						
			System.out.println("Case #" + ++i + ": "
					+ result(a, b));
		}
	}
	
	private static int result(int a, int b) {
		int size = b - a + 1;
		int[] nums = new int[size];
		for (int i = 0; i < size; ++i) nums[i] = a + i;
		
		int counter = 0;
		for (int i = 0; i < size; ++i) {
			if (nums[i] > -1) {
				counter += rotate(nums[i], a, b, nums);
				nums[i] = -1;
			}
		}		
		return counter;
	}
	
	private static int rotate(Integer n, int a, int b, int[] nums) {
		String valString = n.toString();
		int length = valString.length();
		valString = valString + valString;
		int counter = 0;
		for (int i = 1; i < length; ++i) {
			int rotated = Integer.parseInt(
					valString.substring(i, i + length));
			if (rotated > n && rotated <= b
					&& nums[rotated - a] != -1) {
				counter++;
				nums[rotated - a] = -1;
			}
		}
		return (counter * (counter + 1)) >> 1;
	}
}

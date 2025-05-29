import java.util.HashSet;
import java.util.Scanner;

public class RecycledNumbers {
	
	public static int[] POWER_OF_10 = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000};
	
	public static int rotate(int n, int offset) {
		return (n % POWER_OF_10[offset]) * POWER_OF_10[(int) Math.log10(n) + 1 - offset] + (n / POWER_OF_10[offset]);
	}
	
	public static int count(int low, int high) {
		int count = 0;
		if (low < 10) {
			low = 10;
		}
		
		HashSet<Integer> group = new HashSet<Integer>();
		for (int i = low; i < high; i++) {
			int numDigit = (int) Math.log10(i) + 1;
			while (numDigit > 0) {
				int num = rotate(i, numDigit--);
				if (num > i && num <= high && !group.contains(num)) {
					count++;
					group.add(num);
				}
			}
			group.clear();
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		final Scanner in = new Scanner(System.in);
		final int numCase = in.nextInt();
		in.nextLine();
		for (int i = 0; i < numCase; i++) {
			int low = in.nextInt();
			int high = in.nextInt();
			System.out.println("Case #" + (i+1) + ": " + count(low, high));
			in.nextLine();
		}
	}
}

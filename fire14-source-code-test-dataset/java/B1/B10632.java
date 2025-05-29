package assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import base.Assignment;

public class AssignmentC implements Assignment {

	private int min;
	private int max;

	@Override
	public String solve() {
		int total = 0;
		int length = (int) Math.log10(min) + 1;
		for (int i = min; i < max; i++) {
			List<Integer> counted = new ArrayList<Integer>();
			for (int j = 1; j < length; j++) {
				int shifted = shift(i, j, length);
				if (shifted > i && shifted <=max && !counted.contains(shifted)) {
					counted.add(shifted);
					total++;
				}
			}
		}
		return Integer.toString(total);
	}

	private int shift(int i, int shift, int length) {
		int temp = (int) Math.pow(10, shift);
		
		int result = (i % temp) * ((int)Math.pow(10, length - shift)) + ((int)i / temp);
		return result;
	}

	public static Assignment createFromScanner(Scanner scanner) {
		AssignmentC assignment = new AssignmentC();
		assignment.min = scanner.nextInt();
		assignment.max = scanner.nextInt();
		return assignment;
	}

}

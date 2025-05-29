package codejam2012;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class RecycledNumbers {

	private boolean[] data;
	private int min;
	private int max;
	private int digits;
	private int mask;

	public RecycledNumbers(int min, int max) {
		this.min = min;
		this.max = max;
		digits = (int) Math.ceil(Math.log10(max));
		mask = (int) Math.pow(10, digits);
		initData();
	}

	private void initData() {
		data = new boolean[max - min + 1];
	}

	public int eval() {
		int[] result = new int[digits];
		int total = 0;
		for (int number = min; number <= max; number++) {
			if (!isTested(number)) {
				int n = getRecycleNumbers(number, result);
				int real_n = setTested(result, n);
				if (real_n > 1) {
					total += real_n * (real_n - 1) / 2;
				}
			}
		}
		return total;
	}

	private int setTested(int[] result, int n) {
		int tested = 0;
		for (int i = 0; i < n; i++) {
			if (!data[result[i] - min]) {
				data[result[i] - min] = true;
				tested++;
			}
		}
		return tested;
	}

	private int getRecycleNumbers(int number, int[] result) {
		int count = 0;
		for (int i = 0; i < digits; i++) {
			if (number >= min && number <= max) {
				result[count++] = number;
			}
			int number10 = number * 10;
			number = (number10 % mask) + (number10 / mask);
		}
		return count;
	}

	private boolean isTested(int number) {
		return data[number - min];
	}

	public static void main(String[] args) throws Exception {
		PrintWriter output = new PrintWriter("output3.txt");
		Scanner scanner = new Scanner(new File("input3.txt"));
		try {
			int input_T = scanner.nextInt();
			for (int i = 0; i < input_T; i++) {
				int input_A = scanner.nextInt();
				int input_B = scanner.nextInt();
				RecycledNumbers testing = new RecycledNumbers(input_A, input_B);
				long start = System.nanoTime();
				int eval = testing.eval();
				output.printf("Case #%d: %d\n", i + 1, eval);
				System.out
						.printf("Case #%d: %d (%d)\n",
								i + 1,
								eval,
								TimeUnit.NANOSECONDS.toMillis(System.nanoTime()
										- start));
			}
		} finally {
			output.close();
			scanner.close();
		}
	}

}

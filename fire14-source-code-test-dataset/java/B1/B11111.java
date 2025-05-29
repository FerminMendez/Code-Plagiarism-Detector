package recycled;

import java.util.List;
import java.util.Set;

import util.ListFactory;
import util.SetFactory;
import file.Input;
import file.Output;

public class Recycled {

	public void start() {
		List<String> inputLines = Input.getLines();
		if (inputLines.size() > 0) {
			List<String> outputLines = ListFactory.newArrayListInstance();
			int t = Integer.parseInt(inputLines.get(0));
			for (int i = 1; i <= t; i++) {
				String[] parts = inputLines.get(i).split(" ");
				int a = Integer.parseInt(parts[0]);
				int b = Integer.parseInt(parts[1]);
				outputLines.add("Case #" + i + ": " + getNumber(a, b));
			}
			Output.writeLines(outputLines);
		}
	}

	private int getNumber(int a, int b) {
		Set<Pair> set = SetFactory.newHashSetInstance();
		if (a <= b) {
			for (int n = a; n <= b; n++) {
				int length = getLength(n);
				for (int i = 0; i < length - 1; i++) {
					int m = moveRight(n, i + 1);
					if (n < m && m <= b) {
						set.add(new Pair(n, m));
					}
				}
			}
		}
		return set.size();
	}

	private int getLength(int number) {
		int length = 0;
		if (number >= 0 && number <= 9) {
			length = 1;
		} else if (number >= 10 && number <= 99) {
			length = 2;
		} else if (number >= 100 && number <= 999) {
			length = 3;
		} else if (number >= 1000 && number <= 9999) {
			length = 4;
		} else if (number >= 10000 && number <= 99999) {
			length = 5;
		}
		return length;
	}

	private int moveRight(int n, int times) {
		String number = String.valueOf(n);
		for (int i = 0; i < times; i++) {
			int length = number.length();
			number = number.substring(length - 1, length)
					+ number.substring(0, length - 1);
		}
		return Integer.parseInt(number);
	}

	public static void main(String[] args) {
		new Recycled().start();
	}

}

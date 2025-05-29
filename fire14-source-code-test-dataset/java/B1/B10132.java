package in.co.google.jam;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Recycled {

	public Recycled() throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(
				new FileInputStream("C:/C-small.in.txt")));
		int numTests = Integer.parseInt(br.readLine());
		for (int i = 0; i < numTests; i++) {
			int result = 0;
			String s = br.readLine();
			String[] numbers = s.split(" ");
			int A = Integer.parseInt(numbers[0]);
			int B = Integer.parseInt(numbers[1]);
			if (A < 10 && B < 10) {
				result = 0;
			} else {
				List<Integer> allNumbers = new ArrayList<Integer>();
				for (int x = A; x <= B; x++) {
					allNumbers.add(x);
				}
				int middle = allNumbers.size() / 2;
				int base = 0;
				int t = A;
				int tester = 1;
				while (t >= 10) {
					t = t / 10;
					base++;
					tester *= 10;
				}

				for (int c = 0; c < allNumbers.size() - 10; c++) {
					for (int d = c + 9; d < allNumbers.size(); d++) {
						int numToTest = allNumbers.get(d);
						for (int b = 0; b < base; b++) {
							numToTest = recycle(numToTest, tester);
							if (allNumbers.get(c) == numToTest) {
								result++;
								break;
							}
						}
					}
				}

			}
			System.out.println("Case #" + (i + 1) + ": " + result);
		}

	}

	private int recycle(int num, int base) {
		int ret = num;
		int t = num;
		ret = ((t % base) * 10) + (t / base);
		return ret;
	}

	public static void main(String[] args) {
		try {
			new Recycled();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

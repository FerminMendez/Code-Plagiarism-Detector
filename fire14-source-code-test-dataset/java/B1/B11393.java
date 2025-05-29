import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


public class C {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner read = new Scanner(new File("C-small-attempt0.in"));
		PrintWriter out = new PrintWriter(new File("c-small.out"));
		int numberOfTests = read.nextInt();
		for (int i = 1; i <= numberOfTests; i++) {
			int a = read.nextInt();
			int b = read.nextInt();
			int countOfDigits = 0;
			int t = 1;
			while (a / t != 0) {
				countOfDigits++;
				t *= 10;
			}
			t /= 10;
			int result = 0;
			for (int n = a; n < b; n++) {
				int m = n;
				for (int k = 1; k < countOfDigits; k++) {
					int lastDigit = m % 10;
					m = m / 10;
					m = lastDigit * t + m;
					if (m <= b && m > n) {
						result++;
					}
				}
			}
			
			out.println(String.format("Case #%d: %d", i, result));
		}
		out.close();
	}
}

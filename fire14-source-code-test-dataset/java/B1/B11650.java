package qualify;

import java.util.Scanner;

public class C {

	private static int rotate(int input) {
		int order = 1;
		while (input / order >= 10) order *= 10;
		
		int lastDigit = 0;
		do {
			lastDigit = input % 10;
			input /= 10;
			input += lastDigit * order;
		} while (lastDigit == 0);
		return input;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i=0;i<t;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int total = 0;
			
			for (int j=a;j<b;j++) {
				int x = j;
				while ((x = rotate(x)) != j) {
					if (x > j && x <= b) total++;
				}
			}
			System.out.println("Case #" + (i + 1) + ": " + total);
		}
	}
}

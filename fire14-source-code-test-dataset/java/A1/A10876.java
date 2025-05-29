import java.util.Scanner;



public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 1; i <= testCases; i++) {
			int n = sc.nextInt();
			int s = sc.nextInt();
			int p = sc.nextInt();
			int[] points = new int[n];
			int result = 0;
			boolean[] flags = new boolean[n];
			for (int j = 0; j < n; j++) {
				int temp = sc.nextInt();
				if (temp == 0) {
					points[j] = 0;
					flags[j] = false;
				} else if (temp % 3 == 0) {
					points[j] = temp / 3;
					flags[j] = true;
				} else if (temp % 3 == 1) {
					points[j] = temp / 3 + 1;
					flags[j] = false;
				} else {
					points[j] = temp / 3 + 1;
					flags[j] =true;
				}
			}
			for (int j = 0; j < n; j++) {
				if (points[j] >= p) {
					result += 1;
					flags[j] = false;
				}
			}
			int currentSurprising = 0;
			for (int j = 0; j < n && currentSurprising < s; j++) {
				if (flags[j] && points[j] + 1 >= p) {
					result += 1;
					currentSurprising += 1;
				}
			}
			System.out.println("Case #" + i + ": " + result);
		}
	}	
}

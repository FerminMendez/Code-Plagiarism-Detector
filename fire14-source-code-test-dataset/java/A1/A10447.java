import java.util.Scanner;

public class Dancing {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			int k = scan.nextInt();
			int[] arrayInt = new int[k];
			int s = scan.nextInt();
			int p = scan.nextInt();
			for (int j = 0; j < k; j++)
				arrayInt[j] = scan.nextInt();
			int a = 0;
			for (int j = 0; j < k; j++) {
				int div = arrayInt[j] / 3;
				int rem = arrayInt[j] - div * 3;
				if (rem == 0) {
					if (div >= p)
						a++;
					else if (div == p - 1 && s >= 1 && div - 1 >= 0) {
						a++;
						s--;
					}
				} else if (rem == 1) {
					if (div >= p - 1)
						a++;
				} else {
					if (div >= p - 1)
						a++;
					else if (div == p - 2 && s >= 1) {
						a++;
						s--;
					}
				}
			}
			array[i] = a;
		}
		for (int i = 1; i <= n; i++)
			System.out.println("Case #" + i + ": " + array[i - 1]);
	}
}

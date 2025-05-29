import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class cyclic {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int in = Integer.parseInt(sc.nextLine());		
		int i = 1;
		while (i <= in) {
			int A = sc.nextInt();
			int B = Integer.parseInt(sc.nextLine().trim());			
			System.out.print("Case #" + i + ": ");
			if(i < in)
				System.out.println(count(A,B));
			else
				System.out.print(count(A,B));
			i++;
		}
	}

	public static int count(int A, int B) {
		boolean[] flag = new boolean[B - A + 1];
		int numDigits = (int) Math.log10(A) + 1;
		int pairs = 0;
		for (int i = A; i <= B; i++) {
			if (!flag[i - A]) {
				flag[i - A] = true;
				int n = 1;
				for (int j = 1; j < numDigits; j++) {
					int l = (int) (i / Math.pow(10, j));
					l += (i % Math.pow(10, j)) * Math.pow(10, numDigits - j);
					if (l >= A && l <= B && !flag[l-A]) {
						flag[l - A] = true;
						n++;
					}
				}
				if (n > 1) {
					int nC2 = 1;
					for (int j = 0; j < 2; j++) {
						nC2 = nC2 * (n - j) / (j + 1);
					}
					pairs += nC2;
				}
			}
		}

		return pairs;
	}
}

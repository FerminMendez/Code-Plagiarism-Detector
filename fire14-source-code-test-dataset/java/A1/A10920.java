import java.util.Arrays;
import java.util.Scanner;
public class DancingGoogler {
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		int x = sc.nextInt();
		for (int i = 0; i < x; i++) {
			int num = sc.nextInt();
			int lim = sc.nextInt();
			int goal = sc.nextInt();
			int [] list = new int [num];
			for (int j = 0; j < num; j++)
				list[j] = sc.nextInt();
			Arrays.sort(list);
			int count = 0;
			for (int j = num-1; j >= 0; j--) {
				if (list[j] >= goal*3-2) count++;
				else if (lim > 0 && list[j] >= goal && list[j] >= goal*3-4) {
					count++;
					lim--;
				}
			}
			System.out.println("Case #" + (i+1) + ": " + count);
		}
	}
}

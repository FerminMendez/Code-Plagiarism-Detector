import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int i = 1; i <= testCases; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();
			int digit = ("" + A).toCharArray().length;
			int result = 0;
			for (int j = A; j <= B; j++) {
				char[] cs = ("" + j).toCharArray();
				Set<Integer> set = new HashSet<Integer>();
				for (int k = 1; k < digit; k++) {
					String str = "";
					for (int l = 0; l < digit; l++) {
						str += cs[(k + l) % digit];
					}
					int temp = Integer.parseInt(str);
					if (j < temp && temp <= B) {
						set.add(temp);
					}
				}
				result += set.size();
			}
			System.out.println("Case #" + i +": " + result);
		}
	}
}

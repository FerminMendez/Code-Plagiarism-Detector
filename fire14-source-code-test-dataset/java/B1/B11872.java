import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("c:\\eclipse\\3\\C-small-attempt0.in"));
		int numTc = scanner.nextInt();
		for (int index = 0; index < numTc; index++) {
			int result = 0;
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			for (int i = a; i <= b; i++) {
				if (i < 10) continue;
				int num = findNumPairs(i, a, b);
				result += num;
			}
			System.out.println("Case #" + (index + 1) + ": " + result/2);
		}
	}
	private static int findNumPairs(int num, int a, int b) {
		
		char[] origStr = String.valueOf(num).toCharArray();
		int len = origStr.length;
		char[] newStr = new char[len];
		int result = 0;
		int startIndex = 1;
		HashSet<Integer> consumedSet = new HashSet<Integer>();
		do {
			if (startIndex == len) {
				break;
			}
 			int idx = 0;
			for (int i = startIndex; i < len; i++) {
				newStr[idx++] = origStr[i];
			}
			for (int i = 0; i < startIndex; i++) {
				newStr[idx++] = origStr[i];
			}
			startIndex++;
			int newNum = Integer.parseInt(String.valueOf(newStr));
			if (newNum < a || newNum > b || newNum == num || consumedSet.contains(newNum)) {
				continue;
			}
			result++;
			consumedSet.add(newNum);
		} while(true);
		return result;
	}
}
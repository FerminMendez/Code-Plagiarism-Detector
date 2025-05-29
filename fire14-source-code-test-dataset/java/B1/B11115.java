import java.util.*;

public class RecycledNumbers {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cases = scan.nextInt();
		
		for (int i = 0; i < cases; i++) {
			System.out.print("Case #" + (i + 1) + ": ");
			int bot = scan.nextInt();
			int top = scan.nextInt();
			int count = 0;
			
			for (int a = bot; a <= top; a++) {
				for (int b = a+1; b <= top; b++) {
					if (test(a, b)) count++;
				}
			}
			
			System.out.println(count);
		}
	}

	private static boolean test(int a, int b) {
		String numA = String.valueOf(a);
		String numB = String.valueOf(b);
		if (numA.length() != numB.length()) return false;
		
		char refA = numA.charAt(0);
		for (int i = 0; i < numA.length(); i++) {
			char currB = numB.charAt(i);
			if (currB == refA) {
				String compare = numB.substring(i) + numB.substring(0, i);
				if (compare.equals(numA)) return true;
			}
		}
		
		return false;
	}
}

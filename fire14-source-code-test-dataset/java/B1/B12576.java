import java.util.ArrayList;
import java.util.Scanner;

public class ProblemC {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		int a = 0, b = 0, count;
		String a_str = "";
		ArrayList<String> ar = new ArrayList<String>();
		for (int i = 0; i < t; i++) {
			ar.clear();
			count = 0;
			a = in.nextInt();
			b = in.nextInt();
			a_str = Integer.toString(a);
			int a_length = a_str.length();
			if (a_length > 1) {
				for (int j = a; j < b; j++) {
					for (int k = j + 1; k <= b; k++) {
						a_str = Integer.toString(j);
						//b_str = Integer.toString(k);
						for (int h = 0; h < a_length - 1; h++) {
							a_str = a_str.charAt(a_length - 1) + a_str.substring(0, a_length - 1);
							if (Integer.parseInt(a_str) == k && !ar.contains(j + ", " + k)) {
								count++;
								ar.add(j + ", " + k);
								//System.out.println(j + ", " + k);
							}
						}
					}
				}
				System.out.println("Case #" + (i + 1) + ": " + count);
			} else {
				System.out.println("Case #" + (i + 1) + ": 0");
			}
		}
	}
}

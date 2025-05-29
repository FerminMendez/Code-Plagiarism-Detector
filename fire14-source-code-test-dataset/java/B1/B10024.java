package WQ;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class Problem_C {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static boolean check(String s) {
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.charAt(i) != s.charAt(i + 1))
				return true;
		}
		return false;
	}

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader("C-small-attempt0.in"));
		PrintWriter out = new PrintWriter("out1.txt");
		int num = in.nextInt();
		for (int CASE = 1; CASE <= num; CASE++) {
			int a = in.nextInt();
			int b = in.nextInt();
			HashSet<String> hs = new HashSet<String>();
			for (int i = a; i <= b; i++) {
				String s = i + "";
				if (check(s) && s.length() > 1) {
					for (int k = s.length() - 2, j = 0; k >= 0
							&& j < s.length() - 1; j++, k--) {
						String newS = s.substring(k + 1)
								+ s.substring(0, k + 1);
						int newInt = Integer.parseInt(newS);
						if (newInt <= b && i < newInt
								&& s.length() == (newInt + "").length()
								&& !newS.equals(s)) {
							if (i < Integer.parseInt(newS))
								hs.add(i + " " + newS);
							else
								hs.add(newS + " " + i);
						}
					}
				}
			}
			out.println("Case #" + CASE + ": " + hs.size());
		}
		out.close();
	}
}

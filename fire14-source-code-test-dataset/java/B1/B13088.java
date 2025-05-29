import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class C {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new FileInputStream("C-small-attempt0.in"));
		System.setOut(new PrintStream(new FileOutputStream("c.out")));
		C c = new C();
		long start = System.currentTimeMillis();
		int t = sc.nextInt();
		for (int i = 0; i < t; i++)
			System.out.println("Case #" + (i + 1) + ": "
					+ c.solve(sc.nextInt(), sc.nextInt()));
		long end = System.currentTimeMillis();
//		System.out.println((end - start) / 1000.0);
		// System.out.println("Case #" + (i + 1) + ": " +
		// c.bruteSolve(sc.nextInt(), sc.nextInt()));
	}

	private int compare(String a, String b, int shift) {
		int l = a.length();
		int ai = 0;
		int bi = shift;
		for (int i = 0; i < l; i++) {
			int c = a.charAt(ai) - b.charAt(bi);
			if (c != 0)
				return c;
			ai++;
			bi++;
			if (bi == l)
				bi = 0;
		}
		return 0;
	}

	private String shift(String a, int shift) {
		return a.substring(shift) + a.substring(0, shift);
	}

	private long solve(int a, int b) {
		long count = 0;
		String aStr = a + "";
		String bStr = b + "";
		if (aStr.length() != bStr.length())
			throw new RuntimeException("Need the same length");
		HashSet<String> ready = new HashSet<String>();
		int l = aStr.length();
		for (int i = a; i <= b; i++) {
			ready.clear();
			for (int j = 1; j < l; j++) {
				String iStr = i + "";
				String iShifted = shift(iStr, j);
//				debug("Par: " + iStr + " and " + iShifted);
				if (iShifted.equals(iStr))
					continue; // Get the same
//				debug("1");
				if (iShifted.charAt(0) == '0')
					continue; // has leading zero
//				debug("2");
				if (iShifted.compareTo(aStr) <= 0)
					continue;// smaller than lower bound
//				debug("4");
				if (iShifted.compareTo(iStr) <= 0)
					continue; // smaller than first
//				debug("3");
				if (iShifted.compareTo(bStr) > 0)
					continue;// smaller than great bound
//				debug("5");
				if (ready.contains(iShifted))
					continue;
//				debug("6");
				ready.add(iShifted);
				count++;
			}
		}
		return count;
	}

	private long bruteSolve(int a, int b) {
		long count = 0;
		String aStr = a + "";
		String bStr = b + "";
		if (aStr.length() != bStr.length())
			throw new RuntimeException("Need the same length");

		HashSet<String> ready = new HashSet<String>();
		int l = aStr.length();
		for (int i = a; i <= b; i++)
			for (int j = i + 1; j <= b; j++) {
				ready.clear();
				for (int k = 1; k < l; k++) {
					if (shift(i + "", k).equals(j + "")
							&& !ready.contains(j + "")) {
						ready.add(j + "");
						System.out.println("Pair: " + i + " and " + j);
						count++;
					}
				}
			}
		return count;
	}

}

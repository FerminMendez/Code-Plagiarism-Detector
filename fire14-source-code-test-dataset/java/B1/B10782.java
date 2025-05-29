//import java.io.*;
import java.util.*;

public class ProblemC {
	public static void main(String[] args) {
		/*
		try {
			System.setIn(new FileInputStream("c-example.in"));
		} catch (Exception e) {}
		*/
		new ProblemC();
	}
	
	public ProblemC() {
		Scanner input = new Scanner(System.in);
		int cases = input.nextInt();
		for (int n = 0; n < cases; n++) {
			int lower = input.nextInt();
			int upper = input.nextInt();
			System.out.println("Case #" + (n+1) + ": " + findPairs(lower, upper));
		}
	}
	
	private int findPairs(int lower, int upper) {
		List<Integer> pairs = new ArrayList<Integer>();
		for (int i = lower; i <= upper; i++) {
			List<Integer> p = recycle(i);
			for (int j : p) {
				if (j >= i && j <= upper) {
					pairs.add(j);
					//System.out.println(i + ", " + j);
				}
			}
		}
		return pairs.size();
	}
	
	private List<Integer> recycle(int n) {
		List<Integer> p = new ArrayList<Integer>();
		int m = n;
		int len = Integer.toString(n).length();
		int mult = (int)Math.pow(10, len - 1);
		for (int i = 0; i < len; i++) {
			int d = m % 10;
			m /= 10;
			m += (d * mult);
			if (m != n && len == Integer.toString(m).length() && !p.contains(m)) {
				p.add(m);
			}
		}
		return p;
	}
}

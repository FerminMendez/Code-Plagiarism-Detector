import java.io.*;
import java.util.*;

public class Main {
	
	Scanner in;
	PrintWriter out;
	
	static final String problemName = "B";
	
	static void asserT(boolean e) {
		if (!e) {
			throw new Error();
		}
	}
	
	
	static class Triple {
		int a;
		int b;
		int c;
		
		int max;
		int min;
		
		Triple(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
			
			max = Math.max(a, Math.max(b, c));
			min = Math.min(a, Math.min(b, c));
			asserT(max - min <= 2);
		}
		
		boolean isSurprising() {
			return max - min == 2;
		}
	}
	
	static class Point {
		ArrayList <Triple> list = new ArrayList<Triple>();
		int sMax = -1;
		int uMax = -1;
						
		void add(int a, int b, int c) {
			list.add(new Triple(a, b, c));
		}
		
		int getSurpriseMaximum() {
			if (sMax == -1) {
				sMax = 0;
				for (Triple curr : list) {
					if (curr.isSurprising()) {
						sMax = Math.max(curr.max, sMax);
					}
				}
			}
			return sMax;
		}
		
		int getUsualMaximum() {
			if (uMax == -1) {
				uMax = 0;
				for (Triple curr : list) {
					if (!curr.isSurprising()) {
						uMax = Math.max(curr.max, uMax);
					}
				}
			}
			return uMax;
		}
	}
	
	static final int MAX_COUNT = 100;
	static final int MAX_POINTS = 10;
	
	Point p[] = new Point[31];
	
	int res[][];
	int scores[];
	
	int gen(int idx, int remainSurp, int least) {
		if (idx == -1) {
			if (remainSurp == 0) {
				return 0;
			} else {
				return Integer.MIN_VALUE / 10;
			}
		}
		if (res[idx][remainSurp] != -1) {
			return res[idx][remainSurp];
		}
		int ans = 0;
		int score = scores[idx];
		int maxSurp = p[score].getSurpriseMaximum();
		int maxUsual = p[score].getUsualMaximum();
		
		if (remainSurp != 0) {
			if (maxUsual >= least || maxSurp >= least) {
				ans++;
			}
			ans += gen(idx - 1, remainSurp - 1, least);
		} 
		int ans2 = 0;
		if (maxUsual >= least) {
			ans2++;
		}
		ans2 += gen(idx - 1, remainSurp, least);
		
		res[idx][remainSurp] = Math.max(ans, ans2);
		return res[idx][remainSurp];
	}
	
	
	int solveOne() {
		scores = new int[in.nextInt()];
		int nSurprising = in.nextInt();
		int least = in.nextInt();
		for (int i = 0; i < scores.length; i++) {
			scores[i] = in.nextInt();
		}
		
		res = new int[scores.length][nSurprising + 1];
		for (int []ar : res) {
			Arrays.fill(ar, -1);
		}
		
		return gen(scores.length - 1, nSurprising, least);
	}
	
	void solve() {
		for (int i = 0; i < p.length; i++) {
			p [i] = new Point();
		}
		for (int i = 0; i <= 10; i++) {
			for (int j = i; j <= 10; j++) {
				for (int k = j; k <= 10; k++) {
					if (k - i <= 2) {
						int sum = i + j + k;
						p[sum].add(i, j, k);
					}
				}
			}
		}
		
		int nTests = in.nextInt();
		in.nextLine();
		for (int i = 0; i < nTests; i++) {
			out.println("Case #" + (i+1) + ": " + solveOne());
		}
	}
	
	void run() {
		try {
			in = new Scanner(new FileReader("C:/GCJ/" + problemName + ".in"));
			out = new PrintWriter(new FileWriter("C:/GCJ/" + problemName + ".out"));
		} catch (IOException e) {
			in = new Scanner(System.in);
			out = new PrintWriter(System.out);
		//	throw new Error();
		}
		
		try {
			solve();
		} finally {
			out.close();
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
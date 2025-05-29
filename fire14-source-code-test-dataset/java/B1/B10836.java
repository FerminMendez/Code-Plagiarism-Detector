package codejam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class RecycledNumbers {
	
	private StreamTokenizer in;
	private PrintWriter out;
//	private Set<Chain> map = new HashSet<Chain>();
	
	public static void main (String[] args) throws IOException {
		new RecycledNumbers().soilve();
	}
	
	int nextInt () throws IOException {
		in.nextToken();
		return (int)in.nval;
	}
	
	void soilve () throws IOException {
		in = new StreamTokenizer(new BufferedReader(new FileReader("./src/codejam/input.txt")));
		out = new PrintWriter(new FileWriter("./src/codejam/output.txt"));
		
		int t = nextInt();
		for (int i = 0; i < t; i++) {
			int cnt = 0;
			int a = nextInt();
			int b = nextInt();
			int len = Chain.getLen(a);
			for (int j = a; j <= b; j++) {
				cnt += check(a, b, j, len);
			}
			out.println("Case #" + (i + 1) + ": " + cnt);
		}
		
		out.flush();
	}
	
	int check(int a, int b, int q, int len) {
//		Chain chain = new Chain(q);
//		if (map.contains(chain)) {
//			return 0;
//		}
//		map.add(chain);
		
		int first = q;
		int cnt = 0;
		for (int i = 1; i < len; i++) {
			int last = q % 10;
			q /= 10;
			q += last * (int)Math.pow(10, len - 1);
			if ((first < q) && (a <= q) && (q <= b)) {
				cnt++;
			}
		}
		
		return cnt;
	}
	
}

class Chain {
	
	int a;
	
	Chain(int a) {
		this.a = a;
	}
	
	@Override
	public boolean equals(Object b) {
		Chain c = (Chain)b;
		int lenC = getLen(c.a);
		int lenA = getLen(a);
		if (lenA != lenC) {
			return false;
		}
		
		if (lenA == 1) {
			return a == c.a;
		}
		
		for (int i = 1; i < lenA; i++) {
			int last = c.a % 10;
			c.a /= 10;
			c.a += last * (int)Math.pow(10, lenA - 1);
			if (c.a == a) {
				return true;
			}
		}
		
		return false;
	}
	
	public static int getLen (int a) {
		int i = 1;
		int len = 0;
		while (a / i != 0) {
			len++;
			i *= 10;
		}
		return len;
	}
	
}

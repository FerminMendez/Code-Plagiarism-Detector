package gcj;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class Recycled {
	Scanner sc;
	PrintWriter pw;
	
	int t, a, b, n, m, y;

	Recycled() {
		try {
			sc = new Scanner(new File("C-small-attempt0.in"));
			pw = new PrintWriter(new FileWriter("out-small.txt"));
		} catch (IOException e) {
		}
		
		t = sc.nextInt();
		int caseNum = 1;
		
		while (caseNum <= t) {
			y = 0;
			a = sc.nextInt();
			b = sc.nextInt();
			
			n = a;
			m = b;
			while (n < m) {
				while (m > n) {
					recycle(n, m);
					m--;
				}
				n++;
				m = b;
			}
			pw.println("Case #" + caseNum + ": " + y);
			caseNum++;
		}
		pw.flush();
		pw.close();
	}

	void recycle(int a, int b) {
		char[] n = String.valueOf(a).toCharArray();
		char[] m = String.valueOf(b).toCharArray();
		char[] shifted = null;

		for (int i = n.length - 1; i > 0; i--) {
			shifted = shift(n, i);
			if (equal(shifted, m)) {
				this.y++;
				return;
			}
		}
	}

	private char[] shift(char[] x, int start) {
		char[] ret = new char[x.length];

		int i = start;
		for (int j = 0; j < x.length; j++) {
			if (i < x.length) {
				ret[j] = x[i];
				i++;
			} else {
				i = 0;
				ret[j] = x[i];
				i++;
			}
		}
		return ret;
	}

	boolean equal(char[] a, char[] b) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i])
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		new Recycled();
	}

}

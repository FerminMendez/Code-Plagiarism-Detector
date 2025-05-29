import java.util.*;
import java.io.*;

public class B {
	public static void main(String[] args) {
		int n = 0;
		int[] m = null;
		int[] s = null;
		int[] p = null;
		int[][] t = null;
		try {
			File file = new File(args[0]);
			Scanner sc = new Scanner(file);
			n = sc.nextInt();
			m = new int[n];
			s = new int[n];
			p = new int[n];
			t = new int[n][];
			for(int i=0;i<n;i++) {
				m[i] = sc.nextInt();
				s[i] = sc.nextInt();
				p[i] = sc.nextInt();
				t[i] = new int[m[i]];
				for(int j=0;j<m[i];j++) {
					t[i][j] = sc.nextInt();
				}
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}

		for (int i=0;i<n;i++) {
			int b1 = p[i] * 3 - 2;
			int b2 = p[i] * 3 - 4;
			int good = 0;int suprise = 0;
			for (int j=0;j<m[i];j++) {
				if (t[i][j] < p[i]) { continue; }
				if (t[i][j] >= b1) {
					good++;
				} else if (t[i][j] >= b2) {
					suprise++;
				}
			}
			int res;
			if (suprise > s[i]) {
				res = good + s[i];
			} else {
				res = good + suprise;
			}
			System.out.println("Case #" + (i+1) + ": " + res);
		}
	}
}

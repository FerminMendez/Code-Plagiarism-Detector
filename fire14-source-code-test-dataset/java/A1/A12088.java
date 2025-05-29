import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class B {
	static PrintWriter out;

	public static void main(String[] args) throws IOException {
		String name = "B-Small";
		Scanner s = new Scanner(new File(name + ".in"));
		int c = s.nextInt();
		out = new PrintWriter(new BufferedWriter(new FileWriter(name + ".out")));
		// out = new PrintWriter(System.out);
		for (int i = 1; i <= c; i++) {
			out.print("Case #" + i + ": ");
			int n = s.nextInt();
			int S = s.nextInt();
			int p = s.nextInt();
			int[] t = new int[n];
			for (int j = 0; j < n; j++) {
				t[j] = s.nextInt();
			}
			int res = solve(n, S, p, t);
			out.print(res);
			out.println();
		}
		out.close();
	}

	static int solve(int n, int s, int p, int[] t) {
		if(p == 0) return n;
		int res = 0;
		for(int i=0; i<n; i++) {
			int b = t[i] / 3;
			int min1=0, max1=0, min2=0, max2=2;
			switch(t[i] % 3) {
			case 0:
				min1 = b;
				max1 = b;
				min2 = b-1;
				max2 = b+1;
				break;
			case 1:
				min1 = b;
				max1 = b+1;
				min2 = b-1;
				max2 = b+1;
				break;
			case 2:
				min1 = b;
				max1 = b+1;
				min2 = b;
				max2 = b+2;
				break;
			}
			if(min2<0) {
				if(max1>=p) {
					res++;
				}
				continue;
			}
			if(max1>=p) {
				res++;
				continue;
			}
			if(max2>=p && s>0) {
				res++;
				s--;
			}
		}
		return res;
	}

}

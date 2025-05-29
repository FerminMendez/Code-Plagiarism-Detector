import java.io.*;
import java.util.*;

public class codejam2 {
	
	static class triplet {
		
		int a, b, c;
		int maxdiff;
		
		public triplet(int pa, int pb, int pc) {
			a = pa;
			b = pb;
			c = pc;
			maxdiff = maxdiff();
			if (pa < 0 || pb < 0 || pc < 0) maxdiff = 3;
		}
		
		public boolean isSurprising() {
			return Math.abs(a-b) == 2 || Math.abs(a-c) == 2 || Math.abs(b-c) == 2;
		}
		
		public int maxdiff() {
			return Math.max(Math.abs(a-c), Math.max(Math.abs(a-b), Math.abs(b-c)));
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("B-small-attempt0.in"));
		int T;
		
		T = Integer.parseInt(f.readLine());
		StringTokenizer t;
		
		for (int q = 0; q < T; q++) {
			int N, S, p;
			triplet[] ts;
			boolean[] sat;
			t = new StringTokenizer(f.readLine());
			N = Integer.parseInt(t.nextToken());
			S = Integer.parseInt(t.nextToken());
			p = Integer.parseInt(t.nextToken());
			ts = new triplet[N];
			sat = new boolean[N];
			int surpcount = 0;
			for (int i = 0; i < N; i++) {
				int n = Integer.parseInt(t.nextToken());
				int diff = n - (3 * (n/3));
				if (diff == 0 || diff == 1) {
					ts[i] = new triplet(n/3, n/3, n/3 + diff);
				}
				if (diff == 2) {
					ts[i] = new triplet(n/3, n/3+1, n/3+1);
				}
			}
			
			for (int i = 0; i < N; i++) {
				if (ts[i].c >= p) {
					sat[i] = true;
					continue;
				}
				
				triplet newtrip = new triplet(ts[i].a, ts[i].b-1, ts[i].c+1);
				if (newtrip.maxdiff == 1 && (newtrip.c >= p)) {
					sat[i] = true;
					continue;
				}
				if (surpcount >= S) continue;
				
				if (newtrip.maxdiff == 2 && (newtrip.c >= p)) {
					sat[i] = true;
					surpcount++;
					continue;
				}
				
				triplet newnewtrip = new triplet(ts[i].a - 1, ts[i].b-1, ts[i].c+2);
				if (newnewtrip.maxdiff == 2 && (newtrip.c >= p)) {
					sat[i] = true;
					continue;
				}
				
			}
			int tot = 0;
			for (int i = 0; i < N; i++) {
				if (sat[i]) {
					tot++;
				}
			}
			System.out.println("Case #" + (q+1) + ": " + tot);
		}
	}

}

import java.util.*;

public class b {
	static int n,s,p;
	static int[] v;
	static int[][] memo;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1; t<=T; t++) {
			n = in.nextInt();
			s = in.nextInt();
			p = in.nextInt();
			v = new int[n];
			for(int i=0; i<n; i++)
				v[i] = in.nextInt();
			memo = new int[n][s+1];
			for(int[] x : memo) Arrays.fill(x,-1);
			System.out.printf("Case #%d: %d%n", t, go(0,s));
		}
	}
	static int go(int pos, int left) {
		if(left < 0) return -10000;
		if(pos == n) return left == 0 ? 0:-10000;	
		if(memo[pos][left] != -1) return memo[pos][left];
		int best = -10000;
		for(int i=0; i<=10; i++)
			for(int j=i; j<=i+2; j++)
				for(int k=j; k<=i+2; k++)
					if(i+j+k==v[pos]) {
						int sup = 0;
						if(k-i==2) sup = 1;
						int win = 0;
						if(k >= p) win = 1;
						best = Math.max(best,win+go(pos+1,left-sup));
					}
		return memo[pos][left] = best;
	}
}
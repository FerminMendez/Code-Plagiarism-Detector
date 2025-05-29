import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B {
	public static void main(String args[]) {
		try {
			String fileName = "C:\\Users\\Lenovo Z370\\Desktop\\gcj\\comp-2012\\B-small-attempt0.in";
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
			int t = Integer.parseInt(br.readLine());
			for(int i=0; i<t; i++) {
				String[] vals = br.readLine().split("\\s+");
				int n = Integer.parseInt(vals[0]);
				int s = Integer.parseInt(vals[1]);
				int p = Integer.parseInt(vals[2]);
				int[] scores = new int[n];
				int tn=n+3;
				for(int j=3; j<tn; j++) {
					scores[j-3] = Integer.parseInt(vals[j]);
				}
				
				System.out.println("Case #" + (i+1) + ": " + (solve(n, s, p, scores)));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static int solve(int n, int s, int p, int[] scores) {
		List<Triplet[]> list = new ArrayList<Triplet[]>(n);

		int sn = 0, fn = 0;
		for(int i=0; i<n; i++) {
			Triplet[] t = Triplet.getTriplets(scores[i], p);
			if(t != null) {
				list.add(t);
				if(t[1] != null) {
					sn++;
				}
				
				fn++;
//				System.out.print(scores[i] + "=[" + t[0] + " & " + t[1] + "]; ");
			}
		}

//		System.out.println();
		
		long[] ca = new long[fn];
		Arrays.fill(ca, 0);
		long c = computeCombination(sn, s);
		long mc = computeCombination(sn-1, s-1);

		int max = 0;
//		System.out.println("Combi: " + c);
		for(long i=0; i<c; i++) {
			int st = s;
			int lmax = 0;
			for(int j=0; j<fn; j++) {
				Triplet[] t = list.get(j);
				if(st > 0 && t[1] != null && ca[j] < mc) {
					ca[j]++;
					if(t[1] != null) {
						if(t[1].max >= p) lmax++;
						st--;
//						System.out.print(t[1] + " ");
					} else {
						if(t[0] != null && t[0].max >= p) lmax++;
//						System.out.print(t[0] + " ");
					}
				} else {
					if(t[0] != null && t[0].max >= p) lmax++;
//					System.out.print(t[0] + " ");
				}
			}
			
			if(lmax > max) {
				max = lmax;
			}
			
//			System.out.println();
		}
		
		return max;
	}
	
	private static long computeCombination(int n, int r) {
		long nf = 1;
		for(int i=n; i>r; i--) {
			nf *= i;
		}
		
		int nmr = n-r;
		long nrf = 1;
		for(int i=nmr; i>1; i--) {
			nrf *= i;
		}
		
		return nf/nrf;
	}
	
	private static class Triplet {
		int total;
		int max;
		boolean isSurprise;
		
		int s1,s2,s3;
		
		public Triplet(int s1, int s2, int s3, boolean isSurprise) {
			this.total = s1+s2+s3;
			this.max = Math.max(s1, Math.max(s2, s3));
			this.isSurprise = isSurprise;
			
			this.s1 = s1;
			this.s2 = s2;
			this.s3 = s3;
		}
		
		public static Triplet[] getTriplets(int s, int p) {
			int is = s/3;
			int rs = s%3;

			int s1 = is;
			int s2 = is;
			int s3 = is;

			Triplet res0 = null, res1 = null;
			int sm3 = s%3;
			if(sm3 == 2) {
				res0 = new Triplet(s1, s2+1, s3+1, false);

				if(s3+2 < 11) {
					res1 = new Triplet(s1, s2, s3+2, true);
				}
			} else if(sm3 == 1) {
				res0 = new Triplet(s1, s2, s3+1, false);
				if(s1-1 >0 && s2+1 < 11 && s3+1 <11) {
					res1 = new Triplet(s1-1, s2+1, s3+1, true);
				}
			} else {
				res0 = new Triplet(s1, s2, s3, false);
				if(s1-1 >0 && s3+1 <11) {
					res1 = new Triplet(s1-1, s2, s3+1, true);
				}
			}
				
			if((res0 == null || res0.max < p) && (res1 == null || res1.max <p)) {
				return null;
			}
			
			Triplet[] res = new Triplet[2];
			if(res0 != null && res0.max >= p) res[0] = res0;
			if(res1 != null && res1.max >= p) res[1] = res1;
			
			return res;
		}
		
		public String toString() {
			return "(" + s1 + ", " + s2 + ", " + s3 + ")";
		}
	}
}

import java.util.ArrayList;
import java.util.Scanner;


public class Recycle2 {

	
	private static int solve(int L, int H) {
		class Slice {
			int L,H,mul,dig;
			Slice(int LL,int HH,int Mull,int digg) {
				L=LL; H=HH; mul=Mull; dig=digg;
			}
			public String toString() { return String.format("%d-%d, %d(%d)", L,H,mul,dig); }
		}
			
		ArrayList<Slice> slices = new ArrayList<Slice>();
			
		int k = 10, d=1;
		int l = L, h=H;
		while(true) {
			if (l>=k) {
				k*=10;d++;
				continue;
			}
			if (h<k) {
				slices.add( new Slice(l,h,k/10,d));
				break;
			} else {
				slices.add( new Slice(l,k-1,k/10,d));
				l=k;
				k=k*10;d++;
				continue;
			}
		}
		
		class Pair {
			int i,j;
			Pair(int ii,int jj) {i=ii;j=jj;}
			boolean equal(Pair p) {
				return p.i==i && p.j==j;
			}
			public String toString() { return String.format("(%d,%d)",i,j); }
		}
		
		ArrayList<Pair> ps = new ArrayList<Pair>();
		
		int ret = 0;
		//System.out.println(slices);
		for(Slice slice:slices) {
			for(int i=slice.L; i<=slice.H; i++) {
				int n=i;
				ArrayList<Integer> past = new ArrayList<Integer>();
				for (int j=0;j<(slice.dig-1);j++) {
					int dd=n%10;
					n=(n/10)+dd*slice.mul;
					if (n>i && n<=slice.H && !past.contains(n)) {
						//System.out.println("checking (" + i + ", " + n + ")");
						/*Pair p=new Pair(i,n);
						for(Pair c:ps) {
							if (c.equal(p)) {
								System.out.println("Duplicate: " + p);
							}
						}
						ps.add(p);*/
						ret++;
						past.add(n);
					}
				}
				
			}
		}
	
		return ret;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int T = in.nextInt();
		for(int t=1;t<=T;t++) {
			int L = in.nextInt();
			int H = in.nextInt();
			System.out.printf("Case #%d: %d%n", t, solve(L,H));
		}

	}

}

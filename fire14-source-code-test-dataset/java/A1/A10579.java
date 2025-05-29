import java.util.Scanner;


public class Main {
	
	static int solve( Scanner in ) {
		int N, S, p, ti, sol=0;
		double div = 0.0;
		N = in.nextInt();
		S = in.nextInt();
		p = in.nextInt();
		double req = 0.0;
		double min = 0.0;
		if(p>0) {
			req = (p*3-2)/3.0;
			if(p==1)
				min = 1.0/3.0;
			else
				min = (p*3-4)/3.0;
		}
		while(N-->0) {
			ti = in.nextInt();
			if(ti>0)
				div = ti/3.0;
			else
				div = 0.0;
			if(div>=req) {
				sol++;
			}else if( S>0 && div>=min ) {
				S--;
				sol++;
			}
		}
		return sol;
	}
	
	public static void main ( String args[] ) {
		int T; 
		Scanner in = new Scanner(System.in);
		T = in.nextInt();
		int cnt=0;
		int sol;
		for( cnt=1; cnt<=T; cnt++ ) {
			sol = solve( in );
			System.out.printf("Case #%d: %d\n", cnt, sol);
		}

	}
}

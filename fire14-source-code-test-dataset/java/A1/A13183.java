import java.util.Scanner;

public class DancingGooglers {
	public static void main( String args[] ) {
		new DancingGooglers();
	}
	
	public DancingGooglers() {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for( int j=0; j<T; j++ ) {
			System.out.println( "Case #"+ (j+1) + ": " + doCase(sc) );
		}
	}
	
	public int doCase( Scanner sc ) {
		int N = sc.nextInt();
		int S = sc.nextInt();
		int p = sc.nextInt();
		
		int naturalP    = 0;
		int surprisingP = 0;
		for( int j=0; j<N; j++ ) {
			int points = sc.nextInt();
			
			if( p + Math.max(p-1,0) + Math.max(p-1,0) <= points )
				naturalP++;
			else if( p + Math.max(p-2,0) + Math.max(p-2,0) <= points )
				surprisingP++;
		}
		
		return naturalP + Math.min(surprisingP, S);
	}
}

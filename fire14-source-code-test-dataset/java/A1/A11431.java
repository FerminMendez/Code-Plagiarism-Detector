import java.util.*;

public class Dancing {
	public static void main( String[] args ) {
		Scanner scan = new Scanner(System.in);
		int cases = scan.nextInt();
		for (int i = 0; i < cases; i++) {
			int count = 0;
			int n = scan.nextInt();
			int s = scan.nextInt();
			int p = scan.nextInt();
			for( int j = 0; j < n; j++) {
				int score = scan.nextInt();
				if( reg(score) >= p ) {
					count++;
				}
				else if( s > 0 && spec(score) >= p ) {
					count++;
					s--;
				}
			}
			System.out.println("Case #" + (i+1) + ": " + count);			
		}
	}
	
	public static int reg(int n) {
		if( n == 0) {
			return 0;
		}
		else if(n == 2 || n == 1) {
			return 1;
		}
		else if( (n%3) == 0) {
			return (n/3);
		}
		else if( (n%3) == 1) {
			return (n/3) + 1;
		}
		else if( (n%3) == 2) {
			return (n/3)+1;
		}
		return 0;
	}
	
	public static int spec(int n) {
		if( n== 0 ) {
			return 0;
		}
		else if(n == 1) {
			return 1;
		}
		else if(n == 2) {
			return 2;
		}
		else if( (n%3) == 0) {
			return (n/3)+1;
		}
		else if( (n%3) == 1) {
			return (n/3) + 1;
		}
		else if( (n%3) == 2) {
			return (n/3)+2;
		}
		return 0;
	}
}

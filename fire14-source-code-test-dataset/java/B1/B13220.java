import java.util.Scanner;

public class NumberRecycling {
	public static void main( String args[] ) {
		new NumberRecycling();
	}
	
	public NumberRecycling() {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for( int j=1; j<=T; j++ ) {
			System.out.println( "Case #"+ j + ": " + doCase(sc) );
		}
	}
	
	public int doCase( Scanner sc ) {
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int pairs = 0;
		for( int i=A+1; i<=B; i++ )
			pairs += numberOfLowerPairNumbers(A,i);
		
		return pairs;
	}
	
	public int numberOfLowerPairNumbers( int lowerBound, int num ) {
		String number = Integer.toString(num);
		String tmp    = new String(number);
		
		int result = 0;
		
		for( int i=0; i<number.length()-1; i++ ) {
			tmp = tmp.substring(1) + tmp.charAt(0);
			
			if( tmp.charAt(0) == '0' )
				continue;
			
			int shiftedNum = Integer.parseInt(tmp);
			
			if( shiftedNum == num )
				break;
			
			if( shiftedNum < num && shiftedNum >= lowerBound )
				result++;
		}
		
		return result;
	}
}
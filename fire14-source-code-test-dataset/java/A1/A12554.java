
import java.util.*;

public class DancingWithGooglers {
	public static void main( String[] args ) {
	    Scanner in = new Scanner( System.in );
	    int T = in.nextInt();
	    
	    for( int z = 1; z <= T; z++ ) {
	    	int N = in.nextInt();
	    	int S = in.nextInt();
	    	int p = in.nextInt();
	    	
	    	int count = 0;
	    	
	    	for( int i = 0; i < N; i++ ) {
	    		int sum = in.nextInt();
	    		int avg = sum / 3;
	    		
	    		if( Math.ceil( sum / 3.0 ) >= p ) {
	    			count++;
	    		} else if( S > 0 ) {
	    			boolean flag = false;
	    			
	    			for( int a = 0; a <= 10; a++ ) {
	    				for( int b = 0; b <= 10; b++ ) {
	    					int c = sum - a - b;
	    					
	    					if( c < 0 || c > 10 || max3( a, b, c )-min3( a, b, c ) > 2 ) {
	    						continue;
	    					}
	    					
	    					if( max3( a, b, c ) >= p ) {
		    					S--;
		    					count++;
		    					flag = true;
		    					break;
	    					}
		    			}
	    				
	    				if( flag ) {
	    					break;
	    				}
	    			}
	    		}
	    	}
	    	
	    	System.out.println( "Case #" + z + ": " + count );
	    }
    }
	
	public static int max3( int a, int b, int c ) {
		return Math.max( a, Math.max( b, c ) );
	}
	
	public static int min3( int a, int b, int c ) {
		return Math.min( a, Math.min( b, c ) );
	}
}

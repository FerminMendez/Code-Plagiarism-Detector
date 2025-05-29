/**
 * C.java
 * @author Joel C. Soares
 */

import java.util.Scanner;
import java.util.HashSet;
 
public class C 
{
	public static int inv( int n, int l )
	{
		int x = n % 10, p = ( int ) Math.pow( 10, l - 1 );
		
		for( int i = 0; i < l - 1; i++ )
		{			
			x = x * 10 + n / p;
			n = n % p;
			p = p / 10;
		}
		
		return x;
	} // fim de método
	
	public static int length( int n )
	{	
		int i = 0;
	
		if( n == 0 )
			return 1;
			
		while( n != 0 )
		{
			n = n / 10;
			i++;
		}
		
		return i;
	} 
	
	public static void main( String args[] )
	{
		Scanner input = new Scanner( System.in );
		int t, a, b, n, q, p, l, total, count;
		HashSet<Integer> set = new HashSet<Integer>();
		
		t = input.nextInt();
		for( int i = 0; i < t; i++ )
		{
			a = input.nextInt();
			b = input.nextInt();
			
			// computa resultado
			set.clear();
			total = 0;
			for( n = a; n < b; n++ )
			{
				q = n;
				l = length( q );
				set.add( q );
				count = 1;
				
				for( int j = 0; j < l - 1; j++ )
				{			
					q = inv( q, l );
					
					// verifica restricoes
					if( q >= a && q <= b && !set.contains( q ) )
					{
						set.add( q );
						count++;
					} // fim de if
				} 
				total += ( count - 1 ) * count / 2;
			} // fim de for
			
			System.out.printf( "Case #%d: %d\n", i + 1, total );
		} 	
	}
}
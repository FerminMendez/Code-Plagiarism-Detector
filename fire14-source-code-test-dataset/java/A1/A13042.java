import java.util.*;
import java.io.*;

public class B
{
	public static void main( String args[] )throws Exception
	{
		Scanner in = new Scanner( System.in );
		int i, j, s, p, n, hasilBagi, score, sisa, max, test;
		
		test = in.nextInt();
		
		for( i = 0 ; i < test ; i++ )
		{
			n = in.nextInt();
			s = in.nextInt();
			p = in.nextInt();
			max = 0;
			
			for( j = 0 ; j < n ; j++ )
			{
				score = in.nextInt();	
				sisa = score % 3;
				hasilBagi = score / 3;
					
				if( sisa == 0 )
				{
					if( hasilBagi >= p )
						max++;
					else if( score != 0 && s != 0 && hasilBagi + 1 >= p )
					{
						max++;
						s--;
					}
				}
				else if( sisa == 1 )
				{
					if( hasilBagi + 1 >= p )
						max++;
				}
				else
				{
					if( hasilBagi + 1 >= p )
						max++;
					else if( s != 0 && hasilBagi + 2 >= p )
					{
						max++;
						s--;
					}
				}
			}
			
			System.out.println( "Case #" + (i+1) + ": " + max );
		}
	}
}
import java.util.*;
import java.io.*;

public class C
{
	public static void main( String args[] )throws Exception
	{
		ArrayList<String> arr = new ArrayList<String>();
		Scanner in = new Scanner( System.in );
		String nStr, pref, suff;
		int i, j, a, b, count, test, lengthN, temp, lengthTemp;
		
		test = in.nextInt();
		
		for( i = 0 ; i < test ; i++ )
		{
			a = in.nextInt();
			b = in.nextInt();
			count = 0;
			arr.clear();
			
			int low = a;
			
			if( a < 10 )
			{
				a = 10;
			}
			
			while( a < b )
			{
				nStr = Integer.toString( a );
				lengthN = nStr.length();
				
				for( j = 1 ; j < lengthN ; j++ )
				{
					pref = nStr.substring( 0, lengthN - j );
					suff = nStr.substring( lengthN - j, lengthN );
					//if( i == 3 )
						//System.out.println( pref + " " + suff );
					String tempStr = suff + pref;
					temp = Integer.parseInt( tempStr );
					lengthTemp = Integer.toString( temp ).length();
					
					if( lengthTemp == lengthN && temp != a )
					{
						String ct = nStr + tempStr;
						if( !arr.contains( ct ) && temp <= b && temp >= low )
						{
							arr.add( ct );
							arr.add( tempStr + nStr );
							//if( i == 3 )
								//System.out.println( a + " " + temp );
							count++;
						}
					}
					else
					{
						//if( i == 3 )
							//System.out.println( "GA MASUK " + a + " " + temp );
					}
				}
				
				//System.out.println();
				a++;
			}
				 
			
			System.out.println( "Case #" + (i+1) + ": " + count );
		}
	}
}

class Pair
{
	int x;
	int y;

	public Pair( int x, int y )
	{
		this.x = x;
		this.y = y;
	}
}	
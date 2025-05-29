

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmallMain 
{
	public static void main( String arg[] )
		throws IOException
	{
		BufferedReader reader = new BufferedReader( new InputStreamReader( System.in ) );
		String line = null;
		int test = 0;
		int testCases = 0;
		while( ( line = reader.readLine() ) != null && test <= testCases )
		{
			if( line != null && !line.isEmpty() )
			{
				String tokens[] = line.split( " " );
				if( tokens.length == 1 && testCases == 0 )
				{
					testCases = Integer.parseInt( tokens[ 0 ] );
				}
				else if( tokens.length == 2 )
				{
					++test;
					int start = Integer.parseInt( tokens[ 0 ] );
					int end = Integer.parseInt( tokens[ 1 ] );
					int counter = 0;
					for( int i = start; i <= end; ++i )
					{
						for( int j = start; j <= end; ++j )
						{
							if( i < j )
							{
								for( int s = 1; s < ( "" + j ).length(); ++s )
								{
									if( i == moveDigits( j, s ) )
									{
										++counter;
										break;
									}
								}
							}
						}
					}
					System.out.println( "Case #" + ( test ) + ":  "+ counter );
				}
				else
				{
					System.out.println( "Invalid length: " + tokens.length + " line: " + line );
				}
			}
		}
		reader.close();
	}
	
	private static int moveDigits( int number, int digits )
	{
		int r;
		String n = "" + number;
		String end = n.substring( n.length() - digits );
		String start = n.substring( 0, n.length() - digits );
	//	System.out.println( "N: " + number + " d: " + digits + " start: " + start + " end: " + end );
		r = Integer.parseInt( end + start );
		return r;
	}
}

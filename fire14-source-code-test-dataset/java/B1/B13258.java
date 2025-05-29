import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

@SuppressWarnings( "nls" )
public class R0C
{
  public static void main( final String[] args ) throws IOException
  {
    final Scanner in = new Scanner( new File( "R0C.txt" ) );
    final FileWriter out = new FileWriter( "R0C.out" );

    final int n = in.nextInt();
    in.skip( in.delimiter() );

    for( int i = 0; i < n; i++ )
      out.write( "Case #" + (i+1) + ": " + countAllRecycledNumbersBetween( in.nextInt(), in.nextInt() ) + "\n" );

    in.close();
    out.close();
  }

  static int countAllRecycledNumbersBetween( final int a, final int b )
  {
    final int digits = 1 + (int)Math.floor( Math.log10( a ) );
    final int firstDigitMult = (int)Math.pow( 10., digits - 1 );

    final boolean[] visited = new boolean[ b - a + 1 ];
    int count = 0;

    for( int i = 0; i <= b - a; i++ )
    {
      if( visited[ i ] ) continue;
      visited[ i ] = true;
      int subCount = 1;

      int x = a + i;

      for( int j = 1; j < digits; j++ )
      {
        x = x / 10 + x % 10 * firstDigitMult;

        if( ( x >= a ) && ( x <= b ) && !visited[ x - a ] )
        {
          visited[ x - a ] = true;
          subCount++;
        }
      }

      count += subCount * ( subCount - 1 ) / 2;
    }

    return count;
  }
}

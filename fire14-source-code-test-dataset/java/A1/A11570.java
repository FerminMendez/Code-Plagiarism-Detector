import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class B {
	/**
	 * @param args
	 */
	public static void main( String[] args ) {
		try {
			String fileName = "B-small-attempt0";// "B-test";// "B-large";// 
			BufferedReader inFile = new BufferedReader( new FileReader(
					new File( fileName+".in" ) ) );
			PrintStream outFile = new PrintStream(
					new FileOutputStream( fileName+".out" ));

			String line = inFile.readLine();
			int tests = Integer.parseInt( line );
			for (int test = 0; test < tests; test++) {
				line = inFile.readLine();
				String[] ss = line.split( " " );
				int n = Integer.parseInt( ss[0] );
				int s = Integer.parseInt( ss[1] );
				int p = Integer.parseInt( ss[2] );
				int ans = 0;
				for ( int i = 0; i < n; i++ ) {
					int a = Integer.parseInt( ss[i+3] );
					if ( p + 2*Math.max( p-1, 0 ) <= a ) ans++;
					else if ( s > 0 && p + 2*Math.max( p-2, 0 ) <= a ){
						ans++;
						s--;
					}
				}
				outFile.println( "Case #" + (test+1) + ": " + ans );
			}
			inFile.close();
			outFile.close();

		} catch ( IOException e ) {
			e.printStackTrace();
		}
	}

}



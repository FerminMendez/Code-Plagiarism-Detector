import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Input {
	BufferedReader reader;
	StringTokenizer st = new StringTokenizer("");


	public Input( BufferedReader reader_ ) { reader = reader_; }


	public Input( InputStream in_ ) {
		reader = new BufferedReader( new InputStreamReader( in_ ) );
	}


	public Input( String fileName ) throws Exception {
		reader = new BufferedReader( new FileReader( new File( fileName ) ) );
	}

	public String getToken() throws IOException {
		while( !st.hasMoreTokens() ) {
			String line = reader.readLine();
			if ( line == null )
				return null;
			st = new StringTokenizer( line );
		}
		return st.nextToken();
	}

	public String getLine() throws IOException {
		String line = reader.readLine();
		return line;
	}
	
	public int getInt() throws Exception {
		int ret = Integer.parseInt( getToken() );
		return ret;
	}
}
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Speak implements Runnable {

	BufferedReader in;
	BufferedWriter out;
	static String inputFile = "";
	static String outputFile = "";
	
	static {
		inputFile = Speak.class.getName() + ".in";
		outputFile = Speak.class.getName() + ".out";
	}
	
	public int iread() throws Exception {
		return Integer.parseInt(readword());
	}
	
	public double dread() throws Exception {
		return Double.parseDouble(readword());
	}
	
	public long lread() throws Exception {
		return Long.parseLong(readword());
	}
	
	public String readword() throws Exception {
		int c = in.read();
		while( c >= 0 && c <= ' ' ) {
			c = in.read();
		}
		if( c < 0 ) return "";
		StringBuilder bld = new StringBuilder();
		while( c > ' ' ) {
			bld.append((char)c);
			c = in.read();
		}
		return bld.toString();
	}
	
	public void solve() throws Exception {
		
		int t = iread();
		for (int i = 0; i < t; i++) {
			int r = 0;
			int n = iread();
			int s = iread();
			int p = iread();
			//if (p == 0) {
				//r = n;
			//} else {
				int p3 = 3 * p;
				for (int j = 0; j < n; j++) {
					int score = iread();
					if (score == 0) {
						continue;
					} else if (score >= p3 - 2) {
						r++;
					} else if (score >= p3 - 4 && s != 0) {
						r++;
						s--;
					}
				}
			//}
			if(p==0){
			r=n;
			}
			out.write("Case #" + (i + 1) + ": " + r + "\n");
		}
	}
	
	public void run() {
		try {
			in = new BufferedReader( new FileReader( inputFile ));
			out = new BufferedWriter( new FileWriter( outputFile ));
//			in = new BufferedReader( new InputStreamReader(System.in));
//			out = new BufferedWriter( new OutputStreamWriter(System.out));
			solve();
			out.flush();
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new Thread( new Speak()).start();
	}

}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B {

	int N = 0;
	int S = 0;
	int P = 0;
	
	ArrayList<Integer> nrs;
	
	public B(BufferedReader reader) throws IOException {
		String line = reader.readLine();
		StringTokenizer token = new StringTokenizer(line, " ");
		N = Integer.parseInt(token.nextToken());
		S = Integer.parseInt(token.nextToken());
		P = Integer.parseInt(token.nextToken());
		
		nrs = new ArrayList<Integer>();
		
		for (int i = 0; i<N; i++) {
			int nr = Integer.parseInt(token.nextToken());
			nrs.add(nr);
		}
		
	}
	
	public int solve() {
		
		int result = 0;
		
		int P3 = P * 3;
		
		for( Integer nr : nrs) {
			
			// impossible case;
			if (nr < P ) {
				continue;
			}
			
			// is not surprising?
			if ((nr + 2) >= P3) {
				result++;
				continue;
			}
			
			if (((nr + 4) >= P3) && (S > 0)) {
				result++;
				S--;
				continue;
			}
		}
	
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		String inputFile = args[0];
		BufferedReader reader = new BufferedReader(new FileReader(inputFile
				+ ".in"));
		FileWriter outFile = new FileWriter(inputFile + ".out");
		PrintWriter out = new PrintWriter(outFile);
		String strNrLines = reader.readLine();
		int nrLines = Integer.parseInt(strNrLines);
		for (int i = 1; i <= nrLines; i++) {
			B b = new B(reader);
			out.println("Case #" + i + ": " + b.solve());
		}
		reader.close();
		out.close();
	}

}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class B {
	BufferedReader in;
	BufferedWriter out;
	static String inputFile = "B.in";
	static String outputFile = "B.out";
	
	public String readWord() throws Exception {
		int c = in.read();
		while (c>=0 && c<=' ') {
			c = in.read();
		}
		if (c < 0) {
			return "";
		}
		StringBuilder builder = new StringBuilder();
		while( c > ' ' ) {
			builder.append((char)c);
			c = in.read();
		}
		return builder.toString();
	}

	public int nonsurpMax(int totalP) {
		int result = totalP/3;
		if (totalP - result*3 > 0) result++;
		return result;
	}
	
	public void solve() throws Exception {
		int cases = Integer.parseInt(readWord());
		for (int i = 0; i<cases; i++) {
			StringBuilder builder = new StringBuilder();
			builder.append("Case #" + (i+1) + ": ");
			int count = 0;
			int N = Integer.parseInt(readWord());
			int S = Integer.parseInt(readWord());
			int p = Integer.parseInt(readWord());
			for (int j = 0; j<N; j++) {
				int t = Integer.parseInt(readWord());
				int max = nonsurpMax(t);
				if (max >= p) count++;
				if ((max<10) && (max > 0) && (max == p-1) && (S>0)) {
					count++;
					S--;
				}
			}
			builder.append("" + count);
			if (i < cases-1) builder.append("\n");
			out.write(builder.toString());
		}
	}
	
	public static void main(String[] args) {
		B start = new B();
		start.run();
	}
	
	public void run() {
		try {
			in = new BufferedReader(new FileReader(inputFile));
			out = new BufferedWriter(new FileWriter(outputFile));
			solve();
			out.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

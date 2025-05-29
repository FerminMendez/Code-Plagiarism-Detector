import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class C {
	BufferedReader in;
	BufferedWriter out;
	static String inputFile = "C.in";
	static String outputFile = "C.out";

	public Boolean recycled(int n, int m) {
		Boolean result = false;
		String mString = Integer.toString(m);
		String nString = Integer.toString(n);
		String temp;
		int nlen = nString.length();
		int mlen = mString.length();
		for (int a = 0; a < (mlen-nlen); a++) {
			nString = "0" + nString;
		}
		for (int i = 1; i < mlen; i++) {
			temp = switcher(nString,i);
			if (temp.equals(mString)) result = true;
		}
		return result;
	}
	
	public String switcher(String str, int a) {
		int len = str.length();
		StringBuilder builder = new StringBuilder();
		builder.append(str.substring(len-a, len));
		builder.append(str.substring(0,len-a));
		return builder.toString();
	}
	
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
	
	public void solve() throws Exception {
		int cases = Integer.parseInt(readWord());
		for (int i = 0; i<cases; i++) {
			int A = Integer.parseInt(readWord());
			int B = Integer.parseInt(readWord());
			int count = 0;
			StringBuilder builder = new StringBuilder();
			builder.append("Case #" + (i+1) + ": ");
			for (int m=A; m<=B; m++) {
				for (int n = A; n<m; n++) {
					if (recycled(n,m)) count++;
				}
			}
			builder.append("" + count);
			if (i < cases-1) builder.append("\n");
			out.write(builder.toString());
		}
	}
	
	public static void main(String[] args) {
		C start = new C();
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

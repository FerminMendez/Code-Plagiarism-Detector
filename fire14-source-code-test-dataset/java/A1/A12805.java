import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class DancingWithTheGooglers {
	String filename;
	BufferedReader br;
	PrintWriter pw;
	
	public DancingWithTheGooglers(String filename) throws FileNotFoundException {
		this.filename = filename;
		br = new BufferedReader(new FileReader(filename));
		pw = new PrintWriter("output-2.txt");
	}
	
	public void processInput() throws NumberFormatException, IOException {
		StringBuffer sb = new StringBuffer();
		int numCases = Integer.parseInt(br.readLine());
		for(int i=0; i<numCases; i++) {
			sb.append("Case #" + (i+1) + ": " + processCase(br.readLine()));
			if(i!=numCases-1) sb.append("\n");
		}
		pw.print(sb.toString());
		
		br.close();
		pw.close();
	}
	
	private int processCase(String inputCase) {
		String[] s = inputCase.split(" ");
		int N = Integer.parseInt(s[0]);
		int S = Integer.parseInt(s[1]);
		int p = Integer.parseInt(s[2]);
		int[] totals = new int[N];
		int count = 0;
		
		for(int i=0; i<N; i++) {
			totals[i] = Integer.parseInt(s[3+i]);
		}
		for(int i=0; i<N; i++) {
			int total = totals[i];
			if(total<p || total < 3*p-4) continue;
			else if(total <= 3*p-3 && S>0) { S--; count++; }
			else if(total > 3*p-3) count++;
		}
		return count;
	}
}

class Main2 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		DancingWithTheGooglers d = new DancingWithTheGooglers("B-small-attempt0.in.txt");
		d.processInput();
	}
}

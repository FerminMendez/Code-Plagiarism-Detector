import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;


public class RecycledNumbers {
	String filename;
	BufferedReader br;
	PrintWriter pw;
	
	public RecycledNumbers(String filename) throws FileNotFoundException {
		this.filename = filename;
		br = new BufferedReader(new FileReader(filename));
		pw = new PrintWriter("output-3.txt");
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
	
	Set<Integer> visitedSet;
	
	private int processCase(String inputCase) {
		String[] s = inputCase.split(" ");
		int A = Integer.parseInt(s[0]);
		int B = Integer.parseInt(s[1]);
		visitedSet = new HashSet<Integer>();
		int res = 0;
		
		for(int i=A; i<=B; i++) {
			if(!visitedSet.contains(i))
				res+= process(i, A, B);
		}
		return res;
	}
	
	private int process(final int n, final int A, final int B) {
		String s = Integer.toString(n);
		int count=0;
		
		for(int i=s.length()-1; i>0; i--) {
			String s1 = s.substring(i) + s.substring(0, i);
			int num = Integer.parseInt(s1);
			visitedSet.add(num);
			if(num!=n && num>=A && num<=B) { if(num<n) System.out.println(num + ", " + n); else System.out.println(n + ", " + num); count++; }
		}
		visitedSet.add(n);
		return (count==0) ? 0 : (count+1)*(count)/2;
	}
}

class Main3 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		RecycledNumbers r = new RecycledNumbers("C-small-attempt0.in.txt");
		r.processInput();
	}
}
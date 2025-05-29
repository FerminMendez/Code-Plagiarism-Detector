import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class DancingWithTheGooglers {
	public static File input;
	public static FileReader inputreader;
	public static BufferedReader in;

	public static File output;
	public static FileWriter outputwriter;
	public static BufferedWriter out;

	public static BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	public static StringTokenizer st;
	
	public static void main(String[] args) {
		try {
			
			String name = "input-2";
			setInput(name);
			setOutput(name + ".out");
			
			int cases = getInt();
			
			for(int caseNr = 1; caseNr <= cases; caseNr++) {
				int N = getInt(), S = getInt(), p = getInt();
				
				int[] scoreArr = new int[N];
				
				for(int i=0; i<N;i++) {
					scoreArr[i] = getInt();
				}
				// System.out.println("Case #"+caseNr+". N: " + N + ", S: " + S + ", p: " + p);
				print("Case #"+caseNr+": ");
				print(""+getMax(S, scoreArr, p));
				print("\n");
			}
			
			out.flush();
			out.close();
			in.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static int getMax(int surprising, int[] scoreArr, int scoreGoal) {
		return getMaximumOfIndexRecursive(scoreArr.length-1, surprising, scoreArr, scoreGoal, 0);
	}
	
	public static int getMaximumOfIndexRecursive(int index, int surprisingLeft, int[] scoreArr, int scoreGoal, int tempGoal) {
		if (index == -1) return 0;
		
		int thisGoal;
		
		//System.out.println("scoreGoal: " + scoreGoal + ", tempGoal: " + tempGoal);
		if (tempGoal > 10) return 0+getMaximumOfIndexRecursive(index-1, surprisingLeft, scoreArr, scoreGoal, 0);
		
		thisGoal = (tempGoal > 0) ? tempGoal : scoreGoal;

		
		double _a = (double) ((scoreArr[index] - thisGoal) / 2.0);
		double _b = _a;
		
		int a = (int) Math.floor(_a);
		int b = (int) Math.ceil(_b);
		
		a = Math.max(a, 0);
		b = Math.max(b, 0);
		
		int diff = Math.max(Math.max(Math.abs(a-b), Math.abs(a-thisGoal)), Math.abs(b-thisGoal));
		
		boolean scoreOk = (a >= 0 && a <= 10 && b >= 0 && b <= 10 && (a + b + thisGoal == scoreArr[index])) ? true : false;
		
		//System.out.println("Hmm.. case: " + scoreArr[index] + ". Values: " + thisGoal + ", " + a + ", " + b + ". (_a och _b)" + _a + ", " + _b);
		
		if (scoreOk && diff < 2) {
			//System.out.println("YES");
			return 1+getMaximumOfIndexRecursive(index-1, surprisingLeft, scoreArr, scoreGoal, 0);
		} else if (scoreOk && diff == 2 && surprisingLeft > 0) {
			//System.out.println("YES");
			return 1+getMaximumOfIndexRecursive(index-1, surprisingLeft-1, scoreArr, scoreGoal, 0);
		} else if (tempGoal == 0) {
			//System.out.println("NO");
			return 0+getMaximumOfIndexRecursive(index, surprisingLeft, scoreArr, scoreGoal, scoreGoal+1);
		} else {
			//System.out.println("NO");
			return 0+getMaximumOfIndexRecursive(index, surprisingLeft, scoreArr, scoreGoal, tempGoal+1);
		} 
	}
	
	// -------------------- I/O stuff -------------------------
	public static void setInput(String filename) throws IOException {
		input = new File(filename);
		inputreader = new FileReader(input);
		in = new BufferedReader(inputreader);
	}
	
	public static void setOutput(String filename) throws IOException {
		output = new File(filename);
		outputwriter = new FileWriter(output);
		out = new BufferedWriter(outputwriter);
	}

	
	static void print(String s) throws IOException {
		System.out.print(s);
		out.write(s);
	}
	
	static String readLine() throws IOException {
		//return stdin.readLine();
		return in.readLine();
	}

	static String getToken() throws IOException {
		while (st == null || !st.hasMoreTokens()) st = new StringTokenizer(readLine());
		
		return st.nextToken();
	}
	
	static int getInt() throws IOException {
		return Integer.parseInt(getToken());
	}

	static String getChar() throws IOException {
		return getToken();
	}
	
	static String getLine() throws IOException {
		return readLine();
	}
}

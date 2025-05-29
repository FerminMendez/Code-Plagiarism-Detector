import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class RecycledNumbers {
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
			
			String name = "input-3";
			
			setInput(name);
			setOutput(name + ".out");
			
			int cases = getInt();
			
			for(int caseNr = 1; caseNr <= cases; caseNr++) {
				int A = getInt(), B = getInt();
				
				print("Case #"+caseNr+": ");
				print(""+getRecycledPairs(A, B));
				print("\n");
			}
			
			out.flush();
			out.close();
			in.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static int getRecycledPairs(int start, int stop) {
		int pairs = 0;
		
		ArrayList<MyTuple> pairsList = new ArrayList<MyTuple>();
		
		String startAsString = ""+start;
		int numberOfDigits = startAsString.length();
		
		for(int i = start+1; i <= stop; i++) {
			int oldVersion = i;
			int newVersion = i;
			String rotator = i+"";
			
			for(int j = 1; j < numberOfDigits; j++) {
				rotator = moveDigitFromBackToFront(rotator);
				newVersion = Integer.parseInt(rotator);
				
				if (newVersion >= start && newVersion <= stop && newVersion < oldVersion) {
					//System.out.println("Found pair (" + newVersion + ", " + oldVersion + ")");
					
					MyTuple pairTuple = new MyTuple(newVersion, oldVersion);
					
					if (!pairsList.contains(pairTuple)) {
						pairs++;
						pairsList.add(pairTuple);
					}
				}
			}
		}
		
		return pairs;
	}
	
	public static String moveDigitFromBackToFront(String toMove) {
		String lastDigit = toMove.substring(toMove.length()-1);
		String toReturn = lastDigit + toMove.substring(0, toMove.length()-1);
		
		return toReturn;
	}
	
	private static class MyTuple {
		public int x, y;
		
		public MyTuple(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public boolean equals(Object o) {
			if (o instanceof MyTuple) {
				MyTuple t = (MyTuple) o;
				if (this.x == t.x && this.y == t.y) return true;
			}
			
			return false;
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



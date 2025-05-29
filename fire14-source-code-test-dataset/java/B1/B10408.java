import java.io.*;
import java.util.*;

public class Main {
	
	Scanner in;
	PrintWriter out;
	
	static final String problemName = "C";
	
	static void asserT(boolean e) {
		if (!e) {
			throw new Error();
		}
	}
		
	int solveOne(int a, int b) {
		int count = 0;
		int nDigits = ("" + a).length();
		int maxDivisor = 1;
		for (int i = 1; i < nDigits; i++) {
			maxDivisor *= 10;
		}
		
		for (int i = a; i <= b; i++) {
			int maxD = maxDivisor;
			int divisor = 10;
			ArrayList <Integer> list = new ArrayList<Integer>();  
			for (int j = 1; j < nDigits; j++) {
				if (i % divisor >= divisor / 10) {
					int rem = i % divisor;
					int top = i / divisor;
					
					int value = rem * maxD + top;
					
					if (!list.contains(value ) && i < value && value <= b) {
						//out.println(i + ": " + value);
						list.add(value);
						count++;
					}
				}
				divisor *= 10;
				maxD /= 10;
			}
		}
		return count;
	}
	
	void solve() {
		
		int nTests = in.nextInt();
		in.nextLine();
		for (int i = 0; i < nTests; i++) {
			out.println("Case #" + (i+1) + ": " + solveOne(in.nextInt(), in.nextInt()));
		}
	}
	
	void run() {
		try {
			in = new Scanner(new FileReader("C:/GCJ/" + problemName + ".in"));
			out = new PrintWriter(new FileWriter("C:/GCJ/" + problemName + ".out"));
		} catch (IOException e) {
			in = new Scanner(System.in);
			out = new PrintWriter(System.out);
		//	throw new Error();
		}
		
		try {
			solve();
		} finally {
			out.close();
		}
	}

	public static void main(String[] args) {
		new Main().run();
	}
}
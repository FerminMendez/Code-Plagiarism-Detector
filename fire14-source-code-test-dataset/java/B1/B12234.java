package gcj2012;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;

public class C {
public static void main(String[] args) throws Exception {
		
		BufferedReader f = new BufferedReader(new FileReader("C-small-attempt0.in"));
		PrintStream out = new PrintStream(new File("output.txt"));
		int t = Integer.parseInt(f.readLine());
		
		for (int i = 1; i <= t; i++) {
			String[] g = f.readLine().split(" ");
			int a = Integer.parseInt(g[0]);
			int b = Integer.parseInt(g[1]);
		
			out.println("Case #" + i + ": " + solve(a,b) );
		}
	}

private static int solve(int a, int b) {
	int counter=0;
	for (int n = a; n < b; n++) {
		for (int m = n+1; m <=b; m++) {
			if(isRec(n,m))
				counter++;
		}
	}
	return counter;
}

private static boolean isRec(int n, int m) {
	String digitsm = Integer.toString(m);
	for (int i = 1; i < digitsm.length(); i++) {
		String s = digitsm.substring(i) + digitsm.substring(0,i);
		if(n==Integer.parseInt(s))
			return true;
	}
	return false;
}
}

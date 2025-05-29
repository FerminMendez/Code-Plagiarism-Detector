package qualification2012;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class C {

	private final String f = "src\\qualification2012\\C-small-attempt0";
	private BufferedReader in;
	private PrintWriter out;
	private StringTokenizer token;
		

	
	private C() throws IOException {
		in = new BufferedReader(new FileReader(f+".in"));
		out = new PrintWriter(f + ".out");
		eat("");

		int t = nextInt();
		for (int i = 1; i <= t; i++) {
			write("Case #"+i+": ");
			solve();
		}
		
		in.close();
		out.close();
	}
	
	private void solve() throws IOException {	
		int a = nextInt();
		int b = nextInt();
		if (a < 10){
			write(0 + "\n");
			return;
		}
		
		int pair = 0;
		for (int i = a; i <= b; i++) {
			char[] digits = Integer.toString(i).toCharArray();
			char[] tmp = new char[digits.length];
			
			ArrayList<Integer> al = new ArrayList<>();
			for (int start = 1; start < digits.length; start++) {
				int number = 0;
				
				for(int x = 0; x + 1 < digits.length; x++) {
					tmp[x] = digits[x + 1];
					number += Math.pow(10, (digits.length - x - 1)) * (digits[x + 1] - '0');
				}
				tmp[digits.length - 1] = digits[0];
				number += digits[0] - '0';
				digits = tmp.clone();
				
				if (number >= a && number <= b && i > number) {
					if(!al.contains(number)) {
						al.add(number);
						pair++;
					}
				}
			}
		}
			
		write(pair + "\n");	
	}

	private String nextLine() throws IOException {
		return in.readLine();
	}
	
	private String next() throws IOException {
		while (!token.hasMoreTokens()) {
			String line = in.readLine();
			if (line == null) {
				return null;
			}
			eat(line);
		}
		return token.nextToken();
	}
		
	private int nextInt() throws IOException {
		return Integer.parseInt(next());
	}
	
	private long nextLong() throws IOException {
		return  Long.parseLong(next());
	}
	
	private void eat(String s) {
		token = new StringTokenizer(s);
	}

	private void write(String s) {
		System.out.print(s);
		out.print(s);
	}
	
	public static void main(String[] args) {
		try {
			new C();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}


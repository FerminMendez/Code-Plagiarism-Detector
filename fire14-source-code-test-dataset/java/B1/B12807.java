package com.evolve.codejam2012.qualification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Pair {
	private int a;
	private int b;

	Pair(int a, int b) {
		if (a > b) {
			this.b = a;
			this.a = b;
		} else {
			this.a = a;
			this.b = b;
		}
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		return true;
	}
	
	
}

public class Recycled {

	private static final String TEST_FILE = "C-small-attempt0.in";
	private PrintWriter pw = null;
	private BufferedReader br = null; 		
	
	Recycled(boolean skip) throws IOException {
		String outFile = TEST_FILE.replace(".in", ".out");
		//System.out.println(outFile);
		this.pw = new PrintWriter(new FileWriter(outFile));
		if (skip)
			return;
		
		File file = new File(TEST_FILE);
		if (file.exists()) {
			br = new BufferedReader(new java.io.FileReader(TEST_FILE));
		} else {
			br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
		}
	}	
	
	void doit() throws NumberFormatException, IOException {
		int testsNumber = Integer.parseInt(br.readLine());
		
		System.out.println(testsNumber);
		
		for (int i = 1; i <= testsNumber; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			System.out.println(A + " " + B);
			
			int num = check(A, B);
			
			System.out.println(num);
			
			pw.println("Case #" + i + ": " + num);
		}
		pw.flush();
		pw.close();
	}
	
	int check(final int A, final int B) {
		Set<Pair> set = new HashSet<Pair>();
		
		for (int n = A; n < B; n++) {
			String str = Integer.toString(n);
			
			// ile rotacji: str.length - 1
			int rotations = str.length() - 1;
			
			for (int j = 0; j < rotations; j++) {
				str = rotate(str);
				
				// skip numbers starting with 0: 
				if (str.startsWith("0")) {
					continue;
				}
				
				// construct new number:
				int m = Integer.parseInt(str);
				
				// check: n < m
				if (!(n < m)) {
					continue;
				}
				
				// check m <= B
				if (m > B) {
					continue;
				}
				
				
				Pair pair = new Pair(n, m);
				set.add(pair);
				
				
				//System.out.println(n + ", " + m);
			}
			//System.out.println(str);
		}
		return set.size();
	}
	
	static String rotate(String str) {
		char ch = str.charAt(str.length() - 1);
		char[] arr = new char[1];
		arr[0] = ch;
		return new String(arr).concat(str.substring(0, str.length() - 1));
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.out.println(rotate("1"));
		
		new Recycled(false).doit();

	}


}

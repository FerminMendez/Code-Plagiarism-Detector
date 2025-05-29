package c;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.AttributedCharacterIterator;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) {
		InputStream inputStream;
		try {
			inputStream = new FileInputStream("input.txt");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		OutputStream outputStream;
		try {
			outputStream = new FileOutputStream("output.txt");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		InputReader in = new InputReader(inputStream);
		PrintWriter out = new PrintWriter(outputStream);
		Numbers solver = new Numbers();
		int testCases = in.nextInt();
		for (int i = 1; i <= testCases; i++)
			solver.solve(i, in, out);

		out.close();
	}
}

class InputReader {
	private BufferedReader reader;
	private StringTokenizer tokenizer;

	public InputReader(InputStream stream) {
		reader = new BufferedReader(new InputStreamReader(stream));
		tokenizer = null;
	}

	public String next() {
		while (tokenizer == null || !tokenizer.hasMoreTokens()) {
			try {
				tokenizer = new StringTokenizer(reader.readLine());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		return tokenizer.nextToken();
	}

	public boolean haveNextInCurrentLine() {
		return (tokenizer != null && tokenizer.hasMoreTokens());
	}

	public int nextInt() {
		return Integer.parseInt(next());
	}
}

class Numbers {

	public void solve(int testCase, InputReader in, PrintWriter out) {
		int a = in.nextInt();
		int b = in.nextInt();
		int count = 0;
		int[] contains = new int[b + 1];
		
		System.out.println("Case #" + testCase + " a: " + a + " b: " + b);
		
		for(int i = a; i <= b; i++){
			String s = Integer.toString(i);
			//System.out.println(" " + s);
			for(int ii = 1, size = s.length(); ii < size; ii++){
				StringBuilder sb = new StringBuilder();
				String newNumber = sb.append(s.substring(ii, size)).append(s.substring(0, ii)).toString();
				if(newNumber.charAt(0) == '0')
					continue;
				
				int newInt = Integer.valueOf(newNumber);
				if(newInt >= a && newInt < i && contains[newInt] != i){
					contains[newInt] = i;
					count++;
					System.out.println(" " + s + " " + newInt);
				}
			}
		}

		out.println("Case #" + testCase + ": " + count);
		System.out.println("Case #" + testCase + ": " + count);
	}
}
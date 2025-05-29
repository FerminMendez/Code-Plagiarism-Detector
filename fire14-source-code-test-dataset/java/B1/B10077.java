package jamo;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RecycledNumbers {

	public static void main(String[] args) {
		List<String> lines = readFromFile("rnumbers.txt");
		int number = Integer.parseInt(lines.get(0));
		int a = 0;
		int b = 0;

		for (int i = 1; i <= number; i++) {
			String[] a_b = lines.get(i).split(" ");
			a = Integer.parseInt(a_b[0]);
			b = Integer.parseInt(a_b[1]);

			System.out.println( "Case #"+i+": "+checkPair(a, b));

		}

	}

	public static int sumOfDigits(Integer number) {
		int sum = 0;
		String n = number.toString();
		char[] digits = n.toCharArray();
		for (int i = 0; i < digits.length; i++) {

			sum += Integer.parseInt(Character.toString(digits[i]));
		}

		return sum;
	}

	public static boolean same(String a, String b) {
		char[] _a = a.toCharArray();
		char[] _b = b.toCharArray();
		if (_a.length != _b.length) {
			return false;

		}
		Arrays.sort(_a);
		Arrays.sort(_b);
		String a_ = new String(_a);
		String b_ = new String(_b);

		return a_.equals(b_);
	}

	public static List<Integer> iterations(Integer a) {
		char[] a_ = a.toString().toCharArray();

		List<Integer> out = new ArrayList<Integer>();
		String start = new String(a_);

		for (int i = 0; i < a_.length; i++) {
			if (out.contains(Integer.parseInt(start))) {

			} else {
				out.add(Integer.parseInt(start));
				start = next(start);
			}

		}

		return out;
	}

	public static String next(String val) {
		char[] a_ = val.toCharArray();
		char[] x = new char[a_.length];
		for (int i = 1; i < a_.length; i++) {
			x[i - 1] = a_[i];
		}
		x[a_.length - 1] = a_[0];
		return new String(x);
	}

	public static int nextPair(Integer a) {
		char[] a_ = a.toString().toCharArray();
		char[] x = new char[a_.length];
		for (int i = 1; i < a_.length; i++) {
			x[i - 1] = a_[i];
		}
		x[a_.length - 1] = a_[0];
		return Integer.parseInt(new String(x));
	}

	public static int checkPair(int a, int b) {
		int pairs = 0;
		int previ = 0;
		int prevnext = 0;
		int next = 0;
		if (b < 10)
			return 0;
		for (int i = a; i <= b; i++) {
			List<Integer> its = iterations(i);
			for (int j = 0; j < its.size(); j++) {
				next = its.get(j);
				if (next <= b && next > i) {
					 
					pairs += 1;
				}
				prevnext = next;

			}
			previ = i;

		}
		return pairs;
	}

	public static List<String> readFromFile(String filename) {
		List<String> lines = new ArrayList<String>();
		try {
			FileInputStream fstream = new FileInputStream(filename);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				lines.add(strLine);
				// System.out.println(strLine);
			}

			in.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}

		return lines;
	}

}

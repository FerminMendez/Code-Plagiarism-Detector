package net.anzix.learn.codejam.qr12;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class RecycledNumbers {

	private InputStream input;
	private PrintStream output;

	public RecycledNumbers() {

	}

	public RecycledNumbers(InputStream input, PrintStream output) {
		super();
		this.input = input;
		this.output = output;
	}

	public RecycledNumbers(File inputFile, File outputFile) throws Exception {
		this.input = new FileInputStream(inputFile);
		output = new PrintStream(outputFile);

	}

	public void run() throws Exception {
		Scanner scanner = new Scanner(input);
		int lines = scanner.nextInt();
		for (int i = 0; i < lines; i++) {
			int from = scanner.nextInt();
			int to = scanner.nextInt();

			output.println("Case #" + (i + 1) + ": " + calcNo(from, to));
		}
		output.close();
	}

	public static void main(String[] args) {
		try {
			new RecycledNumbers(new File(args[0]), new File(args[1]))
					.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int calcNo(int from, int to) {
		int res = 0;
		Set<String> s = new HashSet();
		for (int m = from; m <= to; m++) {
			for (int p : convertedNumbers(m)) {
				if (p > m && p <= to) {
					if (s.contains(m + " " + p)) {
						System.out.println(m + " " + p + " " + from + " " + to);
					}
					s.add(m + " " + p);

					res++;
				}
			}
		}
		return res;
	}

	public Set<Integer> convertedNumbers(int original) {
		int digits = (int) Math.ceil(Math.log10(original));
		if (digits < 1) {
			return new HashSet<Integer>();
		}
		int pow = (int) Math.pow(10, digits - 1);
		int l = pow;
		int s = 10;
		Set<Integer> res = new HashSet<Integer>();
		for (int i = 0; i < digits - 1; i++) {
			if (original % s != 0) {
				int x = (original % s) * pow + original / s;
				if (x != original && x > l) {
					res.add(x);
				}
			}
			s *= 10;
			pow /= 10;
		}
		return res;
	}
}

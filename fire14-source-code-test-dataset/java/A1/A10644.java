package net.anzix.learn.codejam.qr12;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DancingWithTheGooglers {

	private InputStream input;
	private PrintStream output;

	public DancingWithTheGooglers() {

	}

	public DancingWithTheGooglers(InputStream input, PrintStream output) {
		super();
		this.input = input;
		this.output = output;
	}

	public DancingWithTheGooglers(File inputFile, File outputFile)
			throws Exception {
		this.input = new FileInputStream(inputFile);
		output = new PrintStream(outputFile);

	}

	public void run() throws Exception {
		Scanner scanner = new Scanner(input);
		int lines = scanner.nextInt();
		for (int i = 0; i < lines; i++) {
			int n = scanner.nextInt();
			int s = scanner.nextInt();
			int p = scanner.nextInt();
			List<Integer> maxs = new ArrayList<Integer>();
			for (int j = 0; j < n; j++) {
				maxs.add(scanner.nextInt());
			}
			output.println("Case #" + (i + 1) + ": "
					+ getNoOfBigger(maxs, s, p));
		}
		output.close();
	}

	public static void main(String[] args) {
		try {
			new DancingWithTheGooglers(new File(args[0]), new File(args[1]))
					.run();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getNoOfBigger(List<Integer> maxPoints, int noOfSuprisings,
			int limit) {
		int no = 0;
		for (Integer point : maxPoints) {
			if (point == 0) {
				if (limit == 0) {
					no++;
				}
			} else {
				int ns = maxNo(point, false);
				int s = maxNo(point, true);
				if (noOfSuprisings < 1 && ns >= limit) {
					no++;
				}
				if (noOfSuprisings > 0) {
					if (ns < limit && s >= limit) {
						noOfSuprisings--;
						no++;
					} else if (ns >= limit) {
						no++;
					}

				}
			}

		}

		return no;

	}

	public int maxNo(int sumPoint, boolean suprising) {
		int c = sumPoint % 3;
		if (suprising) {
			switch (c) {
			case 0:
				return (sumPoint + 3) / 3;
			case 1:
				return (sumPoint + 2) / 3;
			case 2:
				return (sumPoint + 4) / 3;
			}
		} else {
			switch (c) {
			case 0:
				return (sumPoint + 0) / 3;
			case 1:
				return (sumPoint + 2) / 3;
			case 2:
				return (sumPoint + 1) / 3;
			}
		}
		throw new IllegalArgumentException();
	}
}

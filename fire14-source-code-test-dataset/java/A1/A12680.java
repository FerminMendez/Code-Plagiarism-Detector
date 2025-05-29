package com.piscessera.google.codejam.q02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class Q2 {

	private int t; // 0-100

	private int[] answer;

	public Q2() {
	}

	public Q2(int testcase) {
		this.t = testcase;
		this.answer = new int[this.t];
	}

	public void startProcess(String filename) {
		try {
			File inFile = new File("C://" + filename + ".in");

			if (inFile.exists()) {
				int lineNumber = 0;
				int input = 0;
				String[] question = null;
				InputStream in = new FileInputStream(inFile);
				BufferedReader br = new BufferedReader(new InputStreamReader(
						in, "utf-8"), 8);

				StringBuffer sb = new StringBuffer();

				String line = null;
				while ((line = br.readLine()) != null) {
					if (lineNumber == 0) {
						input = Integer.parseInt(line);
						question = new String[input];
					} else if (lineNumber > input) {
						continue;
					} else {
						question[lineNumber - 1] = line;
					}
					lineNumber++;
				}

				this.t = input;
				this.answer = new int[this.t];
				int count = 0;
				for (String q : question) {
					String[] vars = q.split(" ");

					int[] scores = new int[vars.length - 3];
					for (int i = 0; i < scores.length; i++) {
						scores[i] = Integer.parseInt(vars[i + 3]);
					}
					this.answer[count] = calculate(Integer.parseInt(vars[0]),
							Integer.parseInt(vars[1]),
							Integer.parseInt(vars[2]), scores);
					count++;
				}

				// set output
				StringBuffer outSb = new StringBuffer();
				int index = 0;
				for (int answer : this.answer) {
					outSb.append("Case #" + (index + 1) + ": " + answer + "\n");
					index++;
				}

				Writer out = new OutputStreamWriter(new FileOutputStream("C://"
						+ filename + ".out"), "utf-8");
				out.write(outSb.toString());
				out.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int calculate(int googlers, int surprising, int minScore,
			int[] scores) {
		int result = 0;

		int index = 0;
		for (int score : scores) {
			int base = score / 3;
			// int[] realScore = { base, base, base };

			// find score
			switch (score % 3) {
			case 0:
				// realScore[0] = base - 1;
				// realScore[1] = base;
				// realScore[2] = base + 1;

				if (base >= minScore) {
					result++;
				} else {
					if (surprising > 0 && base > 0 && (base + 1) >= minScore) {
						surprising--;
						result++;
					}
				}
				break;
			case 1:
				// realScore[0] = base - 1;
				// realScore[1] = base + 1;
				// realScore[2] = base + 1;

				if (base >= minScore || base + 1 >= minScore) {
					result++;
				} else {
					if (surprising > 0 && (base + 1) >= minScore) {
						surprising--;
						result++;
					}
				}

				break;
			case 2:
				// realScore[0] = base;
				// realScore[1] = base;
				// realScore[2] = base + 2;

				if (base >= minScore || base + 1 >= minScore) {
					result++;
				} else {
					if (surprising > 0 && (base + 2) >= minScore) {
						surprising--;
						result++;
					}
				}
				break;
			}
			index++;
		}
		System.out.println("Result: " + result);

		return result;
	}

	public static void main(String[] args) {
		Q2 obj = new Q2();
		obj.startProcess("codejam/B-small-attempt4");
	}

}

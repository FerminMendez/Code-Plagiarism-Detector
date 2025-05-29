package org.resec;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Dancing_With_the_Googlers {

	public static void main(String[] args) {
		String filename = "B-small-attempt5";
		String sep = java.io.File.separator;
		try {
			FileInputStream input = new FileInputStream("c:" + sep + filename
					+ ".in");
			FileOutputStream output = new FileOutputStream("c:" + sep
					+ filename + ".out");
			int T = Integer.parseInt(readLine(input));
			for (int i = 1; i <= T; i++) {
				String G = readLine(input);
				String outLine = "Case #" + i + ": ";
				Go(input, output, G, outLine);
			}
			input.close();
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String readLine(FileInputStream FIS) {
		boolean EOL = true;
		String S = "";
		int in = 0;
		try {
			do {
				in = FIS.read();
				if (in == -1 || in == '\n')
					EOL = false;
				else
					S += (char) in;
			} while (EOL);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return S;
	}

	public static int writeLine(FileOutputStream FOS, String S) {
		int i = 0;
		try {
			for (; i < S.length(); i++)
				FOS.write(S.charAt(i));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return i;
	}

	public static void Go(FileInputStream FIS, FileOutputStream FOS, String G,
			String outLine) {
		String[] data = G.split(" ");
		int N = Integer.parseInt(data[0]);
		int S = Integer.parseInt(data[1]);
		int p = Integer.parseInt(data[2]);
		int cases = 0;
		for (int i = 0; i < N; i++) {
			int score = Integer.parseInt(data[i + 3]);
			int base = (int) (score / 3);

			switch (score % 3) {
			case 0: {
				if (base >= p)
					cases++;
				else {
					if (S > 0 && base > 0 && base + 1 >= p) {
						cases++;
						S--;
					}
				}
				break;
			}
			case 1: {
				if (base >= p || base + 1 >= p)
					cases++;
				else {
					if (S > 0 && base + 1 >= p) {
						cases++;
						S--;
					}
				}
				break;
			}
			case 2: {
				if (base + 1 >= p || base >= p)
					cases++;
				else {
					if (S > 0 && base + 2 >= p) {
						cases++;
						S--;
					}
				}
				break;
			}
			}
		}
		writeLine(FOS, outLine + cases + '\n');
	}
}

package dancingWithTheGooglers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class DancingWithTheGooglers {
	public static void main(String[] args) {
		File inFile = new File(
				"C:\\Users\\Stef\\workspace\\Google Code Jam\\src\\dancingWithTheGooglers\\small.in");
		FileInputStream fis = null;
		Scanner in = null;

		FileWriter outFile;
		try {
			outFile = new FileWriter(
					"C:\\Users\\Stef\\workspace\\Google Code Jam\\src\\dancingWithTheGooglers\\small.out");
			BufferedWriter out = new BufferedWriter(outFile);

			try {
				fis = new FileInputStream(inFile);

				in = new Scanner(fis);
				int cases, googlers, surprises, result, no;
				cases = in.nextInt();

				for (int i = 0; i < cases; i++) {
					googlers = in.nextInt();
					surprises = in.nextInt();
					result = in.nextInt();
					no = 0;
					int[] totalScore = new int[googlers];
					for (int j = 0; j < googlers; j++)
						totalScore[j] = in.nextInt();
					for (int j = 0; j < googlers; j++)
						if (totalScore[j] % 3 == 0) {
							if (totalScore[j] / 3 >= result)
								no++;
							else if (totalScore[j] / 3 == result - 1 && totalScore[j]>0)
								if (surprises > 0) {
									no++;
									surprises--;
								}
						} else if (totalScore[j] % 3 == 1) {
							if (totalScore[j] / 3 >= result - 1)
								no++;
						} else {
							if (totalScore[j] / 3 >= result - 1)
								no++;
							else if (totalScore[j] / 3 == result - 2 && totalScore[j]<29)
								if (surprises > 0) {
									no++;
									surprises--;
								}
						}
					out.write("Case #" + (i + 1) + ": " + no + "\n");
				}

				fis.close();
				in.close();

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			out.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}

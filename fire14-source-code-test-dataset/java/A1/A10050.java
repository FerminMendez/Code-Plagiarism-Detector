import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class GooglerIdol {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		File sample = new File(
				"D:/Feng/Workspace/googlecodejam2012/problemB/in/sample.in");
		
		File in = new File(
				"D:/Feng/Workspace/googlecodejam2012/problemB/in/B-small-attempt1.in");

		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(
					"D:/Feng/Workspace/googlecodejam2012/problemB/out/out-attempt1.txt"));
			StringBuilder s;
			String line = "";
			int googlers, surprises, p = 0;
			int[] totalScores;
			int idols, chances = 0;
			int count = 1;
			Scanner scanner = new Scanner(in);
			// Ignore the first line showing total count
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				s = new StringBuilder("Case #");
				s.append(count);
				s.append(": ");
				line = scanner.nextLine();

				String[] tokens = line.split(" ");
				googlers = Integer.parseInt(tokens[0]);
				surprises = Integer.parseInt(tokens[1]);
				p = Integer.parseInt(tokens[2]);
				totalScores = new int[googlers];
				for (int i = 3; i < tokens.length; i++) {
					totalScores[i - 3] = Integer.parseInt(tokens[i]);
				}
				Arrays.sort(totalScores);

				idols = 0;
				chances = surprises;
				for (int j = googlers - 1; j >= 0; j--) {
					if (pass(p, totalScores[j], false)) {
						idols++;
					}
					else if (chances > 0 && pass(p, totalScores[j], true)) {
						idols++;
						chances--;
					}
				}

				s.append(idols);
				/*
				s.append("\ngooglers:");
				s.append(googlers);
				s.append(" surprises:");
				s.append(surprises);
				s.append(" p:");
				s.append(p);
				s.append("\nTotal Scores");
				s.append(Arrays.toString(totalScores));
				*/

				System.out.println(s);
				out.write(s.toString());
				out.newLine();
				count++;
			}
			scanner.close();
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean pass(int p, int totalScore, boolean surprise) {

		if (p == 0)
			return true;
		
		if (totalScore == 0)
			return false;

		int avg = totalScore / 3;
		if (avg >= p)
			return true;
		
		int diff = totalScore - (3 * avg);

		if (p - avg == 1 && diff > 0) {
			return true;
		}
		
		if (surprise && p - avg == 1 && diff == 0) {
			return true;
		}

		if (surprise && p - avg == 2 && diff > 1) {
			return true;
		}

		return false;
	}
}

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Reverser {

	private static int getMaxNormalCase(int score) {
		return (int) Math.ceil((double) score / 3);
	}

	private static int getMaxSurprisingCase(int score) {
		if (score >= 2 && score <= 28) {
			return (int) Math.round((double) score / 3) + 1;
		} else {
			return 0;
		}
	}

	public static void main(String[] args) {
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(new DataInputStream(
					new FileInputStream("B-small-attempt3.in"))));
			FileOutputStream fos = new FileOutputStream("output3.txt", true);
			Integer inputSize = Integer.parseInt(br.readLine());
			for (int i = 1; i <= inputSize; i++) {
				String line = br.readLine();
				int tallerOrEqualCounter = 0;
				/*
				 * 0 = N = amount of googlers 1 = S = number of surprisings 2 =
				 * p = reference till end ... score of each googler
				 */
				String[] splittedLine = line.split(" ");
				int surprisingCounter = Integer.parseInt(splittedLine[1]);
				int referenceVal = Integer.parseInt(splittedLine[2]);

				for (int n = 0; n < Integer.parseInt(splittedLine[0]); n++) {
					int playerNScore = Integer.parseInt(splittedLine[3 + n]);
					if (getMaxNormalCase(playerNScore) >= referenceVal) {
						tallerOrEqualCounter++;
					} else if (surprisingCounter > 0
							&& getMaxSurprisingCase(playerNScore) >= referenceVal) {
						tallerOrEqualCounter++;
						surprisingCounter--;
					}
				}

				ArrayList<Integer> usedPlayers = new ArrayList<Integer>();

				if (surprisingCounter > 0) {
					for (int n = 0; n < Integer.parseInt(splittedLine[0]); n++) {
						int playerNScore = Integer
								.parseInt(splittedLine[3 + n]);
						if (getMaxNormalCase(playerNScore) >= referenceVal
								&& getMaxSurprisingCase(playerNScore) >= referenceVal) {
							surprisingCounter--;
							usedPlayers.add(n);
						}
					}
				}

				if (surprisingCounter > 0) {
					for (int n = 0; n < Integer.parseInt(splittedLine[0]); n++) {
						int playerNScore = Integer
								.parseInt(splittedLine[3 + n]);
						if (getMaxNormalCase(playerNScore) < referenceVal
								&& getMaxNormalCase(playerNScore) < referenceVal) {
							surprisingCounter--;
						}
					}
				}

				if (surprisingCounter > 0) {
					for (int n = 0; n < Integer.parseInt(splittedLine[0]); n++) {
						int playerNScore = Integer
								.parseInt(splittedLine[3 + n]);
						if (getMaxNormalCase(playerNScore) >= referenceVal
								&& !usedPlayers.contains(n)
								&& playerNScore >= 2 && playerNScore <= 28) {
							tallerOrEqualCounter--;
							surprisingCounter--;
						}
					}
				}

				String output = "Case #" + i + ": " + tallerOrEqualCounter
						+ "\n";
				fos.write(output.getBytes());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

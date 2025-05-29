package main;

import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import qualificationRound.Dancing;
import qualificationRound.Googlerese;
import qualificationRound.Recycled;

import exception.GiveUpException;

public class Main {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		String inputFilename = "C-small-attempt0.in";
		String outputFilename = "C-small-attempt0.out";

		String output = "";

		FileHandling filesHandler = new FileHandling();

		FileReader file = null;

		Vector<String> inputVector = null;

		try {

			file = filesHandler.openFileForReading(inputFilename);
			inputVector = filesHandler.readLinesFromFile(file);
		} catch (GiveUpException e) {
			System.err.println("exiting..");
		} catch (IOException e) {
			System.err.println("error while reading..");
		}

		// ---------------| Place Code Here |-------------------------

		// output = Practice( inputVector );

		// output = QualificationRound_A(inputVector);
		// output = QualificationRound_B(inputVector);

		output = QualificationRound_C(inputVector);

		// -----------------| End of Code |---------------------------

		try {

			filesHandler.writeToFile(outputFilename, output);
			System.out.println("\n----------------------------------\n");
			System.out.println(output);
		} catch (GiveUpException e) {
			System.err.println("error while writing..");
		}
	}

	private static String QualificationRound_A(Vector<String> pInputVector) {

		String output = "";

		int T = Integer.valueOf(pInputVector.get(0));

		for (int i = 1; i <= T; i++) {

			String result = Googlerese.translate(pInputVector.get(i));

			output = output + "Case #" + i + ": " + result + "\n";
		}

		return output;
	}

	private static String QualificationRound_B(Vector<String> pInputVector) {

		String output = "";

		int T = Integer.valueOf(pInputVector.get(0));

		for (int i = 1; i <= T; i++) {

			String line[] = pInputVector.get(i).split(" ");

			int N = Integer.parseInt(line[0]);
			int S = Integer.parseInt(line[1]);
			int P = Integer.parseInt(line[2]);

			int[] Ti = new int[N];

			for (int j = 0; j < N; j++)
				Ti[j] = Integer.parseInt(line[j + 3]);

			int result = Dancing.howMany(N, S, P, Ti);

			output = output + "Case #" + i + ": " + result + "\n";
		}

		return output;
	}

	private static String QualificationRound_C(Vector<String> pInputVector) {

		String output = "";

		int T = Integer.valueOf(pInputVector.get(0));

		for (int i = 1; i <= T; i++) {

			String line[] = pInputVector.get(i).split(" ");

			int A = Integer.parseInt(line[0]);
			int B = Integer.parseInt(line[1]);

			int result = Recycled.howMany(A, B);

			output = output + "Case #" + i + ": " + result + "\n";
		}

		return output;
	}
}

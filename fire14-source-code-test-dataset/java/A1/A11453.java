package de.hg.codejam.tasks.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class Reader {

	public static String[] readFile(String path) {
		String[] input = null;

		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			int inputSize = Integer.parseInt(reader.readLine());
			input = new String[inputSize];

			for (int i = 0; i < inputSize; i++)
				input[i] = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return input;
	}
}

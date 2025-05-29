package de.hg.codejam.tasks.numbers.help;

public abstract class Converter {

	public static int[][] convert(String[] input) {
		int[][] output = new int[input.length][2];

		for (int i = 0; i < input.length; i++) {
			String[] seperatedNumbers = input[i].split(" ");

			output[i][0] = Integer.parseInt(seperatedNumbers[0]);
			output[i][1] = Integer.parseInt(seperatedNumbers[1]);
		}

		return output;
	}

	public static String[] convert(int[] input) {
		String[] output = new String[input.length];

		for (int i = 0; i < input.length; i++)
			output[i] = String.valueOf(input[i]);

		return output;
	}

}

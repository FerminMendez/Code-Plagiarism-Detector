package de.hg.codejam.tasks.dance.help;

public abstract class Converter {

	public static String[] convert(int[] input) {
		String[] output = new String[input.length];

		for (int i = 0; i < input.length; i++)
			output[i] = String.valueOf(input[i]);

		return output;
	}

}

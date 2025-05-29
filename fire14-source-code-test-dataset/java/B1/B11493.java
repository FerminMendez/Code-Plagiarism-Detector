package de.hg.codejam.tasks.numbers.controller;

import de.hg.codejam.tasks.io.Reader;
import de.hg.codejam.tasks.io.Writer;
import de.hg.codejam.tasks.numbers.help.Converter;
import de.hg.codejam.tasks.numbers.service.Calculator;

public class Test {

	public static void main(String[] args) {
		String inputPath = "file/C-small-attempt1.in";
		String outputPath = Writer.generateOutputPath(inputPath);

		System.out.println("=== READ FILE: " + inputPath + " ===");
		String[] input = Reader.readFile(inputPath);
		Writer.print(input);

		int[][] inputInts = Converter.convert(input);
		System.out.println("=== CALCULATION: Start ===");
		int[] results = Calculator.calculate(inputInts);
		System.out.println("=== CALCULATION: End ===");

		System.out.println("=== RESULTS ===");
		String[] resultStrings = Converter.convert(results);
		Writer.write(resultStrings);

		System.out.println("=== WRITE TO FILE: " + outputPath + " ===");
		Writer.write(resultStrings, outputPath);
		System.out.println("=== FILE WRITTEN ===");
	}

}

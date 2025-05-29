package de.hg.codejam.tasks.dance.controller;

import de.hg.codejam.tasks.dance.domain.Case;
import de.hg.codejam.tasks.dance.help.Converter;
import de.hg.codejam.tasks.dance.service.Calculator;
import de.hg.codejam.tasks.io.Reader;
import de.hg.codejam.tasks.io.Writer;

public class Test {

	public static void main(String[] args) {
		String inputPath = "file/B-small-attempt0.in";
		String outputPath = Writer.generateOutputPath(inputPath);

		System.out.println("=== READ FILE: " + inputPath + " ===");
		String[] input = Reader.readFile(inputPath);
		Writer.print(input);

		System.out.println("=== CASES ===");
		Case[] cases = new Case[input.length];
		for (int i = 0; i < input.length; i++) {
			cases[i] = Case.parse(input[i]);
			System.out.println(cases[i]);
		}

		System.out.println("=== CALCULATION: Start ===");
		int[] results = Calculator.calculate(cases);
		System.out.println("=== CALCULATION: End ===");

		System.out.println("=== RESULTS ===");
		String[] resultStrings = Converter.convert(results);
		Writer.write(resultStrings);

		System.out.println("=== WRITE TO FILE: " + outputPath + " ===");
		Writer.write(resultStrings, outputPath);
		System.out.println("=== FILE WRITTEN ===");
	}
}

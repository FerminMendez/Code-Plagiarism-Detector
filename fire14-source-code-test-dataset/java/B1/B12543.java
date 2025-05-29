package contest;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public abstract class ContestProblem {

	File inputFile = new File("input.txt");
	File outputFile = new File("output.txt");

	public ContestProblem() {

	}

	public ContestProblem(String inputFilename) {
		this.inputFile = new File(inputFilename);
		calcOutputFromInput();
	}

	public void run() throws Exception {
		BufferedReader in = new BufferedReader(new FileReader(inputFile));
		PrintWriter out = new PrintWriter(new FileWriter(outputFile));
		try {
			parseInput(new Input(in), out);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();
		in.close();
	}

	public abstract void parseInput(Input in, PrintWriter out);

	public static void runProblem(ContestProblem problem) {
		try {
			long start = System.currentTimeMillis();
			problem.run();
			long end = System.currentTimeMillis();
			System.out.format("Took: %d ms%n", end - start);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if (Desktop.isDesktopSupported()) {
				Desktop.getDesktop().open(problem.outputFile);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public File getInputFile() {
		return inputFile;
	}

	public ContestProblem setInputFile(File inputFile) {
		this.inputFile = inputFile;
		return this;
	}

	public File getOutputFile() {
		return outputFile;
	}

	public ContestProblem setOutputFile(File outputFile) {
		this.outputFile = outputFile;
		return this;
	}

	public ContestProblem calcOutputFromInput() {
		this.outputFile = new File(inputFile.getParentFile(), inputFile.getName() + "-output.txt");
		return this;
	}
}

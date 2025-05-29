package main;

import java.io.*;
import java.util.Scanner;

public class Main {
	static File problemFile = new File(System.getProperty("user.home") + "/Projects/java/CodeJam/DancingWithTheGooglers/B-small-attempt2.in");
	static File solutionFile = new File(System.getProperty("user.home") + "/Projects/java/CodeJam/DancingWithTheGooglers/B-small-attempt2.out");

	public static void main (String[] args) {
		Solver s = new Solver();
		try {
			Scanner input = new Scanner(new FileInputStream(problemFile));
			BufferedWriter outWriter = new BufferedWriter(new FileWriter(solutionFile));

			s.createSolution(input, outWriter);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}


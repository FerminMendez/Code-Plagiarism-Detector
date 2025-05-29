package base;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import assignments.AssignmentB;


public class Solver {
	public static void main(String... args) throws IOException {
		List<Assignment> assignments = readAssignments("test");
		PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));
		int i = 0;
		for (Assignment assignment : assignments) {
			String answer = "Case #" + ++i + ": " + assignment.solve();
			pw.println(answer);
			System.out.println(answer);
		}
		pw.flush();
		pw.close();

	}

	private static List<Assignment> readAssignments(String filename) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(filename));
		int amountOfAssignments = scanner.nextInt();
		scanner.nextLine();
		List<Assignment> result = new ArrayList<Assignment>();
		for (int i = 0; i < amountOfAssignments; i++) {
			result.add(AssignmentB.createFromScanner(scanner));
		}
		scanner.close();
		return result;
	}
}

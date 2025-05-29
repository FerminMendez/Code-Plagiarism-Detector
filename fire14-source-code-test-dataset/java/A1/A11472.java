import java.io.*;
import java.awt.*;
import java.lang.*;
import java.util.*;

public class SolutionTwo {
	public static void main(String[] args) {
		String fileName = null;
		if (args.length > 0) {
			fileName = args[0];
		}
		File file = null;
		Scanner fileScanner = null;
		Scanner lineScanner;
		try {
			file = new File(fileName);
			fileScanner = new Scanner(file);
			int numLines = Integer.parseInt(fileScanner.nextLine());
			for (int lineNumber = 1; lineNumber <= numLines; lineNumber++) {
				String line = fileScanner.nextLine();
				lineScanner = new Scanner(line);
				int numGooglers = lineScanner.nextInt();
				int numSuprisingAllowed = lineScanner.nextInt();
				int leastMaxScore = lineScanner.nextInt();
				int googlerMax = 0;
				int numSuprising = 0;
				int numNotSuprising = 0;
				for (int i = 0; i < numGooglers; i++) {
					googlerMax = lineScanner.nextInt();
					if (googlerMax < leastMaxScore) continue;
					// not suprising
					int testNum = leastMaxScore + (2 * (leastMaxScore - 1));
					if (testNum <= googlerMax) {
						numNotSuprising++;
						continue;
					}
					
					// suprising
					testNum = leastMaxScore + (2 * (leastMaxScore - 2));
					if (testNum <= googlerMax) {
						numSuprising++;
					}
				}
				int answer;
				if (numSuprising <= numSuprisingAllowed) {
					answer = numNotSuprising + numSuprising;
				} else {
					answer = numNotSuprising + numSuprisingAllowed;
				}
				System.out.print("Case #" + lineNumber + ": " + answer);
				System.out.println();
			}
		} catch (Exception e) {
			System.out.println("Error");
		}
	}
}

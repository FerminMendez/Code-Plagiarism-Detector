import java.io.*;
import java.util.*;

public class DancingWithGooglers {
	public static void main(String[] args) {
		try {
			FileWriter output = new FileWriter(new File("output.txt"));
			Scanner s = new Scanner(new File("input.txt"));
			int trials = s.nextInt();
			s.nextLine();
			for (int i = 0; i < trials; i++) {
				int n = s.nextInt();
				int numSupr = s.nextInt();
				int minScore = s.nextInt();
				int cutOff = minScore + Math.max((minScore - 1), 0) * 2;
				int suprisingCutOff = minScore + Math.max((minScore - 2), 0)
						* 2;
				int totalCount = 0;
				int numSuprising = 0;
				for (int b = 0; b < n; b++) {
					int num = s.nextInt();
					if (num >= cutOff)
						totalCount++;
					else if (num >= suprisingCutOff) {
						numSuprising++;
					}
				}
				output.write("Case #" + (i + 1) + ": ");
				output.write(""
						+ (totalCount + Math.min(numSuprising, numSupr)));
				output.write('\n');
			}
			s.close();
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

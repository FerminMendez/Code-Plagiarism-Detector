import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Inputter {

	public static ArrayList<Problem> getProblems(String file) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new FileReader(file));
		
		int numOfProblems = Integer.parseInt(in.readLine());
		
		ArrayList<Problem> problems = new ArrayList<Problem>(numOfProblems);
		
		String curLine = in.readLine();
		while (curLine != null) {
			String[] values = curLine.split("[ \t]");
			
			int googlers = Integer.parseInt(values[0]);
			int suprising = Integer.parseInt(values[1]);
			int best = Integer.parseInt(values[2]);
			
			int[] totals = new int[googlers];
			
			for (int i = 3; i < values.length; i++) {
				totals[i - 3] = Integer.parseInt(values[i]);
			}

			problems.add(new Problem(googlers, suprising, best, totals));
			
			curLine = in.readLine();
		}
		
		in.close();
		
		return problems;
	}
}

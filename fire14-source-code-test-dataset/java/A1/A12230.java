import java.io.IOException;
import java.util.ArrayList;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {

		ArrayList<Problem> problems = Inputter.getProblems("B-small-attempt2.in");
		long results[] = new long[problems.size()];
		
		for (int i = 0; i < results.length; i++) {
			results[i] = problems.get(i).solve();
		}

		Outputter.output(results);
	}

}

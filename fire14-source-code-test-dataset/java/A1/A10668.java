import java.io.IOException;
import java.util.StringTokenizer;

public class Judging {
	private int cases;

	public Judging() throws IOException {
		cases = Integer.valueOf(getLine());

		run();
	}

	public String getLine() throws IOException {
		String s = "";
		char c;
		while ((c = (char) System.in.read()) != '\n') {
			s += c;
		}
		return s;
	}

	public void run() throws IOException {
		Case curr;
		for (int i = 0; i < cases; i++) {
			curr = new Case(getLine());
			System.out.println("Case #" + (i+1) + ": " + curr.calculateNumBestResult());
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			new Judging();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class Case {
	private int numberOfGooglers;
	private int numberOfSuprisingScores;
	private int bestResult;
	private int[] scores;

	public Case(String line) {
		StringTokenizer tokens = new StringTokenizer(line);

		numberOfGooglers = Integer.valueOf(tokens.nextToken());
		numberOfSuprisingScores = Integer.valueOf(tokens.nextToken());
		bestResult = Integer.valueOf(tokens.nextToken());
		scores = new int[numberOfGooglers];

		for (int i = 0; i < numberOfGooglers; i++) {
			scores[i] = Integer.valueOf(tokens.nextToken());
		}
	}

	public int calculateNumBestResult() {
		int counter = 0;
		if (bestResult >= 2) {
			for (int i = 0; i < scores.length; i++) {
				if (scores[i] - (3*bestResult) >= -2)
					counter++;
				else if (scores[i] - (3*bestResult) >= -4) {
					if (numberOfSuprisingScores > 0) {
						counter++;
						numberOfSuprisingScores--;
					}
				}
			}
		} else if (bestResult == 1) {
			for (int i = 0; i < scores.length; i++) {
				if (scores[i] > 0)
					counter++;
			}
		} else if (bestResult == 0) {
			counter = scores.length;
		} else {
			System.err.println("Error!");
		}
		return counter;
	}

}
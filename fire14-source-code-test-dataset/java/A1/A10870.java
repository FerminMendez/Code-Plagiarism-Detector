import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class SurprisingTripletScorer {

	private int numGooglers;
	private int numSurprisingScores;
	private final int minScore;
	
	private int numPossibleSurprising;
	
	public SurprisingTripletScorer(int n, int s, int p) {
		this.numGooglers = n;
		this.numSurprisingScores = s;
		this.minScore = p;
		numPossibleSurprising = 0;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] input = null;
		try {
			input = readInput(args);
		} catch (IOException e) {
		}
		int cases = Integer.parseInt(input[0]);
		for (int i = 1; i <= cases; i++) {
			String[] line = input[i].split(" ");
			int N = Integer.parseInt(line[0]);
			int S = Integer.parseInt(line[1]);
			int p = Integer.parseInt(line[2]);
			
			SurprisingTripletScorer sts = new SurprisingTripletScorer(N, S, p);
			int[] scores = new int[N];
			for (int j = 0; j < N; j++) {
				scores[j] = Integer.parseInt(line[j+3]);
			}
			int max = sts.maxGooglersWithHighScores(scores);
			System.out.println("Case #"+i+": "+max);
		}

	}

	private int maxGooglersWithHighScores(int[] totalScores) {
		int runningTotal = 0;
		List<Integer> list = new ArrayList<Integer>();
		for (int ts : totalScores) {
			list.add(ts);
		}
		Collections.sort(list);
		for (Integer i : list) {
			// Find possible score outcome, check if it contains any number >=minScore
			if (containsHighScore(i)) {
				runningTotal++;
			}
		}
				
		return runningTotal;
	}
	
	private boolean containsHighScore(int totalScore) {
		int mod = totalScore % 3;
		if (totalScore == 0) {
			if (minScore > 0)
				return false;
			else if (minScore == 0)
				return true;
		}
		if (mod == 0) {
			if ((((double)totalScore)/3) >= minScore) {
				return true;
			} else if ((((double)totalScore)/3+1) >= minScore && numSurprisingScores > 0) {
				numSurprisingScores--;
				return true;
			}
		} else if (mod == 1) {
			if (Math.ceil(((double)totalScore)/3) >= minScore) {
				numPossibleSurprising++;
				return true;
			}
		} else {
			if (Math.floor(((double)totalScore)/3) >= minScore || Math.ceil(((double)totalScore)/3) >= minScore) {
				numPossibleSurprising++;
				return true;
			} else if ((Math.ceil(((double)totalScore)/3)+1) >= minScore  && numSurprisingScores > 0) {
				numSurprisingScores--;
				return true;
			}
		}
		numPossibleSurprising++;
		return false;
	}

	public static String[] readInput(String[] args) throws IOException {
		String[] str = new String[101];
		int numStrings = 0;

		// Buffer the input data
	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		// Read the data and store in a string array
		while (in.ready()) {
			str[numStrings] = in.readLine();
			numStrings++;
		}
		in.close();
	    
		return str;
	}
}

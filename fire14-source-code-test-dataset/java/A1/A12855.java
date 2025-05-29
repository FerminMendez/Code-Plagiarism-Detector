import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 */

/**
 * @author Shweta
 * 
 */
public class DancingGoogler {

	/**
	 * @param list
	 * @param minimumScore
	 * @param numberOfSurprisingResults
	 */
	private List<Googler> list;
	private int numberOfSurprisingResults, minimumScore;
	private int maxNumberOfGooglersForBestResult;

	public DancingGoogler(List<Googler> list, int numberOfSurprisingResults,
			int minimumScore) {
		this.list = list;
		Collections.sort(this.list);
		this.numberOfSurprisingResults = numberOfSurprisingResults;
		this.minimumScore = minimumScore;
		putScores(this.list);
		calculateAnswer();
	}

	/**
	 * 
	 */
	private void calculateAnswer() {
		for (Googler googler : this.list) {
			boolean minScoreGiven = false;
			for (int i = 0; i < 3; i++) {
				int score = googler.getScores()[i];
				if (score >= minimumScore) {
					minScoreGiven = true;
					break;
				}
			}
			if (minScoreGiven) {
				maxNumberOfGooglersForBestResult++;
			} else if (numberOfSurprisingResults > 0) {
				if (googler.getMaxScore() > 0) {
					googler.getScores()[1] = googler.getScores()[1] - 1;
					googler.getScores()[2] = googler.getScores()[2] + 1;

					if (googler.getScores()[2] >= minimumScore) {
						maxNumberOfGooglersForBestResult++;
						numberOfSurprisingResults--;
					}
				}
			}
		}
	}

	/**
	 * @param list2
	 */
	private void putScores(List<Googler> googlers) {
		for (Googler googler : googlers) {
			int maxScore = googler.getMaxScore();
			int[] scores = new int[3];
			int base = maxScore / 3;
			scores[0] = base;
			scores[1] = base;
			scores[2] = base;

			if (maxScore % 3 == 1) {
				scores[1] = base + 1;
			} else if (maxScore % 3 == 2) {
				scores[1] = base + 1;
				scores[2] = base + 1;
			}

			googler.setScores(scores);
		}
	}

	/**
	 * @return
	 */
	public int answer() {
		return maxNumberOfGooglersForBestResult;
	}

	public static void main(String args[]) throws Exception {
		BufferedReader bufferedReader = new BufferedReader(
				new FileReader(
						new File(
								"C:\\Documents and Settings\\Kamlesh\\Desktop\\codejam\\B-small-attempt0.in")));
		int numberOfTest = Integer.valueOf(bufferedReader.readLine());
		for (int i = 1; i <= numberOfTest; i++) {
			String line = bufferedReader.readLine();
			String tokens[] = line.split("\\ ");
			int n = Integer.valueOf(tokens[0]);
			int surprizingTriplets = Integer.valueOf(tokens[1]);
			int minimumScore = Integer.valueOf(tokens[2]);
			List<Googler> list = new ArrayList<Googler>();
			for (int j = 1; j <= n; j++) {
				int maxScore = Integer.valueOf(tokens[2 + j]);
				Googler googler = new Googler(maxScore);
				list.add(googler);
			}
			DancingGoogler dc = new DancingGoogler(list, surprizingTriplets,
					minimumScore);

			System.out.println("Case #" + i + ": " + dc.answer());

		}
	}

}

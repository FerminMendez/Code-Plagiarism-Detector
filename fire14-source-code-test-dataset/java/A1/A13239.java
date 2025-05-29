import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class DancingWithGooglers {

	public int numberOfGooglers;
	public int exptectedSurprisingScores;
	public int realSurprisingScores = 0;
	public int bestScore;
	public int googlersBetterThanBestScore = 0;

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		File file = new File("C:\\Users\\xebia\\Downloads\\B-small-attempt0.in");

		FileInputStream fis = new FileInputStream(file);
		DataInputStream in = new DataInputStream(fis);
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		int numberOfTestCases = new Integer(br.readLine());

		for (int k = 0; k < numberOfTestCases; k++) {
			DancingWithGooglers da = new DancingWithGooglers();
			String[] strings = br.readLine().split(" ");
			da.numberOfGooglers = new Integer(strings[0]);
			da.exptectedSurprisingScores = new Integer(strings[1]);
			da.bestScore = new Integer(strings[2]);
			for (int i = 0; i < da.numberOfGooglers; i++) {
				Googlers googler = new Googlers();
				int totalScore = new Integer(strings[3 + i]);
				googler.setTotalScore(totalScore);
				da.calculateOptimizedTriplet(googler);
			}
//			if (da.realSurprisingScores < da.exptectedSurprisingScores) {
//				da.googlersBetterThanBestScore = da.googlersBetterThanBestScore
//						- (da.exptectedSurprisingScores - da.realSurprisingScores);
//			}
			System.out.println("Case #" + (k+1) + ": " + da.googlersBetterThanBestScore);
		}

	}

	public void calculateOptimizedTriplet(Googlers googler) {
		if (googler.getTotalScore() >= ((3 * bestScore) - 2)) {
			googlersBetterThanBestScore++;
		} else if (googler.getTotalScore() == (3 * (bestScore) - 3)
				|| googler.getTotalScore() == (3 * (bestScore) - 4)) {
			
			if(googler.getTotalScore() == 0 || googler.getTotalScore() == 1){
				
			}else if (realSurprisingScores < exptectedSurprisingScores) {
				realSurprisingScores++;
				googlersBetterThanBestScore++;
			}
		}
	}

}

class Googlers {
	private int firstScore;
	private int secondScore;
	private int thirdScore;
	private int totalScore;
	private boolean surprisingScore = false;
	private boolean invalidScore = false;

	public Googlers() {
		// TODO Auto-generated constructor stub
	}

	public Googlers(int firstScore, int secondScore, int thirdScore) {
		this.firstScore = firstScore;
		this.secondScore = secondScore;
		this.thirdScore = thirdScore;
	}

	public void setFirstScore(int firstScore) {
		this.firstScore = firstScore;
	}

	public int getFirstScore() {
		return firstScore;
	}

	public void setSecondScore(int secondScore) {
		this.secondScore = secondScore;
	}

	public int getSecondScore() {
		return secondScore;
	}

	public void setThirdScore(int thirdScore) {
		this.thirdScore = thirdScore;
	}

	public int getThirdScore() {
		return thirdScore;
	}

	public int getHighestScore() {

		int highestScore = firstScore;
		if (secondScore > highestScore) {
			highestScore = secondScore;
		}
		if (thirdScore > highestScore) {
			highestScore = thirdScore;
		}

		return highestScore;

	}

	public int getSmallestScore() {
		int smallestScore = firstScore;
		if (secondScore < smallestScore) {
			smallestScore = secondScore;
		}
		if (thirdScore < smallestScore) {
			smallestScore = thirdScore;
		}

		return smallestScore;

	}

	public void setSurprisingScore(boolean surprisingScore) {
		this.surprisingScore = surprisingScore;
	}

	public boolean isSurprisingScore() {
		return surprisingScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setInvalidScore(boolean invalidScore) {
		this.invalidScore = invalidScore;
	}

	public boolean isInvalidScore() {
		return invalidScore;
	}

}

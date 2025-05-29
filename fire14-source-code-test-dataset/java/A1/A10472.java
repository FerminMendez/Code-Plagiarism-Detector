import java.util.Scanner;
class Another{
	private int total, modulo;
	public Another(int a){
		total = a;
		modulo = a % 3;
	}
	public int surprisingScore(){
		if (total < 3){
			return total;
		} else
		if (modulo == 2){
			return (total/3) + 2;
		} else {
			return (total/3) + 1;
		}
	}
	public int notSurprisingScore(){
		if (total < 2){
			return total;
		} else if (total == 2){
			return 1;
		} else
		if (modulo == 0){
			return (total/3);
		} else {
			return (total/3) + 1;
		}
	}
}
class DanceResult{
	private int[] myArray;
	private int arraySize, minimum, numberOfSurprises;
	private int[][] result;
	public DanceResult(int[] anArray, int min, int surprises){
		myArray = anArray;
		minimum = min;
		numberOfSurprises = surprises;
		arraySize = myArray.length;
		result = new int[arraySize][2];
	}
	public void generateScores(){
		for (int i = 0; i < arraySize; i++){
			int value = myArray[i];
			Another checkScore = new Another(value);
			int surprising = checkScore.surprisingScore();
			int notSurprising = checkScore.notSurprisingScore();
			result[i][0] = surprising;
			result[i][1] = notSurprising;
		}
		return;
	}
	public int solve(){
		int countSurprise = 0;
		int countNotSurprise = 0;
		for (int i = 0; i < arraySize; i++){
			if (result[i][0] >= minimum){
				countSurprise++;
			}
			if (result[i][1] >= minimum){
				countNotSurprise++;
			}
		}
		int difference = countSurprise - countNotSurprise;
		if (difference >= numberOfSurprises){
			return countNotSurprise + numberOfSurprises;
		} else
			return countSurprise;
	}
}
public class Dance {

	public static void main(String[] args) {
		int numberOfGooglers, numberOfSurprising, leastScore, numberOfCases, currentCase;
		int[] scores;
		DanceResult myResult;
		Scanner myScanner = new Scanner(System.in);
		numberOfCases = myScanner.nextInt();
		currentCase = 1;
		for (int j = 0; j < numberOfCases; j++){
			numberOfGooglers = myScanner.nextInt();
			numberOfSurprising = myScanner.nextInt();
			leastScore = myScanner.nextInt();
			scores = new int[numberOfGooglers];
			for(int i = 0; i < numberOfGooglers; i++){
				scores[i] = myScanner.nextInt();
			}
			myResult = new DanceResult(scores, leastScore, numberOfSurprising);
			myResult.generateScores();
			System.out.println("Case #" + currentCase + ": " + myResult.solve());
			currentCase++;
		}

		
	}

}

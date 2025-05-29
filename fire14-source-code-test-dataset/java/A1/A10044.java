import java.util.Scanner;
import java.util.ArrayList;

public class dancing {
	public static void main(String [] args){
		Scanner Keyboard = new Scanner(System.in);
		int testCases;
		ArrayList<String> input = new ArrayList<String>();
		ArrayList<Integer> totalPoints = new ArrayList<Integer>();
		int whitespaceNumber = 1;
		int previousWhitespace = 0;
		int numberOfGooglers = 0;
		int surprisingTriplet = 0;
		int bestResult = 0;
		int k = 0;
		int [] triplet = {0, 0, 0};
		int numberOfBestResults = 0;

		testCases = Keyboard.nextInt();
		Keyboard.nextLine();

		for (int i = 0; i < testCases; i++){
			input.add(Keyboard.nextLine());
		}

		for (int i = 0; i < testCases; i++){
			for (int j = 0; j < input.get(i).length(); j++){
				if (input.get(i).charAt(j) == ' '){
					if (whitespaceNumber == 1){
						numberOfGooglers = Integer.parseInt(input.get(i).substring(0, j));
						whitespaceNumber++;
						previousWhitespace = j;
					}
					else if (whitespaceNumber == 2){
						surprisingTriplet = Integer.parseInt(input.get(i).substring(previousWhitespace+1, j));
						whitespaceNumber++;
						previousWhitespace = j;
					}
					else if (whitespaceNumber == 3){
						bestResult = Integer.parseInt(input.get(i).substring(previousWhitespace+1, j));
						whitespaceNumber++;
						previousWhitespace = j;
					}
					else if (whitespaceNumber >= 4){
						totalPoints.add(Integer.parseInt(input.get(i).substring(previousWhitespace+1, j)));
						whitespaceNumber++;
						previousWhitespace = j;
					}
				}
			}
			totalPoints.add(Integer.parseInt(input.get(i).substring(previousWhitespace+1, input.get(i).length())));

			for (int b = 0; b < numberOfGooglers; b++){
				while(true){
					if (k + k + k < totalPoints.get(b)){
						k++;
					}
					else if (k + k + k > totalPoints.get(b)){
						if (k + k + (k-1) == totalPoints.get(b)){
							triplet[0] = k;
							triplet[1] = k;
							triplet[2] = k-1;
							break;
						}
						else if (k + (k-1) + (k-1) == totalPoints.get(b)){
							triplet[0] = k;
							triplet[1] = k-1;
							triplet[2] = k-1;
							break;
						}
					}
					else if (k + k + k == totalPoints.get(b)){
						triplet[0] = k;
						triplet[1] = k;
						triplet[2] = k;
						break;
					}
				}
				if (triplet[0] < bestResult && triplet[1] < bestResult && triplet[2] < bestResult && surprisingTriplet > 0){
					while (k < bestResult){
						k++;
					}
					if (k + k + (k-2) == totalPoints.get(b) && k >= bestResult && (k-2)>=0){
						triplet[0] = k;
						triplet[1] = k;
						triplet[2] = k-2;
						surprisingTriplet--;
					}
					else if (k + (k-1) + (k-2) == totalPoints.get(b) && k >= bestResult && (k-2)>=0){
						triplet[0] = k;
						triplet[1] = k-1;
						triplet[2] = k-2;
						surprisingTriplet--;
					}
					else if (k + (k-2) + (k-2) == totalPoints.get(b) && k >= bestResult && (k-2)>=0){
						triplet[0] = k;
						triplet[1] = k-2;
						triplet[2] = k-2;
						surprisingTriplet--;
					}
				}

				if (triplet[0] >= bestResult || triplet[1] >= bestResult || triplet[2] >= bestResult){
					numberOfBestResults++;
				}
				k = 0;
			}

			System.out.println("Case #" + (i+1) + ": " + numberOfBestResults);

			whitespaceNumber = 1;
			previousWhitespace = 0;
			numberOfGooglers = 0;
			surprisingTriplet = 0;
			bestResult = 0;
			numberOfBestResults = 0;
			totalPoints.clear();
		}


	}
}

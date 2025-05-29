package dancers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;

public class DancerEvaluation {

    private final int numberOfGooglers;
    private int surpriseCount;
    private final int bestScore;
    private final int[] lstOfPoints;

    public DancerEvaluation(int numberOfGooglers, int surpriseCount, int bestScore, int[] lstOfPoints) {
	this.numberOfGooglers = numberOfGooglers;
	this.surpriseCount = surpriseCount;
	this.bestScore = bestScore;
	this.lstOfPoints = lstOfPoints;

    }

    public int solve() {
	int countOfTotalDancers = 0;
	for (int i = 0; i < lstOfPoints.length; i++) {
	    int avg_point = lstOfPoints[i]/3;
	    int x = avg_point;
	    int y = avg_point;
	    int z = avg_point;

	    int leftOver = lstOfPoints[i] % 3;

	    switch (leftOver) {
	    case 0:
		if(avg_point + 1 == bestScore && surpriseCount > 0 && avg_point > 0){
		    z = z + 1;
		    x = x - 1;
		    surpriseCount--;
		}

   		break;
	    case 1:
		z = z + 1;
		break;
	    case 2:
		 if(surpriseCount > 0 && (z + 2) <= 10){
		    z = z + 2;
		    surpriseCount--;
		}else {
		    z = z+1;
		    y = y+1;
		}
		break;
	    }

	    if(Math.max(Math.max(x, y), z) >= bestScore){
		countOfTotalDancers++;
	    }

	}

	return countOfTotalDancers;
    }

    public static void main(String[] args) throws Exception{
	BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\maheshsa\\Desktop\\input.txt")));
	int numOfTestCases = Integer.parseInt(reader.readLine());
	FileWriter fw = new FileWriter(new File("C:\\Users\\maheshsa\\Desktop\\output.txt"));
	for (int i = 1; i <= numOfTestCases; i++) {
	    String[] inputAsString = reader.readLine().split(" ");
	    int[] input = new int[inputAsString.length];
	    for (int j = 0; j < inputAsString.length; j++) {
		input[j] = Integer.parseInt(inputAsString[j]);
	    }
	    int numberOfDancers = input[0];
	    int surpriseCount = input[1];
	    int bestScore = input[2];
	    int[] scores = Arrays.copyOfRange(input, 3, input.length);
	    fw.append("Case #" + i + ": " + new DancerEvaluation(numberOfDancers, surpriseCount, bestScore, scores).solve() + "\n");
	}

	fw.flush();

	reader.close();
	fw.close();

    }

}

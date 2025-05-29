package recycledNumbers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dancers.DancerEvaluation;

public class RecycledNumberFinder {

    public int findNumbers(int startPoint, int endPoint) {

	List<Pair> lstOfRecycledPairs = new ArrayList<RecycledNumberFinder.Pair>();

	for (int i = startPoint; i < endPoint; i++) {

	    String numberToBeChecked = Integer.toString(i);

	    char[] number = numberToBeChecked.toCharArray();

	    for (int j = 1; j < number.length; j++) {
		char[] prepend = Arrays.copyOfRange(number, number.length - j, number.length);
		char[] append = Arrays.copyOfRange(number, 0, number.length - j);
		String recycledNumberAsString = (new String(prepend) + new String(append));
		int recycledNumber = Integer.parseInt(recycledNumberAsString);
		if( recycledNumber <= endPoint && recycledNumber > i){
 		    Pair p = new Pair(i, recycledNumber);
 		    if(!lstOfRecycledPairs.contains(p))
 			lstOfRecycledPairs.add(p);
		}

	    }



	}


	return lstOfRecycledPairs.size();

    }

    public class Pair{
	private final int x;
	private final int y;

	public int getX() {
	    return x;
	}

	public int getY() {
	    return y;
	}

	public Pair(int x, int y) {
	    this.x = x;
	    this.y = y;

	}

	@Override
	public boolean equals(Object obj) {
	    Pair objPair = (Pair) obj;
	    return getX() == objPair.getX() && getY() == objPair.getY();
	}

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
	    int startPoint = input[0];
	    int endPoint = input[1];
	    fw.append("Case #" + i + ": " + new RecycledNumberFinder().findNumbers(startPoint, endPoint) + "\n");
	}

	fw.flush();

	reader.close();
	fw.close();
    }


}

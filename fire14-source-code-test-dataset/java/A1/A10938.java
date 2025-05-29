import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class TaskB {

	/** last number is always highest score */
	private static Integer[][] noJump = new Integer[31][];
	private static Integer[][] withJump = new Integer[31][];
	private static int bestP;
	
	public static void main(String[] args ) throws IOException {
		File fileName = new File("taskb/B-small-attempt0.in");
		Scanner inFile = new Scanner(fileName);
		int n = inFile.nextInt();
		inFile.useDelimiter("\\r?\\n");
		String[] cases = new String[n];
		for (int i = 0; i < n; i++)
			cases[i] = inFile.next();
		List<String> result = new ArrayList<String>();
		
		constructAllScores();
		printArray(noJump);
		printArray(withJump);
		//constructScore(new Integer[3], 10, 0);	
		for (String caseString: cases) {
			bestP = 0;
			Scanner caseScanner = new Scanner(caseString);
			int dancerNr = caseScanner.nextInt();
			int surprisingNr = caseScanner.nextInt();
			int threshold = caseScanner.nextInt();
			int[] dancerTotal = new int[dancerNr];
			for (int i = 0; i < dancerNr; i++)
				dancerTotal[i] = caseScanner.nextInt();
			findBestRoute(dancerTotal, surprisingNr, threshold, 0, 0);
			result.add("" + bestP);
		}
		
		PrintWriter out = new PrintWriter(new FileWriter("taskb/b-short.out")); 
		for (int i = 0; i < result.size(); i++) {
			out.println("Case #" + (i+1) + ": " + result.get(i));
		}
		out.close();
		System.out.println("Finished!");
	}
	private static void findBestRoute(int[] dancerTotal, int surprisingNr,
			int threshold, int p, int depth) {
		if (depth == dancerTotal.length) {
			if (p > bestP)
				bestP = p;
			return;
		}
			
		if (withJump[dancerTotal[depth]] != null && surprisingNr > 0) {
			if (withJump[dancerTotal[depth]][2] >= threshold)
				findBestRoute(dancerTotal, surprisingNr-1, threshold, p+1, depth+1);
			else findBestRoute(dancerTotal, surprisingNr-1, threshold, p, depth+1);
		}
		if (noJump[dancerTotal[depth]][2] >= threshold)
			findBestRoute(dancerTotal, surprisingNr, threshold, p+1, depth+1);
		else findBestRoute(dancerTotal, surprisingNr, threshold, p, depth+1);		
	}
	private static void printArray(Integer[][] array) {
		for (int i = 0; i < array.length; i++)
			System.out.println("sum: " + i + ": " + Arrays.toString(array[i]));
	}

	private static void constructAllScores() {
		for (int i = 0; i <= 10; i++) {
			for (int j = i; j <= i+2 && j <= 10; j++) {
				for (int k = i; k <= i+2 && k <= 10; k++) {
					Integer[] scoreBoard = {i,j,k};
					int sum = sum(scoreBoard);
					Integer[][] array = noJump;
					if (j == i + 2 || k == i + 2) 
						array = withJump;
					if (array[sum] == null || highest(scoreBoard) > highest(array[sum]))
						array[sum] = scoreBoard;
				}
			}
		}
	}
	
	private static int highest(Integer[] scoreBoard) {
		assert scoreBoard.length == 3;
		return scoreBoard[2];
	}

	private static Integer sum(Integer[] score) {
		assert score.length == 3;
		return score[0]+score[1]+score[2];
	}	
	
}

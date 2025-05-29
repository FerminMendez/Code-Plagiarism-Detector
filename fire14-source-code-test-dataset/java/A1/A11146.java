package fr.diodfr.y2012.qual;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Exo2 {
	private Scanner fileScanner;
	private Scanner lineScanner;
	private int numberOfCase;

	public Exo2(String fileName) {
		try {
			fileScanner = new Scanner(new BufferedReader(new FileReader(fileName)));
			numberOfCase = fileScanner.nextInt();
			nextLine();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public int getNumberOfCase() {
		return numberOfCase;
	}

	public boolean hasNextLine() {
		return fileScanner.hasNextLine();
	}

	public void nextLine() {
		String nextLine = fileScanner.nextLine();
//		System.out.println("Exo2.nextLine():" + nextLine);
		lineScanner = new Scanner(nextLine);
	}

	public boolean hasNext() {
		return lineScanner.hasNext();
	}

	public String next() {
		return lineScanner.next();
	}
	
	public int nextInt() {
		return lineScanner.nextInt();
	}

	public void close() {
		if (lineScanner != null) {
			lineScanner.close();
		}
		fileScanner.close();
	}
	
	
	private void computeCase(String outPutFileName) throws IOException {
		BufferedWriter file = new BufferedWriter(new FileWriter(outPutFileName));

		for (int i = 0; i < numberOfCase; i++) {
			nextLine();
			int result = getResult();

			file.append("Case #" + (i + 1) + ": " + result);
			System.out.println("Case #" + (i + 1) + " : " + result);
			file.newLine();
		}
		file.close();
	}
	
	private int getResult() {
		int numberCount = nextInt();
		int numberSurprisingTriplet = nextInt();
		int p = nextInt();
		int numbers[] = new int[numberCount];
		
		for (int i = 0; i < numberCount; i++) {
			numbers[i] = nextInt();
		}
		
		return dancing(numberCount, numberSurprisingTriplet, p, numbers);
	}

	private int dancing(int numberCount, int numberSurprisingTriplet, int p, int[] numbers) {
		int result = 0;
		int currentSurprising = 0;
		int smallSurprising = Math.max(p*3-4, 0);
		int smallNumber = Math.max(p*3-2, 0); 
		
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] <= p && p!=0) {
			} else if (numbers[i] >= smallNumber) {
				result++;
			} else if (numbers[i] >= smallSurprising) {
				currentSurprising++;
			}
		}
		
		return result + Math.min(numberSurprisingTriplet, currentSurprising);
	}

	public static void main(String[] args) {
		
		Exo2 exo = new Exo2("/home/didier/Téléchargements/B-small-attempt1.in");
	
		try {
			exo.computeCase("/home/didier/Téléchargements/B-small-attempt1.out");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

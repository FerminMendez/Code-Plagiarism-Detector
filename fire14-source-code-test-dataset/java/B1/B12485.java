package org.mlai.google.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RecycledNumbers {

	private static void processLine(String line, int lineNumber) {
		if (lineNumber == 1) {
			return;
		}
		String outputLine = "";
		String[] lineArray = line.split(" ");
		outputLine = "Case #" + String.valueOf(lineNumber - 1) + ": ";
		
		int firstNumber = 0;
		int lastNumber = 0;
		
		ArrayList<Integer> myNumbers = new ArrayList<Integer>();
		
		int recycledPairs = 0;
		
		firstNumber = Integer.valueOf(lineArray[0]);
		lastNumber = Integer.valueOf(lineArray[1]);
		
		for (int i = lastNumber; i >= firstNumber; i--) {
			myNumbers.add(i);
		}

		
		for (int i = myNumbers.size() - 1; i >= 0 ; i--) {
			if (i > myNumbers.size() - 1) {
				continue;
			}
			ArrayList<Integer> myCombinations = new ArrayList<Integer>();
			String[] numberSplit = String.valueOf(myNumbers.get(i)).split("");
			String myNewNumber = "";
			int numberSplitLength = numberSplit.length - 1;
			int myOriginalNumber = myNumbers.get(i);

			for (int j = numberSplitLength - 1; j > 0 ; j--) {
				if (myNewNumber != "") {
					numberSplit = myNewNumber.split("");
					myNewNumber = "";
				}
				myNewNumber += numberSplit[numberSplit.length - 1];

				
				for (int k = 1; k < numberSplit.length - 1; k++) {
					myNewNumber += numberSplit[k];
				}
				
				if (myNewNumber.startsWith("0")) {
					continue;
				}
				
				if (Integer.valueOf(myNewNumber) > lastNumber) {
					continue;
				}
				
				if (myNewNumber.equalsIgnoreCase(String.valueOf(myOriginalNumber))) {
					continue;
				}
				
				if (Integer.valueOf(myNewNumber) > myOriginalNumber) {
					if (!myCombinations.contains(Integer.valueOf(myNewNumber))) {
						myCombinations.add(Integer.valueOf(myNewNumber));
					}
				}
			}
			
			
			for (int k = 0; k < myCombinations.size(); k++) {
				if (myNumbers.contains(myCombinations.get(k))) {
//					System.out.println("(" + myOriginalNumber + "," + myNewNumber + ")");
					recycledPairs++;
				}
			}
			
			
			if (myNumbers.contains(myOriginalNumber)) {
				myNumbers.remove(myNumbers.indexOf(myOriginalNumber));
			}
			
		}

		
		outputLine += String.valueOf(recycledPairs);
		

		writeFile(outputLine);
	}
	
	private static class Combinations {
		
		
		
	}
	
//	private static class Scores {
//		int total = 0;
//		int score1 = 0;
//		int score2 = 0;
//		int score3 = 0;
//		int scoreToEqual = 0;
//		boolean score2Added = false;
//		boolean score1Added = false;
//		
//		
//		public int getTotal() {
//			return score1 + score2 + score3;
//		}
//		
//		public boolean correct() {
//			if (getTotal() == total) {
//				return true;
//			} else {
//				return false;
//			}
//		}
//		
//		public void setDefaultScore (int defaultScore) {
//			score1 = defaultScore;
//			score2 = defaultScore;
//			score3 = defaultScore;
//		}
//		
//		public boolean bestScore() {
//			if ((score1 >= scoreToEqual) || (score2 >= scoreToEqual) || (score3 >= scoreToEqual)) {
//				return true;
//			} else {
//				return false;
//			}
//		}
//
//	}
	

	public static void main(String[] args) {
		 try{
			  FileInputStream fstream = new FileInputStream("input.txt");

			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  int lineNumber = 0;
			  while ((strLine = br.readLine()) != null)   {
				  lineNumber++;				  
				  processLine(strLine, lineNumber);
			  }
			  in.close();
		    }catch (Exception e){
		    	System.err.println("Error Main: " + e.getMessage());
		    	e.printStackTrace();
	    	}
	}

	
	private static void writeFile(String line) {
		try{
			  System.out.println(line);
			  FileWriter fstream = new FileWriter("out.txt",true);
			  BufferedWriter out = new BufferedWriter(fstream);
			  out.write(line + "\n");
			  out.close();
		  }catch (Exception e){
			  System.err.println("Error writeFile: " + e.getMessage());
		  }
	}

}

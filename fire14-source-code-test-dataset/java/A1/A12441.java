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

public class DancingWithTheGooglers {

	private static void processLine(String line, int lineNumber) {
		if (lineNumber == 1) {
			return;
		}
		String outputLine = "";
		String[] lineArray = line.split(" ");
		outputLine = "Case #" + String.valueOf(lineNumber - 1) + ": ";
		
		int numberOfGooglers = 0;
		int numberOfSurprisingTripletScores = 0;
		int maximumBestResultOfAtLeast = 0;
		
		int totalOfBestScorers = 0;
		
			
		numberOfGooglers = Integer.valueOf(lineArray[0]);
		numberOfSurprisingTripletScores = Integer.valueOf(lineArray[1]);
		maximumBestResultOfAtLeast = Integer.valueOf(lineArray[2]);

		ArrayList<Scores> myScores = new ArrayList<Scores>();
		for (int i = 3; i < lineArray.length; i++) {
			Scores myScore = new Scores();
			myScore.total = Integer.valueOf(lineArray[i]);
			int defaultScore = (myScore.total / 3);  //already rounded down
			
			myScore.setDefaultScore(defaultScore);
			
			myScore.scoreToEqual = maximumBestResultOfAtLeast;
			
			if (!myScore.correct()) {
				myScore.score1Added = true;
				myScore.score1++;
			}
			if (!myScore.correct()) {
				myScore.score2Added = true;
				myScore.score2++;
			}
			if (!myScore.correct()) {
				System.out.println("Should not ever happen");
				outputLine += "Should not ever happen";
			}

			myScores.add(myScore);
		}
		
		for (int i = myScores.size() - 1; i >= 0; i--) {
			if (myScores.get(i).bestScore()) {
				totalOfBestScorers++;
				myScores.remove(i);
			}
		}
		
		for (int i = 0; i < myScores.size(); i++) {
//				if (((myScores.get(i).score2 > 0) && (myScores.get(i).score2Added) && (myScores.get(i).score1Added)) || ((myScores.get(i).score2 > 0) && (!myScores.get(i).score1Added) && (!myScores.get(i).score2Added))) {
//					myScores.get(i).score1++;
//					myScores.get(i).score2--;
//				}
				if ((myScores.get(i).score2 > 0) && (myScores.get(i).score2Added) && (myScores.get(i).score1Added)) {
					myScores.get(i).score1++;
					myScores.get(i).score2--;
				} else if ((myScores.get(i).score1 > 0) && (myScores.get(i).score2 > 0) && (!myScores.get(i).score1Added) && (!myScores.get(i).score2Added)) {
					myScores.get(i).score1++;
					myScores.get(i).score2--;
				}
		}
		
		for (int i = myScores.size() - 1; i >= 0; i--) {
			if (myScores.get(i).bestScore()) {
				if (numberOfSurprisingTripletScores <= 0) {
					break;
				}
				totalOfBestScorers++;
				myScores.remove(i);
				numberOfSurprisingTripletScores--;
			}
		}
		
		outputLine += String.valueOf(totalOfBestScorers);
		

		writeFile(outputLine);
	}
	
	private static class Scores {
		int total = 0;
		int score1 = 0;
		int score2 = 0;
		int score3 = 0;
		int scoreToEqual = 0;
		boolean score2Added = false;
		boolean score1Added = false;
		
		
		public int getTotal() {
			return score1 + score2 + score3;
		}
		
		public boolean correct() {
			if (getTotal() == total) {
				return true;
			} else {
				return false;
			}
		}
		
		public void setDefaultScore (int defaultScore) {
			score1 = defaultScore;
			score2 = defaultScore;
			score3 = defaultScore;
		}
		
		public boolean bestScore() {
			if ((score1 >= scoreToEqual) || (score2 >= scoreToEqual) || (score3 >= scoreToEqual)) {
				return true;
			} else {
				return false;
			}
		}

	}
	

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

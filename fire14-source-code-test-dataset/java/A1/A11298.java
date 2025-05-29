package org.pokuri;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Pokuri
 * @since Apr 14, 2012
 * org.pokuri.Googlers
 */
public class Googlers{
	
	private BufferedReader reader = null;

	/**
	 * @param filePath
	 * @return
	 */
	protected void openFile(String filePath){
		try {
			reader = new BufferedReader(new FileReader(new File(filePath)));			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void closeFile(){
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected BufferedWriter openOutputFile(String filePath){
		try {
			return new BufferedWriter(new FileWriter(new File(filePath)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	protected int noOfTestCases(){
		try {
			return Integer.parseInt(reader.readLine());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	protected String nextCase(){
		try {
			return reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	protected void generateOutput() throws IOException {
		
		openFile("input/Googlers.input");
		int cases = noOfTestCases();
		BufferedWriter outputFile = openOutputFile("output/Googlers.txt");
		for(int i=1; i<=cases; i++){			
			String nextCase = nextCase();
			String[] split = nextCase.split(" ");			
			int noOfSurprises = Integer.parseInt(split[1]);
			int minBestScore = Integer.parseInt(split[2]);
			
			int bestScoreGooglers = 0;
			// for each score find it'shad best score or not
			for(int k=3; k<split.length; k++){
				// check that the score can have best score in it
				int score = Integer.parseInt(split[k]);
				// first check that score is greater than or equal to the min.best score
				if(score >= minBestScore){
					// now find the max score that can be when all triplets are min.best score
					int multiplied = minBestScore*3;
					// if score is more than sum of tripltes -2 then we can arrange them to form at lest a best score in it
					if(score >= multiplied - 2){
						bestScoreGooglers++;
					}
					// if not found then check we left with any surprises of not. 
					// the use that surpeise to make that score good enough for forming min.best score in triplets
					else if(noOfSurprises > 0 && score >= multiplied - 4){
						bestScoreGooglers++;
						noOfSurprises--;
					}
				}								
			}
			outputFile.write("Case #"+i+": "+bestScoreGooglers);
			outputFile.newLine();
		}
		outputFile.flush();
		outputFile.close();
		closeFile();
		
	}
	
	public static void main(String[] args) throws IOException {
		
		Googlers googlers = new Googlers();
		googlers.generateOutput();
		
	}	
	
}

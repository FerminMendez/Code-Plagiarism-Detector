package se.pathed.codejam.practice.dansingwithgooglers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class DancingWithGooglers {

	public File getFileFromDisk(String fileName){
		String dataFolder = "C:\\Users\\Patrik\\workspaces\\codejam\\Practis\\data\\";
		return new File(dataFolder + fileName);
	}

	public static void main(String[] args) throws IOException{
		new DancingWithGooglers().run();
	}

	public static class Problem {
		int numDancers;
		int numSupprises;
		int searched;
		int solution;
		int[] scores;
	}
	
	public Problem[] parseInput() throws IOException{
		File f = getFileFromDisk("B-small-attempt0.in");
		FileReader fReader = new FileReader(f);
		BufferedReader reader = new BufferedReader(fReader);
		
		int numCases = Integer.parseInt(reader.readLine());
		Problem[] probs = new Problem[numCases];
		
		for( int i = 0; i < numCases; i++){
			Problem p = new Problem();
			String[] strInp = reader.readLine().split(" ");
			p.numDancers = Integer.parseInt(strInp[0]);
			p.numSupprises = Integer.parseInt(strInp[1]);
			p.searched = Integer.parseInt(strInp[2]);
			
			p.scores = new int[p.numDancers];
			for( int x = 3; x < strInp.length; x++){
				p.scores[x-3] = Integer.parseInt(strInp[x]);
			}
			probs[i] = p;
		}
		
		return probs;
	}
	
	private void run() throws IOException {
		Problem[] problems = parseInput();
		
		File outputFile = getFileFromDisk("out.txt");
		if( outputFile.exists()) outputFile.delete();
		PrintWriter outFile = new PrintWriter(outputFile);
		
		for( int i = 0; i < problems.length; i++){
			Problem p = problems[i];
			
			int lowestScore = ( p.searched * 3) -2;
			int lowestSuppriseScore = lowestScore - 2;

			int possibleScore = 0;
			int possibleSupprise = 0;
			
			for( int sc : p.scores ){
				if( sc >= lowestScore){
					possibleScore++;
				} else if( sc >= lowestSuppriseScore && sc > 0){
					possibleSupprise++;
				}
			}
			
			p.solution = possibleScore + (possibleSupprise > p.numSupprises ? p.numSupprises : possibleSupprise);
			
			outFile.println("Case #" + (1+i) + ": " + p.solution);
		}
		outFile.flush();
	}
}

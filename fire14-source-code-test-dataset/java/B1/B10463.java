package se.pathed.codejam.practice.recycled;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class RecycledNumbers {

	public static void main(String[] args) throws NumberFormatException, IOException{
		new RecycledNumbers().run();
	}


	public File getFileFromDisk(String fileName){
		String dataFolder = "C:\\Users\\Patrik\\workspaces\\codejam\\Practis\\data\\";
		return new File(dataFolder + fileName);
	}
	
	public static class Problem {
		int first;
		int last;
	}
	
	public Problem[] parseInput() throws NumberFormatException, IOException{
		Problem[] probs;
		File f = getFileFromDisk("C-small-attempt0.in");
		FileReader fReader = new FileReader(f);
		BufferedReader reader = new BufferedReader(fReader);
		
		int numCases = Integer.parseInt(reader.readLine());
		probs = new Problem[numCases];
		
		for(int i = 0; i < numCases; i++){
			String[] res = reader.readLine().split(" ");
			Problem p = new Problem();
			p.first = Integer.parseInt(res[0]);
			p.last = Integer.parseInt(res[1]);
			probs[i] = p;
		}
		
		reader.close();
		return probs;
	}
	
	private void run() throws NumberFormatException, IOException {
		Problem[] problems = parseInput();
		
		File outputFile = getFileFromDisk("out.txt");
		if( outputFile.exists()) outputFile.delete();
		PrintWriter outFile = new PrintWriter(outputFile);
		
		for(int i = 0; i < problems.length; i++){
			int solution = solve(problems[i]);
			outFile.println("Case #" + (i+1) + ": " + solution);
		}
		outFile.flush();
	}
	
	private int solve(Problem p){
		int first = p.first;
		int last = p.last;
		
		int count = 0;
		HashMap<Integer,Integer> found = new HashMap<Integer,Integer>();
		
		int[] foundInts = new int[Integer.toString(p.last).length() ]; 
		
		for(int x = first; x <= last; x++){
			String s = Integer.toString(x);
			int foundCount = 0;
			if(s.length() > 1){
				//System.out.println("Testing value: " + x);
				for(int v=1; v < s.length(); v++){
					String next = s.substring(v) + s.substring(0,v);
					//System.out.println("Testing value: " + next);
					if(next.charAt(0) != '0'){
						int val = Integer.parseInt(next);
						if( val <= last && val > x){
							// Already submitted
							boolean f = false;
							for(int i = 0; i < foundCount; i++){
								if( foundInts[i] == val){
									f = true;
								}
							}
							if(f != true){
								foundInts[foundCount] = val;
								foundCount++;
								if( found.containsKey(val) && found.get(val) == x){
									System.out.println("ERROR found duplicate: " + val);
									count++;
								}
								else {
									found.put(val, x);
									count++;
								}
							}
						}
					}
				}
			}
		}
		return count;
	}
}

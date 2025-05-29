package cats;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	public Main() throws Exception{
		FileReader fr = new FileReader(new File("input.txt"));
		BufferedReader in = new BufferedReader(fr);
		
		File outFile = new File("output.txt");
		outFile.createNewFile();
		FileWriter fw = new FileWriter(outFile);
		BufferedWriter out = new BufferedWriter(fw);
		
		
		
		int numTests = Integer.parseInt(in.readLine());
		for(int x = 0; x<numTests; x++){
			System.out.println("Working on case " + x + " of " + numTests);
			
			String[] split = in.readLine().split(" ");
			int numPeople, surprises, scoreToBeat;
			numPeople = Integer.parseInt(split[0]);
			surprises = Integer.parseInt(split[1]);
			scoreToBeat = Integer.parseInt(split[2]);
			
			ArrayList<Integer> totals = new ArrayList<Integer>(numPeople);
			for(int p = 0; p<numPeople; p++){
				totals.add(Integer.parseInt(split[3+p]));
			}
			Collections.sort(totals);
			Collections.reverse(totals);
			
			int count = 0;
			int surprisesLeft = surprises;
			for(int t: totals){
				if(t == 0){
					if(scoreToBeat == 0) count++;
					else break;
				}else if(t >= scoreToBeat+(scoreToBeat-1)*2){
					count++;
				}else if(t >= scoreToBeat+(scoreToBeat-2)*2 && surprisesLeft > 0){
					surprisesLeft--;
					count++;
				}else break;
			}
			out.write("Case #" + (x+1) + ": " + count + "\n");
		}
		
		
		in.close();
		out.close();
	}
	
	
	
	
	public static void main(String[] args) throws Exception{
		new Main();
	}
}

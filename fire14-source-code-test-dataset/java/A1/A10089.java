package se.round1.problem2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import se.round1.util.JamUtil;

public class Problem2 {

	Map<Character, Character> trans = new HashMap<Character, Character>();
	
	public static void main(String[] args) throws IOException{
		new Problem2();
	}
	
	public Problem2() throws IOException{
		
		BufferedReader reader = JamUtil.getReader("problem2/B-small-attempt1.in");
		
		int currCase = 0;
		String s = "";
		boolean first = true;
		BufferedWriter writer = JamUtil.getWriter("problem2/output.txt");
		while((s = reader.readLine()) != null){
			if(first){
				s = reader.readLine();
				first = false;
			}
			currCase++;
			int res = solveLine(s);
			String sol = "Case #"+currCase+": "+res+"\n";
			System.out.print(sol);
	
			writer.write(sol);
		}
		writer.close();
	}
	
	
	private int solveLine(String line){
		String[] linearr = line.split(" ");
		int dancers = Integer.parseInt(linearr[0]);
		int surprice = Integer.parseInt(linearr[1]);
		int scoreToReach = Integer.parseInt(linearr[2]);
		int success = 0;
		for(int i=0;i<dancers;++i){
			int score = Integer.parseInt(linearr[3+i]);
			int maxScore = canReachScoreWithoutSurprice(score);
			
			if(maxScore >= scoreToReach){
				success++;
			}
			else if( surprice > 0 && (maxScore+1) >= scoreToReach && score >= 2 && ( (3*maxScore) -1) <= score){
				success++;
				surprice--;
			}
		}
		
		return success;
	}
	
	private int canReachScoreWithoutSurprice(int score){
		if(score == 0)
			return 0;
		if(score == 1)
			return 1;
		if(score == 2)
			return 1;
		if(score == 3)
			return 1;
		
		int test = score / 3;
		
		while( 3*(test)+1 > score){
			test--;
		}

		if(test <=0)
			return 0;
		return test+1;
	}
	

	
}

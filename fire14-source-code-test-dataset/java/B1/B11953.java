package cs224n.gcj;

import java.io.IOException;
import java.util.HashSet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.File;



public class ProbC {

	static int getNRecycledPair(int b, int B){
		
		String s = new Integer(b).toString();		
		int nDigits = s.length();
		
		String ls, rs;
		HashSet<Integer> validPairs = new HashSet<Integer>();
		
		for(int i = 1; i < nDigits; i++){
			ls = s.substring(0, i);
			rs = s.substring(i);
			int rotb = Integer.parseInt((rs+ls));
			if(rotb > b && rotb <= B)
				validPairs.add(rotb);				
		}
		return validPairs.size();
		
	}
	
	static public int getTotRecycledPair(int A, int B){
		
		int n = 0;
		for(int i = A; i <= B; i++){
			n += getNRecycledPair(i, B);
		}
		
		return n;
	}
	
	static public void main(String[] args) throws IOException{
		
		File inFile = new File(args[0]);
		File outFile = new File(args[1]);
		
		if(!inFile.exists())
			System.out.println("File Does Not Exist!");

		
		BufferedReader in = new BufferedReader( new InputStreamReader( new FileInputStream(inFile) ) );
		PrintWriter out = new PrintWriter( new FileWriter(args[1]), true );
		
		String line;
		line = in.readLine();
		int T = Integer.parseInt(line);
		for(int i = 1; i <= T; i++){
			
			line = in.readLine();
			String[] parts = line.split(" ");
			int A = Integer.parseInt(parts[0]);
			int B = Integer.parseInt(parts[1]);
			out.print("Case #"+i+": ");
			out.println( getTotRecycledPair(A,B) );
			
		}
		
		
		in.close();
		out.close();
		
		
	}
	
}

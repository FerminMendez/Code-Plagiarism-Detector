package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashSet;

public class ProblemB {
	public static void main(String args[]){
		try{
			FileInputStream fileInputStream = new FileInputStream(args[0] + ".in");
			DataInputStream in = new DataInputStream(fileInputStream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			FileWriter fstream = new FileWriter(args[0] + ".out");
			BufferedWriter out = new BufferedWriter(fstream);
			
			String strLine;
			
			strLine = br.readLine();
			int T = Integer.parseInt(strLine);
			
			for(int i = 1; i <= T; i++){
				strLine = br.readLine();
				
				String[] limits = strLine.split(" ", 2);
				
				int lowerLimit = Integer.parseInt(limits[0]);
				int upperLimit = Integer.parseInt(limits[1]);
				
				int count = 0;
				
				for(int j = lowerLimit; j < upperLimit; j++){
					int n = j;
					String temp = Integer.toString(j);
					
					HashSet<String> hashSet = new HashSet<String>();
					for(int k = 0; k < temp.length() - 1; k++){
						temp = temp.substring(temp.length() - 1, temp.length()) + temp.substring(0, temp.length() - 1);
						
						int m = Integer.parseInt(temp);
						if(n < m && m <= upperLimit){
							String temp1 = temp;
							hashSet.add(temp1);
						}
					}
					count = count + hashSet.size();
				}
				System.out.println("Case #" + i + ": " + count);
				out.write("Case #" + i + ": " + count + "\n");
			}
			out.close();
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}

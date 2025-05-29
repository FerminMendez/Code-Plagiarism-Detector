package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.HashSet;

public class ProblemC {
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
				
				String[] input = strLine.split(" ");
				
				int N = Integer.parseInt(input[0]);
				int S = Integer.parseInt(input[1]);
				int p = Integer.parseInt(input[2]);
				
				int count = 0;
				for(int j = 0; j < N; j++){
					int t = Integer.parseInt(input[3 + j]);
					if(t / 3 >= p){
						count++;
					}
					else if(p > t){
						continue;
					}
					else if(t / 3 == p - 1){
						if(t % 3 == 0){
							if(S > 0){
								count++;
								S--;
							}
						}
						else if(t % 3 == 1){
							count++;
						}
						else{
							count++;
						}
					}
					else if(t / 3 == p - 2){
						if(t % 3 == 0){
							
						}
						else if(t % 3 == 1){
							
						}
						else{
							if(S > 0){
								count++;
								S--;
							}
						}
					}
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

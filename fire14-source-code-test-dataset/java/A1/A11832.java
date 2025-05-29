package com.gdacarv.codejam;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ProblemB {

	public static void main(String [ ] args){
		
		try{
			FileInputStream fstream = new FileInputStream("input_problemB.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String input = new String();
			String line;
			while ((line = br.readLine()) != null)
				input += line + '\n';
			System.out.println(input);
			System.out.println(solveProblemB(input));
		}catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
		}
		
	}

	private static String solveProblemB(String input) {
		String result = new String();
		String[] lines = input.split("\n"), numbers;
		int len = Integer.parseInt(lines[0]);
		int N, S, p, qt, num;
		for(int i = 1; i <= len; i++){
			result += "Case #" + i + ": ";
			numbers = lines[i].split(" ");
			N = Integer.parseInt(numbers[0]);
			S = Integer.parseInt(numbers[1]);
			p = Integer.parseInt(numbers[2]);
			qt = 0;
			for(int j = 3; j < 3+N; j++){
				num = Integer.parseInt(numbers[j]);
				if(p == 0){
					qt++;
				}else if(p == 1){
					if(num > 0)
						qt++;
				}else if(num / p >= 3 || (num-1) / (p-1) >= 3){
					qt++;
				}else if(S > 0 && num - p - 2*(p-2) >= 0){
					qt++;
					S--;
				}
			}
			result += qt + "\n";
		}
		return result;
	}
}

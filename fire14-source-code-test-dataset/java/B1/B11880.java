package com.gdacarv.codejam;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ProblemC {

	public static void main(String [ ] args){
		try{
			FileInputStream fstream = new FileInputStream("input_problemC.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String input = new String();
			String line;
			while ((line = br.readLine()) != null)
				input += line + '\n';
			System.out.println(input);
			System.out.println(solveProblemC(input));
		}catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
		}
		
	}


	private static String solveProblemC(String input) {
		String result = new String();
		String[] lines = input.split("\n"), numbers;
		int len = Integer.parseInt(lines[0]);
		int A, B, qt, current, aux, counterTemp = 0;
		String currentString;
		int[] temp = new int[10];
		for(int i = 1; i <= len; i++){
			result += "Case #" + i + ": ";
			numbers = lines[i].split(" ");
			A = Integer.parseInt(numbers[0]);
			B = Integer.parseInt(numbers[1]);
			qt = 0;
			for(current = A; current <= B; current++){
				currentString = String.valueOf(current);
				check: for(int j = 1; j < currentString.length(); j++){
					if(current < (aux = Integer.parseInt(currentString.substring(j) + currentString.substring(0, j))) && aux <= B){
						for(int l = 0; l < counterTemp; l++)
							if(temp[l] == aux)
								continue check;
						qt++;
						temp[counterTemp] = aux;
						counterTemp++;
						//System.out.println(current +","+aux);
					}
				}
				counterTemp = 0;
			}
			result += qt + "\n";
		}
		return result;
	}
}

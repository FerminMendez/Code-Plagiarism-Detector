package com.gmail.bubby4j.cj2012.qual2;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
	public static void main(String[] args) {
		//Begin--------------------------------------------------------------------------
		Scanner scanner = null;
		String inputfile = "C:\\Users\\James\\CodeJam2012\\B-small-attempt0.in";
		String outputfile = "C:\\Users\\James\\CodeJam2012\\small.out";
		BufferedWriter out = null;
		Integer numcases = 0;
		try {
			out = new BufferedWriter(new FileWriter(outputfile));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			scanner = new Scanner(new FileInputStream(inputfile));
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			System.exit(1);
		}
		Integer thisCase = 1;
		Boolean gotCase = false;
		while(scanner.hasNext()){
			String line = scanner.nextLine();
			if(isInteger(line) && !gotCase){
				numcases = Integer.parseInt(line);
				gotCase = true;
			}else{
				System.out.println("Case #"+thisCase);
				if(thisCase < numcases){
					appendOut("Case #" + thisCase + ": "+score(line)+"\n", out);
				}else{
					appendOut("Case #" + thisCase + ": "+score(line), out);
				}
				thisCase++;
			}
		}
		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Complete!");
		//End----------------------------------------------------------------------------
	}
	
	

	private static String score(String line) {
		String[] parts = line.split(" ");
		Integer ngooglers = Integer.parseInt(parts[0]);
		Integer suprising = Integer.parseInt(parts[1]);
		Integer bestresult = Integer.parseInt(parts[2]);
		ArrayList<Integer> scores = new ArrayList<Integer>();
		for (int i = 0; i < ngooglers; i++){
		    scores.add(Integer.parseInt(parts[i+3]));
		}
		//End parsing line
		Integer maxnumbers = 0;
		for (Integer score: scores) {
			Integer[] thisguess = new Integer[]{0,0,0};
			Integer baseNumber = intDivision(score, 3);
			thisguess[0] = baseNumber;
			thisguess[1] = baseNumber;
			thisguess[2] = baseNumber;
			Integer addingTo = 0;
			while(addArray(thisguess) < score){
				thisguess[addingTo]++;
				addingTo++;
			}
			thisguess = reverseArray(thisguess);
			
			
			String sup = "";
			//After all applying
			if(bestScore(thisguess) >= bestresult){
				maxnumbers++;
			}else if(suprising > 0 && canSuprise(thisguess)){
				//Isn't at or past the top, try to make suprising
				Integer[] suprised = suprise(thisguess);
				if(bestScore(suprised) >= bestresult){
					maxnumbers++;
					suprising--;
					thisguess = suprised;
					sup = " (*)";
				}
			}
			System.out.println(thisguess[0] + " " + thisguess[1] + " " + thisguess[2] + sup);
		}
		// return maximum number of Googlers who could have had a best result of 
		// 									 greater than or equal to bestresult
		return Integer.toString(maxnumbers);
	}

	public static boolean canSuprise(Integer[] scores){
		if((scores[2] == scores[1] && scores[0]+1 == scores[1]) || (scores[0] == scores[1] && scores[2] - 1 == scores[1]) || (scores[0] == scores[1] && scores[1] == scores[2] && scores[0] != 0)){
			return true;
		}
		return false;
	}
	
	public static Integer[] suprise(Integer[] in){
		Integer[] in2 = in.clone();
		if(in[2] == in2[1] && in2[0]+1 == in2[1]){
			in2[2]++;
			in2[1]--;
			return in2;
		}else if(in2[0] == in2[1] && in2[2] - 1 == in2[1]){
			in2[1]++;
			in2[0]--;
			return in2;
		}else if(in2[0] == in2[1] && in2[1] == in2[2] && in2[0] != 0){
			in2[0]--;
			in2[2]++;
			return in2;
		}
		return null;
	}
	
	public static Integer bestScore(Integer[] thisguess){
		Integer currentBest = 0;
		for (Integer score: thisguess) {
			if(score > currentBest){
				currentBest = score;
			}
		}
		return currentBest;
	}
	public static Integer addArray(Integer[] list){
		Integer tally = 0;
		for (Integer score: list) {
				tally += score;
		}
		return tally;
	}
	public static Integer[] reverseArray(Integer[] list){
		for(int i = 0; i < list.length / 2; i++){
			int temp = list[i];
		    list[i] = list[list.length - i - 1];
		    list[list.length - i - 1] = temp;
		}
		return list;
	}
	
	public static Integer intDivision(Integer i1, Integer i2){
		//Rounds down integer division
		return (int) Math.floor(i1/i2);
	}

	public static boolean isInteger(String i){
		try{
			Integer.parseInt(i);
			return true;
		}catch(Exception e){
			return false;
		}
		
	}
	public static void appendOut(String str, BufferedWriter out){
		try {
			out.append(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

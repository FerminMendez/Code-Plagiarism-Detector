package com.google.round.qualification;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProblemC {

	/**
	 * 
	 * 
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		String fileName = "C-small-attempt0";

		BufferedReader br = new BufferedReader(new FileReader("C:\\GoogleCodeJam\\"+fileName+".in"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\GoogleCodeJam\\"+fileName+".out"));
		int noofcases = Integer.parseInt(br.readLine());
		for(int i=1;i<=noofcases;i++)
		{
			bw.write("Case #");
			bw.write(i+"");
			bw.write(": ");
			bw.write(findDistinctivePairs(br.readLine()));
			bw.newLine();
		}
		
		bw.flush();
		try
		{
			if(bw != null)
				bw.close();
			if(br != null)
				br.close();
		}
		catch(Exception e)
		{
			// ignore
		}
		

	}
	
	private static String findDistinctivePairs(String readLine) {
		String[] range = readLine.split(" ");
		int start = Integer.parseInt(range[0]);
		int end = Integer.parseInt(range[1]);
		int count =0;
		for(int i=start;i<=end;i++)
		{
			count = count + permutation(i+"",end,i);
		}
		return count+"";
	}

	private static int permutation(String str,int endNumber,int currentNumber)
	{
		int count=0;
		char[] letters = str.toCharArray();
		for(int maxit=1;maxit<letters.length;maxit++)
		{
			shiftRight(letters,1); // 112 121 211
			String permutedStr = new String(letters);
			int permutedInt = Integer.parseInt(permutedStr);
			if(permutedInt > currentNumber && permutedInt <=endNumber)
			{
				count++;
			}
		}
	
		return count;
		
	}

	public static void shiftRight(char[] array, int amount) {
		
	    for (int j = 0; j < amount; j++) {
	            char a = array[array.length - 1];
	            int i;
	            for (i = array.length - 1; i > 0; i--)
	                    array[i] = array[i - 1];
	            array[i] = a;
	    }
	   
	}
	
	

}

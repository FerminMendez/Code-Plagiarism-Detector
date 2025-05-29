package com.googlecodejam;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Dancing {

	private final int n;
	private int p = 0;
	private final int s;
	private final int[] a;
	
	public Dancing(int n, int s, int p, int[] a){
		this.n = n;
		this.p = p;
		this.s = s;
		this.a = a;
	}
	
	public static void main(String[] args) throws Exception{
		
		File src = new File("input");
		Scanner scanner = new Scanner(src);
		int cases = scanner.nextInt();
		int[] results = new int[cases];
		for(int i = 0; i < cases; i++){
			int no = scanner.nextInt();
			int s = scanner.nextInt();
			int p = scanner.nextInt();
			int[] a = new int[no];
			for(int j = 0; j < no; j++)
				a[j] = scanner.nextInt();
			Dancing dancing = new Dancing(no, s, p, a);
			results[i] = dancing.dance();
		}
		
		File target = new File("output");
		FileOutputStream fos = new FileOutputStream(target);
		DataOutputStream dos = new DataOutputStream(fos);
		
		for(int i = 0; i < results.length; i++){
			dos.writeChars("Case #");
			dos.writeChars(String.valueOf(i));
			dos.writeChars(": ");
			dos.writeChars(String.valueOf(results[i]));
			dos.writeChars("\n");
			System.out.println(results[i]);
		}
		dos.flush();
		dos.close();
	}
	
	public int dance() throws Exception{
		return danceHelper(s, 0);
	}
	
	private int danceHelper(int sp, int index) throws Exception{
		
		// base case
		if(index == a.length)
			return 0;
		
		boolean surprising = isSuprisingable(a[index]);
		if(surprising){
			int choiceOne, choiceTwo;
			// assuming the score is surprising
			int max = maxScoreSuprising(a[index]);
			if(sp == 0){
				choiceOne = -1;
			}
			else{
				if(max >= p)
					choiceOne = 1 + danceHelper(sp - 1, index + 1);
				else
					choiceOne = danceHelper(sp - 1, index + 1);
			}
			// assuming the score is not surprising
			int maxTwo = maxScoreNotSurprising(a[index]);
			if(maxTwo >= p)
				choiceTwo = 1 + danceHelper(sp, index + 1);
			else 
				choiceTwo = danceHelper(sp, index + 1);
			
			return Math.max(choiceOne, choiceTwo);
		}
			
		else{
			int max = maxScoreNotSurprising(a[index]);
			if(max >= p)
				return 1 + danceHelper(sp, index + 1);
			else
				return danceHelper(sp, index + 1);
		}
	}
	
	private boolean isSuprisingable(int i){
		//return true;
		if((i == 0) || (i == 1))
			return false;
		else return true;
		/*
		int rem = i % 3;
		if((rem == 0) || (rem == 1))
			return true;
		else return false;*/
	}
	
	private int maxScoreSuprising(int i) throws Exception{
		int mid = i / 3;
		int rem = i % 3;
		if((rem == 0) || (rem == 1))
			return mid + 1;
		else
			return mid + 2;
	}
	
	private int maxScoreNotSurprising(int i){
		int mid = i / 3;
		int rem = i % 3;
		if((rem == 1) || (rem == 2))
			return mid + 1;
		else return mid;
	}
}







package com.google.codejam.B;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Triplet {
	public static void main(String[] args) {
		String line = null;
		BufferedReader reader = null;
		File file = new File("c:\\write.txt");
		BufferedWriter  output = null;
		try {
			output = new BufferedWriter(new FileWriter(file));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			reader = new BufferedReader(new FileReader("c:\\temp1.txt"));
			line = reader.readLine();
			int n = Integer.parseInt(line);
			for (int i=0;i<n;i++){
				line = reader.readLine();
				output.write("Case #"+(i+1)+": ");

				String[]arr = line.split(" ");
				int intarr[]= new int[arr.length];
				for (int j=0;j<intarr.length;j++){
					intarr[j]= Integer.parseInt(arr[j]);
				}
				int noOfGooglers = intarr[0];
				int noOfSurprizing = intarr[1];
				int p= intarr[2];
				int result;
				int count=0;
				int reminder;
				for (int j=0;j<noOfGooglers;j++){
					int number= intarr[3+j];
					if (number==0 && p!=0){
						continue;
					}
					result = number/3;
					reminder = number%3;
					switch (reminder) {
					case 0:
						if (result>=p){
							count++;
							continue;
						}
						if (noOfSurprizing>0){
							if (result+1>=p){
								count++;
								noOfSurprizing--;
								continue;
							}
						}
						break;
					case 1:
						if (result+1>=p){
							count++;
						}
						break;
					case 2:
						if (result+1>=p){
							count++;
							continue;
						}
						if (noOfSurprizing>0){
							if (result+2>=p){
								count++;
								noOfSurprizing--;
								continue;
							}
						}
						break;
					default:
						break;
					}
					
				}
				output.write(count+"");
				
				if (i!=n-1)
				output.write("\n");
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				reader.close();
				output.close();
			
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}

package com.d.qual;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class q2 {
	
	public static final String FILE_NAME = "B-small-attempt3.in";
//	public static final String FILE_NAME = "input.txt";
	public static final String FILE_OUT_NAME = "output.txt";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FileReader reader;
		FileWriter writer;
		try {
			reader = new FileReader(FILE_NAME);
			writer = new FileWriter(FILE_OUT_NAME);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		} catch(IOException e){
			e.printStackTrace();
			return;
		}
		
		BufferedReader r = new BufferedReader(reader);
		BufferedWriter w = new BufferedWriter(writer);
		
		String entriesString;
		int entries;
		try {
			entriesString = r.readLine();
			entries = Integer.parseInt(entriesString);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
		
		for(int i=0; i<entries; i++){

			String curLine;
			try {
				curLine = r.readLine();
				
				String[] tokens = curLine.split(" ");
				int count = Integer.parseInt(tokens[0]);
				int specials = Integer.parseInt(tokens[1]);
				int score = Integer.parseInt(tokens[2]);
				
				int winners = 0;
				int curSpecials = 0;
				
				String out = "Case #"+(i+1)+": ";
				System.out.print(out+"special "+specials+" score "+score+" ");
				w.write(out);
				for(int j=0; j<count; j++){
					int curInt = Integer.parseInt(tokens[3+j]);
					
					int maybeHigh = score * 3 - 3;
					int maybeLow = score * 3 - 4;
//					if(maybeHigh < 0){
//						maybeHigh = 0;
//					}
//					if(maybeLow < 0){
//						maybeLow = 0;
//					}
					
					if(curInt > maybeHigh){
						winners++;
						System.out.println("OK "+winners);
					}
					else if((curInt >= maybeLow) && (curInt <= maybeHigh)){
						if(score == 1){
							if(curInt < score * 3 - 2){
								continue;
							}
						}
						curSpecials++;
						System.out.println("MAYBE "+curSpecials);
						if(curSpecials <= specials){
							winners++;
							System.out.println("MAYBE YES! "+winners);
						}
					}
					out = "-cint "+curInt+" yes "+(score * 3)+" maybe "+maybeLow+" "+maybeHigh+" s "+curSpecials+" w "+winners+" ";
					System.out.println(out);
					
//					if(curInt < score * 3 - 4){
//						continue;
//					}
//					
//					int[] result = new int[3];
//					result[0] = score;
//					result[1] = 0;
//					result[2] = 0;
//					int leftOver = curInt - result[0];
//					if(leftOver > 20){
//						result[0] += leftOver - 20;
//						leftOver = 20;
//					}
//					float leftOverHalf = (float)leftOver / 2;
//					result[1] = leftOver - (int)Math.floor(leftOverHalf);
//					result[2] = leftOver - result[1];
//					
//					int maxDiff = maxDiff(result);
//					if(maxDiff < 2){
//						winners++;
//					}
//					else if(maxDiff == 2){
//						//special
//						curSpecials++;
//						if(curSpecials <= specials){
//							winners++;
//						}
//					}
//					else if(maxDiff > 2){
//						
//					}
//					
//					out = curInt+" "+result[0]+" "+result[1]+" "+result[2]+" maxDiff["+maxDiff+"] ";
//					System.out.print(out);
				}
				System.out.println(" - winners "+winners);
				w.write(""+winners);
				w.newLine();
				w.flush();
				
			} catch (IOException e) {
				e.printStackTrace();
				return;
			}
		}
		
		try{
			r.close();
		} catch(IOException e){
			e.printStackTrace();
			return;
		} finally{
			try{
				w.close();
			} catch(IOException e){
				e.printStackTrace();
				return;
			}
		}
		

	}
	
	public static boolean isSpecial(int[] data){
		int maxDiff = 0;
		for(int i=0; i<data.length; i++){
			int c = data[i];
			int prevIdx = i-1;
			if(prevIdx < 0){
				prevIdx = data.length-1;
			}
			int prev = data[prevIdx];
			int cdiff = c - prev;
			if(Math.abs(cdiff) == 2){
				maxDiff = 2;
			}
		}
		return (maxDiff == 2);
	}
	public static int maxDiff(int[] data){
		int maxDiff = 0;
		for(int i=0; i<data.length; i++){
			int c = data[i];
			int prevIdx = i-1;
			if(prevIdx < 0){
				prevIdx = data.length-1;
			}
			int prev = data[prevIdx];
			int cdiff = c - prev;
			if(Math.abs(cdiff) > maxDiff){
				maxDiff = Math.abs(cdiff);
			}
		}
		return maxDiff;
	}

}

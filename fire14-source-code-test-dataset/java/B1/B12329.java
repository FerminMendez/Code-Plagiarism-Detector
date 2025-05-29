package com.google.codejam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DancingWithGooglers {

	private int limit(long min, long max){
		if (min>max)
			return 0;
		int count = 0;
		for (long i = min; i <= max; i++) {
			int loopCount = 1;
			long start = i;
			long rotation = i;
			do {
				rotation = rotate(start,loopCount);
				if ( rotation <= max && rotation > start) {
//					System.out.println("pair numbers : " + start + "," + rotation);
					count+=1;
				}
//				else{
//					System.out.println("!!not pair numbers : " + start + "," + rotation);
//				}
				loopCount++;

			} while (loopCount<=Long.toString(start).length());
		}
		return count;
	}

//	private long rotate(long x){
//		if (x<9) {
//			return x;
//		}
//		long firstpart = x/10;
//		long secondpart = x%10;
//		double firstpartlen = (String.valueOf(firstpart)).length();
//		int mul = (int) Math.pow(10, firstpartlen);
//		long fin = (secondpart * mul) + firstpart;
//		return fin;
//	}
	private long rotate(long x,int index){
		if (x<9) {
			return x;
		}
		String s = Long.toString(x);
		String s1 = s.substring(0, s.length()-index);
		String s2 = s.substring(s.length()-index, s.length());
		String s3 = s2+s1;
		return Long.parseLong(s3);
	}
	public static void main(String[] args) throws IOException{
		BufferedReader in = new BufferedReader(new FileReader("resources/googlecodejam/dancingwiththegooglers.txt"));
		String strLine;
		int caseLine  = 0;
		int lineCount = 0;
		DancingWithGooglers dancingWithGooglers = new DancingWithGooglers();
		while ((strLine = in.readLine()) != null) {
			// Print the content on the console
			if (lineCount == 0) {
				lineCount+=1;
				continue;
			}
			caseLine += 1;
			long min = Long.parseLong(strLine.split(" ")[0]);
			long max = Long.parseLong(strLine.split(" ")[1]);
			System.out.println("Case #" + caseLine + ": " + dancingWithGooglers.limit(min,max));
		}

	}
}

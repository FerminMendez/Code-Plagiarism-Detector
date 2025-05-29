package com.wonyoung.codejam.qualificationround;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class DancingWithTheGooglers {
	private Integer testCasesT;
	private DancingWithTheGooglersData [] data;

	class DancingWithTheGooglersData {
		Integer googlersN;
		Integer surprisingS;
		Integer p;
		String[] totalPoints;

		public DancingWithTheGooglersData() {
		}
		
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			
			sb.append(googlersN.toString());
			sb.append(" " + surprisingS.toString());
			sb.append(" " + p.toString());
			int count = 0;
			while ( count < googlersN ) {
				sb.append(" " + totalPoints[count].toString());
				count++;
			}

			return sb.toString();
		}
	}
	
	public DancingWithTheGooglers(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		testCasesT = Integer.valueOf(br.readLine());
		data = new DancingWithTheGooglersData[testCasesT];
		
		int count = 0;
		
		while ( count < testCasesT) {
			line= br.readLine();
			String [] words = line.split(" ");

			data[count] = new DancingWithTheGooglersData();
			data[count].googlersN = Integer.valueOf(words[0]);
			data[count].surprisingS = Integer.valueOf(words[1]);
			data[count].p = Integer.valueOf(words[2]);
			data[count].totalPoints = Arrays.copyOfRange(words, 3, 3 + data[count].googlersN);
			
			count++;
		}
		br.close();
	}

	public String result(int i) {
		return "Case #"+ (i+1) +": "+ greaterOrEqualsThanP(i);
	}
	
	private Integer greaterOrEqualsThanP(int i) {
		int result = 0;
		int surprisingCards = data[i].surprisingS;
		if (data[i].p <= 0)
			return data[i].googlersN;
		
		int baseScore = data[i].p*3 - 3;
		for ( String points : data[i].totalPoints) {
			Integer n = Integer.valueOf(points);
			if (baseScore < n) {
				result++;
				System.out.print("+");
			}
			else if (data[i].p < n && baseScore < n+2 && surprisingCards > 0) {
				surprisingCards--;
				result++;
				System.out.print("s");
			}
			else
				System.out.print("-");
		}
		System.out.println();
		return result;
	}

	public void print(String filename) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
		int count = 0;
		
		while (count < testCasesT) {
			bw.write(result(count));
			bw.newLine();
			count++;
		}

		bw.close();		
	}
	
	public static void main(String args[]) throws IOException {
		DancingWithTheGooglers dwg = new DancingWithTheGooglers("B-small-attempt1.in");
		dwg.print("B-small-attempt1.out");	
	}

}


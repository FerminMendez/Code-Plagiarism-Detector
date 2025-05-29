package com.wonyoung.codejam.qualificationround;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecycledNumbers {

	private Integer testCasesT;
	private RecycledNumbersData [] data;

	class RecycledNumbersData {
		Integer A;
		Integer B;
		int count;

		public RecycledNumbersData() {
		}
		
		@Override
		public String toString() {
			return A + " " + B;
		}
	}
	
	public RecycledNumbers(String filename) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(filename));
		String line;
		testCasesT = Integer.valueOf(br.readLine());
		data = new RecycledNumbersData[testCasesT];
		
		int count = 0;
		
		while ( count < testCasesT) {
			line= br.readLine();
			String [] words = line.split(" ");

			data[count] = new RecycledNumbersData();
			data[count].A = Integer.valueOf(words[0]);
			data[count].B = Integer.valueOf(words[1]);
//			System.out.println(data[count].toString());
			count++;
		}
		br.close();
	}

	public String result(int i) {
		return "Case #"+ (i+1) +": "+ numberOfPairs(i);
	}

	private int numberOfPairs(int i) {
		int start = data[i].A;
		int end = data[i].B;
		int found = 0;
		
		for(int num = start; num<=end; num++) {
			String n = String.valueOf(num);
			int nInt = Integer.valueOf(n);
			StringBuilder m = new StringBuilder(n);
			int sizeOfN = n.length();
			List <Integer> mList = new ArrayList<Integer>();
			
			while(--sizeOfN > 0) {
				rotate(m);
				int mInt = Integer.valueOf(m.toString());
				if (m.charAt(0) == '0')
					continue;
				if (mInt <= nInt)
					continue;
				if (mInt <= end)
				{
					if (mList.contains(mInt))
						continue;
					mList.add(mInt);
					found++;
//					System.out.println(nInt+ " " + mInt);
				}
			}
		}
		
		return found;
	}

	private void rotate(StringBuilder n) {
		n.append(n.charAt(0));
		n.deleteCharAt(0);
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
		RecycledNumbers rn = new RecycledNumbers("C-small-attempt0.in");
		rn.print("C-small-attempt0.out");	
	}
	
}

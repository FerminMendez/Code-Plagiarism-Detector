package com.codejam2012;

import java.util.TreeMap;

import com.codejam2012.CodeJam1.Case;



public class CodeJam3 {

	public static String fileDir = "P:\\CodeJam2012\\";
	public static String baseFileName = "C-small-attempt2";
	public static String inputFileName = fileDir + baseFileName + ".in";
	public static String outputFileName = fileDir + baseFileName + ".out";

	public static int Tcase;
	public static int Ccase = 0;
	public static String[] cases;
	public static Case singleCase;
	
	public static void main(String[] args) {
		
		FileUtils.deleteFile(outputFileName);
		String inputString = FileUtils.readFile(inputFileName);
		parseInputString(inputString);
		for (; Ccase < Tcase;) {
			parse();
		}

	}
	
	public static void parseInputString(String inputString) {

		cases = inputString.split("\n");
		Tcase = Integer.parseInt(cases[0]);
		Ccase = 0;
	}

	private static void parse() {

		Ccase++;
		FileUtils.appendToFile(outputFileName, "Case #" + Ccase + ": ");
		singleCase = new Case(cases[Ccase]);
		singleCase.execute();
		FileUtils.appendToFile(outputFileName, singleCase.getDataToPrint()
				+ "\n");

	}

	public static class Case {
		StringBuilder outputStatement;
		
		int N;
		int M;

		public Case(String caseString) {
			outputStatement = new StringBuilder();
			String[] arr = caseString.split(" " );
			N = Integer.parseInt(arr[0]);
			M = Integer.parseInt(arr[1]);
		}

		public void execute() {
			
			int noOfDigits = (N + "").length();
			int TCount = 0;
			TreeMap<Integer, Integer> mList = new TreeMap<Integer,Integer>();
			

			for (int n = N; n <= M; n++) {

				for (int r = 1; r < noOfDigits; r++) {
					int m = rotater(n, r, noOfDigits);
					if (m <= M && m >= N) {
						if (m > n) {
							 if(mList.containsKey(n) ){
								 if(mList.get(n) == m){
									 
								 }else{
									 TCount++;
										mList.put(n,m);
								 }
							 }else if (mList.containsKey(m) ){
								 if(mList.get(m) == n){
									 
								 }else{
									 TCount++;
										mList.put(n,m);
								 }
							 }else{
								 TCount++;
									mList.put(n,m);
							 }
							
						}
					}

				}

			}
			
			outputStatement.append(TCount);
		}
		
		public static int rotater(int n, int rotate, int noOfDigits) {
			int base = (int) Math.pow(10, noOfDigits - 1);
			int[] digits = new int[noOfDigits];
			int d = 0;
			int ans = 0;
			for (int i = base; i >= 1; i /= 10) {
				digits[d] = n / i;
				d++;
				n = n % i;
			}

			shiftLeft(digits, rotate);
			d = 0;
			for (int i = base; i >= 1; i /= 10) {
				ans += digits[d] * i;
				d++;
			}

			return ans;

		}

		public static void shiftLeft(int[] array, int amount) {

			for (int j = 0; j < amount; j++) {
				int a = array[0];
				int i;
				for (i = 0; i < array.length - 1; i++)
					array[i] = array[i + 1];
				array[i] = a;
			}

		}

		public String getDataToPrint() {
			return outputStatement.toString();

		}

	}


}

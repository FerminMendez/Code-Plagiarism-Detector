package com.gcj2012.qr;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;



public class ProblemC {
	private int caseNum = -1;
	private ArrayList<Case> testCases = new ArrayList<Case>();
	
	private class Pair{
		private int m;
		private int n;
	}
	
	private class Case{
		private int A = 0;
		private int B = 0;
		private int digitNum = 0;
		private ArrayList<Pair> pairs = new ArrayList<Pair>();
		
	}
	
	private void readDataFromFile(String fileName) throws IOException{
		
		BufferedReader reader = new BufferedReader(new FileReader(ProblemC.class.getClassLoader().getResource(fileName).getPath().replaceAll("%20", " ")));
		String line = null;
		boolean isFirstLineRead = false;
		
        while ((line=reader.readLine()) != null) {
            if(!isFirstLineRead){
            	caseNum = Integer.valueOf(line);
            	isFirstLineRead = true;
            }else{
            	String[] testCaseLine = line.split(" ");
            	Case testCase = new Case();
            	testCase.A = Integer.valueOf(testCaseLine[0]).intValue();
            	testCase.B = Integer.valueOf(testCaseLine[1]).intValue();
            	
            	testCase.digitNum = testCaseLine[0].length();
            	this.testCases.add(testCase);
            }
        }
        reader.close();
	}
	
	private boolean checkDuplicate(int curCase, int m, int n){
		int size = this.testCases.get(curCase).pairs.size();
		
		for(int i=0;i<size;i++){
			if(this.testCases.get(curCase).pairs.get(i).m == m && this.testCases.get(curCase).pairs.get(i).n == n){		//exact pair
				return true;
			}else if(this.testCases.get(curCase).pairs.get(i).m == n && this.testCases.get(curCase).pairs.get(i).n == m){
				return true;
			}
		}
		Pair p = new Pair();
		p.m = m;
		p.n = n;
		this.testCases.get(curCase).pairs.add(p);
		return false;
	}
	
	private void processCases(){
		for(int i=0;i<caseNum;i++){
			int recycleCount = 0;
			for(int j=testCases.get(i).A;j<=testCases.get(i).B;j++){
				
//				System.out.println("Original int: "+j);
				for(int k=1;k<testCases.get(i).digitNum;k++){
					//System.out.println("Move "+k+" digits forward");
					int resultInt = moveDigitsForward(j,k);
					
					if(j >= testCases.get(i).A && j < resultInt && resultInt <= testCases.get(i).B){
						if(!checkDuplicate(i,j,resultInt)){
							recycleCount++;
							//System.out.println("COUNT int: "+resultInt);
						}
						//System.out.println("COUNT");
					}
				}
			}
			System.out.println("Case #"+(i+1)+": "+recycleCount);
		}
	}
	
	private int moveDigitsForward(int inputInt, int numOfDigits){
		String inputString = String.valueOf(inputInt);
		if(inputString.length() > 1){
			String digitToMove = inputString.substring(inputString.length()- numOfDigits, inputString.length());
			String digitToStay = inputString.substring(0, inputString.length() - numOfDigits);
			String resultString = digitToMove+digitToStay;
			if(String.valueOf(Integer.valueOf(resultString).intValue()).length() == inputString.length()){
				return Integer.valueOf(resultString).intValue();
			}
			return -1;
		}else{
			return inputInt;
		}
		
	}
	
	public static void main(String[] args) {
	       ProblemC c = new ProblemC();
	       
	       try {
	    	   c.readDataFromFile("C-small-attempt0.in");
	    	   c.processCases();
	       } catch (IOException e) {
				e.printStackTrace();
	       }
	    }
	
}

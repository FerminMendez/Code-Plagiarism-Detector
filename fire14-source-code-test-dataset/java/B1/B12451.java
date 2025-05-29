package com.wordofday.service.job;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class GoogleRecycle {

	public GoogleRecycle() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GoogleRecycle recycle = new GoogleRecycle();
		try{
			  FileInputStream in = new FileInputStream(args[0]);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine = null;
			  int count = 0;
			  while ((strLine = br.readLine()) != null)   {
				  if(count>0){
					  //skip first line
					  if(count>1){
						  System.out.print("\nCase #"+count+": "+recycle.output(strLine));
					  }else{
						  System.out.print("Case #"+count+": "+recycle.output(strLine));
					  }				  }
				  count++;
				  
			  }
			  //Close the input stream
			  in.close();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	private int output(String strLine) {
		Set<List<Integer>> outputSet = new LinkedHashSet<List<Integer>>();
		int output = 0;
		if(strLine!=null && strLine.trim().length()>0){
			String[] parts = strLine.split(" ");
			int startInt = Integer.parseInt(parts[0]);
			int endInt = Integer.parseInt(parts[1]);
			for(int i=startInt;i<=endInt;i++){
				Stack<Integer> digStack = new Stack<Integer>();
				int temp =i;
				while(temp>0){
					int digit = temp%10;
					digStack.push(digit);
					temp=(temp-digit)/10;
				}
				List<Integer> digList = new ArrayList<Integer>();
				while(!digStack.empty()){
					digList.add(digStack.pop());
				}
				//now start shuffling from stack
				for(int j=1;j<digList.size();j++){
					int nextNumber = getNextNumber(digList,j);
					if(i<nextNumber && nextNumber<=endInt
							&& !String.valueOf(i).startsWith("0")
							&& !String.valueOf(nextNumber).startsWith("0")){
						output++;
						List<Integer> outputList = new ArrayList<Integer>();
						outputList.add(i);
						outputList.add(nextNumber);
						outputSet.add(outputList);
					}
					
				}
				
			}
		}
		return outputSet.size();
	}

	private int getNextNumber(List<Integer> digList, int j) {
		int nextNumber = 0;
		StringBuilder sb = new StringBuilder();
		if(j<digList.size()){
			List<Integer> frontList = digList.subList(0, j);
			List<Integer> endList = digList.subList(j, digList.size());
			for(Integer end:endList){
				sb.append(end);
			}
			for(Integer front:frontList){
				sb.append(front);
			}
			
			nextNumber = Integer.parseInt(sb.toString());
		}
		return nextNumber;
	}

}

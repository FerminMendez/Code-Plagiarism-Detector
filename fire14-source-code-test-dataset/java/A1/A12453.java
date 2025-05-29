package com.keysbuy.codejam12.GDance;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class GDance {
	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		try{
	          File rFile = new File("E:/GDance/B-small-attempt0.in");
	          File wFile = new File("E:/GDance/B-small-attempt0.out"); 
	          BufferedReader br = new BufferedReader(new FileReader(rFile));
	          BufferedWriter bw = new BufferedWriter(new FileWriter(wFile,true));
	          
	          int caseNum = 1;
	          String str = br.readLine();
	          str = br.readLine();
	          
	          while(str != null) {
	        	  StringTokenizer tokenizer = new StringTokenizer(str);
	        	  int numGoogler = Integer.parseInt(tokenizer.nextToken());
	        	  int numSuper = Integer.parseInt(tokenizer.nextToken());
	        	  int maxPoint = Integer.parseInt(tokenizer.nextToken());
	        	  
	        	  int highBound = 3 * maxPoint - 2;
	        	  if(highBound < maxPoint) {
	        		  highBound = maxPoint; 
	        	  }
	        	  int lowBound = 3 * maxPoint - 4;
	        	  if(lowBound < maxPoint) {
	        		  lowBound = maxPoint;
	        	  }
	        	  
	        	  int validDancer = 0;
	        	  
	        	  while(tokenizer.hasMoreTokens()) {
	        		  int points = Integer.parseInt(tokenizer.nextToken());
	        		  if(points >= highBound) {
	        			  validDancer++;
	        		  }
	        		  else if(numSuper !=0 && points >= lowBound) {
	        			  validDancer++;
	        			  numSuper--;
	        		  }
	        		  
	        	  }
	              bw.append("Case #" + caseNum + ": " + validDancer);
	              bw.newLine();
	              bw.flush();
	              str = br.readLine();
	              caseNum++;
	          }
	          bw.close();
	          br.close();
	          System.out.println("DONE!");
	        }catch(Exception e){
	            System.out.println(e.getMessage());
	        }
		
	}
}

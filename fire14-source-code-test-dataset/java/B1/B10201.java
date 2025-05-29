package cj.sample;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class C2012 {

	BufferedReader br;
	PrintWriter pw;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		C2012 c2012 = new C2012();
		c2012.processInput();		
	}

	public void processInput(){	
		initInFile("/home/Vijitha/GCJ/Testdata/C-small-attempt0.in");
		initOutFile("/home/Vijitha/GCJ/Testdata/C-small-attempt0.out");
		try{
			String l = "";
			// First line
			l = br.readLine();				
			int indx = 1;
			while((l = br.readLine()) != null){				
				String[] ary = l.split(" ");			
				int firstNumber = Integer.parseInt(ary[0]);
				int secondNumber = Integer.parseInt(ary[1]);
				
				int count = getCount(firstNumber, secondNumber);				
				pw.println("Case #" + indx + ": " + count);
				indx++;
			}					
			br.close();		
			pw.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}	
	}  
	
	private int getCount(int firstN, int secondN){		
		int count = 0;	
		
		String firstString = String.valueOf(firstN);
		String secondString = String.valueOf(secondN);
		
		if(firstString.length() != secondString.length())
			return 0;
		
		String fDigit = Character.toString(firstString.charAt(0));
		
		if(firstString.length() == 1)
			return 0;
		
		if(firstString.length() == 2){			
			String sDigit = Character.toString(firstString.charAt(1));			
			while(firstN < secondN){
				firstString = String.valueOf(firstN);				
				fDigit = Character.toString(firstString.charAt(0));
				sDigit = Character.toString(firstString.charAt(1));
				int swapN = Integer.parseInt(sDigit + fDigit);				
				if(swapN > firstN && swapN <= secondN){
					count++;
				}
				firstN++;
			}			
		}
		
		if(firstString.length() == 3){
			String sDigit = Character.toString(firstString.charAt(1));
			String tDigit = Character.toString(firstString.charAt(2));
			while(firstN < secondN){
				firstString = String.valueOf(firstN);
				fDigit = Character.toString(firstString.charAt(0));
				sDigit = Character.toString(firstString.charAt(1));
				tDigit = Character.toString(firstString.charAt(2));
				
				int swapl = Integer.parseInt(tDigit + fDigit + sDigit);
				if(swapl > firstN && swapl <= secondN)
					count++;
				
				int swapBoth = Integer.parseInt(sDigit + tDigit + fDigit);
				if(swapBoth > firstN && swapBoth <= secondN)
					count++;
				
				firstN++;
			}	
			
		}		
		return count;		
	}
	
	
	public void initInFile(String name){		
		try{		
		 br = new BufferedReader(new FileReader(name));		
		}catch(FileNotFoundException fnfe){
			fnfe.printStackTrace();
		}		
	}
	
	public void initOutFile(String name){		
		try{		
		 pw = new PrintWriter(new FileWriter(name));		
		}catch(IOException ex){
			ex.printStackTrace();
		}		
	}
}

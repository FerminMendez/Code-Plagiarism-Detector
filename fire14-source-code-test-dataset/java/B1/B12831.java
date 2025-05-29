package com.cj.rn;

import com.cj.utils.*;
import java.io.*;
import java.util.Scanner;

public class RecycledNumbers {

	int from;
	int to;
	public String getResult(int caseNo, int from, int to){
		int tempFrom = from;
		int result = 0;
		while(tempFrom<to){
			for(int count=1;(tempFrom+count)<=to;count++){
				int n = tempFrom; 
				String nS = Integer.toString(n);
				int m = tempFrom+count;
				String mS = Integer.toString(m);
				boolean flag = true;
				for(int i=0;i<nS.length();i++){
					if(countOccurrences(mS, nS.charAt(i))!=countOccurrences(nS, nS.charAt(i))){
						flag = false;
					}
				}
				if(flag){
					for(int i=1; i<nS.length(); i++){
						String temp = nS.substring(i)+nS.substring(0, i);
						if(temp.equals(mS)){
							flag = true;
							break;
						}
						else
							flag = false;
					}
				}
				if(flag){
					result++;
					//System.out.println(nS+"<>"+mS);
					}
			}
		tempFrom++;
		}
		return "Case #"+caseNo+": "+result;
	}
	public static int countOccurrences(String haystack, char needle)
	{
	    int count = 0;
	    for (int i=0; i < haystack.length(); i++)
	    {
	        if (haystack.charAt(i) == needle)
	        {
	             count++;
	        }
	    }
	    return count;
	}
	public static void main(String[] args){
		RecycledNumbers obj = new RecycledNumbers();
		System.out.println(obj.getResult(1, 1111, 2222));
		InputReader ir = new InputReader();
        Scanner input = ir.loadInput("C-small-attempt0.in");
        int cases = ir.cases;
        OutputWriter ow = new OutputWriter("C-small-attempt0.out");
        for(int count=0 ; count<cases ; count++){
            //object
        	
        	int n = input.nextInt();
        	int m = input.nextInt();
            String output = obj.getResult(count+1, n, m);

            ow.writeLine(output);
            System.out.println(output);
        }
        ow.closeFile(); 
	}
}

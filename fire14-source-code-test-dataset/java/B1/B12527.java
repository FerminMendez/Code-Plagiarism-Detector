package com.blah;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class MainProblem2 {

	static String english = "our language is impossible to understandthere are twenty six factorial possibilitiesso it is okay if you want to just give up",
			grese = "ejp mysljylc kd kxveddknmc re jsicpdrysirbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcdde kr kd eoya kw aej tysr re ujdr lkgc jv";

	static TreeMap<Character, Character> gToE = new TreeMap<Character, Character>();
	
	static String shiftToFront(String digits,int by){
		String toReturn = digits.substring(digits.length()-by).concat(digits.substring(0,digits.length()-by)); 
		return toReturn;
	}

	public static void main(String[] args) {

		try {
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			int numCases = Integer.parseInt(br.readLine());
			int cases[][] = new int[numCases][2];
			int response[] = new int[numCases];
			StringTokenizer st;
			for (int i = 0; i < numCases; i++) {
				st = new StringTokenizer(br.readLine());
				cases[i][0] = Integer.parseInt(st.nextToken()); 
				cases[i][1] = Integer.parseInt(st.nextToken());
			}
			String daCase;
			int shifted;
			TreeSet<String> recycled;
			for (int i = 0; i < numCases; i++) {
				recycled = new TreeSet<String>();
				for (int caseNumber = cases[i][0]; caseNumber <= cases[i][1]; caseNumber++) {
					daCase = ""+caseNumber;
					//System.out.println("Testing integer "+daCase);
					for (int k = 1; k < daCase.length(); k++) {
						shifted = Integer.parseInt(shiftToFront(daCase, daCase.length()-k));
						if(shifted<=cases[i][1] &&  shifted>caseNumber){
							recycled.add(""+caseNumber+""+shifted);
						}
					}
				}
				System.out.println("Case #"+(i+1)+": "+recycled.size());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
	}

}
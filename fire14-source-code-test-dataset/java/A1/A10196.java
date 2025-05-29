package com.kingter;

import java.io.FileReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GoogleDancer {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//read
		List<Integer> resultList = new ArrayList<Integer>();
		
		LineNumberReader lin = new LineNumberReader(new FileReader("./B-small-attempt0.in"));
		
		String line = null;
		while ((line = lin.readLine()) != null) {
			System.out.println("Process #"+lin.getLineNumber()+":"+line);
			if (lin.getLineNumber() == 1) continue;
			String[] testCaseStr = line.split(" ");
			int N = Integer.parseInt(testCaseStr[0]);
			int S = Integer.parseInt(testCaseStr[1]);
			int p = Integer.parseInt(testCaseStr[2]);
			
			List<Integer> tl = new ArrayList<Integer>(testCaseStr.length - 3);
			for (int i = 3; i < testCaseStr.length; i++) {
				tl.add(Integer.parseInt(testCaseStr[i]));
			}
			resultList.add(count(N, S, p, tl));
			
		}
		
		//write
		
		 PrintWriter out = new PrintWriter("./B-small-attempt0.out");
		try{
			int i = 1;
			for (Iterator<Integer> it = resultList.iterator(); it.hasNext();) {
				int count = it.next();
				System.out.println("Case #"+i+": "+count);
				out.println("Case #"+i+": "+count);
				i++;
			}
		} finally {
			out.close();
		}

	}
	public static int count(int N, int S, int p, List<Integer> tl) {
		System.out.print("N="+N+",");
		System.out.print("S="+S+",");
		System.out.println("p="+p+",");
		System.out.println("tl="+tl);
		
		//count
		int count = 0;
		int best = Math.max(S, (p * 3) - 2);
		int supBest = Math.max(S, best -2);
		
		for (Iterator<Integer> it = tl.iterator(); it.hasNext();) {
			int result = it.next();
			if (result >= best) {
				count++;
				continue;
			}
			if (result >= supBest && S >= 1) {
				count++;
				S--;
			}
		}
		System.out.println("count="+count);
		
		return count;
	}

}

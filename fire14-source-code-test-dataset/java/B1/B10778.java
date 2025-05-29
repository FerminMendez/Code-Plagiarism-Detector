package gcj2012qual;

import java.io.*;
import java.util.*;

public class RecycleNum {

	/**
	 * @param args
	 */
	
	HashMap<String, String> map = new HashMap<String, String>();
	
	int totalpair(int start, int end){
		int num = 0;
		
		for(int i = start; i <= end; i++){
			String s = String.valueOf(i);
			//System.out.println(s);
			for(int j = 1; j < s.length(); j++){
				String recycle = s.substring(j) + s.substring(0, j);
				//System.out.println(recycle + " " + recycle.length());
				//System.out.println("hh" + i + " " + j);
				if(recycle.charAt(0) != '0'){
					//int new_num = Integer.getInteger(recycle);
					Integer new_num = new Integer(recycle);
					if(new_num <= end && new_num >= start && new_num != i) {
						//map.put(recycle, s);
						num = num + 1;
					}
				}	
			}
		}
		return num / 2;
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		Scanner input = new Scanner(new File("C-small-attempt0.in"));
		PrintWriter output = new PrintWriter(new FileWriter("output"));
		
		RecycleNum recyclenum = new RecycleNum();
		
		// Scanner in = new Scanner(System.in);
		int case_num = input.nextInt();
		String word = input.nextLine();
					
		for(int i = 0; i < case_num; i++){
			int start = input.nextInt();
			int end = input.nextInt();	
			System.out.println(start + " " + end);
			output.println("Case #" + (i + 1) + ": " + recyclenum.totalpair(start, end));
		}
		
		input.close();
		output.flush();
		output.close();
	}

}

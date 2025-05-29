package source;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class RecycledNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException{
		Scanner scan = new Scanner(new File(""));
		BufferedWriter bw = new BufferedWriter(new FileWriter(""));
		
		int testCases = new Integer(scan.nextLine());
		Set<String> pairs = null;
		
		for(int i=0; i < testCases; i++){
			String[] nums = scan.nextLine().split(" ");
			int min = new Integer(nums[0]);
			int max = new Integer(nums[1]);
			pairs = new TreeSet<String>();
			
			int testNum = min;
			while(testNum <= max){
				getRecycled(testNum, pairs, min, max);
				++testNum;
			}
			bw.write("Case #"+(i+1)+": "+pairs.size()+"\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void getRecycled(int testNum, Set<String> pairs, int min, int max){
		int rec = 0;
		String number = Integer.toString(testNum);
		
		StringBuilder sb = new StringBuilder("");
		for(int i=1; i < number.length(); i++){
			sb.append(number.substring(i)).append(number.substring(0, i));
			try{
				rec = new Integer(sb.toString());
				if(testNum != rec && min <= rec && rec <= max && 
						!pairs.contains(testNum+"-"+rec) && !pairs.contains(rec+"-"+testNum)){
					pairs.add(testNum+"-"+rec);
				}
			} catch(NumberFormatException e){}
			sb.delete(0, sb.length());
		}
	}

}

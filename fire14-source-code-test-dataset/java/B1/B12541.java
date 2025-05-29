package CJ2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Recycle {
	
	static LinkedList<LinkedList<Integer>> db2 = new LinkedList<LinkedList<Integer>>();
public static void main(String [] args){
		
		BufferedReader br = null;
		String line="";
		if(args.length != 1){
			System.out.println("please input test file name as a command line argument");
			System.exit(0);
		}
		try{
			br = new BufferedReader(new FileReader(args[0]));
			line = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		int numOfTests = Integer.parseInt(line);
		BufferedWriter bw = null;
		try{
			FileWriter fw = new FileWriter("resultsM.txt");
			bw = new BufferedWriter(fw);
		}catch(IOException e){
			e.printStackTrace();
		}
		for(int i = 0; i < numOfTests ; i++){
			try{
				line = br.readLine();
				bw.write("Case #"+(i+1)+": ");
				bw.flush();
				bw.write(String.valueOf(checkPairs(line)));
				bw.flush();
				bw.newLine();
				bw.flush();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	public static int checkPairs(String input){
		
		StringTokenizer tok = new StringTokenizer(input);
		int minRange = Integer.parseInt(tok.nextToken());
		int maxRange = Integer.parseInt(tok.nextToken());
		int digits=0;
		int tmp = minRange;
		while(tmp!=0){
			tmp/=10;
			digits+=1;
		}
		db2 = new LinkedList<LinkedList<Integer>>();
		int counter = 0;
		for(int i = minRange ; i <= maxRange ; i++){
			for(int j = 1; j < digits ; j++){
				tmp = rotate(i,j,digits);
				
				if(tmp <= maxRange && tmp >= minRange && tmp != i){
					if(checkExists2(i,tmp))
						counter++;
				}
			}
		}
		
		return counter;
	}
	public static int rotate(int toRotate, int times, int length){
		
		String rotation = String.valueOf(toRotate);
		for(int i=0;i<times;i++){
			
			rotation = rotation.charAt(length-1)+rotation.substring(0,length-1);
		}
		return Integer.parseInt(rotation);
	}
	
	public static boolean checkExists2(int base, int rotated){
		LinkedList<Integer> pair = new LinkedList<Integer>();
		if(base > rotated){
			pair.add(rotated);
			pair.add(base);
		}else{
			pair.add(base);
			pair.add(rotated);
		}
		if(db2.contains(pair)){
			return false;
		}else{
			db2.add(pair);
			return true;
		}
	}
	
	
}

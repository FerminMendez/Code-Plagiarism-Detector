package codejam2012.qualified;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;

public class ProblemC {
	static BitSet bit = new BitSet();

	static BufferedReader buffReader = null;
	static BufferedWriter buffWriter = null;
	static FileReader fileReader = null;
	static FileWriter fileWriter = null;
	static String input_test = "/home/qimeng/problemC.test";
	static String input_small =  "/home/qimeng/C-small-attempt0.in";
	static String input_large = "/home/qimeng/C-large.in";
	static int com = 0;
	static int result = 0;
	//	static int a = 0;
	//	static int b = 0;
	static HashMap<Integer, Integer> hashMap = new HashMap<Integer,Integer>();

	public static final void main(String[] args){
		try {
			//fileReader = new FileReader(input_test);
			fileReader = new FileReader(input_small);
			//fileReader = new FileReader(input_large);
			buffReader = new BufferedReader(fileReader);
			fileWriter = new FileWriter("/home/qimeng/problemC.out");
			buffWriter = new BufferedWriter(fileWriter);

			int total_size = Integer.parseInt(buffReader.readLine());
			//iterate through every input line
			for(int i=1; i<=total_size; i++){
				String[] str = buffReader.readLine().split(" ");
				int a = Integer.parseInt(str[0]);
				int b = Integer.parseInt(str[1]);


				System.out.println("Case #" +i+": " + recycleAlgorithm(a,b));
				buffWriter.write("Case #" +i+": " + recycleAlgorithm(a,b));
				buffWriter.newLine();
				buffWriter.flush();
			}


		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				buffWriter.flush();		
				buffWriter.close();
				buffReader.close();
				fileReader.close();
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static int recycleAlgorithm(int a,int b){
		int count=0;
		for (int i=b;i>=a;i--){
			ArrayList<Integer> permutations = getPermutations(i+"");
			for (Integer ti : permutations){
				if (ti>=a && ti<=b && ti<i){
					count++;
				}
			}
		}
		return count;
	}

	public static ArrayList<Integer> getPermutations(String i){
		ArrayList<Integer> permutations = new ArrayList<Integer>();
		String shift=i.substring(1)+i.substring(0,1);
		while (!shift.equalsIgnoreCase(i)){
			int parsedInt=Integer.parseInt(shift);
			int digits=new String(parsedInt+"").length();
			if (digits==i.length()){
				permutations.add(parsedInt);
			}
			shift=shift.substring(1)+shift.substring(0,1);
		}
		return permutations;
	}



	//	private static int recycleAlgorithm(int a, int b){
	//		result = 0;
	//
	//		for(int i=a; i<=b; i++){
	//			com = 0;
	//			String str_i = Integer.toString(i);
	//			int len_i = str_i.length();
	//			// chars --> all combinations
	//			// all combinations --> numbers
	//			// 
	//			// for all numbers:
	//			// 		check each number if in range
	//			// 		if so, setbit(number), com++
	//			//
	//			//result + all pairs from com
	//			showPattern("", str_i);
	//
	//		}
	//
	//		return result;	
	//	}

	//	private static void showPattern(String st, String chars) {
	//		if (chars.length() <= 1){
	//			//System.out.println(st + chars);
	//			int num = Integer.parseInt(st+chars);
	//			if(num>= a && num<=b){
	//				bit.set(num);
	//			}
	//			com++;
	//		}
	//		else{
	//			for (int i = 0; i < chars.length(); i++) {
	//				try {
	//					String newString = chars.substring(0, i)
	//							+ chars.substring(i + 1);
	//					showPattern(st + chars.charAt(i), newString);
	//				} catch (Exception e) {
	//					e.printStackTrace();
	//				}
	//			}
	//		}
	//	}

	//	private static int permutation(int x){
	//		return fact(x) / fact(x-2);		
	//	}

	//	private static int fact(int x) {
	//		if(hashMap.containsKey(x)){ 
	//			return hashMap.get(x);
	//		}
	//		else {
	//			int re = 0;
	//			if(x == 0) return 0;
	//			else if(x == 1) return 1;
	//			else {
	//				re = x*fact(x-1);
	//				hashMap.put(x, re);
	//				return re;
	//			}		
	//		}
	//	}
}

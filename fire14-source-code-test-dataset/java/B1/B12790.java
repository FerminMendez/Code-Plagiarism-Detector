package qualification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import loader.InputReader;
import loader.OutPutWriter;

public class RecycledNumber {

	static String inputName = "C-small-attempt0.in";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		List<Integer> list = new LinkedList<Integer>();
//		list.add(1);
//		list.add(2);
//		System.out.println(listToInt(list));
//		int a = 4009;
//		System.out.println(intToList(a));
		start();
	}

	private static void start(){
		InputReader reader = new InputReader();
		reader.read(inputName);
		List<String> inputs = reader.getInputs();
		List<String> outputs = new ArrayList<String>();
		for(String in: inputs){
			String[] aLine = in.split(" ");
			int a = Integer.parseInt(aLine[0]);
			int b = Integer.parseInt(aLine[1]);
			int amount = findPairs(a,b);
			outputs.add(new Integer(amount).toString());
		}
		
		OutPutWriter writer = new OutPutWriter();
		writer.write("question3.out", outputs);
	}
	
	private static int findPairs(int a, int b) {
		Set<Pair> resultSet = new HashSet<Pair>();
		
//		int res = 0;
		if(a == b) return 0;
		for(int n=a; n<b; n++){
			List<Integer> nList = intToList(n);
			int shiftTimes = nList.size()-1;
			for(int i=1; i<=shiftTimes; i++){
				int m = shift(i, nList);
				if(n < m && m <= b){
					Pair pair = new Pair(n, m);
//					res += 1;
					if(!resultSet.contains(pair))
						resultSet.add(pair);
				}
			}
		}
		List view = new ArrayList(resultSet);
		Collections.sort(view);
		System.out.println(view);
		
		return resultSet.size();
//		return res;
	}

	private static int shift(int shiftTimes, List<Integer> list){
		
		List<Integer> copyList = new ArrayList<Integer>();
		copyList.addAll(list);
		for(int i=0; i<shiftTimes; i++){
			Integer moved = copyList.remove(0);
			copyList.add(moved);
		}
		
		return listToInt(copyList);
	}

	
	private static List<Integer> intToList(int a){
		List<Integer> l = new LinkedList<Integer>();
		
		while(a > 0){
			int digit = a%10;
			l.add(0, digit);
			a /= 10;
		}
		
		return l;
	}
	
	private static int listToInt(List<Integer> list){
		int res = 0;
		int length = list.size();
		
		int pow = 0;
		for(int i=length-1; i>=0; i--){
			int digit = list.get(i);
			int value = (int) (digit * Math.pow(10.0, pow));
			res += value;
			pow++;
		}
		return res;
	}
}

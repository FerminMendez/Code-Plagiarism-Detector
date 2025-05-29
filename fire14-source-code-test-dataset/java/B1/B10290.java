package com.gcj.parser;

import java.util.ArrayList;
import java.util.List;

public class Number {

	private static List<Integer> getRecylcedCombining(int value){

		List<Integer> toReturn = new ArrayList<Integer>();
		
		Integer intValue = new Integer(value);
		String strValue = intValue.toString();
		
		for (int i = 1; i < strValue.length() ; i ++) {
			Integer newValue = new Integer(strValue.substring(i, strValue.length()) + strValue.substring(0, i));
			if (newValue.intValue() > value && !toReturn.contains(newValue)){
				toReturn.add(newValue);
			}
		}
		
		return toReturn;
	}
	
	public static int nbOfRecycledInteger(int min, int max){
		int toReturn = 0;
//		boolean[] alreadyDone = new boolean[10000000];
		
		for (int i = min ; i <= max ; i++){
			List<Integer> list = getRecylcedCombining(i);
			
			for (Integer number : list){
				int intNumber = number.intValue();
				if (intNumber >= min && intNumber <= max ){//&& !alreadyDone[intNumber]){
					toReturn++;
//					alreadyDone[intNumber]=true;
				}
			}
		}
		
		return toReturn;
	}

	
	public static void main(String[] args) {
	
		System.out.println(nbOfRecycledInteger(1111, 2222));
		
	}
}

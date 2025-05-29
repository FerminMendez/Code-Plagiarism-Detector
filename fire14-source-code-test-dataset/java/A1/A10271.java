package com.gcj.main;

import java.util.ArrayList;

import com.gcj.parser.Parser;
import com.gcj.parser.MaxPoints;

public class Main {


	public static void main(String[] args) {
		Parser parser = new Parser("resource/InputData.txt");
		ArrayList<Integer>[] datas = parser.toArray();
		int index = 1;

		for (ArrayList<Integer> dataRow : datas){
			
			int nbGooglers = dataRow.get(0).intValue();
			int nbSurprinsingResult = dataRow.get(1).intValue();
			int targetPoints = dataRow.get(2).intValue();
			
			int result = 0;
			
			for (int i = 0 ; i < nbGooglers ; i++) {
				if (MaxPoints.normal(dataRow.get(i+3)) >= targetPoints){
					result ++;
				}
				else {
					if (nbSurprinsingResult > 0){
						if (MaxPoints.surprising(dataRow.get(i+3)) >= targetPoints){
							result ++;
							nbSurprinsingResult --;
						}
					}
				}
			}
			
			StringBuffer stringBuf = new StringBuffer("Case #").append(index).append(": ").append(result);
			System.out.println(stringBuf.toString());
			index ++;
		}
	}
}
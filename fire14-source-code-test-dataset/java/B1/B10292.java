package com.gcj.main;

import java.util.ArrayList;

import com.gcj.parser.Number;
import com.gcj.parser.Parser;

public class Main {


	public static void main(String[] args) {
		Parser parser = new Parser("resource/InputData.txt");
		ArrayList<Integer>[] datas = parser.toArray();
		int index = 1;

		for (ArrayList<Integer> dataRow : datas){

			int min = dataRow.get(0).intValue();
			int max = dataRow.get(1).intValue();

			StringBuffer stringBuf = new StringBuffer("Case #").append(index).append(": ").append(Number.nbOfRecycledInteger(min, max));
			System.out.println(stringBuf.toString());
			index ++;
		}
	}
}
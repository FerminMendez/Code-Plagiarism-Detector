package com.numbers.recycle.orchestrator;

import java.util.ArrayList;
import java.util.List;

import com.numbers.recycle.algo.Recycler;
import com.numbers.recycle.io.FileOutputWriter;
import com.numbers.recycle.io.FileParser;

public class NumberRecycler {
	
	private FileParser parser = new FileParser();
	private Recycler recycler = new Recycler();
	private FileOutputWriter writer = new FileOutputWriter();
	
	public void solveAndWriteToOutputFile(String filePath){
		List<String> fileContents = parser.readFile(filePath);
		List<String> outputContents = new ArrayList<String>();
		int size = Integer.valueOf(fileContents.get(0));
		int counter = 1;
		while(counter <= size){
			outputContents.add("Case #"+ counter +": "+recycler.getRecycledNumberCount(fileContents.get(counter++).split(" ")));
		}
		writer.writeToFile(outputContents);
	}
}

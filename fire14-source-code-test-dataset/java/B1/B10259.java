package com.numbers.recycle.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class FileParser {
	
	public List<String> readFile(String path){
		File file = new File(path);
		List<String> fileContents = parseFile(file);
		return fileContents;
	}
	
	private List<String> parseFile(File file){
		List<String> contents = new ArrayList<String>();
		try {
			FileInputStream inputStream = new FileInputStream(file);
			BufferedReader bufReader = new BufferedReader(new InputStreamReader(inputStream));
			String line = null;
			while ((line = bufReader.readLine())!= null){
				contents.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contents;
	}
	
}

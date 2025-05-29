package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyUtil {

	
	public static BufferedReader getReader(String filename){
		try {
			return new BufferedReader(new FileReader("data/" + filename));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static BufferedWriter getWriter(String filename){
		try {
			return new BufferedWriter(new FileWriter("output/" + filename + ".out.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}

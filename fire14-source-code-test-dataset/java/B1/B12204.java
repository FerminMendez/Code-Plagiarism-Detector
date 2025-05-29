package com.google.codejam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ContentReader {
	public static ArrayList<String> getContents(String fileName) {
		ArrayList<String> fileContents = new ArrayList<String>();
	    try {
	      //use buffering, reading one line at a time
	      //FileReader always assumes default encoding is OK!
	      
	      InputStream is = ContentReader.class.getResourceAsStream(fileName);
	      InputStreamReader  in = new InputStreamReader(is);
	      BufferedReader input =  new BufferedReader(in);
	      try {
	        String line = null; //not declared within while loop
	        /*
	        * readLine is a bit quirky :
	        * it returns the content of a line MINUS the newline.
	        * it returns null only for the END of the stream.
	        * it returns an empty String if two newlines appear in a row.
	        */
	        while (( line = input.readLine()) != null){
	        	fileContents.add(line);
	        }
	      }
	      finally {
	        input.close();
	      }
	    }
	    catch (IOException ex){
	      ex.printStackTrace();
	    }
	    return (fileContents);
	}
}

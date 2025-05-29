package com.codejam2012;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
	
	
	public static String readFile(String fileName){
		FileReader reader = null;
		String temp = null;
		try {
			reader = new FileReader(fileName);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	    StringBuffer strContent = new StringBuffer("");
	    
	    try 
	    {
	      
	      BufferedReader bufferedReader = new BufferedReader(reader);
	      temp =bufferedReader.readLine();
	      while (temp != null)
	      {		    	  
	    	  strContent.append(temp + "\n");
	    	  temp =bufferedReader.readLine();
	      }
	      
	    } 
	    catch (Exception e) 
	    {
	      System.out.println(e);
	    }
	    
	    return strContent.toString();
	}

	public static void appendToFile(String outputFileName, String dataToPrint) {
						 
		File file =new File(outputFileName);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		FileWriter fileWritter;
		try {
			fileWritter = new FileWriter(outputFileName,true);
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
	        bufferWritter.write(dataToPrint);
	        bufferWritter.close();
	        fileWritter.close();
	        
		} catch (IOException e) {
			e.printStackTrace();
		}
	        
		
		
	}

	public static void deleteFile(String outputFileName) {
		File file =new File(outputFileName);
		if(file.exists()){
			file.delete();
		}
		
	}
	

}

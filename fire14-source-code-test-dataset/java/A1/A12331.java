package com.interview.prep.sorting;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DancingGooglers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = new File("/Users/Ankit/Downloads/B-small-attempt1.in");
	    FileInputStream fis = null;
	    BufferedInputStream bis = null;
	    DataInputStream dis = null;

	    try {
	      fis = new FileInputStream(file);

	      // Here BufferedInputStream is added for fast reading.
	      bis = new BufferedInputStream(fis);
	      dis = new DataInputStream(bis);

	      // dis.available() returns 0 if the file does not have more lines.
	      int i = 0;
	      dis.readLine();
	      while (dis.available() != 0) {
		      i++;
	    	  dancingStars(dis.readLine(), i);
	      }
	      fis.close();
	      bis.close();
	      dis.close();
	      
	    } catch (FileNotFoundException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
	public static void dancingStars(String caseString, int casenumber) {
		String[] numbers = caseString.split(" ");
		int googlers = Integer.parseInt(numbers[0]);
		int max = Integer.parseInt(numbers[2]);
		int surprises = Integer.parseInt(numbers[1]);
		int counter = 0;
		int limit = 3*max - 2;
		
		
		for (int i=0;i<googlers;i++) {
			int score = Integer.parseInt(numbers[3+i]);
			if(score >= (limit)){
				counter++;
				continue;
			}
			if(surprises > 0 && score >= (limit-2) && score > 1 ) {
				surprises--;
				counter++;
				continue;
			}
		}
		System.out.println("Case #"+ casenumber + ": " +counter);
	}
}

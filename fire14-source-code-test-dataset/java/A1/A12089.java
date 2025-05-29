package edu.tamu.dwang089;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Dancing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				String string = "";
			
				 try {
				      //use buffering, reading one line at a time
				      //FileReader always assumes default encoding is OK!
				      BufferedReader input =  new BufferedReader(new FileReader("input.in"));
				      try {
				        String line = null; //not declared within while loop
				        int num = 0;
				        
				        /*
				        * readLine is a bit quirky :
				        * it returns the content of a line MINUS the newline.
				        * it returns null only for the END of the stream.
				        * it returns an empty String if two newlines appear in a row.
				        */
				        line = input.readLine();
				        while (( line = input.readLine()) != null) {
				        	//System.out.println(line);
				        	int result = 0;
				        	String[] strings = line.split(" ");
				        	int count = Integer.parseInt(strings[0]);
				        	int surprise = Integer.parseInt(strings[1]);
				        	int score = Integer.parseInt(strings[2]);
				        	
				        	List<Integer> scores = new ArrayList<>();
				        	for (int i = 3; i < strings.length; i++) {
				        		int value = Integer.parseInt(strings[i]);
				        		scores.add(value);
				        		//System.out.println(value);
				        	}
				        	
				        	for (int i = 0; i < scores.size(); i++) {
				        		int value = scores.get(i);
				        		//System.out.println(value);
				        		if (((value + 2) >= (3 * score)) && (value >= score))
				        			result++;
				        		else if (((value + 4) >= (3 * score)) && (surprise > 0) && (value >= score)) {
				        			result++;
				        			surprise--;
				        		}
				        		
				        	}
				        	
				        	num++;
				        	System.out.print("Case #" + num + ": " + result);
				        	System.out.println();
				        }
				        
				      }
				      finally {
				        input.close();
				      }
				    }
				    catch (IOException ex){
				      ex.printStackTrace();
				    }
	}

}

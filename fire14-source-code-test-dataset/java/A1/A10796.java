package dancing_with_googlers;

import java.io.*;
import java.util.*;

public class Start {
	
	/** Requires two arguments - the file name, and the encoding to use.  */
	  public static void main(String [] args) throws IOException {
		        ArrayList<String> input = ReadWriteTextFile.doReadTextFile("B-small-attempt4.in");
		        ArrayList<String> output = new ArrayList<String>();
		        
		        int n = Integer.parseInt(input.get(0));
		        for (int i=1;i<=n;i++) {
		            System.out.println("Case#: " + i + " ");
		        	output.add(Integer.toString(FindNumber.start(input.get(i))));
		        }
		        
		        ReadWriteTextFile.doWriteTextFile(output);
	}
	 
}
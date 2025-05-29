import java.io.*;
import java.util.*;

public class CodeJamC {
	public static void main (String[] args) throws IOException {
		int i, j, k;
		long startTime = System.currentTimeMillis();
		File inFile  = new File("C-small-attempt0.in");  // File to read from
		File outFile = new File("C-small.out");
		
		BufferedReader reader = new BufferedReader(new FileReader(inFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
	
			
		String line = null;
		line = reader.readLine();
		int cases = Integer.parseInt(line);
		int counter = 1;
		
        while ((line=reader.readLine()) != null) {
        	int A,B;
        	int pairs = 0;
        	
        	String[] node = line.split(" ");
        	A = Integer.parseInt(node[0]);
        	B = Integer.parseInt(node[1]);
        	        
        	if ((node[0].length() == 1) || (A == B)) {
        		;
        	} else if (node[0].length() == 2) {
        		for(i = A; i <= B; i++) {
        			int oneth = i % 10;
        			int tenth = i /10;
        			int newNum = oneth*10+tenth; 
        			if(newNum > i && newNum <= B)
        				pairs++;
        		}
        	} else if (node[0].length() == 3) {
        		for(i = A; i <= B; i++) {
        			int oneth = i % 10;
        			int tenth = (i /10) % 10;
        			int hunth = i /100;
        			int newNum1 = oneth*100+hunth*10+tenth;
        			int newNum2 = tenth*100+oneth*10+hunth;
        			if(newNum1 > i && newNum1 <= B)
        				pairs++;
        			if(newNum2 > i && newNum2 <= B)
        				pairs++;
        		}
        	}
        	
        	//System.out.println("Case #"+counter+": "+pairs);
        	writer.write("Case #"+counter+": "+pairs);        	
        	writer.newLine();
        	counter++;        		
        }
        
        writer.close();       
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total Time: " + totalTime);		
	}
 }

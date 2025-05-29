import java.io.*;
import java.util.*;

public class CodeJamB {
	public static void main (String[] args) throws IOException {
		int i, j, k;
		long startTime = System.currentTimeMillis();
		File inFile  = new File("B-small-attempt0.in");  // File to read from
		File outFile = new File("B-small-practice.out");
		
		BufferedReader reader = new BufferedReader(new FileReader(inFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(outFile));
	
			
		String line = null;
		line = reader.readLine();
		int cases = Integer.parseInt(line);
		int counter = 1;
		
        while ((line=reader.readLine()) != null) {
        	int googlers = 0;
        	int N, S, p;
        	int sur = 0;
        	String[] node = line.split(" ");
        	N = Integer.parseInt(node[0]);
        	S = Integer.parseInt(node[1]);
        	p = Integer.parseInt(node[2]);
        	if(p <= 1) {
        		for(i = 3; i < node.length; i++) {   
        			if(Integer.parseInt(node[i]) >= p)
        				googlers++;
        		}
        	} else {
	        	for(i = 3; i < node.length; i++) {        		
	        		if(Integer.parseInt(node[i]) >= (3*p-2)) {
	        			googlers++;
	        		} else if (Integer.parseInt(node[i]) >= (3*p-4)) {
	        			sur++;
	        		}
	        	}       
        	}
        	googlers += Math.min(S, sur);
        	writer.write("Case #"+counter+": "+googlers);        	
        	writer.newLine();
        	counter++;        		
        }
        
        writer.close();       
        long endTime   = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("Total Time: " + totalTime);		
	}
 }

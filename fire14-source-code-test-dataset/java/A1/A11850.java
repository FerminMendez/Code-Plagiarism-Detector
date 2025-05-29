package Q1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Dancing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	     //Open the file for reading
		String thisLine;
		int numTest = 0;
	     try {
	       BufferedReader br = new BufferedReader(new FileReader("c:\\CodeJam\\Q1\\B-small-attempt0.in"));
	       Writer output = new BufferedWriter(new FileWriter("c:\\CodeJam\\Q1\\B-small-attempt0.out"));
	     
	       numTest = Integer.parseInt(br.readLine());
	       int ansCount = 0;
	       for (int i = 0; i < numTest; i++) {
	    	   ansCount = 0;
	    	   thisLine = br.readLine();
	    	   String[] inputArray = thisLine.split("\\s+");
	    	   int dancerNum = Integer.parseInt(inputArray[0]);
	    	   int surpriseNum = Integer.parseInt(inputArray[1]);
	    	   int pNum = Integer.parseInt(inputArray[2]);
	    	   
	    	   //System.out.println("Line 1 : d, s, p = "+dancerNum+", "+surpriseNum+", "+pNum);
	    	   for (int j = 0; j < dancerNum; j++) {
	    		   int total = Integer.parseInt(inputArray[3+j]);
	    		   if (total < pNum) {
	    			   continue;
	    		   }
	    		   
	    		   int middleScore = total/3;
	    		   int modScore = total%3;
	    		   if (middleScore == 0 && modScore >= pNum) {
	    			   ansCount++;
	    			   continue;
	    		   }
	    		   if (middleScore >= pNum) {
	    			   ansCount++;
	    		   }else if (modScore == 0 && middleScore+1 >= pNum && surpriseNum > 0){
	    			   ansCount++;
	    			   surpriseNum--;
	    		   }else if (modScore == 1 && middleScore+1 >= pNum) {
	    			   ansCount++;
	    		   }else if (modScore == 2 && middleScore+1 >= pNum) {
	    			   ansCount++;
	    		   }else if (modScore == 2 && middleScore+2 >= pNum && surpriseNum > 0) {
	    			   ansCount++;
	    			   surpriseNum--;
	    		   }
	    		   
	    		   //System.out.println("total "+ j +" : "+total + ", div = "+middleScore+", mod = "+modScore);
	    	   }
	    	   
	    	   System.out.println("Case #"+(i+1)+": "+ansCount);
	    	   
	    	   if (i == numTest-1) {
	    		   output.write("Case #"+(i+1)+": "+ansCount);
	    	   }else {
	    		   output.write("Case #"+(i+1)+": "+ansCount+"\n");
	    	   }
	    	   
	    	   
	       } // end while 
	       output.close();
	     } // end try
	     catch (IOException e) {
	       System.err.println("Error: " + e);
	     }
	}

}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 */

/**
 * @author Pandapotan Christian
 *
 */
public class RecycledNumbers {
	/*
	 * Write string to a file with specified path
	 */
	public static void writeFile(String filePath, String content){
		try{
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filePath)));
			out.write(content);
			out.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/*
	 * Return array that contains each lines of the input file, null if the reading process failed
	 */
	public static ArrayList<String> getLines(String filePath){
		ArrayList<String> lines = null;
		
		try{
			lines = new ArrayList<String>();
			
			String s;	    	   
		    BufferedReader in = new BufferedReader( new FileReader(filePath));
		    while ((s = in.readLine()) != null) {
		    	lines.add(s);	      
		    }	    
		    in.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return lines;
	}
	
	/**
	 * Replace value with the real path
	 */
	public static final String fileIn = "D:\\CodeJam\\RecycledNumbers-small-attempt0.in";	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		//get input from file						
		ArrayList<String> lines = getLines(fileIn);
		
		//process data
		if(lines!=null){			
			System.out.println("System Start");
			long systemStart = System.currentTimeMillis();
			
			String firstLine = lines.get(0);
			int T = Integer.parseInt(firstLine);				
					
			//Main Algorithm			
			StringBuffer result = new StringBuffer();
			for(int testIdx = 1; testIdx<=T; testIdx++){	
				System.out.println("Test Case Number: "+testIdx);
				long start = System.currentTimeMillis();    										
				
				String param[] = lines.get(testIdx).split(" ");
				int A = Integer.parseInt(param[0]);
				int B = Integer.parseInt(param[1]);							

				int total = countRecycle(A, B);
							
				long elapsedTime = System.currentTimeMillis() - start;
				System.out.println("Case #"+testIdx+" takes "+elapsedTime+"ms.");
				
				//Append the result with the previous testcase
				result.append("Case #"+testIdx+": "+ total+"\n");
			}
			
			//write the result to a file
			String fileOut = fileIn.replace(".in", ".out");
			writeFile(fileOut, result.toString());
			
			System.out.println("SUCCESS");
			long elapsedTimeSyetem = System.currentTimeMillis() - systemStart;
			System.out.println("Time Elapsed to run whole test case: "+elapsedTimeSyetem+"ms");
				
		}			
	}
	
	public static int countRecycle(int A, int B){
		int count = 0;
		for(int i = A; i<=B; i++){
			String number = i+"";
			HashMap<Integer, Boolean> checker = new HashMap<Integer, Boolean>();
			for(int charIdx = 1; charIdx<number.length(); charIdx++){
				String newNumberString = number.substring(charIdx) + number.substring(0, charIdx);
				int newNumber = Integer.parseInt(newNumberString);
				if(newNumber>i && newNumber<=B)
					checker.put(newNumber, true);			 			
			}				
			count += checker.size();
		}
		return count;
	}
}

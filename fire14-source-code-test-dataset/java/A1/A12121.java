import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Pandapotan Christian
 *
 */
public class DancingWithGooglers {
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
	public static final String fileIn = "D:\\CodeJam\\DancingGooglers-small-attempt0.in";	
	
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
				int N = Integer.parseInt(param[0]);
				int S = Integer.parseInt(param[1]);
				int p = Integer.parseInt(param[2]);
				int[] t = new int[N];
				for(int i=0; i<N; i++)
					t[i] = Integer.parseInt(param[i+3]);

				int maximumNumber = countMaximumNumber(t,S,p,N);
							
				long elapsedTime = System.currentTimeMillis() - start;
				System.out.println("Case #"+testIdx+" takes "+elapsedTime+"ms.");
				
				//Append the result with the previous testcase
				result.append("Case #"+testIdx+": "+ maximumNumber+"\n");
			}
			
			//write the result to a file
			String fileOut = fileIn.replace(".in", ".out");
			writeFile(fileOut, result.toString());
			
			System.out.println("SUCCESS");
			long elapsedTimeSyetem = System.currentTimeMillis() - systemStart;
			System.out.println("Time Elapsed to run whole test case: "+elapsedTimeSyetem+"ms");
				
		}			
	}
	
	public static int countMaximumNumber(int[] t, int S, int p, int N){
		int total=0;
		//1. construct possibilities
		ArrayList<ArrayList<String>> possibilities = getPossibilities();
		
		//2. traverse through loop
		for (int score : t) {
			//3. check whether have values >p,
			if(containNeededValue(possibilities.get(score), p)){
				//4. if yes check have if need surprising or not. if need, then total++ and S--
				if(needSurprising(possibilities.get(score), p)){
					if(S>0){
						total++;
						S--;
					}
				}
				//5. if yes and no need surprising then only total++
				else
					total++;
			}					
		}
		
		return total;
	}
	
	public static ArrayList<ArrayList<String>> getPossibilities(){		
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		
		for(int number = 0; number<=30; number++){
			ArrayList<String> possibilities = new ArrayList<String>();
			for(int first = 0; first<=10; first++)
				for(int second = 0; second<=10; second++)
					for(int third = 0; third<=10; third++){
						if((first+second+third==number) && !(Math.abs(first-second)>2 || Math.abs(first-third)>2 || Math.abs(second-third)>2))
							possibilities.add(first+" "+second+" "+third+ (isSurprising(first, second, third)?" S":"") );
					}
			result.add(possibilities);
		}
		
		return result;
	}
	
	public static boolean isSurprising(int first, int second, int third){
		return Math.abs(first-second)==2 || Math.abs(first-third)==2 || Math.abs(second-third)==2;
	}
	
	public static boolean containNeededValue(ArrayList<String> list, int p){
		boolean isExist = false;
		for (String string : list) {
			String[] numbers = string.split(" ");
			isExist = (Integer.parseInt(numbers[0])>=p || Integer.parseInt(numbers[1])>=p || Integer.parseInt(numbers[2])>=p );
			if(isExist) break;
		}
		return isExist;
	}
	
	public static boolean needSurprising(ArrayList<String> list, int p){
		boolean noNeed = false;
		for (String string : list) {
			String[] numbers = string.split(" ");
			noNeed = (Integer.parseInt(numbers[0])>=p || Integer.parseInt(numbers[1])>=p || Integer.parseInt(numbers[2])>=p ) && !string.contains("S");
			if(noNeed) break;
		}
		return !noNeed;
	}
}

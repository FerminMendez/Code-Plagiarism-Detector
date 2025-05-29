import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;





public class e {
	private static class ABPair{
		int A;
		int B;
	}
	static boolean  isPerm(int m, int n){
		boolean ret = false;
		for(int i = 0;i<String.valueOf(m).length();i++){
			String tester = String.valueOf(m).substring(i)+String.valueOf(m).substring(0,i);
			if(String.valueOf(n).equals(tester)){
				ret = true;
				break;
			}
		}
		return ret;
	}
	public static ABPair[] parseFile(String fileName){
		ABPair[] ret=null;
	     try{
	    	    FileInputStream fstream = new FileInputStream(fileName);
	    	    DataInputStream in = new DataInputStream(fstream);
	    	        BufferedReader br = new BufferedReader(new InputStreamReader(in));
	    	    String strLine;
	    	   int  lineCounter = 0;


	    	    while ((strLine = br.readLine()) != null)   {
	    	      if(lineCounter==0){
	    	    	  ret = new ABPair[Integer.valueOf(strLine)];
	    	    	  
	    	      }else{
		    	  
	    	      if(ret!=null){
	    	    	  StringTokenizer st = new StringTokenizer(strLine);
	    	    	  ABPair pair = new ABPair();
	    	    	     while (st.hasMoreTokens()) {
	    	    	    	
	    	    	    		 pair.A=Integer.valueOf(st.nextToken()).intValue();
	    	    	    		 pair.B=Integer.valueOf(st.nextToken()).intValue();
	    	    	     }
	    	      ret[lineCounter-1]=pair;
	    	      }
	    	      
	    	    }
	    	      lineCounter++;
	    	    }

	    	    in.close();
	    	    }catch (Exception e){
	    	      System.err.println("Error: " + e.getMessage());
	    	    }
		return ret;
	}
	public static void outputFile(String[] results, String fileName){
		PrintWriter pw = null;

	    try {


	        pw = new PrintWriter(new FileWriter(fileName));
	        int testNumber = 1;
	      for (String result:results) {

	        pw.println("Case #"+String.valueOf(testNumber)+": "+String.valueOf(result));
	        testNumber++;
	      }
	      pw.flush();

	    }
	    catch (IOException e) {
	      e.printStackTrace();
	    }
	    finally {
	      
	      //Close the PrintWriter
	      if (pw != null)
	        pw.close();
	      
	    }
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ABPair[] inputs = parseFile("/home/nick/C-small-attempt0.in");
		String[] results = new String[inputs.length];
		
		for(int i=0;i<inputs.length;i++){
			StringBuilder output = new StringBuilder();
			int count =0;
			for(int j = inputs[i].A; j<=inputs[i].B;j++){
				for(int k =j+1;k<=inputs[i].B;k++)
			if(isPerm(j, k)){
				count++;
			}
			}
			results[i]=String.valueOf(count);
		}

		outputFile(results, "/home/nick/outC.txt");
		
	}

}

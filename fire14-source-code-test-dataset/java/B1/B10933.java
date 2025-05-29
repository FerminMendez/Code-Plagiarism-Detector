import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class RecycledNumbers {
	
	public static ArrayList<Integer> palindroms = new ArrayList<Integer>();

	public static void main(String[] args) throws FileNotFoundException, IOException {
		File inFile = new File("/Users/johannesvietze/Desktop/C-small-attempt0.in");
	    
		
	    //read
	    StringTokenizer tok = new StringTokenizer(getContents(inFile),"\n");
	    tok.nextToken(); //delete first token
	    
	    String result = "";
	    int counter = 1;
	    
	    //compute
	    while(tok.hasMoreTokens()){
	    	String in = tok.nextToken(); //next line
	    	String[] current = in.split(" ");
	    	int a = Integer.parseInt(current[0]);
	    	int b = Integer.parseInt(current[1]);
	    	double res = 0;
	    	
	    	palindroms.clear();
	    	for(int n = a; n <= b; n++){
	    		if(n >= 10){
	    			res += getNumberOfRecycledNumbers(a, b, n);
	    		}
	    	}
	    	
	    	DecimalFormat df = new DecimalFormat("#");
	    	result += "Case #" + counter++ + ": ";
	    	result += df.format(res);
	    	result += "\n";
	    }
	    
	    //System.out.println(result);
	    
		//write
	    File outFile = new File("/Users/johannesvietze/Desktop/C-small-attempt0.out");
	    setContents(outFile, result);
		
	}
	
	public static double getNumberOfRecycledNumbers(int min, int max, int in){
		double result = 0;
		
		String currentS = Integer.toString(in);
		int length = currentS.length();
		
		for (int i = 0; i < length; i++) {
			
			currentS = currentS.charAt(length-1) + currentS.substring(0, length-1);
			
			if(Integer.parseInt(currentS) <= max && Integer.parseInt(currentS) > min && in < Integer.parseInt(currentS)){
				if(isPalindrom(String.valueOf(in)  + currentS)){
					if(!palindroms.contains(Integer.parseInt(String.valueOf(in)  + currentS))){
						palindroms.add(Integer.parseInt(String.valueOf(in)  + currentS));
						result++;
					}
				}else{
					result++;
				}
			}
		}
		
		return result;
	}
	
	public static boolean isPalindrom(String s){
		return s.equals(new StringBuffer(s).reverse().toString());
	}
	
	public static String getContents(File aFile) {
	    StringBuilder contents = new StringBuilder();
	    try {
	      BufferedReader input =  new BufferedReader(new FileReader(aFile));
	      try {
	        String line = null;
	        while (( line = input.readLine()) != null){
	          contents.append(line);
	          contents.append(System.getProperty("line.separator"));
	        }
	      }
	      finally {
	        input.close();
	      }
	    }
	    catch (IOException ex){
	      ex.printStackTrace();
	    }
	    
	    return contents.toString();
	  }

	public static void setContents(File aFile, String aContents) throws FileNotFoundException, IOException {
	    Writer output = new BufferedWriter(new FileWriter(aFile));
	    try {
	      output.write( aContents );
	    }
	    finally {
	      output.close();
	    }
	 }
}

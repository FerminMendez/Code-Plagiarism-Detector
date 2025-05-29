import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.StringTokenizer;


public class DancingWithTheGooglers {
	
	public static HashMap <String, String> mappings = new HashMap<String, String>();

	public static void main(String[] args) throws FileNotFoundException, IOException {
		File inFile = new File("/Users/johannesvietze/Desktop/B-small-attempt0.in");
	    
	    //read
	    StringTokenizer tok = new StringTokenizer(getContents(inFile),"\n");
	    tok.nextToken(); //delete first token
	    
	    String result = "";
	    int counter = 1;
	    
	    
	    //compute
	    while(tok.hasMoreTokens()){
	    	String in = tok.nextToken(); //next line
	    	
	    	StringTokenizer current = new StringTokenizer(in, " ");
	    	int n,s,p, min, safe, occ;
	    	n = Integer.parseInt(current.nextToken());
	    	s = Integer.parseInt(current.nextToken());
	    	p = Integer.parseInt(current.nextToken());
	    	min = p + 2 * (p-2);
	    	safe = p + 2 * (p-1);
	    	occ = 0;
	    	
	    	if(p > 1){ //regular
		    	while(current.hasMoreTokens()){
		    		int cur = Integer.parseInt(current.nextToken());
		    		if(safe <= cur) {occ++;} else //got p as max for sure
		    		if(min <= cur) {if(s>0){occ++;s--;}} //got p as max if surprises are still available 
		    	}
	    	}else if(p == 1){ //special case p == 1
	    		while(current.hasMoreTokens()){
	    			int cur = Integer.parseInt(current.nextToken());
	    			if(cur > 0){occ++;}
	    		}
	    	}else{ //special case p < 1
	    		occ = n;
	    	}
	    	result += "Case #" + counter++ + ": ";
	    	result += occ;
	    	result += "\n";
	    }
	    
		//write
	    File outFile = new File("/Users/johannesvietze/Desktop/B-small-attempt0.out");
	    setContents(outFile, result);
		
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

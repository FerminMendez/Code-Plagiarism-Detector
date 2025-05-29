import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class Recycling {
	Map<String, Boolean> map = null;
	
	public static void main(String[] args) {
		String inFile = args[0];
		//String inFile = "resources/C-small-attempt1.in";
		
		try {
			new Recycling().whatever(inFile, inFile+".out");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void whatever(String inFile, String outFile) throws NumberFormatException, IOException {
		StringBuffer out = new StringBuffer();
		BufferedReader br = new BufferedReader(new FileReader(new File(inFile)));
	    String line;
	    int currentLineNumber = 0;
	    int totalTestCases = 0;
	    
	    while((line = br.readLine()) != null) {
	    	if(currentLineNumber == 0){
	    		totalTestCases = Integer.valueOf(line);
	    		currentLineNumber++;
	    		continue;
	    	}
	    	
	    	String[] tokenizedLine = line.split(" ");
	    	int a = Integer.valueOf(tokenizedLine[0]);
	    	int b = Integer.valueOf(tokenizedLine[1]);
		
	    	int count = countRecyclings(a, b);
	    	out.append("Case #"+currentLineNumber+": "+count+System.getProperty("line.separator"));
	    	currentLineNumber++;
	    }
	    
	    writeTextToFile(out.toString(), outFile);
	}
	
	
	private int countRecyclings(int a, int b){
		map = new HashMap<String, Boolean>();
		int recyclingCount = 0;
		for(int n = a; n<= b; n++){
			for(int j = 1; j<(""+n).length(); j++){
				String r = (""+n).substring((""+n).length()-j);
				if(!r.startsWith("0")){
					String m = r+(""+n).substring(0, (""+n).length()-j);
					if(a <= n && n < Integer.valueOf(m) && Integer.valueOf(m) <= b){
						if(!map.containsKey(n+m)){
							map.put(n+m, true);
							recyclingCount++;
						}
					}
				}
			}
		}
		return recyclingCount;
	}
	
	private void writeTextToFile(String text, String outputFileName) throws IOException{
		 BufferedWriter out = new BufferedWriter(new FileWriter(outputFileName));
		 out.write(text);
		 out.close();
	}
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Dancing {
	
	
	Map<Integer, Map<Integer, Boolean>> bestResultsMap;
	
	public static void main(String[] args) {
		String inFile = args[0];
		//String inFile = "resources/B-small-attempt0.in";
		
		try {
			new Dancing().countGooglers(inFile, inFile+".out");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void countGooglers(String inFile, String outFile) throws NumberFormatException, IOException{
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
	    	int numberOfGooglers = Integer.valueOf(tokenizedLine[0]);
	    	int suprisingTriplets = Integer.valueOf(tokenizedLine[1]);
	    	int minBestResult = Integer.valueOf(tokenizedLine[2]);
	    	
	    	/*
	    	System.out.println("numberOfGooglers"+numberOfGooglers);
	    	System.out.println("suprisingTriplets"+suprisingTriplets);
	    	System.out.println("minBestResult"+minBestResult);
	    	System.out.println("tokenizedLine length: "+tokenizedLine.length);
	    	*/
	    	
	    	int[] resultTotals = new int[tokenizedLine.length - 3 ];
	    	for(int i = 3; i < tokenizedLine.length; i++){
	    		resultTotals[i-3] = Integer.valueOf(tokenizedLine[i]);
	    	}
	    	
	    	int googlers = calculateMaxGooglersForBestResult(numberOfGooglers, suprisingTriplets, minBestResult, resultTotals);
	    	out.append("Case #"+currentLineNumber+": "+googlers +System.getProperty("line.separator"));
	    	
	    	currentLineNumber++;
	    }
	    
	    writeTextToFile(out.toString(), outFile);
	    
	}
	
	
	private int calculateMaxGooglersForBestResult(int numberOfGooglers, int suprisingTriplets, int minBestResult, int[] totalPoints){
		int googlerCount = 0;
		int surprisedTriplets = 0;
		
		for (int totalPoint : totalPoints) {
			if(totalPoint < minBestResult){
				continue;
			}
			
			int twoResults = totalPoint - minBestResult;
			int r1 = twoResults / 2;
			int r2 = twoResults - r1;
			
			int apart = getMaxApart(minBestResult, r1, r2);
				
			
			if(apart < 2){
				googlerCount++;
			}else if(apart == 2){
				if(surprisedTriplets < suprisingTriplets){
					surprisedTriplets++;
					googlerCount++;
				}
			}
			
			//System.out.println("tot: "+totalPoint +" minbest "+minBestResult+" surp: "+suprisingTriplets+"-> "+minBestResult +":"+r1+":"+r2 +" apart: "+apart);
		}
		
		return googlerCount;
	}
	
	private int getMaxApart(int r1, int r2, int r3){
		int apart = 0;
		if(Math.abs(r1-r2) > Math.abs(apart)) apart = r1-r2;
		if(Math.abs(r3-r3) > Math.abs(apart)) apart = r2-r3;
		if(Math.abs(r1-r3) > Math.abs(apart)) apart = r1-r3;
		return apart;
	}
	
	private void writeTextToFile(String text, String outputFileName) throws IOException{
		 BufferedWriter out = new BufferedWriter(new FileWriter(outputFileName));
		 out.write(text);
		 out.close();
	}
}


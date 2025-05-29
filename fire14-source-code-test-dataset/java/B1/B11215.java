import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class RecycledNumbers {
	
	public static File inputFile, outputFile;
	public static List<String> inputLines = new ArrayList<String>();
	public static List<String> outputLines = new ArrayList<String>();
	
	public static Map<Character,Character> mapGtE = new HashMap<Character,Character>(); 
	
	private static void initFiles() {
		inputFile = new File("C:\\Users\\Enrique\\Desktop\\codejam\\RecycledNumbers\\C-small-attempt0.in");
		outputFile = new File("C:\\Users\\Enrique\\Desktop\\codejam\\RecycledNumbers\\RecycledNumbers.out");
	}
	
	
	private static void readInput() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(inputFile));		
			String line = ""; 
			int numberOfCases = Integer.parseInt(reader.readLine()); 
			for(int i=0; i<numberOfCases; i++) {		
				line=reader.readLine();
				inputLines.add(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void writeOutput() {
		PrintWriter writer;
		try {
			writer = new PrintWriter(outputFile);
			int numberOfCase = 1;
			int numberOfLines = outputLines.size();
			for(String outputLine : outputLines) {
				writer.print("Case #"+numberOfCase+": "+outputLine);
				if(numberOfCase!=numberOfLines) {
					writer.println("");					
				}			
				numberOfCase++;
			}
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void doAlgorithm() {		

		for(String inputLine : inputLines) {			
			StringTokenizer st = new StringTokenizer(inputLine," ");
			
			int downBounds = Integer.parseInt(st.nextToken());
			int upBounds = Integer.parseInt(st.nextToken());
			
			int outputLine = getResult(downBounds, upBounds);
			
			outputLines.add(String.valueOf(outputLine));
		}
		
		
	}
	
	private static int getResult(int downBounds, int upBounds) {
		
		Set<String> recycledPairs = new HashSet<String>();
		
		int result=0;	
		
		for(int i=downBounds; i<=upBounds; i++) {
				String numstr_rotate = String.valueOf(i);
				String numstr_original = String.valueOf(i);
				for(int j=1; j<=numstr_rotate.length()-1; j++) {
					numstr_rotate = numstr_rotate.charAt(numstr_rotate.length()-1)+numstr_rotate.substring(0,numstr_rotate.length()-1);				
					if(!numstr_rotate.equals(numstr_original)) {								
						if(Integer.parseInt(numstr_rotate) <= upBounds && Integer.parseInt(numstr_rotate) >= downBounds) {
							if(!recycledPairs.contains(numstr_original+":"+numstr_rotate) && !recycledPairs.contains(numstr_rotate+":"+numstr_original)) {						
								recycledPairs.add(numstr_original+":"+numstr_rotate);
								result++;
							}
						}
					}
				}
		}		
		
		return result;
	}
	

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		initFiles();
		
		readInput();	
		
		doAlgorithm();
		
		writeOutput();
	}
	
}

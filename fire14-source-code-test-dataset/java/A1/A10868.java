import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;


public class tongue {

	static HashMap<String, String> translationMap = new HashMap<String, String>();
	private static void init() {
		translationMap.put("a", "y");
		translationMap.put("b", "h");
		translationMap.put("c", "e");
		translationMap.put("d", "s");
		translationMap.put("e", "o");
		translationMap.put("f", "c");
		translationMap.put("g", "v");
		translationMap.put("h", "x");
		translationMap.put("i", "d");
		translationMap.put("j", "u");
		translationMap.put("k", "i");
		translationMap.put("l", "g");
		translationMap.put("m", "l");
		translationMap.put("n", "b");
		translationMap.put("o", "k");
		translationMap.put("p", "r");
		translationMap.put("q", "z");
		translationMap.put("r", "t");
		translationMap.put("s", "n");
		translationMap.put("t", "w");
		translationMap.put("u", "j");
		translationMap.put("v", "p");
		translationMap.put("w", "f");
		translationMap.put("x", "m");
		translationMap.put("y", "a");
		translationMap.put("z", "q");
		translationMap.put(" ", " ");
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		init();
		String inputFilePath = args[0];
		try {
			File inputFile = new File(inputFilePath);
			FileInputStream fis = new FileInputStream(inputFile);
			BufferedReader br = new BufferedReader(new InputStreamReader(fis)); 
			
//			translate(br);
			findScore(br);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static void findScore(BufferedReader br) throws NumberFormatException, IOException {
		String line = null;
		Integer numberOfLines = Integer.valueOf(br.readLine());
		if( !(1<=numberOfLines && numberOfLines<=100)){
			throw new IllegalArgumentException("Not valid number of lines");
		}
		
		for(int i=1; i<=numberOfLines; i++){
			line = br.readLine();
			String[] values = line.split(" ");
			
			
			int res = computeResult(values); // line.substring(5).trim()); 
			System.out.println("Case #"+i+": " +res);
		}
		
	}


	private static int computeResult(String[] values) {
		int peopleCount = Integer.valueOf(values[0].trim());
		int surprisingCount = Integer.valueOf(values[1].trim());
		int minScore = Integer.valueOf(values[2].trim());
		
		int foundCases =0;
		for (int i=3; i<values.length; i++) {
			String oneScore = values[i];
			Integer sc = Integer.valueOf(oneScore.trim());
			int base = sc/3;
			int left = sc%3;
			switch(left){
				case 0:
					if(base>=minScore){
						foundCases++;
					}
					else if(surprisingCount>0 && base>0 && base+1>=minScore){
						surprisingCount--;
						foundCases++;
					} 
					break;
				case 1:
					// normal case
					if(base>=minScore || (base+1)>=minScore){
						foundCases++;
					}
					// suprise use case
					else if(surprisingCount>0 && (base+1)>=minScore){
						foundCases++;
						surprisingCount--;
					}
					break;
				case 2:
					// normal case
					if(base>=minScore || (base+1)>=minScore){
						foundCases++;
					}
					// surprise case
					else if(surprisingCount>0 && (base+2)>=minScore){
						foundCases++;
						surprisingCount--;
					}
					break;
			}
			
		}
		return foundCases;
	}
	
	
	private static void translate(BufferedReader br) throws IOException {
		String line = null;
		StringBuffer result = new StringBuffer();
		Integer numberOfLines = Integer.valueOf(br.readLine());
		if( !(1<=numberOfLines && numberOfLines<=30)){
			throw new IllegalArgumentException("Not valid number of lines");
		}
		for(int i=1; i<=numberOfLines; i++){
			line = br.readLine();
			result.append(translateLine(line));
			System.out.println("Case #"+i+": " +result);
			result = new StringBuffer();
		}
	}

	private static StringBuffer translateLine(String line) {
		StringBuffer translatedLine = new StringBuffer();
		for (int i=0; i < line.length(); i++) {
			translatedLine.append(translateChar(line.charAt(i)));
		}
		return translatedLine;
	}

	private static String translateChar(char charAt) {
		return translationMap.get(new Character(charAt).toString());
	}

}

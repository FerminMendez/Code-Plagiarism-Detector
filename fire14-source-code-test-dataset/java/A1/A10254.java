import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class DancingGooglers {
	private String[] m_testInput;
	private String[] m_testOutput;
	private int[] m_bestNormal = {0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10};
	private int[] m_bestSurprising = {0, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10, 10};
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("CodeJam #1: Speaking In Tongues!");
		DancingGooglers dg = new DancingGooglers();

		//actual test cases:
		dg.m_testInput = dg.readInputTestCases("./testcases/input2.in");
		//length: System.out.println(sit.m_testInputGooglerese.length);
		int noOfTestCases = Integer.parseInt(dg.m_testInput[0]);
		System.out.println("Number of test cases: " + noOfTestCases);
		
		//for(int i : dg.m_bestNormal)
			//System.out.println(dg.m_bestNormal[i]);
		System.out.println(dg.m_bestNormal.length);
		System.out.println(dg.m_bestSurprising.length);
		

		
		String outputLine = null;
		dg.m_testOutput = new String[noOfTestCases];
		for(int i=1; i <= noOfTestCases; i++) {
			// translate each single testcase, write to output
			//dg.computeMaxResult(i);
			outputLine = "Case #" + i + ": " + dg.computeMaxResult(i);	// + sit.mapUnknownString(sit.m_testInputGooglerese[i]);
			dg.m_testOutput[i-1] = outputLine;
		}
		for(String s : dg.m_testOutput)
			System.out.println(s);
		
		//write to output file
		dg.writeOutputTestResults("./testcases/output2.out");
	}
	
	public DancingGooglers() {
/*		for int(i=1; i < 10; i++) {
			m_bestNormal[i] = 
		}*/
	}
	
	public int computeMaxResult(int _testCaseNo) {
		int res = 0;
		int curNormValue = -1;
		int curSurpriseValue = -1;
		int curSurprises = 0;
		String input = this.m_testInput[_testCaseNo];
		
		System.out.println(input);
		String[] inStrings = input.split(" ");
		Integer[] integers = new Integer[inStrings.length];
	    for(int i = 0; i < inStrings.length; i++) {
	        integers[i] = Integer.valueOf(inStrings[i]);
	    }
		int _noGooglers = integers[0];
		int _noSurprising = integers[1];
		int _bestResult = integers[2];
		//System.out.println(_noGooglers);
		
		for(int i=0; i < _noGooglers; i++) {
			curNormValue = m_bestNormal[integers[i+3]];
			curSurpriseValue = m_bestSurprising[integers[i+3]];
			System.out.println(curNormValue + " " + curSurpriseValue);
			System.out.println();
			
			if(curNormValue >= _bestResult)
				res++;
			else if(curSurprises < _noSurprising) {
				if(curSurpriseValue >= _bestResult) {
					res++;
					curSurprises++;
				}
			}
		}
		
		System.out.println("Result: " + res);
		return res;
	}
	
	public String[] readInputTestCases(String _filename) {
		try {
		    BufferedReader in = new BufferedReader(new FileReader(_filename));
		    String line = null;
		    List<String> lines = new ArrayList<String>();
		    
		    while ((line = in.readLine()) != null) {
		        //process(str);
		    	//System.out.println(line);
		    	lines.add(line);
		    }
		    in.close();
		    return lines.toArray(new String[lines.size()]);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void writeOutputTestResults(String _outputFilename) {
		//String[] array = ...  // wherever you get this from;  
				
		try {
		File file = new File(_outputFilename);  
		PrintWriter out = new PrintWriter(new FileWriter(file));  
		  
		// Write each string in the array on a separate line  
		for (String s : this.m_testOutput) {  
		    out.println(s);  
		}
		  
		out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

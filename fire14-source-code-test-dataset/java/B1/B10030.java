package recycledNumbers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class RecycledNumbers {

	private String inputPath;
	private String outputPath;
	private ArrayList<String> inputLines;
	private ArrayList<String> outputLines = new ArrayList<String>();
	
	public RecycledNumbers(String inputPath){
		
		try 
		{
			this.inputPath = inputPath;
			this.outputPath = inputPath.replace(".in", ".out");
			this.inputLines = openFile();
			
			findSolution();
			
			generateOutputFile();
		} 
		catch (IOException e) 
		{			
			e.printStackTrace();
		}	
	}
	
	private ArrayList<String> openFile() throws IOException
	{
		ArrayList<String> lines = new ArrayList<String>();
		FileReader fr = new FileReader(this.inputPath);
		BufferedReader br = new BufferedReader(fr);
		String zeile = null;
		
		while ((zeile = br.readLine()) != null)
		{
			lines.add(zeile);
		}
		br.close();
		
		return lines;
	}	
	
	private void generateOutputFile() throws IOException
	{
		FileWriter fw = new FileWriter(outputPath);
		PrintWriter pw = new PrintWriter(fw);
		
		for (String string : outputLines) {
			//System.out.println(string);	
			pw.println(string);
		}	
		
		pw.close();
	}
	
	private void findSolution()
	{
		
		
		for (int i=1; i<inputLines.size(); i++)
		{		
			Set<String> gefunden = new HashSet<String>();
			
			Integer m = 0;				
			String inp = inputLines.get(i);
			String outp = "Case #" + i + ": ";
			Integer A = Integer.parseInt( inp.split(" ")[0] );
			Integer B = Integer.parseInt( inp.split(" ")[1] );			
			
			for (Integer n=A; n<B; n++){					
				String N = n.toString();
				
				for (int j=1; j<N.length(); j++){
					String M = N.substring(j) + N.substring(0, j);
					if (!M.startsWith("0") && N.length() == M.length()) 
								m =  Integer.parseInt(M);					
										
					if (!M.startsWith("0") && m>n){
						if (m<=B){
							gefunden.add(n+"<->"+m);							
						}
					}					
				}
			}			
			outp += gefunden.size();
			outputLines.add(outp);
		}
	}
	
	public static void main(String[] args) {
		//new RecycledNumbers("src/recycledNumbers/sample.in");
		new RecycledNumbers("src/recycledNumbers/C-small-attempt0.in");

	}
}


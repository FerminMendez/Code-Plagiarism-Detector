package codejam;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class RecyledNumbers {

	public static void main(String[] args) {
		String filename = "C:\\Users\\maheswaran\\Desktop\\C-small-attempt0.in";
		String fileContents = readFile(filename);
		
		String[] lines = fileContents.split("\n");
		
		int noOfLines = Integer.parseInt(lines[0]);
		
		for(int i = 1; i <= noOfLines; i++)
		{
			int noOfRecyclables = 0;
			HashMap<String, String> recyclables = new HashMap<String, String>();
			
			String[] numbers = lines[i].split(" ",2);
			
			int start = Integer.parseInt(numbers[0]);
			int end = Integer.parseInt(numbers[1]);
			
			for( int j = start; j<=end; j++)
			{
				int digits = (start+"").length();
				
				for(int k = 1; k< digits;k++)
				{
					String numString = j+"";
					String shiftString = shift(numString,k);
					
					if(numString.equals(shiftString))
					{
						continue;
					}
					
					int shiftNum  = Integer.parseInt(shiftString); 
					if(shiftNum <= end && shiftNum>=start)
					{
						
						if(shiftNum > j)
						{
						
							recyclables.put(numString+","+shiftNum,"12");
							//noOfRecyclables++;
							continue;
						}
					}
					
					
				}
				
				
				
			}
			
			noOfRecyclables = recyclables.size();
			
			System.out.println("Case #"+i+": "+noOfRecyclables);
		}
		
	}
	
	private static String shift(String num, int numToShift)
	{
		String shiftedNum;
		int positionToSplit = num.length() - numToShift;
		shiftedNum = num.substring(positionToSplit) + num.substring(0,positionToSplit);
		
		return shiftedNum;		
	}

	private static String readFile(String filename)
	{
		StringBuffer file = new StringBuffer();
		try{
			  // Open the file that is the first 
			  // command line parameter
			  FileInputStream fstream = new FileInputStream(filename);
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  
			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null)   {
			  // Print the content on the console
			 file.append(strLine).append("\n");
			  }
			  //Close the input stream
			  in.close();
			    }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
		return file.toString();
		
	}


}

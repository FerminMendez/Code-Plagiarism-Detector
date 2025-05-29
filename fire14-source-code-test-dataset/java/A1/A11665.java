import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/** Main function is "solve" **/
public class CodeJamProblem2 {

		static HashMap<String,String> mappings=null;
		public static void main(String args[])
		{				
			solve();
		}

		private static void solve() {
				readFromInputAndWriteInOutput();			
		}

		private static void readFromInputAndWriteInOutput() {
			try {
				File f = new File("B-small-attempt1.in");
				FileReader fileReader = new FileReader(f);
				BufferedReader buff = new BufferedReader(fileReader);
				String totalTestCases = buff.readLine();
				PrintWriter printWriter = new PrintWriter("B-small-attempt1.out");
				int testCases = Integer.parseInt(totalTestCases);
				for(int i =1;i<=testCases;i++)
				{
					
					String line =  buff.readLine();
					String outputLine = "Case #"+i+": ";
					String result = solveForThisLine(line);
					outputLine = outputLine.concat(result);			
					printWriter.println(outputLine);
					//System.out.println(outputLine);
				}
				printWriter.close();
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}

		private static String solveForThisLine(String line) {
			
			String splitS[] = line.split(" ");
			int numberOfGooglers = Integer.parseInt(splitS[0]);
			int numberOfSurprisingScores = Integer.parseInt(splitS[1]);
			int reqP = Integer.parseInt(splitS[2]);
			int result = 0;
			int number=0;
			int quo = 0;
			int rem = 0;
			for(int i = 3;i<splitS.length;i++)
			{
				number =Integer.parseInt(splitS[i]);
				if(number==0 && reqP==0)
				{
					
					result=result+1;
					continue;
				}
				if(number ==0 )
					continue;
				quo = number/3;
				rem = number%3;
				rem = rem==0? 0 : 1;
				if(quo>=reqP || (rem+quo)>=reqP)
				{
					result=result+1;
					continue;
				}
				else 
				{
					if(numberOfSurprisingScores>=1)
					{
						number +=2;
						quo = number/3;
						rem = number%3;
						rem = rem==0? 0 : 1;
						if(quo>=reqP || (rem+quo)>=reqP)
						{
							result=result+1;
							numberOfSurprisingScores=numberOfSurprisingScores-1;
							continue;
						}
					
					}
						
				}
			}
			return result+"";
		}
}

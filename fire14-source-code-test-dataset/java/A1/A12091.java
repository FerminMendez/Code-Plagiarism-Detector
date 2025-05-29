package dancers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dancers {

	public static int SURPRISE = 0;
	public static int ATENDEE = 0;
	public static int BESTRESULT = 0;
	public static int[] SCORES;
	public static int[] RESULTS;
	public static String[] inputLines;
	
	
	public static void main(String args[])
	{
		try {
			readIo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		solveProblemsFromLine();
		try {
			saveOutputFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int countResult()
	{
		int result = 0;
		int mayResult = 0;
		for(int score:SCORES){
			if(score>=(BESTRESULT+(Math.max(0, 2*(BESTRESULT-1)))))
				result++;
			else
				if(score>=BESTRESULT+(Math.max(0,2*(BESTRESULT-2))))
					mayResult++;
		}
		mayResult = Math.min(mayResult, SURPRISE);
		
		return result+mayResult;
	}
	
	
	
	public static void readIo() throws Exception
	{
		 DataInputStream in = new DataInputStream(new FileInputStream("B.in"));//inp2.in
		 BufferedReader br = new BufferedReader(new InputStreamReader(in));
		 int lineNum = Integer.parseInt(br.readLine());
		 inputLines = new String[lineNum];
		 RESULTS = new int[lineNum];
		 String strLine=null;
		 int count=0;
		 while ((strLine = br.readLine()) != null)
		 {
			 inputLines[count] = strLine;
			 count++;
		 }		 
	}
	
	public static void parse(String input)
	{
		String tokens[] = input.split(" ");
		ATENDEE = Integer.parseInt(tokens[0]);
		SURPRISE = Integer.parseInt(tokens[1]);
		BESTRESULT = Integer.parseInt(tokens[2]);
		SCORES = new int[ATENDEE];
		for(int i = 3; i<tokens.length; i++)
			SCORES[i-3] = Integer.parseInt(tokens[i]);
		
	}
	
	
	public static void solveProblemsFromLine()
	{
		for(int inp=0; inp<inputLines.length;inp++)
		{
			parse(inputLines[inp]);
			RESULTS[inp] = countResult();
			System.out.println(RESULTS[inp]);
		} 
		
	}
	
	public static void saveOutputFile() throws IOException
	{
		BufferedWriter out = new BufferedWriter(new FileWriter("result.txt"));
		for(int i=0; i<RESULTS.length; i++)
		{
			out.write("Case #"+(i+1)+": "+ RESULTS[i]);
			out.newLine();
		}
		out.flush();
		out.close();
	}
}

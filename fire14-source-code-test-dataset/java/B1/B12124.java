package Television;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Television {
	
	public static int Max=0;
	public static int Min = 0;
	public static List<Pair> currentCandidate = new ArrayList<Pair>();
	public static String[] inputLines;
	public static int[] RESULTS; 
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
	
	public static void readIo() throws Exception
	{
		 DataInputStream in = new DataInputStream(new FileInputStream("C.in"));//inp2.in
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
		Min = Integer.parseInt(tokens[0]);
		Max = Integer.parseInt(tokens[1]);		
	}
	
	public static void solveProblemsFromLine()
	{
		for(int inp=0; inp<inputLines.length;inp++)
		{
			parse(inputLines[inp]);
			try {
				RESULTS[inp] = findProperIntegers();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			System.out.println(RESULTS[inp]);
		} 
		
	}
	
	public static int findProperIntegers() throws Exception	
	{
		for(int integer = Min; integer<=Max; integer++)
		{
			
			ArrayList<Pair> pPair=null;
			if((pPair=checkValid(integer)).size()!=0)
				for(Pair childPair : pPair){
					if(currentCandidate.contains(childPair))
					{
						System.out.println("repeated value");
						continue;
					}else
					currentCandidate.add(childPair);
				}
										
		}
		int result = currentCandidate.size();
		
		if(result==288)
		{
			for(Pair pp:currentCandidate)
				System.out.println("("+pp.a+", "+pp.b+")");
		}
		
		currentCandidate.clear();
		return result;
	}
	
	public static ArrayList<Pair> checkValid(int data) throws Exception
	{
		String dataStr = Integer.toString(data);
		String left, result;
		String right;
		
		ArrayList<Pair> resultPairs = new ArrayList<Pair>();
		for(int pos=1;pos<dataStr.length(); pos++)
		{
			left = dataStr.substring(0, pos);
			right = dataStr.substring(pos);
			
			result=right+left;
			int nextInt = Integer.parseInt(result);
			
			if(result.charAt(0)!='0' && nextInt>data && nextInt<=Max && nextInt!=data && data>=Min)
				resultPairs.add(new Pair(data, nextInt));
			
		}
		return resultPairs;
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

package actual;
import java.io.*;
import java.util.*;

public class C
{
	String line;
	StringTokenizer inputParser;
	BufferedReader is;
	FileInputStream fstream;
	DataInputStream in;
	
	void openInput(String file)
	{

		//is = new BufferedReader(new InputStreamReader(System.in));//stdin
		try{
			fstream = new FileInputStream(file);
			in = new DataInputStream(fstream);
			is = new BufferedReader(new InputStreamReader(in));
		}catch(Exception e)
		{
			System.err.println(e);
		}

	}
	
	void readNextLine()
	{
		try {
			line = is.readLine();
			inputParser = new StringTokenizer(line, " ");
			//System.err.println("Input: " + line);
		} catch (IOException e) {
			System.err.println("Unexpected IO ERROR: " + e);
		}	
		
	}
	
	int NextInt()
	{
		String n = inputParser.nextToken();
		int val = Integer.parseInt(n);
		
		//System.out.println("I read this number: " + val);
		return val;
	}
	
	String NextString()
	{
		String n = inputParser.nextToken();
		return n;
	}
	
	void closeInput()
	{
		try {
			is.close();
		} catch (IOException e) {
			System.err.println("Unexpected IO ERROR: " + e);
		}
			
	}
	
	public static void main(String [] argv)
	{
		C c = new C(argv[0]);
	}
	public C(String inputFile)
	{
		openInput(inputFile);
		readNextLine();

		int TC = NextInt();
		
		for(int t=0; t<TC; t++)
		{	
			int ret=0;
			readNextLine();
			int A=NextInt();
			int B=NextInt();
			for(int i=A; i<B; i++)
				ret+=get(i, B);
			System.out.println("Case #"+(t+1)+": "+ret);
		}
		closeInput();
	}

	private int get(int a, int B) {
		int ret=0;
		String s=""+a;
		List <Integer> all = new ArrayList<Integer>();
		for(int i=1; i<s.length(); i++)
		{
			String s2=s.substring(i)+s.substring(0, i);
			int b=Integer.parseInt(s2);
			if(b>a&&b<=B)
			{
				if(all.contains(b))continue;
				all.add(b);
				
				ret++;
			}
		}
		
		return ret;
	}
	
}


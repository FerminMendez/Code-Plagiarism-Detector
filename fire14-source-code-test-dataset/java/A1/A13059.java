package actual;
import java.io.*;
import java.util.*;

public class B
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
		new B(argv[0]);
	}
	
	public B(String inputFile)
	{
		openInput(inputFile);
		readNextLine();

		int TC = NextInt();
		
		for(int t=0; t<TC; t++)
		{	
			int ret=0, sup=0;
			readNextLine();
			int N=NextInt();
			int S=NextInt();
			int p=NextInt();
			
			for(int i=0; i<N; i++)
			{
				int b=NextInt();
				if(p==0)ret++;
				else if(p==1)
				{
					if(b>0)ret++;
				}
				else
				{
					if(b>=(p*3-2))ret++;
					else if(b>=(p*3-4))sup++;
				}
			}
			ret+=Math.min(S, sup);
			
			System.out.println("Case #"+(t+1)+": "+ret);
		}
		closeInput();
	}

	
}


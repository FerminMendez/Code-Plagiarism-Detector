package gcj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) {
	
		String filenamein = "B-small-attempt1.in";
		String filenameout = "out.txt";
		
		try
		{
			  FileInputStream fstreamin = new FileInputStream(filenamein);
			  DataInputStream in = new DataInputStream(fstreamin);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  
			  FileWriter fstreamout = new FileWriter(filenameout);
			  BufferedWriter out = new BufferedWriter(fstreamout);

			  String strLine = br.readLine();
			  int nCases = Integer.parseInt(strLine);
			  int counter = 1;	  
			  while ((strLine = br.readLine()) != null)   
			  {
				  System.out.println (strLine);
				  
				  String solu = Solve(strLine);
				  
				  System.out.println (solu);
				  System.out.println ();
				  
				  out.write("Case #"+ counter++ +": " + solu + "\n");
			  }

			  in.close();
			  out.close();
		}
		catch (Exception e)
		{
			  System.err.println("Error: " + e.getMessage());
		}
	}

	private static String Solve(String strLine) 
	{
		String[] ss = strLine.split(" ");
		
		int n = Integer.parseInt(ss[0]);
		int s = Integer.parseInt(ss[1]);
		int p = Integer.parseInt(ss[2]);
		
		int sum = 0;
		
		int valorIntermedio = 3*p;
		
		if(valorIntermedio == 0)
		{
			sum = n;
		}
		else if(valorIntermedio == 3)
		{
			int count = 0;
			for(int i = 0 ; i < n ; i++)
			{
				int t = Integer.parseInt(ss[i+3]);
				if(t>0) count++;
			}
			sum = count;
		}
		else
		{
			for(int i = 0 ; i < n ; i++)
			{
				int t = Integer.parseInt(ss[i+3]);
				
				if(t >= valorIntermedio-2)
				{
					sum++;
				}
				
				else if(s > 0 && t >= valorIntermedio-4)
				{
					s--;
					sum++;
				}
			}
		}
		
		return String.valueOf(sum);
	}

}

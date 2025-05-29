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
	
		String filenamein = "C-small-attempt0.in";
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
		
		int A = Integer.parseInt(ss[0]);
		int B = Integer.parseInt(ss[1]);
		
		int length = String.valueOf(A).length();
		
		int suma = 0;
		
		for(int num = A ; num <= B ; num++)
		{
			int[] permu = generaPermu(num, length);
			if(permu != null)
			{
				for(int j = 0 ; j < permu.length ; j++)
				{
					if (permu[j] <= B && permu[j] > num) suma++;
				}
			}
		}
		
		return String.valueOf(suma);
	}

	private static int[] generaPermu(int num, int length) 
	{
		int[] permu = null;
		
		if(length > 1)
		{
			permu = new int[length-1];
			permu[0] = cambia(num, length);
			for(int j = 1 ; j < permu.length ; j++)
			{
				permu[j] = cambia(permu[j-1], length);
			}
			
			
			//Evito repetidos!!!
			for(int j = 0 ; j < permu.length ; j++)
			{
	            for (int k = j + 1; k < permu.length ; k++)
	            {
	                if (permu[j] == permu[k]) permu[k] = -1;
	            }
			}
		}
		
		return permu;
	}

	private static int cambia(int i, int l) 
	{
		return (int) ((i + (i % 10) * Math.pow(10, l)) / 10);
	}
}

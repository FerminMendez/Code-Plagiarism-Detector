package common;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class FileRead 
{
	public static StringBuffer read()
	{
		FileInputStream fstream=null;
		 DataInputStream in=null;
		 BufferedReader br=null;
		 StringBuffer sb=new StringBuffer("");
	  try
	  {
		  fstream = new FileInputStream("D:/tony/code jam/Recycledf Numbfers/C-small-attempt0.in");
		  in = new DataInputStream(fstream);
		  br = new BufferedReader(new InputStreamReader(in));
		  String strLine;
		  while ((strLine = br.readLine()) != null)   
		  {
			  sb=sb.append (strLine+"\n");
		  }
	  }
	  catch (Exception e)
	  {
		  System.err.println("Error: " + e.getMessage());
	  }
	 finally
	 {
		 try
		 {
			 br.close();
			 in.close();
			 fstream.close();
		 }
		 catch (Exception e)
		  {
			  System.err.println("Error: " + e.getMessage());
		  }
	}
	  return sb;
	  
	}
}

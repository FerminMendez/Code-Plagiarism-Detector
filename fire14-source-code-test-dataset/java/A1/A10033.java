package com.code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Writer;

public class ReadWriteInputFile 
{
	public BufferedReader readInputFile(String filePath)
	{
		try 
		{
			FileInputStream fstream = new FileInputStream(filePath);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			return br;
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}	
	}
	
	public Writer writeOutputFile(String filePath)
	{
		try
		{
			File file = new File(filePath);
			Writer outWriter = new BufferedWriter(new FileWriter(file));
			return outWriter;
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
		
	}
	
	public void closeObjects(Writer outWriter)
	{
		try
		{
			outWriter.close();
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
}

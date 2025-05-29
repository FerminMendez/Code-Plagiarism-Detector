package com.code.jam;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecycledNumbers {

	FileInputStream in;
	FileOutputStream out;
	BufferedReader br;

	void open() throws IOException {
		in = new FileInputStream(new File(
				"/home/lenovo/Documents/GCJ/C-small-attempt0.in"));
		out = new FileOutputStream(new File(
				"/home/lenovo/Documents/GCJ/C-small-attempt0.out"));

		br = new BufferedReader(new InputStreamReader(new DataInputStream(in)));

	}

	void close() throws IOException {
		out.close();
	}

	void run() throws IOException {
		int tn = new Integer(br.readLine());
		for (int i = 1; i <= tn; i++) {

			// System.out.println(br.readLine());
			String AB = br.readLine();
			BigInteger A = new BigInteger(AB.split(" ")[0]);
			BigInteger B = new BigInteger(AB.split(" ")[1]);

			int count = 0;
			Map nm = new HashMap();
			
			
			
			for (BigInteger k = A; k.compareTo(B) ==  -1; k = k
					.add(BigInteger.ONE)) {

				String n = k.toString();
				String	m = n;
				nm.clear();
				
				
				for(int l=0;l<n.length();l++)
				{
							m  = rotateDigitRight(m);
					
							BigInteger mBig = new BigInteger(m);
					
						if (mBig.compareTo(k) >0 && mBig.compareTo(B) <= 0 && mBig.compareTo(A) >0 && !nm.containsValue(m) )
						{
							count++;							
							
							nm.put(n, m);
							
							System.out.println(n + ", " +m+"   "+ count);
						
						}	
				}
					
				}
				

							
							
							
			

			out.write(("Case #" + i + ": " + count).getBytes());
			out.write("\n".getBytes());
		}

	}

	public static String rotateDigitRight(String A) {

	
		String val = A.toString();
		
		String val0 = String.valueOf(val.charAt(val.length()-1));
		
		
		
		String valRest = "";
		if(val.length()>=2)
		{
			 valRest = val.substring(0, val.length()-1);
		}

		
		val = val0 + valRest;
		
		
		return val;

	}

	public static void main(String[] args) throws IOException {
		RecycledNumbers solution = new RecycledNumbers();
		solution.open();
		solution.run();
		solution.close();
	}

}

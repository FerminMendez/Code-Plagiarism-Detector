package org.code.jam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class RecycledNumbers 
{
	public static void main(String[] args) 
	{
		try 
		{
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\academics\\CodeJamWS\\C-small-attempt0.in")));
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("D:\\academics\\CodeJamWS\\small-output.txt")));
			
			String lineInput = in.readLine();
			int counter = 1;
			Integer a,b;
			
			while( (lineInput = in.readLine()) != null)
			{
//				System.out.println(lineInput);
//				System.out.println(decodeInput(lineInput));
//				out.write("Case #" + counter + ": " + decodeInput(lineInput));
				StringTokenizer tok = new StringTokenizer(lineInput," ");
				a = Integer.valueOf(tok.nextToken());
				b = Integer.valueOf(tok.nextToken());
//				System.out.println(distinctRecyclables(a, b));
//				distinctRecyclables(a, b);
				out.write("Case #" + counter + ": " + distinctRecyclables(a, b));
//				System.out.println(Integer.MAX_VALUE);
				out.newLine();
				counter++;
			}
			
			in.close();
			out.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static int distinctRecyclables(Integer a,Integer b)
	{
		int cnt = 0;;
		String comboString;
		ArrayList<String> recyclablesCombo = new ArrayList<String>();
		
		if(String.valueOf(a).length() == 1)
			return 0;
		
		for(int i = a; i < b ; i++)
		{
			comboString =  String.valueOf(i);
			for(int j = String.valueOf(i).length() - 1; j > 0 ; j--)
			{
				int origint = Integer.valueOf(comboString);
				int quotient = Integer.valueOf(comboString) / 10;
				int remainder = Integer.valueOf(comboString) % 10;
				
				comboString =  "" + remainder + quotient;
				int permutedint = Integer.valueOf(comboString); 
				if(remainder != 0 && permutedint <= b && permutedint >= a &&  permutedint != i && permutedint != origint && !(recyclablesCombo.contains(permutedint + "," + i) || recyclablesCombo.contains(i + "," + permutedint)))
				{
					if(i < permutedint)
						recyclablesCombo.add(i + "," + permutedint);
					else
						recyclablesCombo.add(i + "," + origint);
					
					if(origint == i)
						cnt++;
				}
			}
		}
		
		System.out.println(recyclablesCombo.size());
		/*for(int i = 0; i < recyclablesCombo.size(); i++)
			System.out.println(recyclablesCombo.get(i));*/
		
		
		
		return recyclablesCombo.size();
	}
}

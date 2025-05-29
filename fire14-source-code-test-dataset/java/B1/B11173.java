package com.google;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class RecycledNumbers {

	public static void main(String[] args) throws Exception{
		RecycledNumbers s = new RecycledNumbers();
		s.solve();
		
	}
	public void solve() throws Exception
	{
		int lines = Integer.parseInt(readLine());
		for(int i=0;i<lines;i++)
		{
			String line = readLine();
			if(line == null)
				break;
			String[] comps = line.split(" ");
			int A = Integer.parseInt(comps[0]);
			int B = Integer.parseInt(comps[1]);
			int count = 0;
			
			for(int j=A;j<=B;j++)
			{
				boolean[] a = new boolean[2000001];
				String n = Integer.toString(j);
				for(int k=0;k<n.length()-1;k++)
				{
					n =  n.charAt(n.length()-1) + n.substring(0,n.length()-1);
					String n2 = n;
					while(n2.charAt(0) == '0')
					{
						if(n2.length() == 0)
							break;
						n2 = n2.substring(1,n2.length());
					}
					int n1 = Integer.parseInt(n2);
					if(n1 < A || n1 > B || n1 <= j)
						continue;

					if(!a[n1])
					{
						count++;
						a[n1] = true;
					}
				}
			}
			if(i == lines-1)
				writeLine("Case #" + (i+1) + ": " + count);
			else
				writeLine("Case #" + (i+1) + ": " + count + "\n");
		}
		o.close();
	}
	BufferedReader f = null;
	public String readLine() throws Exception
	{
		if(f == null)
			f = new BufferedReader(new FileReader(new File("C:\\Users\\raj617\\workspace\\srm\\dat\\C-small-attempt0.in")));
		return f.readLine();
	}
	BufferedWriter o = null;
	public void writeLine(String line) throws Exception
	{
		if(o == null)
			o = new BufferedWriter(new FileWriter(new File("C:\\Users\\raj617\\workspace\\srm\\dat\\out.txt")));
		o.write(line );
		o.flush();
	}
}

package com.google;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class DancingWithGooglers {

	public static void main(String[] args) throws Exception{
		DancingWithGooglers s = new DancingWithGooglers();
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
			int N = Integer.parseInt(comps[0]);
			int S = Integer.parseInt(comps[1]);
			int p = Integer.parseInt(comps[2]);
			
			int n1 = p *3;
			int n2 = p *3 -1;
			int n3 = p *3 -2;
			int n4 = p *3 -3;
			int n5 = p *3 -4;
			int count=0;
			for(int j=0;j<N;j++)
			{
				int n = Integer.parseInt(comps[j+3]);
				if(n <p)
					continue;
				
				if(n >= n1)
					count++;
				else if(n == n2 || n == n3)
					count++;
				else if(n == n4 || n == n5)
				{
					if(S > 0)
					{
						count++;
						S--;
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
			f = new BufferedReader(new FileReader(new File("C:\\Users\\raj617\\workspace\\srm\\dat\\B-small-attempt0.in")));
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

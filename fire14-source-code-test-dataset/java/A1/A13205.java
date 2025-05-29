package com.codejam;


import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;

public class DancingWithTheGooglers {

	public static void main(String[] args) {
		try {
			FileInputStream fstream = new FileInputStream(
					"D:\\Softwares\\B-small-attempt0.in");
			
			DataInputStream in = new DataInputStream(fstream);

			FileOutputStream out = new FileOutputStream(
					"D:\\Softwares\\B-small-attempt0.out");
			PrintStream p = new PrintStream(out);

			int lineNo = 1;
			
			while (in.available() != 0) {
				if (lineNo == 1) {
					cases(in.readLine(), in, p);
				}
				lineNo++;
			}

			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static void cases(String firstLine, DataInputStream in,
			PrintStream p) throws IOException {
		int casesNo = Integer.parseInt(firstLine);
		for (int i = 0; i < casesNo; i++) {
			p.print("Case #" + (i + 1) + ": ");
			String line = in.readLine();
			googlers(line, p);
		}

	}

	private static void googlers(String line, PrintStream p) {
		
		String lines[] = line.split(" ");
		int suprises = Integer.parseInt(lines[1]);
		int reqP = Integer.parseInt(lines[2]);
		int result = 0;
		int number=0;
		int quo = 0;
		int rem = 0;
		for(int i = 3;i<lines.length;i++)
		{
			number =Integer.parseInt(lines[i]);
			if(number==0 && reqP==0)
			{
				
				result=result+1;
				continue;
			}
			if(number ==0 )
				continue;
			quo = number/3;
			rem = number%3;
			rem = rem==0? 0 : 1;
			if(quo>=reqP || (rem+quo)>=reqP)
			{
				result=result+1;
				continue;
			}
			else 
			{
				if(suprises>=1)
				{
					number +=2;
					quo = number/3;
					rem = number%3;
					rem = rem==0? 0 : 1;
					if(quo>=reqP || (rem+quo)>=reqP)
					{
						result=result+1;
						suprises=suprises-1;
						continue;
					}
				
				}
					
			}
		}
		p.println(result+"");
	}

}

package t2012.classification;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class ExB {

	
	
	
	
	public void exec(String filename, String out_filename)
	{
		try{
			FileInputStream fis = new FileInputStream(filename); 
			Scanner s = new Scanner(fis);
			
			FileWriter output_fstream = new FileWriter(out_filename);
			BufferedWriter out = new BufferedWriter(output_fstream);
			
			// The problem
			int T = Integer.parseInt(s.nextLine());
			for(int testNum = 1; testNum <=T; testNum++)
			{
				System.out.println(testNum);
				String line = s.nextLine();
				String[] list = line.split(" ");
				int N = Integer.parseInt(list[0]);
				int S = Integer.parseInt(list[1]);
				int p = Integer.parseInt(list[2]);
				int numGood = 0;
				int numSurp = 0;
				int discarded = 0;
				for(int i = 3; i < N+3; i++)
				{
					int sum = Integer.parseInt(list[i]);
					if(sum >= 3*p-2 && sum >=p)
					{
						numGood++;
					}
					else if(sum < 3*p-2 && sum >= 3*p-4 && sum >=p)
					{
						numSurp++;
					}
					else
					{
						discarded++;
					}
				}
				int result = numGood + Math.min(numSurp,S);
				out.write("Case #"+testNum+": "+result+"\n");
				
			}
			
			// End the problem
			
			out.close();
			output_fstream.close();
		}catch(Exception e)
		{
			System.out.println("Some error occurred");
		}
	}


	public static void main(String args[])
	{
		String PATH= "/home/pau/development/workspace/CodeJam/testfiles/2012/";
		ExB a = new ExB();
		a.exec(PATH + "B-small-attempt0.in", PATH + "B-small-attempt0.out");
		//a.exec(PATH + "B-large-practice.in", PATH + "B-large-practice.out");
	}

}

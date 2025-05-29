package dancing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class DanceAllNight {
	
	
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader(new File("test.txt")));
		BufferedWriter wr = new BufferedWriter(new FileWriter(new File("output.txt")));
		int count = Integer.parseInt(br.readLine());
		int yes,surprising,p,numsurprising,current,div3,output;
		String[] buffer;
		int[] values;
		for(int i=1; i<=count; i++)
		{
			String line = br.readLine();
			buffer = line.split(" ");
			values = new int[buffer.length];
			for(int j=0; j<buffer.length; j++)
			{
				values[j] = Integer.parseInt(buffer[j]);
			}
			yes = 0;
			surprising =0;
			p = values[2];
			numsurprising = values[1];
			
			for(int k=3; k<values.length; k++)
			{
				current = values[k];
				div3 = current/3;
				if(current % 3 == 0)
				{
					if(div3 >= p)
					{
						yes++;
					}
					else if(div3 == p-1  && current >= p)
						{
							surprising++;
						}
				}
				else if(current %3 == 1)
				{
					if(div3 >= p-1 && current >= p)
					{
						yes++;
					}
					
				}
				else
				{
					if(div3 >= p-1 && current >= p)
					{
						yes++;
					}
					else if(div3  == p-2 && current >= p)
					{
						surprising++;
					}
				}
					
				
			}
			output = Math.min(yes+surprising, yes+numsurprising);
			//make sure that its not more than the total # of contestants
			//output = Math.min(output, values[0]);
			wr.write("Case #"+i+": "+output);
			
			wr.newLine();
			
		}
		wr.close();
	}
	
}

package classes;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Recycle
{
	public static void main(String[] args)
	{
		try
		{
			FileInputStream fstream = new FileInputStream("/Users/jleibsly2002/C-small-attempt0.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine = br.readLine();
			int N = Integer.parseInt(strLine);
			
			for(int i = 0; i < N; i++)
			{
				int count = 0;
				String[] range = br.readLine().split(" ");
				int min = Integer.parseInt(range[0]);
				int max = Integer.parseInt(range[1]);
				int length = range[0].length();
				
				ArrayList<String> numbers = new ArrayList<String>();
				for(int j = min; j <= max; j++)
					numbers.add(j + "");
				
				
				for(int k = 0; k < numbers.size(); k++)
				{
					String n = numbers.get(k);
					for(int l = length-1; l>=1; l--)
					{
						String recycled = n.substring(l) + n.substring(0, l);
						if(numbers.contains(recycled) &&
								recycled.charAt(0)!='0' &&
								recycled.compareTo(n)>0)
						{
							count++;
						}
					}
				}
				
				System.out.println("Case #" + (i+1) + ": " + count);
			}
			
			in.close();
		}
		catch (Exception e){
			System.err.println("Error: " + e.getMessage());
		}
	}
}

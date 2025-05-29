// Calculate num of recycled pairs
// Anna Thalassinos
// 14 April 2012

import java.io.*;
import java.util.Scanner;

public class RecycledPairs{
public static void main(String[] args)
{
	Scanner input = null;
	PrintWriter out = null;
	
	try
	{
		input = new Scanner(new FileInputStream("C-small-attempt0.in"));
		out = new PrintWriter(new FileOutputStream ("pairs.out"));
		
		int numLines = Integer.parseInt(input.nextLine());
		String[] lines = new String[numLines];

		int[][] AB = new int[numLines][2]; 
			
		int[] temp = new int[2];
		
		for(int i = 0; i < numLines; i++)
		{
			lines[i] = input.nextLine();
			temp[0] = Integer.parseInt(lines[i].split(" ")[0]);
			temp[1] = Integer.parseInt(lines[i].split(" ")[1]);
			AB[i][0] = temp[0];
			AB[i][1] = temp[1];
			
		}
		
			
		int max;
		int min;
	
		int[] range;
		int match = 0;
		int size = 0;

		for(int j = 0; j < numLines; j++)
		{
			match = 0;
			max = AB[j][1];
			min = AB[j][0];
		
			range = new int[max-min+1];
			
			for(int k = 0; k < range.length; k++)
			{
				range[k] = min;
				min++;
			}
			int[] sums = new int[range.length];
			// calculate sums of numbers
			
			size=(""+range[0]).length();
			for(int l = 0; l <range.length; l++)
			{
				for(int p = 0; p < (range[l]+ "").length(); p++)
				{
					String strNum = range[l] + "";
					String check = strNum.charAt(p)+ "";
					sums[l] += Integer.parseInt(check);
					
				}				
			}

			for(int o = 0; o < sums.length; o++)
			{
				for(int s = o+1; s < sums.length; s++)
				{ int thisMatch = 0;
					if(sums[o] == sums[s])
					{thisMatch =0;
						for(int len2= 0; len2 < (range[s]+ "").length(); len2++)
						{
								if((""+range[s]).contains(""+(""+range[o]).charAt(len2)))
								{
									
									String newNum = "";
									
									for(int move = 0; move < size; move++)
									{
										
										if(range[s]/(int)Math.pow(10, move)==0)
										{
											newNum = ""+ range[s]%(int)Math.pow(10, move);
										}
										
										else if(range[s]%(int)Math.pow(10, move)==0)
										{
											newNum= ""+ range[s]/(int)Math.pow(10, move);
										}
										
										else
										{
											newNum= ""+ range[s]%(int)Math.pow(10, move) + "" + range[s]/(int)Math.pow(10, move);
										}
										
										
										if(Integer.parseInt(newNum) == range[o])
										{
											thisMatch++;
											match++; 
											
										}
										
										
									}
								}
								
						}
					}
				}
					
			}
			if((AB[j][1]-AB[j][0])== (AB[j][0]))
			{
				match--;
			}
			
			out.write("Case #" + (j+1) + ": " + (match/size)+"\n");
			out.flush();
			
			}
		}

	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	
}
}

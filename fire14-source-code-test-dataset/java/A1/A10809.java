/**
 * 
 */
package me.adrabi.codejam;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Adrabi Abderrahim, z3vil
 *
 */
public class P2
{
	
	private static int SURPRISING = 0;
	
	public static void main(String[]$) throws NumberFormatException, IOException
	{
		List<String> dancers = new ArrayList<String>();
		{
			BufferedReader reader = new BufferedReader( new InputStreamReader(new FileInputStream("p2")));
			int count = Integer.parseInt(reader.readLine());
			
			String line = null;
			while((line = reader.readLine()) != null)
			{
				dancers.add(line);
			}
		}
		
		int currentLine = 1;
		for(String line : dancers)
		{
			String elements[] = line.split(" ");
			// 0 - number of dancers
			// 1 - Surprise
			// 2 - score
			final int score = Integer.parseInt(elements[2]);
			
			int currentScoreAccepted = 0;
			
			//System.out.print(line+ "\t\t");
			
			for(int index = 3 ; index < elements.length; index++)
			{
				int surp = Integer.parseInt(elements[1]);
				int scorces[] = calcNumber(Integer.parseInt(elements[index]) , surp > 0 && surp > SURPRISING, score);
				for(int tmp : scorces)
				{
					if(tmp >= score)
					{
						currentScoreAccepted++;
						break;
					}
				}
			}
			
			SURPRISING = 0;
			System.out.printf("Case #%d: %d\n", currentLine++ , currentScoreAccepted, score);
		}
	}
	
	public static int[] calcNumber(int number, boolean isSuprising, int score)
	{
		
		if(number == 0)
		{
			return new int[]{0, 0, 0};
		}
		else 
		{
			int pass = 0;
			boolean change = false;
			while((pass < 3 || !change) || (pass > -3 && change))
			{
				int part1 = -1;
				int part2 = -1;
				int part3 = -1;
				
				if(number > 3)
				{
					part1 = number/2 - (isSuprising? ( number % 2 == 0 ? 2 : 1) : 0);
					part2 = part1/2  - pass;
					part3 = -1;
					
					if(part1 + part2 > 20)
					{
						part2 = 20 - part1;
					}
					else if((part1 + part2) % 2 == 1)
					{
						part2--;
					}
					part1 += part2;
					for(int bruteForce = 10; bruteForce > 0; bruteForce--)
					{
						int tmp = Math.abs((part1/2) - bruteForce);
						boolean active = false;
						if(part1 + bruteForce == number && (tmp == 1 || tmp == 0 || ( tmp == 2 && (active = isSuprising))))
						{
							if(active)
							{
								SURPRISING++;
							}
							part3 = bruteForce;
							break;
						}
					}
				}
				else
				{
					part1 = part2 = part3 = 0;
					change = true;
					pass = -4;
				}
				
				if(part3 > -1)
				{
					int x = part1/2, y = part1/2, z = part3;
					
					if(number == 1)
					{
						x = 1;
						y = 0;
						z = 0;
					}
					else if(number == 2)
					{
						x = 1;
						y = 1;
						z = 0;
					}
					else if(number == 3)
					{
						x = 1;
						y = 1;
						z = 1;
					}
					
					if( (x < score && y < score && z < score) && isSuprising)
					{
						if(z + 1 <= 10 && z + 1 >= score)
						{
							if( x - 1 < y && y < z + 1 && Math.abs((x - 1) - y) <= 1 && Math.abs((x-1) - (z+1)) <= 2)
							{
								SURPRISING++;
								//System.out.printf("(%d, %d, %d)", x -1 , y, z + 1);
								return new int[]{x -1 , y, z + 1};
							}
							else if( y - 1 < x && x < z + 1 && Math.abs(x - (y-1)) <= 1 && Math.abs((z+1) - (y-1)) <= 2)
							{
								SURPRISING++;
								//System.out.printf("(%d, %d, %d)", x , y - 1, z + 1);
								return new int[]{x , y - 1, z + 1};
							}
							else
							{
								//System.out.printf("(%d, %d, %d)", x , y, z);
								return new int[]{ x , y, z};
							}
						}
						else if(z + 2 <= 10 && z + 2 >= score && x == y && Math.abs((z + 2) - (y - 1)) == 2)
						{
							SURPRISING++;
							//System.out.printf("(%d, %d, %d)", x - 1 , y - 1, z + 2);
							return new int[]{x + 1 , y - 1, z + 2};
						}
						else
						{
							//System.out.printf("(%d, %d, %d)", x, y, z);
							return new int[]{ x , y, z};
						}
					}
					else
					{
						//System.out.printf("(%d, %d, %d)", x, y, z);
						return new int[]{ x , y, z};
					}
				}
				else
				{
					if(change)
					{
						pass--;
					}
					else
					{
						pass++;
					}
					if(pass >= 3)
					{
						change = true;
						pass = -1;
					}
				}
			}
		}
		return new int[]{ -1 , -1, -1};
	}
}

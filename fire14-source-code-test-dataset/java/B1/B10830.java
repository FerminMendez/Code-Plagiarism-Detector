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
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Adrabi Abderrahim, z3vil
 *
 */
public class P3
{
	public static void main(String[]$) throws NumberFormatException, IOException
	{
		List<String> recycled = new ArrayList<String>();
		{
			BufferedReader reader = new BufferedReader( new InputStreamReader(new FileInputStream("p3")));
			int count = Integer.parseInt(reader.readLine());
			
			String line = null;
			while((line = reader.readLine()) != null)
			{
				recycled.add(line);
			}
		}
		
		int currentLine = 1;
		for(String line : recycled)
		{
			String numbers[] = line.split(" ");
			if(numbers.length > 1)
			{
				Map<String, Integer> tmp = new TreeMap<String, Integer>();
				
				int a = Integer.parseInt(numbers[0]), b = Integer.parseInt(numbers[1]), count = 0;
				
				for(int index = a ; index <= b; index++)
				{
					String array[] = (index+"").split("");
					
					if(isSimilare(array))
					{
						continue;
					}
					
					List<String> elements = toList(array);
					
					int steps = array.length - 2;
					while(steps >= 1)
					{
						String element = elements.get(elements.size() - 1);
						elements.remove(elements.size() - 1);
						elements.add(0, element);
						steps--;
						
						String number = toString(elements);
						if(number.startsWith("0"))
						{
							continue;
						}
						else if(number.endsWith("00"))
						{
							continue;
						}
						else
						{
							int testNumber = Integer.parseInt(number);
							if( index < testNumber && testNumber <= b )
							{
								if(tmp.containsKey(number))
								{
									tmp.put(number, tmp.get(number) + 1);
								}
								else
								{
									tmp.put(number, 1);
								}
								if(tmp.get(number) < 4)
								{
									count++;
								}
							}
						}
					}
				}
				
				System.out.printf("Case #%d: %d\n", currentLine++, count);
			}
			else
			{
				System.out.printf("Case #%d: 0\n", currentLine++);
			}
		}
		
		
	}
	
	private static boolean isSimilare(String[]array)
	{
		String lastElement = array[1];
		boolean check = true;
		for(int start = 2; start < array.length; start++)
		{
			if(!lastElement.equals(array[start]))
			{
				check = false;
				break;
			}
			lastElement = array[start];
		}
		return check;
	}
	
	private static String toString(List<String> list)
	{
		String str = "";
		for(String tmp : list)
		{
			str += tmp;
		}
		return str;
	}
	
	private static List<String> toList(String array[])
	{
		List<String> list = new ArrayList<String>();
		for(int start = 1; start < array.length; start++)
		{
			list.add(array[start]);
		}
		return list;
	}
}

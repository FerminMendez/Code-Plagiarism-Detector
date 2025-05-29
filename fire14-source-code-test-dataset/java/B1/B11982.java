package recycledNumbers;

import java.util.*;

public class RecycledNumbers 
{
	public int countRecylcedNumbers(int x, int y )
	{
		
		int count =0;
		int m=x+1;
		ArrayList<ArrayList<String>>  arrayList= new ArrayList<ArrayList<String>>();
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0;i<y;i++)
		{
			
			arrayList.add(null);
		}
		boolean flag = true;;
		for(int i=m;i<=y;i++)
		{
			int[] array = recycledNumber(i);
			list = new ArrayList<String>();
			for(int j=0;j<array.length;j++)
			{
				
				if(array[j]<=y && array[j]!=i && array[j]!=0 && array[j]>=x)
				{
					flag = true;
					if(i==m)
					{
						System.out.println(i + "    " + array[j]);
						count++;
						list.add(new Integer(array[j]).toString());
					}
					else
					{
						ArrayList<String> searchList= arrayList.get(array[j]);
						if(searchList!= null)
						{
							for(int k=0;k<searchList.size();k++)
							{
								if(Integer.parseInt(searchList.get(k))==i)
								{
									flag = false;
								}
							}
						}
						if(flag != false)
						{
							System.out.println(i + "    " + array[j]);
							count++;
							list.add(new Integer(array[j]).toString());
						}
						
					}
				}
			}
			arrayList.add(i, list);
		}
		System.out.println(count);
		return count;
	}
	public int digitCount(int x)
	{
		int count=0;
		while(x!=0)
		{
			x/=10;
			count++;
		}
		return count;
		
	}
	
	public int[] recycledNumber(int x)
	{
		int y, count = 0;
		count = digitCount(x);
		y=count-1;
		int place;
		int lastInt;
		int[] array = new int[y];
		int i=0;
		while(y!=0)
		{
			place = (int) Math.pow(10, count-1);
			lastInt = x%10;
			x/=10;
			x=lastInt*place + x;
			if(digitCount(x)==count)
			{
				array[i++]=x;
			}
			y--;
		}
		return array;
	}
}

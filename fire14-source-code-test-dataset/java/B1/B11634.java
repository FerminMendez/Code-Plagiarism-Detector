import java.util.*;
import java.io.*;

public class qualC
{
	public static void main(String[] args) throws IOException
	{
		Scanner sin = new Scanner(new File("/Users/G/Documents/Programming/Java/CodeJam2012/C-small-attempt0.in"));
		
		int t = sin.nextInt(), a, b;
		for(int i = 1; i <= t; ++i)
		{
			a = sin.nextInt();
			b = sin.nextInt();
			int ret = 0;
			
			for(long j = a; j <= b; ++j)
			{
				if(j >= 10)
				{
					int length = 0;
					long firstPosition, shift=j;
					for(firstPosition = 1; firstPosition <= shift; firstPosition*=10) length++;
					firstPosition /= 10;
					
					long[] numbers = new long[length];
					
					for(int k = 0; k < length; ++k)
					{
						long lastDigit = shift%10;
						shift /= 10;
						shift += firstPosition*lastDigit;
						
						numbers[k] = shift;
						boolean found = false;
						
						for(int m = 0; m < k; ++m)
						{
							if(shift == numbers[m])
							{
								found = true;
								break;
							}
						}
						
						if(shift >= a && shift <= b && j < shift && lastDigit != 0 && !found)
						{
							ret++;	
						}
					}	
				}
			}
			
			System.out.println("Case #"+i+": "+ret);
		}
	}
}

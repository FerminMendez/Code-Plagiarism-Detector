import java.io.*;
import java.util.*;

class Main
{
	public static void main(String[] args) throws Exception
	{
		Main m = new Main();
		m.foo();
	}
	
	long count = 0;
	void foo() throws Exception
	{
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner s = new Scanner(System.in);
		
		int T = s.nextInt();
		int testNum = 1;
		while(T-->0)
		{
			int numGooglers = s.nextInt();
			int numSurprises = s.nextInt();
			int p = s.nextInt();
			
			int[] scores = new int[numGooglers];
			for(int k=0; k<scores.length; k++)
			{
				scores[k] = s.nextInt();
			}
			
			Arrays.sort(scores);
			
			int ret = 0;
			for(int k=0; k<scores.length; k++)
			{
				int sc = scores[k];
				
				if(sc < p)
					continue;
				
				int d = sc/3;
				int r = sc%3;
				//System.out.printf("sc: %d, d: %d, r: %d\n", sc, d, r);
				
				if(r==0)
				{
					if(d >= p)
					{
						ret++;
						continue;
					}
					// TODO: Handle a surprise
					if(d+1 >= p && numSurprises != 0)
					{
						ret++;
						numSurprises--;
						continue;
					}
				}
				else if(r==1)
				{
					if(d+1 >= p)
					{
						ret++;
						continue;
					}
					// TODO: Handle a surprise
					// I can't.
				}
				else if(r==2)
				{
					if(d+1 >= p)
					{
						ret++;
						continue;
					}
					// TODO: Handle a surprise
					if(d+2 >= p && numSurprises != 0)
					{
						ret++;
						numSurprises--;
						continue;
					}
				}
				
			}
			//ret += numSurprises;
			//ret -= Math.max(0, numSurp - numSurprises);
			
			//System.out.printf("Known surprises: %d, Found surprises: %d\n", numSurprises, numSurp);
			System.out.printf("Case #%d: %d\n", testNum, ret);
			testNum++;
		}
	}
}
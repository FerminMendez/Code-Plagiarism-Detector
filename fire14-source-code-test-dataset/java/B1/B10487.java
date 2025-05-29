import java.util.Scanner;


public class Recycle {
	public static void main(String args[])
	{		
		int t;
		int save[] = new int[50];
		Scanner kb = new Scanner(System.in);
		t = kb.nextInt();
		int a,b;
		for(int i=0;i<t;i++)
		{
			a = kb.nextInt();
			b = kb.nextInt();
			int change = 0;
			int count = 0;
			System.out.print("Case #"+(i+1)+": ");
			
			for(int j=a;j<=b;j++)
			{
				
				String s = Integer.toString(j); 
				int x=0;
				for(int start=1;start<s.length();start++)
				{
					int max=0;
					change = 0;
					for(int k=start-1;max<s.length();max++,k--)
					{
						if(k<0) k = s.length()-1;
						change = change + (s.charAt(k)-'0')*((int)Math.pow(10,max));
						if(max==s.length()-1)
						{
							save[x++] = change;
						}
						
					}
					if(change<=b && change>=a && change!=j && change>j) 
					{
						int point=0;
						for(int y=0;y<x-1;y++)
						{
							if(save[y]==change) 
							{
								point=1;
								break;
							}
						}
						if(point==0)
						{	
							count++;
						}
					}
				}
			}
			System.out.println(count);
		}
		
	}
}

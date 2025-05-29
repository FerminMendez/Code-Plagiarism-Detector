
public class Dancing_With_the_Googlers {

	public int solve1(int s, int p, int[] t)
	{
		int ans=0;
		for (int i=0;i<t.length;i++)
		{
			boolean next=false;
			for(int a0=0;a0<=t[i];a0++)
			{
				for(int a1=0;a0+a1<=t[i];a1++)
				{
					int a2=t[i]-a1-a0;
					if(a2<0)
						continue;
					
					if(Math.abs(a0-a1)<=2 && Math.abs(a1-a2)<=2 && Math.abs(a0-a2)<=2)
					if(Math.abs(a0-a1)<2 && Math.abs(a1-a2)<2 && Math.abs(a0-a2)<2)
					{
						if(a0>=p || a1>=p || a2>=p)
						{
							ans++;
							next=true;
							break;
						}
					}

				}
				if(next)
					break;
			}
			if(next)
				continue;
			for(int a0=0;a0<=t[i];a0++)
			{
				for(int a1=0;a0+a1<=t[i];a1++)
				{
					int a2=t[i]-a1-a0;
					if(a2<0)
						continue;
					if(Math.abs(a0-a1)<=2 && Math.abs(a1-a2)<=2 && Math.abs(a0-a2)<=2)
					if((Math.abs(a0-a1)==2 || Math.abs(a1-a2)==2 || Math.abs(a0-a2)==2) && s>0)
					{
						if(a0>=p || a1>=p || a2>=p)
						{
							s--;
							ans++;
							next=true;
							break;
						}
					}
				}
				if(next)
					break;
			}			
		}
		
		return ans;
	}
	
	public int solve(int s, int p, int[] t)
	{
		int whichContainsMoreThanP=0;
		int ans=0;
		for (int i=0;i<t.length;i++)
		{
			if(t[i]==0)
			{
				if(0>=p)
					ans++;
				continue;
			}else if(t[i]==1)
			{
				if(1>=p)
					ans++;
				continue;
			}else if(t[i]==2)
			{
				if(1>=p)
					ans++;
				else if(2>=p && s>0)
				{
					ans++;
					s--;
				}
				continue;
			}
			
			int reminder=t[i]%3;
			int division=t[i]/3;

			switch(reminder)
			{
				case 0:// 1,2 or 0,0
					if(division>=p)
						whichContainsMoreThanP++;
					else
						if(division-1+2>=p && s>0)
						{
							s--;
							ans++;
						}
					break;
				case 1:// 2,2 or 0,1
					if(division+1>=p)
						whichContainsMoreThanP++;
					else
						if(division-1+2>=p && s>0)
						{
							s--;
							ans++;
						}
					break;
				case 2:// 0,2 or 1,1
					if(division+1>=p)
						whichContainsMoreThanP++;
					else
						if(division+2>=p && s>0)
						{
							s--;
							ans++;
						}
					break;
				default:
			}
		}
		return ans+whichContainsMoreThanP;
	}
}
/*
 import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;


public class Program {


	public static void main(String[] args) {
		
		try {
			FileWriter fileWriter=new FileWriter("B-small-attempt0.out");
			FileReader fileReader=new FileReader("B-small-attempt0.in");
			BufferedReader in = new BufferedReader(fileReader);

			int T= Integer.parseInt(in.readLine());
			for(int t=1;t<=T;t++)
			{
				String[] tokens= in.readLine().split(" ");
				int N= Integer.parseInt(tokens[0]);
				int[] values=new int[N];
				int S= Integer.parseInt(tokens[1]);
				int p= Integer.parseInt(tokens[2]);
				
				for(int n=0;n<N;n++)
				{
					values[n]= Integer.parseInt(tokens[n+3]);
				}
				
				Dancing_With_the_Googlers d=new Dancing_With_the_Googlers();				
				int result=d.solve(S, p, values);
				fileWriter.write("Case #"+t +": " +result+"\n");
				
			}
			fileWriter.close();
			fileReader.close();	
		} catch (Exception e) {
			System.out.println("Error! Exception: "+e); 
		}
		
		
	}

}

 */
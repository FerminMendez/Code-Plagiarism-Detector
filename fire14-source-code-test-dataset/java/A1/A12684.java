import java.io.*;

/*
 *Problem

You're watching a show where Googlers (employees of Google) dance, and then each dancer is given 
a triplet of scores by three judges. Each triplet of scores consists of three integer scores from 0 to 10 inclusive.
The judges have very similar standards, so it's surprising if a triplet of scores contains two scores that are 2 apart.
No triplet of scores contains scores that are more than 2 apart.
For example: (8, 8, 8) and (7, 8, 7) are not surprising. (6, 7, 8) and (6, 8, 8) are surprising. (7, 6, 9) will never happen.

The total points for a Googler is the sum of the three scores in that Googler's triplet of scores. 
The best result for a Googler is the maximum of the three scores in that Googler's triplet of scores. 
Given the total points for each Googler, as well as the number of surprising triplets of scores, what is 
the maximum number of Googlers that could have had a best result of at least p?
 **/

public class Dancing_With_the_Googlers
{
	public static void main(String[] args)
	{
		try
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(new File("g:/G.txt"))));
			int n=Integer.parseInt(br.readLine());
			String str=null;
			String arr[]=new String[n];
			String array[];
			File f=new File("g:/Output1.txt");
			f.createNewFile();
			int N=0,S=0,P=0;
			int count=0;
			int rescount=0;
			boolean result[];
			for(int i=0;i<n;i++)
			{
				str=br.readLine();
				array=str.split(" ");
				N=Integer.parseInt(array[0]);
				S=Integer.parseInt(array[1]);
				P=Integer.parseInt(array[2]);
				count=0;rescount=0;
				for(int j=1;j<=N;j++)
				{
					System.out.println("Number"+Integer.parseInt(array[2+j]));
					if((N-j+1)>(S-count))
					{
						if(S-count>0)
							result=getResult(Integer.parseInt(array[2+j]),P,true,true);
						else
							result=getResult(Integer.parseInt(array[2+j]),P,true,false);	
					}
					else
					{
						if(S-count>0)
						result=getResult(Integer.parseInt(array[2+j]),P,false,true);
						else 
						result=getResult(Integer.parseInt(array[2+j]),P,false,false);		
					}
					if(result[0])
					{
						rescount++;
						System.out.println("rescount"+rescount);
					}
					if(result[1])
					{
						count++;
						System.out.println("count"+count);
					}
				}
				arr[i]=new String("Case #"+(i+1)+": "+rescount);
			}
				FileWriter bout=new FileWriter(f);
		for(int i=0;i<n;i++)
		{
			bout.append(arr[i]+"\n");			
		}
		bout.close();
		}	
		catch(IOException e1)
		{
			e1.printStackTrace();
		}	
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
	public static boolean[] getResult(int sum,int P,boolean flag,boolean flag1)
	{
		int temp;
		boolean result[]=null;
		int a=0,b,c;
		temp=sum/3;
		if(temp==0)
		{
			if(P==0)
				return new boolean[]{true,false};
			else
				return new boolean[]{false,false};
		}
		if(temp>=P)
		{
			System.out.println("1 ");
			if(flag)
				return new boolean[]{true,false};
			else 
				return new boolean[]{true,true};
		}
		if(temp+1>=P)
		{
			a=temp+1;
			b=c=temp;
			System.out.println("+2 "+a);
			if(a+b+c==sum)
				return new boolean[]{true,false};
			b=b+1;
				if(a+b+c==sum)
				return new boolean[]{true,false};	
		
		}
		if(temp+2>=P)
		{
			System.out.println("+3 "+a);
			a=temp+2;
			b=c=temp+1;
			if(a+b+c==sum)
				return new boolean[]{true,false};	
			
		}
		if(temp-1>=P)
		{
			a=temp-1;
			b=c=temp;
			System.out.println("+4 "+a);
			if(a+b+c==sum)
				return new boolean[]{true,false};	
			c=c+1;		
			if(a+b+c==sum)
				return new boolean[]{true,false};	
			
		}
		if(temp-2>=P)
		{
			a=temp-2;
			b=c=temp-1;
			System.out.println("+5 "+a);
			if(a+b+c==sum)
				return new boolean[]{true,false};	
			
		}
	if(temp+1>=P)
		{
			a=temp+1;
			b=c=temp;
			c=c-1;
			System.out.println("+6 "+a);
			if(a+b+c==sum&&flag1)
				return new boolean[]{true,true};
			b=b-1;
			if(a+b+c==sum&&flag1)
				return new boolean[]{true,true};
		}
		if(temp+2>=P)
		{
			a=temp+2;
			b=c=temp+1;
			c=c-1;
			System.out.println("+7 "+a);
			if(a+b+c==sum&&flag1)
				return new boolean[]{true,true};
			b=b-1;
			if(a+b+c==sum&&flag1)
				return new boolean[]{true,true};
		}
			if(temp-1>=P)
		{
			a=temp-1;
			b=c=temp;
			b=b+1;
			System.out.println("+8 "+a);
			if(a+b+c==sum&&flag1)
				return new boolean[]{true,true};
			c=c+1;
			if(a+b+c==sum&&flag1)
				return new boolean[]{true,true};			
		}
		if(temp-2>=P)
		{
			a=temp-2;
			b=c=temp-1;
			b=b+1;
			System.out.println("+9 "+a);
			if(a+b+c==sum&&flag1)
				return new boolean[]{true,true};
			c=c+1;
			if(a+b+c==sum&&flag1)
				return new boolean[]{true,true};
		}
		
		return new boolean[]{false,false};
	}

	 
}
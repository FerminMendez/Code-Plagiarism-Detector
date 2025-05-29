import java.io.*;
import java.util.*;
class GoogleRecycle
{
	public static void main(String[] args)
	{
		Integer a,b,m,n;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Scanner sc=new Scanner(new InputStreamReader(System.in));
		int t=sc.nextInt();
		String ans[]=new String[t];
		for(int i=0;i<t;i++)
		{
			a=sc.nextInt();
			b=sc.nextInt();
			HashMap<Integer, HashMap<Integer,Integer>> h=new HashMap<Integer, HashMap<Integer,Integer>>();
			int temp=b,d=0,req=0;
//			System.out.println(a+" "+b);
//			System.out.println("********");
			while(temp!=0)
			{
				temp/=10;
				d++;
			}
			for(int j=a;j<b;j++)
			{
				temp=1;
				int rem,quo,oth;
				for(int k=1;k<d;k++)
				{
					temp*=10;
					rem=j%temp;
					quo=j/temp;
					oth=(int) (rem*Math.pow(10,(d-k)) + quo);
					if(oth<=b && oth >=a && oth>j)
					{
						if(h.containsKey(j))
						{
							if(h.get(j).containsKey(oth))
								continue;
							h.get(j).put(oth,1);
//							System.out.println(j+" "+oth);
							req++;
						}
						else
						{
							HashMap<Integer,Integer> ht=new HashMap<Integer,Integer>();
							ht.put(oth,0);
							h.put(j,ht);
//							System.out.println(j+" "+oth);
							req++;
						}
					}
					
				}
			}
			ans[i]="Case #"+(i+1)+": "+req;
//			System.out.println("------");
//			System.out.println(req);	
//			System.out.println("**********");
		}
		for(int i=0;i<t;i++)
			System.out.println(ans[i]);
	}

}

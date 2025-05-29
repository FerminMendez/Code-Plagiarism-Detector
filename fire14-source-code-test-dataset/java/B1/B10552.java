import java.io.*;
import java.util.*;

public class recycle
{	
	public static void main(String[] args) throws Exception
	{
		int cases;
		BufferedReader in=new BufferedReader(new FileReader("input.in"));
		PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("recycle.out")));
		cases=Integer.parseInt(in.readLine());
		int numPairs=0;
		
		for (int k=0; k<cases; k++)
		{
			numPairs=0;
			String a,b;
			int left, right;
			StringTokenizer stg=new StringTokenizer(in.readLine());
			a=stg.nextToken();
			b=stg.nextToken();
			left=Integer.parseInt(a);
			right=Integer.parseInt(b);
			String[] checked=new String[a.length()];
			
			outer:for(int j=left; j<=right; j++)
			{
				if(a.length()==1)
					break;
				String temp=""+j;
				Arrays.fill(checked,null);
				inner:for(int m=0; m<temp.length()-1; m++)
				{
					temp=temp.charAt(temp.length()-1)+temp.substring(0,temp.length()-1);
					for(int n=0; n<m; n++)
					{
						if(temp.equals(checked[n]))
							continue inner;
					}
					checked[m]=temp;
					int n=Integer.parseInt(temp);
					if(n>j && n>left && n<=right)
					{
						numPairs++;
					}
				}
			}
			out.println("Case #"+(k+1)+": "+numPairs);
		}
		
		out.close();
	}
}

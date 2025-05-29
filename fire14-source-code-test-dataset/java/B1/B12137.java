import java.io.*;

public class C
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());	
		
		String[] line;
		for(int i=1;i<=T;i++)
		{
			line = br.readLine().split("\\W+");
			int a = Integer.parseInt(line[0]);
			int b = Integer.parseInt(line[1]);
			System.out.println("Case #"+i+": "+recycled(a,b));
		}
	}
	
	public static long recycled(int a,int b)
	{
		long ret = 0;
		for(int i=a;i<b;i++)
		{
			int temp = i;
			int len = 0;
			int p;
			for(p = 1;temp/p!=0;p*=10)len++;
			
			p = p/10;
			int in = 10;
//			System.out.println(i+" length "+len);
			for(int j=1;j<len;j++, in *= 10)
			{
				int r  = temp%in;
				int l  = temp/in;
				int n  = (r*10*p)/in;
				n  += l;
				if(n<=i || n<a || n > b) continue;
				//System.out.println(i+" "+n);
				ret++;
			}
		}
		return ret;
	}	
}

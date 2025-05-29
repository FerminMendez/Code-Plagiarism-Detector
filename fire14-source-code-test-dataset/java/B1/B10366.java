

import java.util.Scanner;
public class CodeJam3 {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int s=in.nextInt();
		for(int i=0;i<s;i++)
		{
			long c=0;
			long v1=in.nextInt();
			long v2=in.nextInt();
			for(long k=v1;k<v2;k++)
			{
				String begin=new Long(k).toString();
				long b=0;
				long n=0;
				for(int j=1;j<begin.length();j++)
				{ 
					String temp=begin.substring(j)+begin.substring(0,j);
					long t1=Long.parseLong(temp);
					n=t1;
					if(v1<=k && k<t1 && t1<=v2)
					{
						if(n!=b)
						{
							c++;
						}
						b=n;
						
					
					}
				}					
			}
			System.out.println("Case #"+(i+1)+": "+c);
		}
		

	}

}

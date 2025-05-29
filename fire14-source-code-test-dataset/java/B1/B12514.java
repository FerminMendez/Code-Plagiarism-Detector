import java.io.*;
import java.util.*;
import java.math.*;
public class recycle
{
	static int A=0;
	static int B=0;
	static int C=0;
	static int T=0;
	static int ans=0;
	static HashSet<Integer> ansset= new HashSet<Integer>();
	public static void main(String[] args)
	{
		Scanner scan= new Scanner(System.in);
		
		T=scan.nextInt();
		
		for(int i=1; i<=T; i++)
		{
			A=scan.nextInt();
			B=scan.nextInt();
			String s1="";
			C=0;
			ans=0;
			
			if(B>10)
			for(int n=A; n<B; n++)
			{
				s1=n+"";
				String t1="";
				String t2="";
				ansset.clear();
				for(int j=1; j<=s1.length(); j++)
				{
					t1=s1.substring(0,j);
					t2= s1.substring(j);
					C= Integer.parseInt(t2+t1);
			//		System.out.println(C);
					if(C>n && C<=B)
						ansset.add(C);
				}
				ans+=ansset.size();
			}
			
			System.out.println("Case #"+i+": "+ans);
		}
	}

}
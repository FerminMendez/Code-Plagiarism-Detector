import java.util.*;
import java.io.*;

public class recycled
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader baca= new BufferedReader(new InputStreamReader(System.in));
		int T= Integer.parseInt(baca.readLine());
		for(int i=1; i<=T; i++)
		{
			StringTokenizer token= new StringTokenizer(baca.readLine());
			int A= Integer.parseInt(token.nextToken());
			int B= Integer.parseInt(token.nextToken());
			int count=0;
			
			for(int n=A; n<B; n++)
			{
				for(int m=n+1; m<=B; m++)
				{
					count=count+hitung(n,m);
				}
			}
			System.out.println("Case #"+i+": "+count);
		}
	}
	
	public static int hitung(int n, int m)
	{
		String angka= Integer.toString(n);
		String tanda= Integer.toString(m);
		char[] sesuatu=angka.toCharArray();
		char[] acuan=tanda.toCharArray();
		for(int i=0; i<angka.length(); i++)
		{
			char temp=sesuatu[0];
			for(int j=0; j< angka.length()-1; j++)
			{
				sesuatu[j]=sesuatu[j+1];
			}
			sesuatu[angka.length()-1]=temp;
			boolean b=true;
			
			for(int z=0; z<angka.length();z++)
			{
				if(sesuatu[z]!=acuan[z])
				{
					b=false;
					break;
				}
			}
			if(b==true)
			{
				return 1;
			}
		}
		return 0;
	}	
}
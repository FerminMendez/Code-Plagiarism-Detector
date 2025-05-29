import java.io.*;
import java.util.*;
public class Main
{
	public static void main(String[] args)throws IOException
	{
		new Main().start();
	}
	public void start()throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int test=Integer.parseInt(br.readLine());
		int ans=0;
		int ind=1;
		while(test-->0){
			ans=0;
			st=new StringTokenizer(br.readLine());
			int A=Integer.parseInt(st.nextToken());
			int B=Integer.parseInt(st.nextToken());
			for(int num=A;num<=B;num++){
			String n=num+"";
			int len=n.length();
			for(int i=1;i<len;i++)
			{
				int m=Integer.parseInt(n.substring(i)+n.substring(0,i));
				if((m+"").length()!=len)
					continue;
				if(m<=B && m>=A && m>num){
					ans++;
					//System.out.print(m+" ");
				}
			}
			}
			System.out.println("Case #"+ind+": "+ans);
			ind++;
		}
	}
}
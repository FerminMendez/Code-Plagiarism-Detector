import java.io.*;
import java.util.*;
public class Revn{
	static int bt[]={0,10,100,1000,10000,100000,1000000},gl[]=new int[2000001];;
public static void main(String args[])throws Exception{
BufferedReader br=new BufferedReader(new FileReader("ginp.txt"));
PrintWriter pr=new PrintWriter("Revn.txt");
int i=0,j=0,k=0,a=0,b=0,tc=Integer.parseInt(br.readLine());long co=0;
StringTokenizer st=null;
for(k=1;k<=tc;k++)
{st=new StringTokenizer(br.readLine());
a=Integer.parseInt(st.nextToken());
b=Integer.parseInt(st.nextToken());
co=0;
for(i=a;i<b;i++)
	co=co+get(i,b);

pr.println("Case #"+k+": "+co);
}
pr.close();


}
public static int get(int x,int y)
{
	String s1=""+x;
	int i=0,j=0,l=s1.length()-1,t=bt[l],ty=x,ry=0,gp[]=new int[l];
	for(i=0;i<l;i++)
	{ty=(ty%t)*10+ty/t;
		
	 ry=ty>x&&ty<=y&&gl[ty]==0?ry+1:ry;
	 if(ty<y){
         gl[ty]=1;
         gp[i]=ty;}	 
 
	}
	for(i=0;i<l;i++)
		gl[gp[i]]=0;
	return ry;
}

}

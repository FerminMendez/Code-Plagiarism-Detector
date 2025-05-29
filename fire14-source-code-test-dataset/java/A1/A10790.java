import java.io.*;
import java.util.*;

class JamB
{

public static void main(String args[])throws Exception
{

FileReader fr = new FileReader("B-small-attempt0.in"); 
BufferedReader br = new BufferedReader(fr); 

FileWriter fw= new FileWriter("out.txt");

BufferedWriter bw=new BufferedWriter(fw);
PrintWriter pw= new PrintWriter(bw);

int t=Integer.parseInt(br.readLine());
int n=0,s=0,p=0,ans=0,scount=0;String str="";

for(int i=0;i<t;i++)
{
n=0;s=0;p=0;ans=0;scount=0;
 str=br.readLine();
StringTokenizer st=new StringTokenizer(str);

n=Integer.parseInt(st.nextToken());
s=Integer.parseInt(st.nextToken());
p=Integer.parseInt(st.nextToken());

for(int j=0;j<n;j++)
{
int a=Integer.parseInt(st.nextToken());
if(a!=0)
{
if(a>(p-1)*3)ans++;
else if(a>=(p-1)*3-1&&scount<s){scount++;ans++;}
}
else if(p==0)
ans++;
}


pw.println("Case #"+(i+1)+": "+ans);
}

pw.close();
bw.close();
fw.close();
}
}
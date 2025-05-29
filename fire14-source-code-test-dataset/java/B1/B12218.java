import java.io.*;
class Recycled
{
public static void main(String args[])throws IOException
{
BufferedReader x=new BufferedReader(new InputStreamReader(System.in));
int t=Integer.parseInt(x.readLine());
int c[]=new int[t];
for(int i=0;i<t;i++)
{
c[i]=0;
int a=0,b=0;
String q=x.readLine();
for(int j=0;j<q.length();j++)
if(q.charAt(j)==' ')
{
a=Integer.parseInt(q.substring(0,j));
b=Integer.parseInt(q.substring(j+1));
break;
}
for(int j=a;j<=b;j++)
{
String s=""+j;
int y;
do{
s=s.charAt(s.length()-1)+s.substring(0,s.length()-1);
y=Integer.parseInt(s);
if(y>j&&y<=b)
c[i]++;
}
while(y!=j);
}
}
for(int i=0;i<t;i++)
System.out.println("Case #"+(i+1)+": "+c[i]);
}}



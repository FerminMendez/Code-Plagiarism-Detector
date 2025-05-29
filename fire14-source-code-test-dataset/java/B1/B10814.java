
import java.io.*;
import java.util.*;

class JamC
{

public static void main(String args[])throws Exception
{

FileReader fr = new FileReader("C-small-attempt0.in"); 
BufferedReader br = new BufferedReader(fr); 

FileWriter fw= new FileWriter("out.txt");

BufferedWriter bw=new BufferedWriter(fw);
PrintWriter pw= new PrintWriter(bw);

int t=Integer.parseInt(br.readLine());int l=0;

String str="",A="",B="",n="",m="";int a=0,b=0,count=0;

for(int i=0;i<t;i++)
{
str=br.readLine();
StringTokenizer st=new StringTokenizer(str);
A=st.nextToken();
B=st.nextToken();
l=A.length();
a=Integer.parseInt(A);
b=Integer.parseInt(B);
count=0;

for(int j=a;j<=b;j++)
{
n=""+j;
for(int k=1;k<l;k++)
{
if(n.charAt(k)=='0')
{}
else if(n.charAt(k)>B.charAt(0))
{}
else if(n.charAt(k)<n.charAt(0))
{}
else if(n.charAt(k)==B.charAt(0)&&(Integer.parseInt(n.substring(k)+n.substring(0,k))>b))
{}
else if(n.charAt(k)==n.charAt(0)&&(Integer.parseInt(n.substring(k)+n.substring(0,k))<=j))
{}
else if(n.equals(n.substring(k)+n.substring(0,k)))
{}
else
count++;
}
}

pw.println("Case #"+(i+1)+": "+count);
}

pw.close();
bw.close();
fw.close();
}
}




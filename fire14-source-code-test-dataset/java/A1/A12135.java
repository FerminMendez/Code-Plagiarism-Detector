import java.io.*;
import java.util.*;
class c2
{
public static void main(String args[])throws IOException
{
Scanner sc=new Scanner(new FileReader("C:\\Users\\vivek\\Desktop\\B-small-attempt0.in"));

PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\vivek\\Desktop\\out.txt")));

int t=sc.nextInt();
int n,p,x,x1,x2,s,count;
for(int i=0;i<t;i++)
{
n=sc.nextInt();
s=sc.nextInt();
p=sc.nextInt();
count=n;

for(int j=0;j<n;j++)
{
x=sc.nextInt();
x1=((x-2)/3)+2;
x2=((x+2)/3);
if(x<2)
{
if(p>x)
count--;
}
else if(x>=2&&x<=28)
{
if(x1<p&&x2<p)
count--;
else if(x1>=p&&x2<p)
{
if(s>0)
{
s--;
}
else
count--;
}
}
}

out.println("Case #"+(i+1)+": "+count);
count=0;
x1=0;x2=0;
}
out.flush();
}
}
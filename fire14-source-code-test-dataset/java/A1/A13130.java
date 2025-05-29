import java.io.*;
import java.util.*;
class codejam2
{
public static void main(String args[])throws IOException
{
Scanner sc=new Scanner(new FileReader("C:\\Users\\chotu\\Desktop\\B-small-attempt3.in"));

PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("C:\\Users\\chotu\\Desktop\\out.txt")));

int t=sc.nextInt();
int n,p,x,sur,nsur,s,c;
for(int i=0;i<t;i++)
{
n=sc.nextInt();
s=sc.nextInt();
p=sc.nextInt();
c=n;

for(int j=0;j<n;j++)
{
x=sc.nextInt();
sur=((x-2)/3)+2;
nsur=((x+2)/3);
if(x<2)
{
if(p>x)
c--;
}
else if(x>=2&&x<=28)
{
if(sur<p && nsur<p)
c--;
else if(sur>=p && nsur<p)
{
if(s>0)
{
s--;
}
else
c--;
}
}
}

out.println("Case #"+(i+1)+": "+c);
c=0;
sur=0;nsur=0;
}
out.flush();
}
}
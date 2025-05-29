import java.util.Scanner;
class recycled{
public static void main(String args[])
{
Scanner s=new Scanner(System.in);
int t,i,n,m,a,b,o,f=0,c=0,ca=1;
t=s.nextInt();
for(i=1;i<=t;i++)
{
a=s.nextInt();
b=s.nextInt();
for(n=a;n<b;n++)
{
String str=Integer.toString(n);
int l=str.length();
f=rep(str,l,b);
if(f==1)
c--;
for(o=l-1;o>0;o--)
{
m=Integer.parseInt(str.substring(o)+str.substring(0,o));
if(m>n && m>a && m<=b)
{
c++;
}
}
f=0;
}
System.out.println("Case #"+ca+": "+c);
c=0;
ca++;
}
}
private static int rep(String str,int l,int b)
{
int i,f=0;
if(l%2==0 && l>3 && (int)(str.charAt(0))<(int)(str.charAt(1)) && Integer.parseInt(str.charAt(l-1)+str.substring(0,l-1))<=b)
{
for(i=2;i<l;i++)
{
if(str.charAt(i)==str.charAt(i-2))
f=1;
else 
return 0;
}
}
return f; 
}
}
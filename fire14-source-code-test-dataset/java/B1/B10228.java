import java.io.*;
class yo
{
public static void main(String args[])
throws IOException
{
try
{
FileWriter fs=new FileWriter("o1.out");
FileInputStream f1=new FileInputStream("C-small-attempt3 (1).in");
DataInputStream d=new DataInputStream(f1);
BufferedReader br=new BufferedReader(new InputStreamReader(d));
BufferedWriter out=new BufferedWriter(fs);
String s,s1;
s=br.readLine();
int T=Integer.parseInt(s);
int cnt=0,nn,f,ll,ul,p;
String w1;
char temp;
for(int i=0;i<T;i++)
{
out.write("Case #"+(i+1)+": ");
s1=br.readLine();
String[] n=s1.split(" ");
ll=Integer.parseInt(n[0]);
ul=Integer.parseInt(n[1]);
p=ul-ll+1;
f=ll;
for(int j=0;j<p;j++)
{
s1=Integer.toString(f);
char c[]=new char[s1.length()];
c=s1.toCharArray();
for(int k=0;k<s1.length()-1;k++)
{
temp=c[s1.length()-1];
for(int l=(s1.length()-1);l>0;l--)
{
c[l]=c[l-1];
}
c[0]=temp;
w1="";
for(int m=0;m<s1.length();m++)
{
w1=w1+c[m];
}
nn=Integer.parseInt(w1);
if(nn>ll)
if(nn>f)
if(nn<=ul)
cnt=cnt+1;
}
f=f+1;
}
String h=Integer.toString(cnt);
out.write(h);
out.write("\r\n");
cnt=0;
}
out.close();
br.close();
}
catch(Exception e){
System.out.println("Error :"+e);
}
}
}
import java.util.*;
import java.io.*;
class RecycledNumbers{
static int A,B,l,count=0;
static int v[]=new int[10000];
public static void main(String[] args){
  try {
File file = new File("C-small-attempt1.in");  
 FileReader fr = new FileReader(file);
BufferedReader br = new BufferedReader(fr); 
File file1 = new File("Coutput2.in");
FileWriter fw = new FileWriter(file1); 
PrintWriter pw = new PrintWriter(fw);
int T= Integer.valueOf(br.readLine());

int i,p=1,j,k;

while(p<=T)
{	

String G=br.readLine(); 
j=0;i=0;k=1;
int m=1;
String r="";
if(G==null)break;

int l;
for(l=0;l<G.length();l++)
{
r="";
for(;G.charAt(i)!=' ' && i+1<G.length();i++)
{
r+=G.charAt(i);
if(G.charAt(i+1)==' '){j++;}
}
i++;
if(i==G.length())
{j++;r+=G.charAt(i-1);}
	if(j==1)
	A=Integer.valueOf(r);
	else if(j==2)
	B=Integer.valueOf(r);
	

if(i==G.length())
{break;}
}
	 l=length(A);
	count=0;

for(int n=A;n<B;n++)
{
int t=n;
m=n;
	for(j=1;j<=l;j++)
	{
	if(m%10==0)
	{m=shifttwo(m);j++;}
	else
	m=shiftone(m);

	if(t<m && range(m))
	{			
	//System.out.println(t+" "+m);
	count++;
	}

	}
}	

 pw.println("Case #"+p+":  "+count);
	p++;
	}

 fr.close(); 
fw.close();

  } catch(IOException e) { }
}//main


static int length(int a)
{
int c=0;
	while(a>0)
	{
	c++;
	a=a/10;
	}
return c;
}
static int shiftone(int n)
{

	int v=n%10;
	n=n/10;
	return (n+v*pow(10,length(n)));
}
static int shifttwo(int n)
{

	int v=n%100;
	n=n/100;
	return (n+v*pow(10,length(n)));
}
static int pow(int i,int j)
{
	if(j==0)
	return 1;
	return i*pow(i,j-1);
}

static boolean range(int m)
{
	for(int i=A;i<=B;i++)	{
	if(m==i){
			return true;
			}
				}
	return false;
}
}//class

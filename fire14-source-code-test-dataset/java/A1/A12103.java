import java.util.*;
import java.io.*;
class GooglerDancing2{
static int S,p,count=0;
static int[] g=new int[10];
static int[] v=new int[10];
static PrintWriter pw ;
public static void main(String[] args){

  try {
File file = new File("B-small-attempt4.in");  
 FileReader fr = new FileReader(file);
BufferedReader br = new BufferedReader(fr); 
File file1 = new File("Bout4.in");
FileWriter fw = new FileWriter(file1); 
pw= new PrintWriter(fw);
int T= Integer.valueOf(br.readLine());
Scanner cin=new Scanner(System.in);
int i,j,k;

//System.out.println("enter no. of test cases");
int n=1;
	while(n<=T)
	{	
//	int ok=cin.nextInt();
	int N=0;
count=0;
	

String G=br.readLine(); j=0;i=0;k=1;
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
	N=Integer.valueOf(r);
	else if(j==2)
	S=Integer.valueOf(r);
	else if(j==3)
	{p=Integer.valueOf(r);k=j;k++;}
	else if(j==k)
	{
	if(m<=N)
	g[m]=Integer.valueOf(r);
	m++;k++;
	}

if(i==G.length())
{break;}
}
//
for(i=1;i<=N;i++){
if(pos(g[i],i)==1)count++;}


 pw.println("Case #"+n+":  "+count);
	n++;
	}

 fr.close(); 
fw.close();

  } catch(IOException e) { }
}//main

static int pena(int t,int l)
{
int i,j,k;
	if(S>0)
	{
	for(i=10;i>=0;i--)
	for(j=10;j>=0;j--)
	for(k=10;k>=0;k--)
	{
	if(t==(i+j+k))
	 if(any(i,j,k)>0 && (max(i,j,k)>=p))
	{
	//count++;
	v[l]=1;
	S--;//pw.println("penallty "+" "+i+" "+j+" "+k+" "+t);
	return 1;
	}
	}
	}
return 0;
}
static int any1(int i,int j,int k)
{
if(mod(i-j)==0 && mod(j-k)==0 && mod(i-k)==0)
return 1;
if(mod(i-j)==1 && mod(j-k)==1 && mod(i-k)==0)
return 1;
if(mod(i-j)==1 && mod(j-k)==0 && mod(i-k)==1)
return 1;
if(mod(i-j)==0 && mod(j-k)==1 && mod(i-k)==1)
return 1;
return 0;
}
static int any(int i,int j,int k)
{
if(mod(i-j)==2 && mod(j-k)==2 && mod(i-k)==0)
return 1;
if(mod(i-j)==0 && mod(j-k)==2 && mod(i-k)==2)
return 1;
if(mod(i-j)==2 && mod(j-k)==0 && mod(i-k)==2)
return 1;
if(mod(i-j)==2 && mod(j-k)==1 && mod(i-k)==1)
return 1;
if(mod(i-j)==1 && mod(j-k)==2 && mod(i-k)==1)
return 1;
if(mod(i-j)==1 && mod(j-k)==1 && mod(i-k)==2)
return 1;
return 0;
}
static int max(int i,int j,int k)
{
if(i>j && i>k)return i;
if(j>k)return j;
return k;
}
static int mod(int n)
{
if(n<0)
return n*-1;
return n;
}
static int diff(int i,int j,int k)
{
if(any1(i,j,k)>0)
{
if(max(i,j,k)>=p)
{
//count++;
return 1;
}
}


return 0;
}
static int pos(int t,int l)
{
int i,j,k;
for(i=10;i>=0;i--)
for(j=10;j>=0;j--)
for(k=10;k>=0;k--)
{
if(t==(i+j+k))
if(diff(i,j,k)==1)
{
v[l]=-1;
//pw.println(" "+i+" "+j+" "+k+" "+t);
return 1;
}
}

return pena(t,l);
	
//return 0;
}


}//class


import java.io.*;

class qu3{
public static void main(String arg[])throws Exception
{
File f=new File("/Users/rishabhsonthalia/Downloads/C-small-attempt0.in.txt");
FileInputStream fin=new FileInputStream(f);
File fo=new File("opt.txt");
FileOutputStream fout=new FileOutputStream(fo);
BufferedWriter bwr=new BufferedWriter(new OutputStreamWriter(fout));
BufferedReader br=new BufferedReader(new InputStreamReader(fin));
String g="";

long len=Long.parseLong(br.readLine());
long ca=1;
long a,b;
String e="";
long n,m;
while(--len >=0)
{
long count=0;
g=br.readLine();
a=Long.parseLong(g.substring(0,g.indexOf(" ")) );
b=Long.parseLong( g.substring(g.indexOf(" ")+1,g.length())) ;

for(long i=a;i<=b;i++)
{
n=i;
	for(long j=0 ; j<(i+"").length()-1; j++)
	{ 
		
		 m=shift(n);
		if(m>-1 & i<m & m <=b)
		{count++;
		}
		n=m;
		
	}
}


bwr.write("Case #"+(ca++)+": "+count);
bwr.newLine();
bwr.flush();
}//while

}

public static long shift(long x)
{

	String s;
	if(x<0)
	s="0"+(-x)+"";
	else
	s=x+"";
	String ss=s.charAt(s.length()-1)+s.substring(0,s.length()-1);
	if(x%10==0)
	return(-Long.parseLong(ss));
	return (Long.parseLong(ss));
}
}
import java.io.*;

class Recycle{
public static void main(String arg[])throws Exception
{
File f=new File("C-small-attempt0.in");
FileInputStream fin=new FileInputStream(f);
File f2=new File("bo.txt");
FileOutputStream fout=new FileOutputStream(f2);
BufferedWriter bwr=new BufferedWriter(new OutputStreamWriter(fout));
BufferedReader br=new BufferedReader(new InputStreamReader(fin));
String g="";

int ipn=Integer.parseInt(br.readLine());
int ipni=1;
int a,b;
String e="";
int n,m;
while(--ipn >=0)
{
int count=0;
g=br.readLine();
a=Integer.parseInt(g.substring(0,g.indexOf(" ")) );
b=Integer.parseInt( g.substring(g.indexOf(" ")+1,g.length())) ;

for(int i=a;i<=b;i++)
{
n=i;
	for(int j=0 ; j<(i+"").length()-1; j++)
	{ 
		
		 m=shift(n);
		 if(m>-1)
		if(i<m && m <=b)
		{count++;
		}
		n=m;
		
	}
}


bwr.write("Case #"+(ipni++)+": "+count);
bwr.newLine();
bwr.flush();
}//while

}

public static int shift(int num)
{

	String s;
	if(num<0)
	s="0"+(-num)+"";
	else
	s=num+"";
	String ss=s.charAt(s.length()-1)+s.substring(0,s.length()-1);
	if(s.charAt(s.length()-1)=='0')
	return(-Integer.parseInt(ss));
	return (Integer.parseInt(ss));
}
}
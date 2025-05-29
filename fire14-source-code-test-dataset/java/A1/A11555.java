import java.io.*;
public class GoogJam2
{
	public static void main(String args[])
	{
	try{
	
	BufferedReader br=new BufferedReader(new FileReader(args[0]));
		int T=Integer.parseInt(br.readLine());
		BufferedWriter bw=new BufferedWriter(new FileWriter("output.txt",true));
	for(int i1=0;i1<T;i1++)
	{
	String st=br.readLine();
	String sam[]=st.split(" ");
	int N=Integer.parseInt(sam[0]);
	int s=Integer.parseInt(sam[1]);
	int p=Integer.parseInt(sam[2]);
	int a[]=new int[N];

	for(int k=0;k<N;k++)
	{a[k]=Integer.parseInt(sam[k+3]);
	}	
	int b[][]=new int[N][2];
	int count=0;
	for(int i=0;i<N;i++)
	{
	b[i][0]=a[i]/3;
	b[i][1]=a[i]%3;
	//System.out.println(b[i][0]+" "+b[i][1]+"\n");
	}
	
	for(int i=0;i<N;i++)
	{	
	if((b[i][0]>=p)||((b[i][0]==p-1)&&(b[i][1]==1))||((b[i][0]==p-1)&&(b[i][1]==2)))
	{//System.out.println("c1");
	count++;
	}
	else if(s>0)
	{
			if((b[i][0]==p-1)&&(b[i][1]==0))
			{if(a[i]>=1)
				{//System.out.println(b[i][0]+" c2");
				count++;
				s--;
				}
			}
			else if((b[i][0]==p-2)&&(b[i][1]==2))
			{//System.out.println(b[i][0]+" "+b[i][1]+"\n");
				if(a[i]>=2)
				{//System.out.println(b[i][0]+" c2");
				count++;
				s--;
				}
			}
	}
	}
	bw.write("Case #"+(i1+1)+": "+count+"\n");
	//System.out.println(count);
	}
	bw.close();
	br.close();
	}
	catch(Exception e)
	{}
	
	}
}
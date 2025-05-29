import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class DancingWiththeGooglers 
{
public static void main(String[] args) throws IOException {
	FileWriter wr=new FileWriter("Output.txt");
	BufferedWriter buff=new BufferedWriter(wr);
	
	FileReader read=new FileReader("B-small-attempt2.in");
	BufferedReader buffr=new BufferedReader(read);
	
	String str;
	str=buffr.readLine();
	int n=Integer.parseInt(str);
	int j=1;
	Scanner sc;
	int googleres,s,p;
int list[];
	int i;
	int num;
	int total=0;
	while(j<=n)
	{
		int non[]={0,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,9,9,9,10,10,10};
		
		int sup[]={-1,-1,-1,2,3,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,9,9,10,10,10,-1,-1,-1};
		
		total=0;
	str=buffr.readLine();
	sc=new Scanner(str);
	sc.useDelimiter(" ");
	googleres=sc.nextInt();
	s=sc.nextInt();
	p=sc.nextInt();
	i=1;
	list=new int[googleres];
	while(i<=googleres)
	{
	list[i-1]=sc.nextInt();
	i++;
	}
	
	if(s==0)
	{
		for(int k=1;k<=googleres;k++)
		{
			num=list[k-1];
			if(non[num]>=p)
				++total;
		}
		
	}
	else
	{
		
		for(int k=1;k<=googleres;k++)
		{
			if(s!=0)
			{
			num=list[k-1];
			if(non[num]>=p)
				++total;
			else
			{
				if(sup[num]>=p)
				{
					--s;
					++total;
				}
			}
		}
			else
			{
				num=list[k-1];
				if(non[num]>=p)
					++total;
			}
			
		}	
		
	}
		
	StringBuffer temp = new StringBuffer("Case #"+j+": ");
	temp=temp.append(Integer.toString(total));
	buff.write(temp.toString());
	buff.newLine();
	j++;
	}
buff.close();
}
}

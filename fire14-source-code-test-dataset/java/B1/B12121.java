import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class RecycledNumbers 
{
public static void main(String[] args) throws IOException {
	FileWriter wr=new FileWriter("Output.txt");
	BufferedWriter buff=new BufferedWriter(wr);
	
	FileReader read=new FileReader("C-small-attempt0.in");
	BufferedReader buffr=new BufferedReader(read);
	
	String str;
	str=buffr.readLine();
	
	int n=Integer.parseInt(str);
	int j=1;
	int a,b;
	int num,lower,upper;
	int total;
	while(j<=n)
	{
		
		str=buffr.readLine();
		Scanner sc=new Scanner(str);
		sc.useDelimiter(" ");
		a=sc.nextInt();
		b=sc.nextInt();
		
		upper=b;
		lower=a;
		total=0;
		while(a<=b)
		{
		
		String first=Integer.toString(a);
	String orig=first;
	String newStr;
	int curr=Integer.parseInt(first);
		if(first.length()!=1)
		{
			
			while(true)
			{
				
				first=first.charAt(first.length()-1)+first.substring(0,first.length()-1);
				if(first.equals(orig))
					break;
				
				if(!first.startsWith("0"))
				{
				num=Integer.parseInt(first);
				if(num<=upper && num>=lower && num>curr)
					++total;	
				}
				
			}
		}
		++a;
		}
		StringBuffer temp = new StringBuffer("Case #"+j+": ");
		temp=temp.append(Integer.toString(total));
		buff.write(temp.toString());
		buff.newLine();
		++j;
	}
	
	buff.close();
}
}

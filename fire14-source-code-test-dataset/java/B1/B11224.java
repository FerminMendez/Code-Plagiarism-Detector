import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {
public static void main(String[] arg) throws FileNotFoundException
{
	Scanner scan =new Scanner(System.in);
	LinkedList<String> lilo=new LinkedList<String>();
	int t=scan.nextInt();
	for(int j=0;j<t+1;j++)
	{
		String str=scan.nextLine();
		lilo.add(str);
	}
	
	String[] str=lilo.toArray(new String[lilo.size()]);
	
	Formatter form=new Formatter("exoC.txt");
	for(int i=0;i<str.length;i++)
	{
		int u,v;
		try{
		String s=new String(str[i]);
		Scanner se=new Scanner(s);
		u=se.nextInt();
		v=se.nextInt();
		int q=calcul(u,v);
		int k=i;
		form.format("Case #"+k+": "+q+"\n");
		}catch(Exception e)
		{
			
		}
	}
	form.close();
	System.out.println("fin");
}
public static int calcul(int n,int m)
{
	int i=0;
	Methode met=new Methode();
	for(int j=n;j<=m;j++)
	{
		Integer v=new Integer(j);
		for(int k=j+1;k<=m;k++)
		{
			Integer u=new Integer(k);
			if((met.text(v.toString(), u.toString())))
			{
				i++;
			}
		}
	}
	return i;
}
}

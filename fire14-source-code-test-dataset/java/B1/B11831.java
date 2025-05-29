import javax.swing.*;
import java.util.Scanner;
import java.io.*;

class ProblemC
{
	public static void main (String []sdvv) throws IOException
	{
		int cases=0, A=0, B=0, total;
		String num;
		Scanner sc;
		PrintWriter es;
		try
		{
			sc = new Scanner(new File("Csmall.IN"));
			es = new PrintWriter(new BufferedWriter(new FileWriter("solutionC.txt")));
			cases=Integer.parseInt(sc.nextLine());
			for(int j=1;j<=cases;j++)
			{
				total=0;
				es.print("Case #"+j+": ");
				A=sc.nextInt();
				B=sc.nextInt();

				for(int n=A;n<B;n++)
				{
					for(int m=n+1;m<=B;m++)
					{
						if(checkRotation(n,m))
						{
							total++;
						}
					}
				}

				es.println(total);
			}
			es.close();
		}
		catch(FileNotFoundException error)
		{
			System.out.println("no se encuentra el archivo");
		}
		catch (EOFException e)
		{
		    System.out.println("Final de Stream");
		}

	}
	public static boolean checkRotation(int n, int m)
	{
		String num=Integer.toString(n);
		String ref=Integer.toString(m);
		if(num.length()==ref.length())
		{
			int l=num.length();
			String temp=num;
			for(int z=1;z<l;z++)
			{
				temp=temp.substring(1,l);
				temp+=num.charAt(z-1);
				if(temp.equals(ref))
					return true;
			}
		}
		return false;
	}
}
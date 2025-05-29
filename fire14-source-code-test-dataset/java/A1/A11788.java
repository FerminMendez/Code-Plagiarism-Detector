import javax.swing.*;
import java.util.Scanner;
import java.io.*;

class ProblemB
{
	public static void main (String []sdvv) throws IOException
	{

		int cases=0, N, S, p, normal, surprise, number, total;
		String palabra="";
		Scanner sc;
		PrintWriter es;
		try
		{
			sc = new Scanner(new File("Bsmall.IN"));
			es = new PrintWriter(new BufferedWriter(new FileWriter("solutionBsmall.txt")));
			cases=Integer.parseInt(sc.nextLine());
			for(int j=1;j<=cases;j++)
			{
				surprise=0;
				normal=0;
				es.print("Case #"+j+": ");
				N=sc.nextInt();
				S=sc.nextInt();
				p=sc.nextInt();
				for(int x=0; x<N; x++)
				{
					number=sc.nextInt();
					if(number==0&&p==0)
						normal++;
					else
						if(p*3-2<=number)
							normal++;
						else
							if(p*3-4<=number&&p>1)
								surprise++;
				}
				if(surprise>=S)
					if(normal+S>N)
						total=N;
					else
						total=normal+S;
				else
					total=normal+surprise;


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
}
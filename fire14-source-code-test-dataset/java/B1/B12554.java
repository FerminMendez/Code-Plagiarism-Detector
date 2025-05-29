import java.util.HashSet;
import java.util.Scanner;


public class qualifier3 {
	public static void main(String[] args)
	{

	Scanner sc = new Scanner(System.in);
	int numcases = sc.nextInt();
	sc.nextLine();
	for(int curcase = 1;curcase <=numcases;curcase++)
	{
		int min = sc.nextInt();
		int max = sc.nextInt();
		int numdigits = 0;
		for(int i=max;i>0;i/=10,numdigits++);
		int tennum =1;
		for(int i=0;i<numdigits;i++,tennum*=10);
		int count =0;
		for(int i=min;i<max;i++)
		{
			HashSet<Integer> seen = new HashSet<Integer>();
			int mult =1;
			for(int j=1;j<numdigits;j++)
			{mult*=10;
			int mine = ((i*mult)%tennum+(i/(tennum/mult)));
				if ((mine>i)&&(mine<=max)&&(!seen.contains(mine)))
					{
					count++;
					seen.add(mine);
					}
			}
		}
		sc.nextLine();
		
		
		System.out.println("Case #"+curcase+": "+count);
	
	}

	}
}

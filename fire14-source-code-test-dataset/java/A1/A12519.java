import java.util.Scanner;


public class qualifier2 {
public static void main(String[] args)
{
	Scanner sc = new Scanner(System.in);
	int numcases = sc.nextInt();
	sc.nextLine();
	for(int curcase = 1;curcase <=numcases;curcase++)
	{
		int numgoog = sc.nextInt();
		int supr = sc.nextInt();
		int cutoff = sc.nextInt();
		int[] scrtot = new int[numgoog];
		for(int i=0;i<numgoog;i++)
		{
			scrtot[i] = sc.nextInt();
		}
		sc.nextLine();
		int count =0;
		for(int i=0;i<numgoog;i++)
		{
			if(cutoff*3 -2 <=scrtot[i])
			{
				count++;
			}else
			{
				if((cutoff*3-4<=scrtot[i])&&(supr>0)&&(scrtot[i]!=0))
				{
				count++;
				supr--;
				}
			}
		}
		System.out.println("Case #"+curcase+": "+count);
	}
}
}

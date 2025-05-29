import java.util.*;

class Dancing
{

	public static void main(String[] args)
	{
		int[] dancers = new int[100];
		int N;
		int surprising;
		int target;
		int i;
		int result;
		int optimal;
		int n;
		int T;
		int t;
		Scanner myInput = new Scanner(System.in);
		T = myInput.nextInt();
		for (t=1; t<=T; t++)
		{
			result=0;
			N = myInput.nextInt();
			surprising = myInput.nextInt();
			target = myInput.nextInt();
			for (i=0; i<N; i++)
				dancers[i] = myInput.nextInt();
			Arrays.sort(dancers,0,N);
			for (i=N-1; i>=0; i--)
			{
				optimal = 0;
				n=dancers[i];
				//System.out.println(n);
				if (surprising>0)
				{
					if (n%3==0) 
					{
						optimal=n/3;
						if (((optimal-1>=0)&&(optimal<target)) && (optimal+1>=target))
						{
							optimal++;
							surprising--;
						}
					}
					else
						if (n%3==1)
						{
							optimal=(n/3)+1;
						}
						else
							if (n%3==2)
							{
								optimal=(n/3)+1;
								if ((optimal<target) && (optimal+1>=target))
								{
									optimal++;
									surprising--;
								}
							}

					if (optimal>=target) result++;

				}
				else
				{
					if (n%3==0) optimal=n/3;
					else
						optimal = (n/3)+1;
					if (optimal>=target) result++;
				}
			}
			System.out.println("Case #"+t+": "+result);
		}
	}

}

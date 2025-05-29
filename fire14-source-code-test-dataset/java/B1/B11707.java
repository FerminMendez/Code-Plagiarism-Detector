import java.util.*;

class Recycle
{
	public static int[] combi = {0,0,1,3,6,10,16,21};
	
	public static boolean[] bool;
	
	public static int howMany(int x, int least, int greatest)
	{
		int rotate = x;
		int pair = 1;
		int i;
		int j;
		int dummy;
		ArrayList<Integer> digit = new ArrayList<Integer>();
		bool[rotate]=true;
		while (rotate>0)
		{
			digit.add(rotate%10);
			rotate=rotate/10;
		}

		for (i=1; i<digit.size(); i++)
		{
			dummy=digit.get(0);
			digit.remove(0);
			digit.add(dummy);
			if (digit.get(digit.size()-1)!=0)
			{
				rotate=0;
				for (j=digit.size()-1; j>=0; j--)
					rotate = rotate*10+digit.get(j);
				if (((rotate<=greatest) && (rotate>=least))&&(bool[rotate]==false))
				{
					//System.out.println(rotate);
					bool[rotate]=true;
					pair++;
				}
			}
		}
		return (combi[pair]);
	}

	public static void main (String[] args)
	{
		Scanner myInput = new Scanner(System.in);
		int T;
		int t;
		T = myInput.nextInt();
		int i;
		int A;
		int B;
		int result;
		for (t=1; t<=T; t++)
		{
			A=myInput.nextInt();
			B=myInput.nextInt();
			result=0;
			bool = new boolean[B+1];
			for (i=A; i<=B; i++)
				if (bool[i]==false)
					result=result+howMany(i,A,B);
			System.out.println("Case #"+t+": "+result);
		}

	}
	
}

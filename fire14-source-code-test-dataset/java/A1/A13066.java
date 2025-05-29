import java.util.Scanner;


public class DWtG {

	static int T,N,S,P;
	static int[] t = new int[1000];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = Integer.parseInt(sc.nextLine());
		for (int k = 0; k<T; k++)
		{
			int result = 0;
			N = sc.nextInt();
			S = sc.nextInt();
			P = sc.nextInt();
			for (int i =0; i<N; i++)
			{
				t[i] = sc.nextInt();
				int base =(int) t[i]/3;
				switch (t[i]%3)
				{
				case 0:
				{
					if (base >= P) result++;
					else
					{
						if (S > 0 && base > 0 && base+1>=P)
						{
							result++;
							S--;
						}
					}
					break;
				}
				case 1:
				{
					if (base >= P || base+1 >= P) result++;
					else
					{
						if (S > 0 && base+1 >=P) 
						{
							result ++;
							S--;
						}
					}
					break;
				}
				case 2:
				{
					if (base + 1 >= P || base >= P) result ++;
			          else
			          {
			            if (S > 0 && base + 2 >= P)
			            {
			              result++;
			              S--;
			            }
			          }

					break;
				}
				}
			}
			System.out.println("Case #" + (k+1) + ": " + result);
		}
	}

}

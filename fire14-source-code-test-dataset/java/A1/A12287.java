import java.util.Scanner;


public class B {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int nbr_case = scan.nextInt();
		for(int i = 0; i < nbr_case; i++)
		{
			int N = scan.nextInt();
			int S = scan.nextInt();
			int p = scan.nextInt();
			int possible_max = 0;
			int curr =0;
			//int[] vec = new int[N];
			for( int j = 0; j<N;j++)
			{
				
				curr = scan.nextInt();
				if(S> 0)
				{
					if(curr > (p*3 - 3) && (curr >= p))
					{
						possible_max++;
					}					
					else
					{
						if(curr > (p*3-5) && (curr >= p))
						{
							possible_max++;
							S--;
						}
						
					}
					
				}
				else
				{
					
					if(curr > (p*3 - 3) && (curr >= p))
					{
						possible_max++;
					}
					
				}
				

					//vec[j] = scan.nextInt();				
			}
			//System.out.println(vec.toString());
			System.out.format("Case #%d: %d\n", i+1, possible_max);
		}
		

	}

}

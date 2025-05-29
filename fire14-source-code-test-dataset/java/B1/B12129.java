import java.util.HashSet;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner oku = new Scanner(System.in);

		int test = oku.nextInt(), A = oku.nextInt(), B = oku.nextInt(), dijit = Integer.toString(A).length(), sayimiz = 0;

		HashSet<Integer> eleme;

		for (int i = 0; i < test; i++, A = oku.nextInt(), B = oku.nextInt(), sayimiz = 0)
		{
			dijit = Integer.toString(A).length();
			
			for (int j = A; j < B; j++)
			{
				eleme = new HashSet<Integer>();
				
				for (int k = 1; k < dijit; k++)
				{
					int saga_kayan = j / (int) Math.pow(10, k);
					int sola_kayan = (j % (int) Math.pow(10, k) * (int) Math.pow(10, dijit - k));
					int son = saga_kayan + sola_kayan;
					
					if (son <= B && j < son)
					{
						eleme.add(son);
					}
				}

				sayimiz += eleme.size();
			}

			System.out.println("Case #" + (i + 1) + ": " + sayimiz);
		}
	}
}
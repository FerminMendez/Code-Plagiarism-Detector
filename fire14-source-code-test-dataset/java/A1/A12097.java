import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Scanner oku = new Scanner(System.in);

		int test = oku.nextInt(), n, s, p;

		int surp_siniri;
		int enAzindan, kesin_surp, toplam;

		for (int i = 0; i < test; i++, oku.nextLine())
		{
			n = oku.nextInt();
			s = oku.nextInt();
			p = oku.nextInt();

			if (p == 0 || p == 1)
			{
				surp_siniri = s;
			}
			else
			{
				surp_siniri = 3 * p - 4;
			}

			enAzindan = 0;
			kesin_surp = 0;

			for (int j = 0; j < n; j++)
			{
				toplam = oku.nextInt();

				if (toplam >= 2)
				{
					if (toplam >= surp_siniri && toplam <= surp_siniri + 1)
					{
						kesin_surp++;
					}
					else if (toplam > surp_siniri + 1)
					{
						enAzindan++;
					}
				}
				else
				{
					if (surp_siniri == 0 && toplam >= p)
					{
						enAzindan++;
					}
				}
			}

			if (kesin_surp >= s)
			{
				System.out.println("Case #" + (i + 1) + ": " + (enAzindan + s));
			}
			else
			{
				System.out.println("Case #" + (i + 1) + ": " + (enAzindan + kesin_surp));
			}
		}
	}
}

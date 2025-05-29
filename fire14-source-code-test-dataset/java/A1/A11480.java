import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Dancing {

	
	public static void main(String[] args) throws IOException
	{
		BufferedReader f = new BufferedReader(new FileReader("dancing.in"));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("botTrust.out")));
		int T = Integer.parseInt(f.readLine());
		
		
		for (int i = 0; i < T; i++)
		{
			StringTokenizer tok = new StringTokenizer(f.readLine());
			int N = Integer.parseInt(tok.nextToken());
			int S = Integer.parseInt(tok.nextToken());
			int P = Integer.parseInt(tok.nextToken());
			int count = 0;
			for (int j = 0; j < N; j++)
			{
				int x = Integer.parseInt(tok.nextToken());
				if (x % 3 == 0)
				{
					if (x/3 >= P)
						count++;
					if (x/3 == P-1 && x > 0)
					{
						if (S > 0)
						{
							S--;
							count++;
						}
					}
				}
				if (x % 3 == 1)
				{
					if (x/3 >= P-1)
						count++;
				}
				if (x % 3 == 2)
				{
					if (x/3 >= P-1)
						count++;
					if (x/3 == P-2)
					{
						if (S > 0)
						{
							S--;
							count++;
						}
					}
					
				}
				

				
			}
			System.out.println("Case #" + (i+1) + ": " + count);
		}
	}
}

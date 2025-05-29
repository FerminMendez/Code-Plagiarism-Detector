
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Dancers
{
	public static void main(String[] args)
	{
		try
		{
			Scanner s = new Scanner(new File("dancers.in"));
			BufferedWriter w = new BufferedWriter(new FileWriter(new File("dancers.out")));
			int numCases = s.nextInt();
			s.nextLine();
			
			for(int n = 1;n <= numCases; n++)
			{
				int numGooglers = s.nextInt();
				int surprising = s.nextInt();
				int p = s.nextInt();
				int lowerBoundWithoutSurprising = (p * 3) - 2;
				int lowerBoundWithSurprising = (p * 3) - 4;
				
				if(lowerBoundWithoutSurprising < p)
					lowerBoundWithoutSurprising = p;
				if(lowerBoundWithSurprising < p)
					lowerBoundWithSurprising = p;
				
				int count = 0;
				for(int m = 1; m <= numGooglers; m++)
				{
					int cur = s.nextInt();

					if(cur >= lowerBoundWithoutSurprising)
						count++;
					else if(cur >= lowerBoundWithSurprising && surprising > 0)
					{
						count++;
						surprising--;
					}
				}
				w.write("Case #" + n + ": " + count + "\n");
			}
			
			w.flush();
			w.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	

}
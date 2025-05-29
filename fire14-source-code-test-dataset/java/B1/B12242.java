import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.TreeSet;

public class C_Recylce
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader(new File("./data/C-small-attempt0.in")));
		long casos = Integer.parseInt(br.readLine());

		for (long caso = 1; caso <= casos; caso++)
		{
			String[] datos = br.readLine().split(" +");
			int A = Integer.parseInt(datos[0]);
			int B = Integer.parseInt(datos[1]);
			int pairs = 0;
			TreeSet lstPairs = new TreeSet<String>();

			if (A >= 10)
			{
				for (int i = A; i <= B; i++)
				{
					String original = Integer.toString(i);
					// System.out.print(original + " : ");
					for (int j = 1; j < original.length(); j++)
					{
						String corrido = original.substring(j) + original.substring(0, j);
						int test = Integer.parseInt(corrido);
						if (test <= B && test > i)
						{
							// System.out.print(corrido + " ");
							pairs++;
							String pareja = original + "-" + corrido;
							lstPairs.add(pareja);
						}
					}
					// System.out.println("");
				}
			}

			System.out.println("Case #" + caso + ": " + lstPairs.size());
		}

		br.close();
	}
}

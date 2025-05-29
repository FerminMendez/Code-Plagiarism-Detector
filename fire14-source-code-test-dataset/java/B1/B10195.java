// usage: java c infile > outfile
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Set;
import java.util.HashSet;

public class c
{
	public static void main(String[] args) throws Exception
	{
		String infile = args[0];
		
		BufferedReader reader = new BufferedReader(new FileReader(infile));
		int T = Integer.parseInt(reader.readLine());
		for (int t = 1; t <= T; t++)
		{
			Set<String> pairs = new HashSet<String>();
			String[] inputs = reader.readLine().split(" ");
			int A = Integer.parseInt(inputs[0]);
			int B = Integer.parseInt(inputs[1]);
			int length = inputs[0].length();
			//System.out.println("test = " + A + ", " + B + ", " + length);
			
			int total = 0;
			for (int i = A; i <= B; i++)
			{
				String trial = "" + i;
				//System.out.println("i = " + i);
				for (int n = 1; n < length; n++)
				{
					int j = Integer.parseInt(trial.substring(n) + trial.substring(0, n));
					//System.out.println(trial.substring(n) + ":" + trial.substring(0, n));
					if (trial.charAt(n) == '0')
					{
						continue;
					}
					
					String pair = i + " " + j;
					if (i < j && j <= B && !pairs.contains(pair))
					{
						total++;
						pairs.add(pair);
					}
				}
			}
			
			System.out.println("Case #" + t + ": " + total);
		}
		reader.close();
	}
}

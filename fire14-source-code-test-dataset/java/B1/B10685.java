import java.io.*;
import java.util.*;
public class RecycledNumbers
{
	public static void main(String [] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("CI.txt"));

		String write = "";
		int i = Integer.parseInt(br.readLine());

		for(int j = 1; j <= i; j++)
		{
			String ra = br.readLine();
			int c = 0;

			Integer [] ir = c(ra.split(" "));
			
			for(int k = ir[0]; k < ir[1]; k++)
			{
				String number1 = "" + k;
				String number2 = "";
				int m = 0;
				HashSet <String> size= new HashSet <String> ();
				for(int l = 1; l < number1.length(); l++)
				{
					if(number1.charAt(0) <= number1.charAt(l))
					{
						number2 = number1.substring(l) + number1.substring(0,l);
						m = Integer.parseInt(number2);
						if(m <= ir[1] && m > k)
						{
							if(!size.contains(number2))
							{
								//System.out.println(k + " " + m);
								c = c + 1;
							}
							size.add(number2);
						}
					}
				}

			}
			String newLine = "\n";
			if(j == i)
				newLine = "";
			write = write + "Case #" + j + ": " + c + newLine;
			//System.out.println("Case #" + j + ": " + c);
		}

		BufferedWriter bw = new BufferedWriter(new FileWriter("CO.txt"));
		bw.write(write);
		bw.flush();
		bw.close();
		System.out.println(write);
	}

	static Integer [] c(String [] args)
	{
		Integer [] array = new Integer[args.length];
		for(int i = 0; i < args.length; i++)
		{
			array [i] = Integer.parseInt(args[i]);
		}
		return array;
	}

}
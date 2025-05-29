import java.io.*;
public class DancingWithTheGooglers
{
	public static void main(String [] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("BI.txt"));

		String write = "";
		int i = Integer.parseInt(br.readLine());

		for(int j = 1; j <= i; j++)
		{
			String ra = br.readLine();
			int c = 0;

			Integer [] ir = c(ra.split(" "));
			int S = ir[1];
			for(int k = 0; k < ir[0]; k++)
			{
				boolean flag = false;
				int score = ir[k + 3];
				int [] triplet = new int[3];
				
				for(int l = 0; l < 3; l++) 
				if(score >= 0)
				{
					triplet [l] = score / (3 - l);
					score = score - triplet[l];
					if(triplet[l] >= ir[2])
					{
						c = c + 1;
						flag = true;
						break;
					}
					
				}

				if(S > 0)
				{
					for(int m = 1; m < 3; m++)
					{
						if(!flag && triplet[m-1] > 0)
						if(triplet[m] == triplet[m - 1])
						{
							triplet[m] = triplet[m] + 1;
							triplet[m-1] = triplet[m-1] - 1;
							if(triplet[m] >= ir[2])
							{
								c = c + 1;
								S = S - 1;
							}
							break;
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

		BufferedWriter bw = new BufferedWriter(new FileWriter("BO.txt"));
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
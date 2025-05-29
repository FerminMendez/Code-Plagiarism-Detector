import java.io.*;
import java.util.Scanner;


public class SurprisingDancers {
	public static void main(String[] args) {
		BufferedReader br;
		BufferedWriter bw;
		int count;
		try
		{	
			br = new BufferedReader(new FileReader(args[0]));
			bw = new BufferedWriter(new FileWriter(new File("output.txt")));
			count = new Integer(br.readLine());
			for(int i = 1; i <= count; i++)
			{
				try
				{					
					bw.write("Case #" + i + ": ");
					Scanner intReader = new Scanner(br.readLine());
					int numGooglers = intReader.nextInt();
					int numSurprises = intReader.nextInt();
					int p = intReader.nextInt();
					int ans = 0;
					for(int j = 1; j <= numGooglers; j++)
					{
						int score = intReader.nextInt();
						if((score/3) >= p)
						{
							ans++;
						}
						else
						{
							if(score % 3 == 0 && score > 0)
							{
								if((score/3 + 1) >= p)
								{
									if(numSurprises > 0)
									{
										numSurprises--;
										ans++;
									}
								}									
							}
							if(score % 3 == 1)
							{
								if((score/3 + 1) >= p)
								{
									ans++;
								}
							}
							if(score % 3 == 2)
							{
								if((score/3 + 1)  >= p)
								{
									ans++;
								}
								else if((score/3 + 2) >= p)
								{
									if(numSurprises > 0)
									{
										numSurprises--;
										ans++;
									}
								}
							}
						}
					}
					String stringAns = "" + ans;
					bw.write(stringAns);
					bw.newLine();
				}
				catch(IOException e)
				{
					System.out.println("Error reading line.");
				}
			}
			br.close();
			bw.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File not found.");
		}
		catch(IOException e)
		{
			System.out.println("Error reading first line or creating output.");
		}
	}

}

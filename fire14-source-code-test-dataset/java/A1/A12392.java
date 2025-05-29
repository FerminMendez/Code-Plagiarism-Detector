import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class DancingGooglers 
{
	String line="Code Jam";
	static int noOfTCs;
	
	public static void main(String[] args)
	{
		//initialize();
		new DancingGooglers().calculate();
		//generateOPFile();
	}
	
	private void calculate() 
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("C:/CodeJam/B-small-attempt1.in"));
			FileWriter fw = new FileWriter("C:/CodeJam/B-small-output.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			line = br.readLine().trim();
			noOfTCs = Integer.parseInt(line);
			int dancers,surprises,maxScore;
			for(int testCase=0;testCase<noOfTCs;testCase++)
			{
				line = br.readLine().trim();
				String[] input = line.split(" ");
				dancers = Integer.parseInt(input[0]);
				surprises = Integer.parseInt(input[1]);
				maxScore = Integer.parseInt(input[2]);
				int sum,maxDancers=0;
				
				for(int i=3; i<input.length;i++)
				{
					sum =  Integer.parseInt(input[i]);
					int rem = sum%3;
					int result = sum/3;
					if(rem <= 1) 
					{
						if((result+rem)>=maxScore)
							maxDancers++;
						else if(rem == 0 && result > 0 && (result+1)>=maxScore && surprises > 0)
						{
							maxDancers++;
							surprises--;
						}
					}
					else
					{
						if((1+result) >= maxScore)
						{
							maxDancers++;
						}
						else
						{
							if(surprises > 0 && (rem+result) >= maxScore)
							{
								maxDancers++;
								surprises--;
							}
						}
					}
					
				}
				
				line = "Case #"+(testCase+1)+": "+maxDancers;
				System.out.println(line);
				bw.write(line);
				bw.newLine();
			}
			br.close();
			bw.close();
			System.out.println("Done !");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/*static void generateOPFile()
	{
		try
		{
			FileWriter fw = new FileWriter("C:/CodeJam/output.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			for(int i=1;i<=noOfTCs;i++)
			{
				line = "Case #"+i+": "+1;
				bw.write(line);
				bw.newLine();
			}			
			bw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}*/

	/*static void initialize()
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("C:/CodeJam/C-small.in"));
			line = br.readLine().trim();
			noOfTCs = Integer.parseInt(line);
			br.close();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}*/
}

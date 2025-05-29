import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class RecycledPairs 
{
	static String line="Code Jam";
	static int noOfTCs;
	static long lowerLimit,upperLimit;
	static ArrayList<String> pairs = new ArrayList<String>();
	
	public static void main(String[] args)
	{
		//initialize();
		calculate();
		//generateOPFile();
	}
	
	private static void calculate() 
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader("C:/CodeJam/C-small-attempt2.in"));
			FileWriter fw = new FileWriter("C:/CodeJam/output.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			line = br.readLine().trim();
			noOfTCs = Integer.parseInt(line);
			for(int testCase=0;testCase<noOfTCs;testCase++)
			{
				line = br.readLine().trim();
				String[] limits = line.split(" ");
				lowerLimit = Long.parseLong(limits[0]);
				upperLimit = Long.parseLong(limits[1]);
				for(long n = lowerLimit; n<upperLimit; n++)
				{
					StringBuffer nsb = new StringBuffer(""+n);
					//System.out.println(nsb.toString());
					for(int length = 1; length < nsb.length();length++)
					{
						StringBuffer msb = new StringBuffer(nsb.substring(length, nsb.length())+nsb.substring(0, length));
						//System.out.println(msb.toString());
						if(msb.charAt(0)=='0')
							continue;
						long m = Long.parseLong(msb.toString());
						if(n<m && m <=upperLimit)
						{
							String s = nsb.toString()+","+msb.toString();
							//System.out.println(s);
							if(!pairs.contains(s))
								pairs.add(s);
						}
					}
				}
				line = "Case #"+(testCase+1)+": "+pairs.size();
				pairs.clear();
				bw.write(line);
				bw.newLine();
			}
			br.close();
			bw.close();
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

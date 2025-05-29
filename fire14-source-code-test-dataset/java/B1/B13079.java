import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ProblemC {
	
	public static void main(String [] args)
	{
		new ProblemC();
	}
	
	public ProblemC()
	{
		try
		{
			String [] inputFiles = { "C-small" };//,"A-large" };
			BufferedReader in;
			PrintWriter out;
			for(int i = 0 ; i < inputFiles.length; i++)
			{
				in = new BufferedReader(new FileReader(inputFiles[i]));
				out = new PrintWriter(new FileWriter(inputFiles[i]+".out"),true);
				
				int numCases = Integer.parseInt(in.readLine());
				int min, max;
				String [] items = null;
				for(int j = 0 ; j < numCases; j++)
				{
					items = in.readLine().split("\\s+");
					min = Integer.parseInt(items[0]);
					max = Integer.parseInt(items[1]);
					int total = 0;
					for(int x = min; x <= max; x++)
					{
						for(int y=x+1; y<= max; y++)
						{
							if(checkReycled(x,y))
								total++;
							
						}
					}
					out.println("Case #" + (j+1) + ": " + total);
				}
				in.close();
				out.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	private boolean checkReycled(int x, int y) {
		if(x == y)
			return false;
		else if(x<10 || y<10)
			return false;
		else if(x>=1000)
			return false;
		
		String xstr = new String("" +x);
		String ystr = new String("" +y);
		if(xstr.length() != ystr.length())
			return false;
		
		if(xstr.length() == 2)
		{
			if(xstr.charAt(0) == ystr.charAt(1) &&
					xstr.charAt(1) == ystr.charAt(0))
				return true;
		}
		else
		{
			if(xstr.charAt(0) == ystr.charAt(1) &&
					xstr.charAt(1) == ystr.charAt(2) &&
					xstr.charAt(2) == ystr.charAt(0))
				return true;
			else if(xstr.charAt(0) == ystr.charAt(2) &&
					xstr.charAt(1) == ystr.charAt(0) &&
					xstr.charAt(2) == ystr.charAt(1))
				return true;
		}
		return false;
	}
}

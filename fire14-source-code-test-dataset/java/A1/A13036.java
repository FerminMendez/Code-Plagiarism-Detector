import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;


public class ProjectB {
	
	public static void main(String [] args)
	{
		new ProjectB();
	}
	
	public ProjectB()
	{
		try
		{
			String [] inputFiles = { "B-small" };//,"B-large" };
			BufferedReader in;
			PrintWriter out;
			for(int i = 0 ; i < inputFiles.length; i++)
			{
				in = new BufferedReader(new FileReader(inputFiles[i]));
				out = new PrintWriter(new FileWriter(inputFiles[i]+".out"),true);
				
				int numCases = Integer.parseInt(in.readLine());
				int numDancers = 0, surprises = 0, p = 0;
				String [] items = null;
				for(int j = 0 ; j < numCases; j++)
				{
					items = in.readLine().split("\\s+");
					numDancers = Integer.parseInt(items[0]);
					surprises = Integer.parseInt(items[1]);
					p = Integer.parseInt(items[2]);
					int nonSurprisingScore = (p*3) - 2;
					int numScores = 0;
					for(int k = 0; k < numDancers; k++)
					{
						int score = Integer.parseInt(items[k+3]);
						if(score >= nonSurprisingScore)
							numScores++;
						else if(surprises > 0 && score !=0 && score + 2 >= nonSurprisingScore)
						{
							numScores++;
							surprises--;
						}
					}
					out.println("Case #" + (j+1) + ": " + numScores);
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
}

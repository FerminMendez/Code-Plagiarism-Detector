import java.io.*;
import java.util.Vector;
import java.util.StringTokenizer;

public class Dance
{
	private static int googlers = 0;
	private static int surprises = 0;
	private static int hits = 0;
	private static int target = 0;
	private static int[] scores;

	public static void main(String[] args)
	{
		Integer currentCase = 0, totalCases = 0;
		String justRead = "";
		BufferedReader in = new BufferedReader(
			new InputStreamReader(System.in));
		try{
			justRead = in.readLine();
		}catch(Exception e)
		{
			System.out.println(e.toString());
			System.exit(0);
		}

		totalCases = Integer.parseInt(justRead);

		do	
		{
			System.out.print("Case #" + (++currentCase).toString() + ": ");
			//Do stuff for the case:
			try
			{
				justRead = in.readLine();
			}catch(Exception ex)
			{
				System.out.println(ex.toString());
			}
			StringTokenizer st = new StringTokenizer(justRead);

			//First, get the number of googlers:
			String thisToken;
			thisToken = st.nextToken();
			googlers = Integer.parseInt(thisToken);

			//Then, we get the number of surprises
			thisToken = st.nextToken();
			surprises = Integer.parseInt(thisToken);

			//Finally, we get the target score:
			thisToken = st.nextToken();
			target = Integer.parseInt(thisToken);

			//Now, we populate the score table!

			
			//NOTE: For large inputs, consider putting scores
			//in an array and sorting.


			scores = new int[googlers];
			hits = googlers;
			for(int i = 0; i < googlers; i++)
			{
				int currentScore;
				thisToken = st.nextToken();
				currentScore = Integer.parseInt(thisToken);
				int minScore = target + (2*(target-1));
				int minSurprise = target + (2*(target-2));

				if(target == 1)
				{
					minSurprise = 1;
				}
			


				if(minScore > currentScore)
				{

					//If that doesn't work, we have no choice but to
					//try and use a 'surprise' score.
						
					if(surprises > 0)
					{
						if(minSurprise > currentScore)
						{
							hits--;
						}else
						{
							surprises--;
						}
					}else
					{
						hits--;
					}
				}

			}

			//Done! Now print out the result:
			System.out.print(hits);
			System.out.println();

			//Reset things for next case;
			hits = 0;
			surprises = 0;


		}while(currentCase < totalCases);
	}
}

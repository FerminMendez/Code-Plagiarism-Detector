import java.util.ArrayList;


public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Reader reader = new Reader();
		ArrayList<String> input = reader.LinesReader();
		
		ArrayList<String> output = new ArrayList();
		for (String i : input)
		{
			output.add(handleCase(i));
		}
		reader.output(output);
	}

	private static String handleCase(String s) 
	{
		String output = "";
		
		String[] split = s.split(" ");
		ArrayList<Integer> listInt = new ArrayList<Integer>();
		
		for (String string : split)
		{
			listInt.add(Integer.valueOf(string));
		}
		
		int nbGooglers = listInt.get(0);
		int nbSurprising = listInt.get(1);
		int bestResultNeeded = listInt.get(2);
		
		int nbAchieved = 0;
		for (int i = 0; i < nbGooglers; i++)
		{
			double score = listInt.get(3 + i);
			
			if (Math.ceil(score / 3) >= bestResultNeeded)
			{
				nbAchieved++;
			}
			else
			if (nbSurprising > 0)
			{
				// prevention cas negatif
				double maxAdded = 4;
				if (score < maxAdded)
					maxAdded = score;
				if (((score + maxAdded) / 3) >= bestResultNeeded)
				{
					
					nbAchieved++;
					nbSurprising--;
				}
			}
		}
		
		return "" + nbAchieved;
	}

}

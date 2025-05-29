import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;


public class Run2
{
	public static void main(String[] args)
	{
		String path = "files/B-small-attempt1.in";
		
		int T = 0;
		ArrayList<ArrayList<Integer>> googlers = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> surprisings = new ArrayList<Integer>();
		ArrayList<Integer> leasts = new ArrayList<Integer>();
		
		try
		{
			boolean isFirstLine = true;
			
			FileReader FR = new FileReader(path);
			BufferedReader BR = new BufferedReader(FR);
			String str = "";
			
			while((str=BR.readLine())!=null)
			{
				if (isFirstLine)
				{
					T = Integer.parseInt(str);
					isFirstLine = false;
				}
				else
				{
					String[] temp = str.split(" ");
					
					surprisings.add(Integer.parseInt(temp[1]));
					leasts.add(Integer.parseInt(temp[2]));
					
					ArrayList<Integer> score = new ArrayList<Integer>();
					for(int i = 3; i < temp.length; i++)
					{
						score.add(Integer.parseInt(temp[i]));
					}
					googlers.add(score);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		for(int i = 0; i < T; i++)
		{
			ArrayList<Integer> googler = googlers.get(i);
			int surprising = surprisings.get(i);
			int least = leasts.get(i);
			int number = 0;
			
			int dontSurprising = 0;
			int isSurprising = 0;
			for(int j = 0; j < googler.size(); j++)
			{
				int score = googler.get(j);
				
				int surprisingBounds = least+(least-2)*2;
				int dontSurprisingBounds = least+(least-1)*2;
				if (least < 2)
				{
					surprisingBounds = least;
					dontSurprisingBounds = least;
				}
				if (score >= surprisingBounds && score < dontSurprisingBounds)
				{
					isSurprising++;
				}
				else if (score >= dontSurprisingBounds)
				{
					dontSurprising++;
				}
			}
			number = dontSurprising+isSurprising+((surprising-isSurprising)>=0?0:(surprising-isSurprising));
			System.out.println("Case #"+(i+1)+": "+number);
		}
	}
}
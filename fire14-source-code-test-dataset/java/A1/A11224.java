import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class DancingWiththeGooglers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new DancingWiththeGooglers().fun();
	}
	
	private void fun()
	{
		String file = "D:/CodeJam/inputB.in";
		try {
			scan = new Scanner(new File(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int cases = scan.nextInt();
		
		for(int i = 1; i <= cases ; i++)
		{
			int noOfGooglers = findTheResult();
			System.out.println("Case #"+i+": "+noOfGooglers);
		}
	}
	
	private int findTheResult()
	{
		int googlers = scan.nextInt();
		int surprising = scan.nextInt();
		int minScore = scan.nextInt();
		int minValue = getMinValue(minScore);
		int criticValue1 = minValue;
		int criticValue2 = criticValue1 + 1;
		int count = 0;
		int criticalCount = 0;
		for(int i = 0; i< googlers; i++)
		{
			int score = scan.nextInt();
			if(minValue == 0)
			{
				count++;
				continue;
			}
			else if(minValue == 1)
			{
				if(score >= minValue)
					count++;
				continue;
			}
			if(score >= minValue)
			{
				if(score == criticValue1 || score == criticValue2)
				{
					if(criticalCount < surprising)
					{
						count++;
						criticalCount++;
					}
				}
				else
					count++;
			}
		}
		return count;
	}
	
	private int getMinValue(int minScore)
	{
		int value = 0;
		if(minScore > 2)
		{
			value = minScore - 2;
			value = minScore + value*2;
		}
		else
			value = minScore;
		
		return value;
	}
	
	Scanner scan = null;
}

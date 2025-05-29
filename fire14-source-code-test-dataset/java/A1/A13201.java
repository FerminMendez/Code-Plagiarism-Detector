import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
public class GooglersDance {
	static int output = 0;
	static int numberOfDancers = 0;
	static int surprise = 0;
	static int bestResult = 0;

	public static void main(String[] args) {
		try {

			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader reader = new BufferedReader(new FileReader("e:/B-small-attempt0.in"));
			int totalLines = Integer.parseInt(reader.readLine());
			for(int k=0;k<totalLines;k++)
			{
				String[] input = reader.readLine().split(" ");
				numberOfDancers = Integer.parseInt(input[0]);
				surprise = Integer.parseInt(input[1]);
				bestResult = Integer.parseInt(input[2]);
				output = 0;
				
				int [] totalPoints = new int[numberOfDancers];
				for (int i = 0; i < totalPoints.length; i++) {
					totalPoints[i] = Integer.parseInt(input[3+i]);
					isBestReesult(totalPoints[i]);
				}
				System.out.println("Case #" + (k+1) + ": " + output);
			}
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	private static void isBestReesult(int i) {
		int av = i/3;
		int rem = i%3;

		if(av+2 < bestResult)
			return;

		if(rem == 0)
		{
			if(av >= bestResult)
			{
				output++;
			}else if(av+1 >= bestResult && av+1 <= i && surprise > 0)
			{
				output++;
				surprise--;
			}
		}else if(rem == 1)
		{
			if((av >= bestResult || av+1 >= bestResult) && av+1 <= i)
				output++;
		}else
		{
			if((av >= bestResult || av+1 >= bestResult) && av+1 <= i )
			{
				output++;
			}else if(av+2 >= bestResult && surprise > 0 && av+1 <= i )
			{
				output++;
				surprise--;
			}
		}
	}
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main
{
	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException
	{
		BufferedReader reader = new BufferedReader(new FileReader(args[0]));
		int numCases = Integer.parseInt(reader.readLine());
		Thread[] thread = new Thread[numCases];
		ScoreSet[] sets = new ScoreSet[numCases];
		for(int i = 0; i < numCases; i ++)
		{
			sets[i] = new ScoreSet(reader.readLine());
			thread[i]= new Thread(sets[i]);
			thread[i].start();
		}
		for(int i = 0; i < numCases; i ++)
		{
			thread[i].join();
			System.out.println("Case #" + (i + 1) + ": " + sets[i].getResult());
		}
		
	}
}

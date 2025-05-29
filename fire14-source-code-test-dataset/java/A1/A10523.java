import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;


public class Dancing {
	
	public static void main(String[] args) throws IOException
	{
		String text = "";
		String fileName = "/users/bestja/desktop/abc.txt";
		File textFile = new File(fileName);
		Scanner in = new Scanner(textFile);
		
		int testCases = in.nextInt();
		in.nextLine();
		
		for (int i = 1; i <= testCases; i++)
		{
			int count = in.nextInt();
			int surprises = in.nextInt();
			int targetScore = in.nextInt();
			
			int[] dancers = new int[count];
			
			int winners = 0;
			
			for (int n = 0; n < count; n++)
			{
				dancers[n] = in.nextInt();
			}
			
			for (int n = 0; n < count; n++)
			{
				if (dancers[n] > targetScore*3-3 && dancers[n] >= targetScore)
					winners++;
				else if (dancers[n] > targetScore*3-5 && surprises > 0 && dancers[n] >= targetScore)
				{
					winners++;
					surprises--;
				}
			}
			
			text += "Case #" + i + ": " + winners + "\n";
		}
		
		Writer output = null;
		File file = new File("/users/bestja/desktop/def.txt");
		output = new BufferedWriter(new FileWriter(file));
		output.write(text);
		output.close();
	}
	
	

}

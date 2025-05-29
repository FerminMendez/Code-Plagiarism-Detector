import java.io.*;
import java.util.*;


public class DancingWithTheGooglers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileReader fileReader = new FileReader("B-small-attempt0.in.txt");
			FileWriter fileWriter = new FileWriter("out.txt");
			BufferedReader reader = new BufferedReader(fileReader);
			BufferedWriter writer = new BufferedWriter(fileWriter);
			String inputString;
			inputString = reader.readLine();
			int cases = Integer.parseInt(inputString);
			for (int caseCount = 0; caseCount < cases; caseCount++)
			{
				inputString = reader.readLine();
				String output = "Case #" + (caseCount+1) + ": ";
				String a[] = inputString.split(" ");
				int n = Integer.parseInt(a[0]);
				int s = Integer.parseInt(a[1]);
				int p = Integer.parseInt(a[2]);
				int ans = 0;
				int score[] = new int[n];
				for (int i = 0; i < n; i++)
					score[i] = Integer.parseInt(a[i + 3]);
				Arrays.sort(score);
				for (int i = 0; i < n; i++)
				{
					if ((score[i] + 2) / 3 >= p) ans ++;
					else
					{
						if (s > 0 && score[i] >= 2 && ((score[i] + 4) / 3 >= p))
						{
							s--;
							ans++;
						}
					}
				}
				output += ans;
				output += '\n';
				writer.write(output);
			}
			reader.close();
			writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

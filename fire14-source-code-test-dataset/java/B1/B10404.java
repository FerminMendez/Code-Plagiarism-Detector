import java.io.*;
public class RecycledNumbers {

	/**
	 * @param args
	 */
	static int isOK(int m, int n)
	{
		String sm = "" + m;
		String sn = "" + n;
		if (sm.length() != sn.length()) return 0;
		int k = sm.length();
		for (int i = 1; i < k; i++)
		{
			String tmp = sm.substring(i) + sm.substring(0, i);
			if (tmp.equals(sn)) return 1;
		}
		return 0;
	}
	public static void main(String[] args) {
		try {
			FileReader fileReader = new FileReader("C-small-attempt0.in.txt");
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
				String[] split = inputString.split(" ");
				int m = Integer.parseInt(split[0]);
				int n = Integer.parseInt(split[1]);
				int ans = 0;
				for (int i = m; i <= n; i++)
					for (int j = i + 1; j <= n; j++)
					{
						ans += isOK(i, j);
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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class RecycledNumbers
{
	private Scanner fileReader;
	private File input;
	private Formatter fileWriter;
	private File output;

	public RecycledNumbers() throws FileNotFoundException
	{
		input = new File("C-small-attempt0.in");
		fileReader = new Scanner(input);
		output = new File("output.txt");
		fileWriter = new Formatter(output);
	}

	public int pairsByLine(String inLn)
	{
		int outLn = 0;
		String[] bounds = inLn.split(" ");
		int A = Integer.parseInt(bounds[0]);
		int B = Integer.parseInt(bounds[1]);
		ArrayList<String> done = new ArrayList<String>();
		for (int t = A; t <= B; t++)
		{
			String s = t + "";
			for (int i = s.length() - 1; i > 0; i--)
			{
				String s1 = s.substring(i, s.length());
				String s2 = s.substring(0, i);
				String res = s1 + s2;
				int reversed = Integer.parseInt(res);
				if (reversed <= B 
						&& reversed <= B 
						&&t<reversed
						&& (reversed + "").length() == s.length()
					    && !done.contains((s+reversed+"")))
						
				{
					done.add((s+reversed+""));
					System.out.println(s + "-->" + reversed);
					outLn++;
				}
			}
		}
		return outLn;
	}

	private boolean repeated(String s)
	{
		boolean repeated = false;
		for (int i = 0; i < s.length(); i++)
		{
			for (int j = i + 1; j < s.length(); j++)
			{
				if (s.charAt(i) == s.charAt(j))
				{
					repeated = true;
				}
			}
		}
		return repeated;
	}

	public void getPairs()
	{
		int i = 0;
		int testcases = Integer.parseInt(fileReader.nextLine());
		while (fileReader.hasNextLine())
		{
			i++;
			String line = fileReader.nextLine();
			fileWriter.format("%s%s%s", "Case #" + i + ": ", pairsByLine(line)
					+ "", "\n");
		}
		fileWriter.close();
	}

	public static void main(String[] args) throws FileNotFoundException
	{
		RecycledNumbers rec = new RecycledNumbers();
		rec.getPairs();
	}

}

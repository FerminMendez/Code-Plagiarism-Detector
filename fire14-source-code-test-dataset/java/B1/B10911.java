import java.io.*;
import java.util.*;

public class ProbC
{
	public static void main(String[] args) throws FileNotFoundException, IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("C-small-attempt0.in"));
		int times = Integer.parseInt(br.readLine());
		BufferedWriter wr = new BufferedWriter(new FileWriter("C-small-attempt0soln.in"));
		for (int i = 0; i < times; i++)
		{
			String sentence = br.readLine();
			String[] nums = sentence.split(" ");
			int a = Integer.parseInt(nums[0]);
			int b = Integer.parseInt(nums[1]);
			int recycledPairs = 0;
			ArrayList<Integer> firstIncluded = new ArrayList<Integer>();
			ArrayList<Integer> secondIncluded = new ArrayList<Integer>();

			for (int currNum = a; currNum <= b; currNum++)
			{
				if (!firstIncluded.contains(currNum))
				{
					boolean currNumAdded = false;
					String currNumString = currNum + "";

					int digits = currNumString.length();
					for (int x = 0; x < digits; x++)
					{
						currNumString = currNumString.substring(currNumString.length() - 1) + currNumString.substring(0, currNumString.length() - 1);

						int currNumCheck = Integer.parseInt(currNumString);
						if (currNumCheck >= a && currNumCheck <= b && !(firstIncluded.contains(currNum) && secondIncluded.get(firstIncluded.indexOf(currNum)).equals(currNumCheck)) && !(secondIncluded.contains(currNumCheck) && firstIncluded.get(secondIncluded.indexOf(currNumCheck)).equals(currNum)) && currNumCheck != currNum)
						{
							secondIncluded.add(currNumCheck);
							recycledPairs++;
							//if (!currNumAdded)
							//{
								firstIncluded.add(currNum);
							//	currNumAdded = true;
						//	}
						//	System.out.println("(" + currNum + ", " + currNumString + ")");
						}
						/*else
						{
							if (currNumCheck >= a && currNumCheck <= b && currNumCheck != currNum) //&& !numsAlreadyIncluded.contains(currNumCheck) && currNumCheck != currNum)
								System.out.println("(" + currNum + ", " + currNumCheck + ")");
						}*/
					}
				}
			}
			recycledPairs /= 2;
			wr.write("Case #" + (i+1) + ": " + recycledPairs);
			wr.newLine();
		}
		wr.close();
	}
}
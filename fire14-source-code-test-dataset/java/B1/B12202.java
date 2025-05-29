package com.archu.contest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;

public class RecycledNum
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		File inputFile = null;
		File outputFile = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		String str = null;
		int nTestCase = 0;

		try
		{
			inputFile = new File("C-small.in");
			outputFile = new File("C-small.out");
			br = new BufferedReader(new FileReader(inputFile));
			bw = new BufferedWriter(new FileWriter(outputFile));

			str = br.readLine();
			nTestCase = Integer.parseInt(str);

			for (int k = 0; k < nTestCase; k++)
			{
				if ((str = br.readLine()) != null)
				{
					String[] range = str.split(" ");
					int start = Integer.parseInt(range[0]);
					int end = Integer.parseInt(range[1]);
					int len = range[0].length();

					HashSet<String> setRecycled = new HashSet<String>();

					if (len > 1)
					{
						for (int i = start; i <= end; i++)
						{
							String numStr = String.valueOf(i);
							char[] numChar = numStr.toCharArray();

							HashSet set = new HashSet();
							for (char ch : numChar)
							{
								set.add(ch);
							}
							if (set.size() == 1)
							{
								continue;
							}
							int origNum = Integer.parseInt(numStr);
							for (int j = 0; j < len - 1; j++)
							{
								// System.out.println("numStr :: " + numStr);
								numStr = rotateNumber(numStr, len);
								// System.out.println("after rotating numStr :: "
								// + numStr);
								int num = Integer.parseInt(numStr);
								if (num != origNum && num >= start && num <= end)
								{
									// System.out.println("Pair :: (" + origNum
									// + " , " +
									// numStr + ")");
									// System.out.println("recycled no found... adding "
									// +
									// (origNum < num ? "" + origNum + num : ""
									// + num +
									// origNum) + " to set");
									setRecycled.add(origNum < num ? "" + origNum + "," + num : "" + num + "," + origNum);
									// System.out.println("size :: " +
									// setRecycled.size());
								}
							}
						}
					}
					System.out.println(setRecycled.size());
					bw.write("Case #" + (k + 1) + ": " + setRecycled.size() + "\n");

					// TreeSet<String> set = new TreeSet<String>(setRecycled);
					// System.out.println(set);
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		try
		{
			if (br != null)
			{
				br.close();
			}
			if (bw != null)
			{
				bw.flush();
				bw.close();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public static String rotateNumber(String num, int len)
	{
		return num.charAt(len - 1) + num.substring(0, len - 1);
	}
}

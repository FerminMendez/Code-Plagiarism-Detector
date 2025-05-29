package googlecodejam;

import java.io.*;
/**
 *
 * @author $Ruslan
 */
public class Dancing {
	private static FileInputStream fileInputStream;
	private static int testCaseNumber = -1;
	public static void main(String[] args)
	{
		String filepath = "D:\\Programming\\NetBeansProjects\\" + ""
				+ "GoogleCodeJam\\src\\googlecodejam\\B-small-attempt0.in";
		try{
			if (args[0] != "")
			{
				filepath = args[0];
			}
		} catch (Exception e) {
			
		}
		
		try{
			fileInputStream = new FileInputStream(filepath);
			readInput();
		} catch (Exception e) {
			System.err.println("Exception: " + e.getMessage());
		}
	}
	
	
		private static void readInput()
	{
		try {
			String str;

			DataInputStream in = new DataInputStream(fileInputStream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));

			str = br.readLine();
			testCaseNumber = Integer.parseInt(str);
			System.out.println(testCaseNumber);

			for (int i = 0; i < testCaseNumber; i++)
			{
				System.out.print("Case #"+(i+1)+":");
				str = br.readLine();
				calculate(str);
			}
			in.close();
		} catch (IOException | NumberFormatException e) {
			System.err.println("Exception: " + e.getMessage());
		}
	}
		
	private static void calculate(String str)
	{
		String[] splitedStr = str.split(" ");
		int amountOfGooglers = Integer.parseInt(splitedStr[0]);
		int amountOfSurpTrp = Integer.parseInt(splitedStr[1]);
		int maxValue = Integer.parseInt(splitedStr[2]);
		int value = -1;
		int answer = 0;
		int minSet = 0;
		for (int i = 0; i < amountOfGooglers; i++)
		{
			minSet = -1;
			value = Integer.parseInt(splitedStr[i+3]);
			minSet = maxValue*3-2;
			if (value >= minSet)
			{
				answer++;
			} else {
				minSet -= 2;
				if (minSet < 1)
				{
					minSet = 1;
				}
				if ((value >= minSet) && (amountOfSurpTrp > 0))
				{
					answer++;
					amountOfSurpTrp--;
				}
			}
		}
		System.out.println(" " + answer);
	}
}

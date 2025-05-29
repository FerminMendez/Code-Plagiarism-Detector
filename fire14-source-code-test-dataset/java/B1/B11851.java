package googlecodejam;

import java.io.*;
/**
 *
 * @author $Ruslan
 */
public class Recycled_numbers {
	private static FileInputStream fileInputStream;
	private static int testCaseNumber = -1;
	public static void main(String[] args)
	{
		String filepath = "D:\\Programming\\NetBeansProjects\\" + ""
				+ "GoogleCodeJam\\src\\googlecodejam\\C-small-attempt0.in";
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
				//calculate(str); //do smt!!!!
				recycleNumbers(str);
			}
			in.close();
		} catch (IOException | NumberFormatException e) {
			System.err.println("Exception: " + e.getMessage());
		}
	}
		
	private static void recycleNumbers(String str)
	{
		//with A ≤ n < m ≤ B
		String[] splitedStr = str.split(" ");
		int start_num = Integer.parseInt(splitedStr[0]);
		int end_num = Integer.parseInt(splitedStr[1]);
		int answer = 0;
		int reversedNum = -1;
		int positions = -1;
		int rest_right = -1;
		int rest_left = -1;
		if (start_num < 10)
		{
			start_num = 12;
		}
		for (int i = start_num; i < end_num; i++)
		{
			//PIZDEC	
			positions = 0;
			reversedNum = i;
			while (reversedNum > 0)
			{
				reversedNum /= 10;
				positions++;
			}
			for (int k = 1; k < positions; k++)
			{
				//Ex: 7487
				//k = 2;
				//rest_right = 87;
				//rest_left = 74;
				//if rest_right > rest_left then we can move it
				//otherwise it's gonna be less the the current num
				//and so on with each k
				rest_right = i % pow(10,k); //right part of the num
				rest_left = i / pow(10, (positions-k)); //left part of the num
				if (rest_right >= rest_left)
				{
					reversedNum = reverseNumber(i, k, positions);
					if ((reversedNum > i) && (reversedNum <= end_num))
					{
						answer++;
					}
				}
			}
		}
		System.out.println(" " + answer);
	}
	
	private static int reverseNumber(int number, int places, int positions)
	{
		int res = number % pow(10, places);
		number /= pow(10, places);
		res *= pow(10, (positions-places));
		res += number;
		return res;
	}
	
	private static int pow(int num, int pow)
	{
		int result = num;
		for (int i = 1; i < pow; i++)
		{
			result *= num;
		}
		return result;
	}
}

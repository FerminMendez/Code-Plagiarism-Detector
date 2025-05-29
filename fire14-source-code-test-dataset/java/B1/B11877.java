package gcj2012;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class RecycledNumber {

		public String count(int A, int B, int caseNr)
		{
			StringBuffer sb = new StringBuffer("");
			sb.append("Case #");
			sb.append(caseNr);
			sb.append(": ");
			int result = 0;
			for (int i = A; i <= B; i++)
			{
				result += recycled(i, B);
			}
			sb.append(result);
			return sb.toString();
		}

		public int recycled(int nr, int max)
		{
			if (nr < 12) return 0;
			int test = nr;
			int count = 0;
			int length = (int)Math.ceil(Math.log10((double)nr));
			int[] digits = new int[length];
			for (int i = length-1; i >=0; i--)
			{
				digits[i] = test%10;
				test = test/10;
			}
			int[] valuesFound = new int[length];
			for (int i = 0; i < length; i++)
			{
				if (digits[i] != 0)
				{
					int value = 0;
					for (int j = 0; j < length; j++)
					{
						value = value*10;
						value += digits[(i+j)%length];
					}
					valuesFound[i] = value;
					if ((value > nr) && (value <= max)) 
					{
						boolean found = false;
						for (int k = 0; k < i; k++)
						{
							if (valuesFound[k] == valuesFound[i]) found = true;
						}
						//System.out.println(nr + " " + value);
						if (!found) count++;
					}
				}
			}
			return count;
		}
		/**
		 * @param args
		 */
		public static void main(String[] args) 
		{
			RecycledNumber test = new RecycledNumber();
			String fileName = "in3.txt";
			String outName = "out3.txt";
			try
			{
				BufferedReader br = new BufferedReader(new FileReader(fileName));
				String line = br.readLine();
				BufferedWriter bw = new BufferedWriter(new FileWriter(outName));
				int tests = new Integer(line).intValue();
				for (int i = 0; i < tests; i++)
				{
					line = br.readLine();
					String[] parts = line.split(" ");
					int A = new Integer(parts[0]).intValue();
					int B = new Integer(parts[1]).intValue();
					String line2 = test.count(A, B, i+1);
					System.out.println(line2);
					bw.write(line2+"\n");
				}
				bw.flush();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}			
		}
}

/**
Input 
Ê
4
1 9
10 40
100 500
1111 2222
Output 
Ê
Case #1: 0
Case #2: 3
Case #3: 156
Case #4: 287
*/
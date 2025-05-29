import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * Google Code Jam 2012 - Qualification Round
 * Google Code Jam 2012 Name - SamCoding
 * @author Sameer Abdul - Purdue University
 */
public class DancingGooglers {
	
	FileOutputStream out = null;
	
	public DancingGooglers() {
		out = null;
		try {
			out = new FileOutputStream("out.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void print(char[][] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			for(int j = 0; j < array.length; j++)
			{
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void output(int casenum, String s)
	{
		String print = "Case #" + casenum + ": " + s + "\n";
		try {
			out.write(print.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean valid(int one, int two, int three)
	{
		int sum1 = two-one;
		int sum2 = three-one;
		int sum3 = three-two;
		sum1 = Math.abs(sum1);
		sum2 = Math.abs(sum2);
		sum3 = Math.abs(sum3);
		if( sum1 > 2 || sum2 > 2 || sum3 > 2)
			return false;
		if( one < 0 || two < 0 || three < 0)
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		DancingGooglers dg = new DancingGooglers();
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
//		System.out.println("Cases = " + cases);
		int casenum = 0;
		while(cases-- != 0)
		{
			int result = 0;
			
			int googlers = sc.nextInt();
			int surprising = sc.nextInt();
			int p = sc.nextInt();
//			System.out.print("Googlers = " + googlers);
//			System.out.print(" p = " + p);
//			System.out.print("; Surprising = " + surprising + " Cases: ");
			int scores[][] = new int[googlers][3];
			for(int i = 0; i < googlers; i++)
			{
				int total = sc.nextInt();
				//split
				int remainder = total%3;
				scores[i][0] = total/3;
				scores[i][1] = total/3;
				scores[i][2] = total/3;
				if(remainder == 1)
				{
					scores[i][0]++;
				}
				if(remainder == 2)
				{
					scores[i][0]++;
					scores[i][1]++;
				}
			}
//			System.out.println();
			
			// Real code
			// torture
			for(int i = 0; i < googlers; i++)
			{
				if(surprising == 0)
				{
					if(scores[i][0] >= p)
						result++;
				}
				else
				{
					int one = scores[i][0];
					int two = scores[i][1];
					int three = scores[i][2];
					
					if(one >= p)
					{
						result++;
					}
					else
					{
						if(one+1 >= p)
						{
							if(dg.valid(one+1, two-1, three))
							{
								scores[i][0]++;
								scores[i][1]--;
								surprising--;
								result++;
							}
						}
					}
				}
				//System.out.println(scores[i][0] + " " + scores[i][1] + " " + scores[i][2] + "; ");
			}
			//dg.out.write("Case #" + ++casenum + ": " + result + "\n");
			System.out.println("Case #" + ++casenum + ": " + result);
		}
	}
}

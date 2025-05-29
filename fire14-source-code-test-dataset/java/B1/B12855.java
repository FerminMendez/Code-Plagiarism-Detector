package problemC;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class RecycledNumbers {
	
	private static BufferedWriter out = null;
	private static int numberOfTestCases;
	static String[] testCases;
	
	private static void loadData()
	{
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("C-small-attempt0.in"));
//			in = new BufferedReader(new FileReader("inputC.small"));
//			in = new BufferedReader(new FileReader("C-large.in"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			numberOfTestCases = Integer.parseInt(in.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

//		System.out.println(numberOfTestCases);

		testCases = new String[numberOfTestCases];
		String testCase = null;

		for (int i=0; i<numberOfTestCases; i++)
		{
			//tasks = new LinkedList<Task>();
			try {
//				in.readLine();
				testCases[i] = in.readLine();
//				System.out.println(testCases[i]);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static boolean isRP(String a, String b)
	{
		String c = a.concat(a);
		if (c.contains(b))
			return true;
		return false;
	}
	
	public static void main(String argv[])
	{
		loadData();
		
		try {
			out = new BufferedWriter(new FileWriter("outputC.small"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int pairC = 0;
		for (int i=0; i<numberOfTestCases; i++)
		{
			String[] testCaseItems;
			testCaseItems = testCases[i].split(" ");
			int a = Integer.parseInt(testCaseItems[0]);
			int b = Integer.parseInt(testCaseItems[1]);
			
			for (int j=a; j<b; j++)
			{
				for (int k=j+1; k<=b; k++)
				{
					if (isRP(String.valueOf(j), String.valueOf(k)))
						pairC++;
				}
			}
			
			try {
				out.write("Case #"+(i+1)+": " + pairC);
				out.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			pairC = 0;
		}
		
		try {
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

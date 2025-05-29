package duyonggang;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class RecycledNumbers {

	public static int pass(int n, int a, int b)
	{
		if(n < 10)
			return 0;
		
		int counter = 0;
		String s = Integer.toString(n);
		int m;
		List<Integer> passedValues = new ArrayList<Integer>();
		for(int i = s.length() - 1; i > 0; i--)
		{
			if(s.charAt(i) == '0')
				continue;
			m = Integer.parseInt(s.substring(i, s.length()) + s.substring(0, i));
			if(m > n && m <= b && !passedValues.contains(m))
			{
				counter++;
				passedValues.add(m);
			}
		}
		return counter;
	}
	
	public static int analyze(String line)
	{
		int counter = 0;
		String[] strs = line.split(" ");
		int a = Integer.parseInt(strs[0]);
		int b = Integer.parseInt(strs[1]);
		for(int i = a; i <= b; i++)
		{
			counter += RecycledNumbers.pass(i, a, b);
		}
		return counter;
	}
	
	public static void main(String[] args) throws Exception
	{
		File input = new File("c.txt");
		FileReader fr = new FileReader(input);
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		line = br.readLine();
		int count = Integer.parseInt(line);
		for(int i = 0; i < count; i++)
		{
			line = br.readLine();
			System.out.println("Case #" + (i + 1) + ": " + RecycledNumbers.analyze(line));
		}
	}
}

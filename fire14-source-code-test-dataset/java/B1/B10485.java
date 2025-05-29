
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Recycle
{
	public static void main(String[] args)
	{
/*		Set<Integer> perms = getPermutations(123456);
		
		for(Integer i: perms)
			System.out.println(i);*/
	
		try
		{
			Scanner s = new Scanner(new File("recycle.in"));
			BufferedWriter w = new BufferedWriter(new FileWriter(new File("recycle.out")));
			int numCases = s.nextInt();
			s.nextLine();
			
			for(int n = 1;n <= numCases; n++)
			{
				int A = s.nextInt();
				int B = s.nextInt();
				int count = 0;
				for(int k = A; k <= B; k++)
				{
					count += getNumPairs(k, B);
				}
				
				w.write("Case #" + n + ": " + count + "\n");
			}
			
			w.flush();
			w.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static int getNumPairs(int n, int B)
	{
		Set<Integer> possibles = getPermutations(n);
		int count = 0;
		for(Integer i : possibles)
			if(i > n && i <= B)
				count++;
		return count;
	}
	
	public static Set<Integer> getPermutations(int n)
	{
		Set<Integer> perms = new TreeSet<Integer>();
		char[] digits = String.valueOf(n).toCharArray();
		
		for(int firstPos = 1; firstPos < digits.length; firstPos++)
		{
			String toBuild = "";
			for(int k = 0; k < digits.length; k++)
				toBuild += digits[(firstPos + k) % digits.length];
			perms.add(Integer.parseInt(toBuild));
		}
		return perms;
	}
	

}
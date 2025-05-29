import java.util.*;
import java.io.*;

public class C {
	public static void main(String[] args) {
		try 
		{
			Scanner input = new Scanner(new FileReader("C.in"));
			PrintWriter output = new PrintWriter(new FileWriter("C.out"));
			try
			{
				int i = Integer.parseInt(input.nextLine());
				for(int j=0; j<i; j++)
				{
					int num = j+1;
					int a = input.nextInt();
					int b = input.nextInt();
					output.println("Case #" + num + ": " + recycle(a, b));
				}
			}
			catch(Exception ex) { System.out.println("Error"); }
			finally
			{
				input.close();
				output.close();
			}
		}
		catch(Exception ex) { System.out.println("Error"); }
	}
	
	public static String recycle(int a, int b)
	{
		int num = 0;
		for(int i=a; i<=b; i++)
		{
			for(int j=i+1; j<=b; j++)
			{
				if(recycled(i,j)) num++;
			}
		}
		
		return Integer.toString(num);
	}
	
	public static boolean recycled(int i, int j)
	{
		String a = Integer.toString(i);
		String b = Integer.toString(j);
		
		int check = 1;
		while(check<a.length())
		{
			char temp = b.charAt(b.length()-1);
			b = temp + b.substring(0, b.length()-1);
			if(a.equals(b)) 
			{
				System.out.println(i + " " + j);
				return true;	
			}
			check++;
		}
		return false;
	}
}
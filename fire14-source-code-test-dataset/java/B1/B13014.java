import java.util.*;
import java.io.*;

public class recycled{
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		//System.out.println("Hello world!");
		String scases = in.nextLine();
		int cases = Integer.parseInt(scases);

		for(int i =1;i<=cases;i++)
		{
			String line = in.nextLine();
			String[] split = line.split(" ");
			String first = split[0];
			String second = split[1];
			int ifirst = Integer.parseInt(first);
			int isecond = Integer.parseInt(second);
			int count = cases(ifirst,isecond);

			System.out.println("Case #"+i+": "+count);
		}
		//System.out.println(count);
		//cases();
	}
	public static int cases(int lower, int upper)
	{
		int count =0;
		//int lower = 1111;
		//int upper = 2222;
		for(int i =lower; i<=upper; i++)
		{
			for(int j =lower; j<=upper; j++)
			{				
				if(isRecycled(i,j)&&i!=j){
					//System.out.println(i+","+j);
					count++;
				}
			}
		}
		//System.out.println(count/2);
		return count/2;
		//System.out.println(isRecycled(12345,34512));
	}
	public static boolean isRecycled(int a, int b)
	{
		String aa = ""+a;
		String bb = ""+b;

		for(int i=0;i<aa.length();i++){

			String test = aa.substring(i,aa.length()) + aa.substring(0,i);
			//System.out.println(test);
			if(test.equals(bb)){
				return true;
			}
		}

		return false;
	}
}
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("input.txt"));
		
		int testcases = in.nextInt();
		int a, b, count;
		String aString, bString;
		ArrayList<String> compList = new ArrayList<String>();
		
		for(int test=1; test<=testcases; test++)
		{
			a = in.nextInt();
			b = in.nextInt();
			count = 0;
			
			while(a<b)
			{
				compList = new ArrayList<String>();
				aString = String.valueOf(a);
				
				for(int i=1; i<aString.length(); i++)
				{
					compList.add(aString.substring(aString.length()-i, aString.length())+aString.substring(0,aString.length()-i));
				}
				
				for(int i=a+1; i<=b; i++)
				{
					bString = String.valueOf(i);
					
					for(String s : compList)
					{
						if (bString.equals(s) && s.indexOf("0")!=0)
						{
							count++;
						}
					}
				}
				a++;
			}
			
			System.out.println("Case #"+test+": "+count);
			
		}

	}

}

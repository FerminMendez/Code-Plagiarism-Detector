import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Arrays;


public class Recycled {


	public static void main(String args[]) throws IOException
	{
		try
		{
			PrintWriter wt= new PrintWriter("C:\\Documents and Settings\\windows\\workspace\\test\\src\\file.out.txt");
			Scanner I = new Scanner(new File("C:\\Documents and Settings\\windows\\workspace\\test\\src\\C-small-attempt0.in"));
			String num = I.nextLine();
			int numTests = Integer.parseInt(num);

			for(int x=0; x<numTests; x++)
			{
				int a = I.nextInt();
				int b = I.nextInt();
				int count = 0;
				int arr[] = new int[b-a+1];

				for(int z = 0; z<(b-a+1); z++)
				{  arr[z] = a + z;
				;
				}

				for( int i = 0; i < (b-a+1); i++)
				{
					for(int j = i; j < (b-a+1); j++)
					{
						if( (arr[i] < arr[j]) && (i != j))
						{
							if (isRecycled(arr[i],arr[j])== true)
								count = count + 1;	 

						} 	
					}
				}
				//logic to write result to file
				String finalResult = "Case #"+(x+1)+": "+count;
				wt.println(finalResult);
			}
			wt.close();
			I.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}

		catch(IOException e)
		{
			System.out.println(e);
		}
	}


	// Replacement algorithm
	public static boolean isRecycled(int a, int b)
	{  
		//also need to check for size of a and b ?? not needed if we directly compare


		String strA = Integer.toString(a);
		String strB = Integer.toString(b);
		String newStr = null;
		for (int i = 0; i<strB.length(); i++)
		{   
		    newStr = movedFirstToLast(strB);
		    strB = newStr;
			if(strA.equals(newStr))
			{
				return true;
			}
		}		  	
		return false;

	} 


	public static String movedFirstToLast(String a)
	{
		String newString = null;
		String firstChar = a.substring(0,1);
		newString = a.substring(1); // except first character
		newString = newString + firstChar;
        return newString;
	}


}		 


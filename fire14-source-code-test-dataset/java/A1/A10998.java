import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class BSmall
{

	public static boolean getNDWithThreshold(int hs , int threshold )
	{
		for(int i = 10 ; i >=0 ; i--)
		{
			int remainder = hs - i ;
			if(remainder>0)
			{
			int second = 0 ; 
			int third =0;
			
			if(remainder%2 == 0)
			{
				second = remainder/2 ;
				third = remainder/2 ;
			}
			else
			{
				second = (remainder/2)+1;
				third = (remainder/2) ;
			}
			
			if(i-third <=1)
			{
				if (i>= threshold)
				{
					return true; 
				}
			}
			
		}
		}
		return false ;
	}
	
	public static boolean getSDWithThreshold(int hs , int threshold )
	{
		for(int i = 10 ; i >=0 ; i--)
		{
			int remainder = hs - i ;
			if(remainder>0)
			{
			int second = 0 ; 
			int third =0;
			
			if(remainder%2 == 0)
			{
				second = remainder/2 ;
				third = remainder/2 ;
			}
			else
			{
				second = (remainder/2)+1;
				third = (remainder/2) ;
			}
			
			if(i-third <=2)
			{
				if (i>= threshold)
				{
					return true; 
				}
			}
			}
		}
		return false ;
	}
	
	public static boolean getND(int hs )
	{
		for(int i = 10 ; i >=0 ; i--)
		{
			int remainder = hs - i ;
			int second = 0 ; 
			int third =0;
			
			if(remainder%2 == 0)
			{
				second = remainder/2 ;
				third = remainder/2 ;
			}
			else
			{
				second = (remainder/2)+1;
				third = (remainder/2) ;
			}
			
			if(i-third <=1)
			{
				return true;
			}
			
		}
		return false ;
	}
	
	public static int[] insertionSort(int[] input)
	{
		int [] output = new int[input.length];
		
		for (int i = 0; i < input.length; i++)
		{
		 int j = 0 ;
		 boolean isAdded = false ;
		 while(!isAdded && j<i)
		 {
		 if(input[i]<= output[j])
		 {
			 for (int k = i; k > j; k--)
			{
				output[k]=output[k-1];
			}
			 output[j]=input[i];
			 isAdded = true;
		 }
		 j++;
		 }
		 if(!isAdded)
		 {
			 output[j]=input[i];
		 }
		}
		return output ;
	}
	
	public static void main(String[] args) throws IOException
	{
		Scanner reader = new Scanner(new File("B-small-attempt3.in"));
		Scanner reader2 = new Scanner(new File("test1.txt"));

		FileWriter writer = new FileWriter(new File("output.out"));
		reader.nextLine();
		int n = 0 ;
		while(reader.hasNext())
		{
			n++;
			String input = reader.nextLine();
//			System.out.println(input);
			String[] inputArray = input.split(" ");
			int size = Integer.parseInt(inputArray[0]);
			int surbCases = Integer.parseInt(inputArray[1]);
			int threshold = Integer.parseInt(inputArray[2]);
			int scores[]  = new int[size];
			int output=0;
			if(threshold!=0)
			{
			for (int i = 3; i < inputArray.length; i++)
			{
			scores[i-3]= Integer.parseInt(inputArray[i]);	
			}
			scores = insertionSort(scores);
			output = 0 ;
			for (int i = 0; i < scores.length; i++)
			{
				if(getNDWithThreshold(scores[i], threshold))
				{
					output++;
				}
				else if(surbCases>0&&getSDWithThreshold(scores[i], threshold))
				{
					output++;
					surbCases -- ;
				}
			}
			}else
			{
				output = size;
			}
			writer.write("Case #"+n+": "+output+"\r\n");
			System.out.println(("Case #"+n+": "+output));
		}
		writer.close();
	}
}

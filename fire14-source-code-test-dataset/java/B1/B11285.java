import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class RecycledNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new RecycledNumbers().fun();
	}
	
	private void fun()
	{
		String file = "D:/CodeJam/input.in";
		int result = 0;
		try {
			scan = new Scanner(new File(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		int cases = scan.nextInt();
		
		for(int i = 1; i <= cases ; i++)
		{
			int lowLimit = scan.nextInt();
			int highLimit = scan.nextInt();
			result = findResult(lowLimit, highLimit);
			
			System.out.println("Case #"+i+": "+result);
		}
	}
	
	private int findResult(int lowLimit, int highLimit)
	{
		if(highLimit < 10)
			return 0;
		
		int[] lowArr = null;
		int count = 0;
		int shift = 0;
		ArrayList list = new ArrayList();
		for(int i = lowLimit; i <= highLimit; i++)
		{
			list.clear();
			lowArr = toArray(i);
			for(int j = 0; j < lowArr.length-1; j++)
			{
				int[] shiftArr = shift(lowArr);
				if(lowArr.length == shiftArr.length)
				{
					shift = arrayToInt(shiftArr);
					if(i < shift && shift >= lowLimit && shift <= highLimit)
					{
						if(!list.contains(shift))
						{
							list.add(shift);
							count++;
						}
					}
				}
			}
		}
		return count;
	}
	
	private int[] shift(int[] array)
	{
		int i = 0;
		
		int temp = array[array.length-1];
		for(i = array.length-1 ; i > 0; i--)
		{
			array[i] = array[i-1];
		}
		array[0] = temp;
		return array;
	}
	
	private int arrayToInt(int[] array)
	{
		int result = 0;
		for(int i =0; i < array.length ; i++)
		{
			result = array[i] + result * 10;
		}
		return result;
	}
	
	private int[] toArray(int value)
	{
		int array[] = new int[100];
		
		int count = 0;
		while(value > 0)
		{
			int temp = value % 10;
			value = value / 10;
			
			array[count++] = temp;
		}
		int array2[] = new int[count];
		int j = count - 1;
		
		for(int i = 0; i < count ; i++ , j--)
		{
			array2[j] = array[i];
		}
		
		return array2;
	}
	Scanner scan = null;
}

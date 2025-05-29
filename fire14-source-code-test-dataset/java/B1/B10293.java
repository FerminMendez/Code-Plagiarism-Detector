import java.util.HashMap;
import java.util.Scanner;


public class recyclednumbers {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numOfLines = Integer.parseInt(in.nextLine());
		for(int i = 0;i<numOfLines;i++)
		{
			String resultline = "Case #"+(i+1)+": "+readLine(in.nextLine());
			System.out.println(resultline);
		}
	}
	
	public static int checkNumber(int min,int max, int number)
	{
		String numberString = String.valueOf(number);
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		int length = numberString.length();
		for(int i =1;i<length;i++)
		{
			int recycled = Integer.parseInt(numberString.substring(i,length)+numberString.substring(0,i));
			if(recycled > number&&recycled<=max)
			{
				map.put(recycled, 0);
			}
		}
		return map.size();
	}
	
	public static int checkRange(int start,int end)
	{
		int count = 0;
		for(int i = start;i<end;i++)
		{
			count += checkNumber(start, end, i);
		}
		return count;
	}
	
	public static String readLine(String line)
	{
		String[] pair = line.split(" ");
		int result = checkRange(Integer.parseInt(pair[0]),Integer.parseInt(pair[1]));
		return String.valueOf(result);
	}

}

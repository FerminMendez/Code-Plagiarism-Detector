import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Main {
	public static void main(String arg[])
	{
		try {
		
			FileInputStream fIn = new FileInputStream("input.txt");
			
			Charset cs = Charset.forName("UTF-8");
			InputStreamReader iRd = new InputStreamReader(fIn,cs);
			BufferedReader bRd = new BufferedReader(iRd);
			
			
			String str = bRd.readLine();
			
			Integer line = Integer.parseInt(str);
						
			Writer output = null;
			File file = new File("output.txt");
			output = new BufferedWriter(new FileWriter(file));
			
			
			for(int i = 0 ; i < line; ++i)
			{
				String inLine = bRd.readLine();
				String[] nums = inLine.split(" ");
				
				String start = nums[0];
				String stop = nums[1];
				
				int result = calculate(Integer.parseInt(start),Integer.parseInt(stop));
//				System.out.println("Case #" + (i+1) + ": " + result);
				output.write("Case #" + (i+1) + ": " + result + "\n");
			}
			
			output.close();
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
	}
	public static int calculate(Integer start, Integer stop)
	{		
		int sum = 0;
		
		List<Integer> ranges = separate(start,stop);
		
		for(int i = 0 ; i < ranges.size() ;)
		{
			
			Integer lowBound = ranges.get(i);
			Integer upBound = ranges.get(i+1);
			
//			System.out.println(ranges.get(i) + " : " + ranges.get(i+1));
			
			sum += countCyclic(lowBound , upBound);
			
			i+=2;
		}
		
		return sum;
		
	}
	
	public static int countCyclic(Integer start,Integer stop)
	{
		int count = 0;
		int dec = start;
		boolean mark[] = new boolean[stop-start+1];
		
		for(int i = start ; i < stop ; ++i)
		{
			if(!mark[i-dec])
			{
				List<Integer> shiftRes = shifting(i,start,stop);
				
				switch(shiftRes.size())
				{
				case 2 : ++count;break;
				case 3 : count+=3;break;
				case 4 : count+=6;break;
				case 5 : count+=10;break;
				case 6 : count+=15;break;
				case 7 : count+=21;break;
				case 8 : count+=28;break;				
				}
				
				
				
				for(int j = 0 ; j < shiftRes.size() ; ++j)
				{
					
					Integer num = shiftRes.get(j);
					mark[num-dec] = true;
				}
			}
		}
		
		return count;
		
	}
	
	public static List<Integer> shifting(Integer seed ,Integer lowerBound, Integer upperBound)
	{
		List<Integer> result = new ArrayList<Integer>();
		
		result.add(seed);
				
		String num = seed.toString();
		
		int n = num.length()-1;		
		
		for(int i = 0 ; i < n ; ++i)
		{
			num = num.substring(1) + num.charAt(0);
			Integer intNum = Integer.parseInt(num); 
			if(num.charAt(0)!='0' && !result.contains(intNum) && intNum <= upperBound && intNum >= lowerBound)
			{								
				result.add(intNum);				
			}
		}
		
		
		return result;
	}
	
	public static List<Integer> separate(Integer start, Integer stop)
	{
		List<Integer> shift = null;  
		
		if(stop.toString().length() > start.toString().length())
		{
			int n = start.toString().length();
			
			String wall = "";
			
			while(wall.length() < n)
			{
				wall += 9;
			}
			
			Integer upBound = Integer.parseInt(wall);
			
			shift = separate(upBound+1,stop);
			shift.add(start);
			shift.add(upBound);
		}
		else
		{
			shift = new ArrayList<Integer>();
			shift.add(start);
			shift.add(stop);
		}
		
		return shift;
	}
	
}

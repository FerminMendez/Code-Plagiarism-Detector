
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;


public class gjam {
	
	public static void main(String[] args)
	{
	
		int TestCases = 0;
		int currentCase = 0;
		
		try
		{
			
		
			FileInputStream fstream = new FileInputStream("C-small-attempt0.in");
			DataInputStream dstream = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(dstream));
			
			String inputStr = br.readLine();
			
			TestCases = Integer.parseInt(inputStr);
			
			while(currentCase != TestCases)
			{
				ArrayList<Integer> results = new ArrayList<Integer>();
				inputStr = br.readLine();
				int result = 0;
				
				String[] inputs = inputStr.split(" ");
				int size = inputs[0].length();
				int A = Integer.parseInt(inputs[0]);
				int B = Integer.parseInt(inputs[1]);
				if(A >= 10 && B > A)
				for(int i = A; i <= B; i++)
				{
					for(int j = 1; j <= size; j++)
					{
						int moved = moveDigits(j,i);
						
						if(A <= i && i < moved && moved <= B)
						{
							
							results.add(i);
							results.add(moved);
							result++;
						}
						
					}
					
					
				}
				
				System.out.println("Case #" + (currentCase +1) + ": " + result);
				currentCase++;
			}
			
			
		}
		catch(Exception e)
		{
			System.err.println("Err: " + e.getMessage());
		}
		
	}
	public static int moveDigits(int numTomove,int input)
	{
		String original = "" + input;
		int length = original.length();
		String sub1 = original.substring(length - numTomove);
		String sub2 = original.substring(0,length - numTomove);
		
		String output = sub1 + sub2;
		
		return Integer.parseInt(output);
	}
	
}

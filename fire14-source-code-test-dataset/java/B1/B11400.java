import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;


public class Recycle {

	
	public Recycle() {
		
		String line;
		Integer maxInputs,output;
		Integer a, b;
		try {
			BufferedReader read = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("input")));
			BufferedWriter write = new BufferedWriter(new FileWriter("output"));
			maxInputs = new Integer(read.readLine());
			for(int i = 1 ; i <= maxInputs ; i++)
			{
				int success = 0;
				line = read.readLine();
				String[] numbers = line.split(" ");
				a = new Integer(numbers[0]);
				b = new Integer(numbers[1]);
				
				success = getCount(a,b);
				
				output = new Integer(success);
				write.write("Case #"+i+": ");
				write.write(output.toString());
				write.write("\n");
			}
			write.close();
		
		
		}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		new Recycle();
		long endTime = System.nanoTime();;
		System.out.println("Took "+(endTime - startTime) + " ns");
	}

	int getCount(int start, int end)
	{
		int count = 0 ;
		
		String numStart = new Integer(start).toString();
		int digits = numStart.length();
		String num ;
		char[] perm = new char[digits];
		
		
		
		
		if(digits == 1)
			return 0;
		
		for( Integer i = start; i <= end; i++)
		{
			num = i.toString();
			for( int j = 1; j < digits; j++)
			{
				for(int k = 0 ; k < digits; k++)
				{
					perm[k] = num.charAt((j+k)%digits); 
				}
				Integer permNum = Integer.parseInt(new String(perm));
				
				if(i < permNum && permNum >= start && permNum <= end)
					{
					count++;
					System.out.println(i+" "+permNum);
					}
			}
			
			
			
			
		}
		
		return count;
	}
}
/*
 * 
			if(digits == 2)
			{	
				perm[0] = num.charAt(1);
				perm[1] = num.charAt(0);
				Integer j = Integer.parseInt(new String(perm));
				
				
				if( j == i )
					continue;
				if(j >= start && j <= end)
				{
					if( i < j )
					count++;
				}
			}
			if(digits == 3)
			{
				perm[0] = num.charAt(2);
				perm[1] = num.charAt(0);
				perm[2] = num.charAt(1);
				Integer j = Integer.parseInt(new String(perm));
				if( j == i )
					continue;
				if(j >= start && j <= end)
				{
					if( i < j )
					count++;
				}
				perm[0] = num.charAt(1);
				perm[1] = num.charAt(2);
				perm[2] = num.charAt(0);
				j = Integer.parseInt(new String(perm));
				if( j == i )
					continue;
				if(j >= start && j <= end)
				{
					if( i < j )
					count++;
				}
			}
*/

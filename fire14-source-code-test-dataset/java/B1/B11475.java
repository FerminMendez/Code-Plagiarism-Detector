import java.io.*;
import java.util.*;
public class ReNu {

	public static void main(String[] args)
	{
		Scanner scan = null;
		PrintWriter outStream = null;
		try
		{
			outStream = new PrintWriter(new FileOutputStream("c_out.txt"));
			scan = new Scanner(new FileInputStream("C-small-attempt0.in"));
		}catch (FileNotFoundException e)
		{
			System.out.println("File not found!");
			System.exit(0);
		}
		
		int lines = scan.nextInt();
		for(int i = 0;i < lines; i++)
		{
			
			int ans = 0;
			int a = scan.nextInt();
			int b = scan.nextInt();
			for(int j = a; j<b+1;j++)
			{
				
				int digit = 1;
				int temp = j/10;
				
				while(temp > 0)
				{
					temp = temp/10;
					digit++;
				}
				temp = j;
				int[] array = new int[digit];
				for(int k = digit-1; k>0; k--)
				{
					int rem = temp%10;
					temp = temp/10;
					temp += rem*Math.pow(10, digit-1);
					array[k] = temp;
					if(temp>j)
						if(temp<b+1)
						{
							boolean notvalid = false;
							for(int x = k+1;x<array.length;x++)
							{
								if(array[x] == temp)
									notvalid = true;
							}
							
							if(!notvalid)
								ans++;
						}
				}
				
			}
			outStream.println("Case #" + (i+1) + ": " + ans);
		}
		outStream.close();

	}
}
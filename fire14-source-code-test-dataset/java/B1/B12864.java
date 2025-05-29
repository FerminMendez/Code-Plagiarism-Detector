import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Recycle {

	public static void main(String[] args) 
	{
		File f = new File("C-small-attempt0.in");
		try
		{
			Scanner scan = new Scanner(f);
			
			int lines = Integer.parseInt(scan.nextLine());
			FileWriter fstream = new FileWriter("output.txt");
			BufferedWriter out = new BufferedWriter(fstream);
						
			for(int i=0; i<lines; i++)
			{
				String line = scan.nextLine();
				String[] bounds = line.split(" ");
				int count = countPairs(Integer.parseInt(bounds[0]), Integer.parseInt(bounds[1]), bounds[0].length());
				out.write("Case #"+(i+1)+": "+count);
				out.newLine();
			}
			out.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	public static int countPairs(int l, int u, int n)
	{
		if(n==1)
			return 0;
		
		int count=0;
		
		for(int i=l+1; i<=u; i++)
		{
			int cycle = (i%10)*((int)Math.pow(10,n-1)) + (i/10);
			
			while(cycle != i)
			{
				if(cycle >= l && cycle < i)
					count++;
				
				cycle = (cycle%10)*((int)Math.pow(10,n-1)) + (cycle/10);
			}
		}
		return count;
	}
	
	
	
}

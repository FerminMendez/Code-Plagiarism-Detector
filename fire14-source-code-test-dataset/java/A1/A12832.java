import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Dance {

	public static void main(String[] args) 
	{
		File f = new File("B-small-attempt0.in");
		try
		{
			Scanner scan = new Scanner(f);
			
			int lines = Integer.parseInt(scan.nextLine());
			FileWriter fstream = new FileWriter("output.txt");
			BufferedWriter out = new BufferedWriter(fstream);
						
			for(int i=0; i<lines; i++)
			{
				String line = scan.nextLine();
				String[] parts = line.split(" ");
				int N = Integer.parseInt(parts[0]);
				int S = Integer.parseInt(parts[1]);
				int p = Integer.parseInt(parts[2]);
				int[] totals = new int[N];
				for(int j=3;j<3+N;j++)
					totals[j-3] = Integer.parseInt(parts[j]);
				int num = solve(N,S,p,totals);
				out.write("Case #"+(i+1)+": "+num);
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

	private static int solve(int n, int s, int p, int[] totals) 
	{
		int count = 0;
		int countS = 0;
		for(int i: totals)
		{
			if(i>3*(p-1))
				count++;
			else if(countS < s && i>0 && (i==3*(p-1) || i==3*(p-1)-1))
			{
				count++;
				countS++;
			}
				
		}
		return count;
	}

}







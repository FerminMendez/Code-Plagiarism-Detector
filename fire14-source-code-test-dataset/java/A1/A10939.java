import java.io.*;
public class Googlers {

	
	public static void main(String[] args) throws IOException	
	{
		BufferedReader in = new BufferedReader(new FileReader("B-small-attempt0.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
		int nc = Integer.parseInt(in.readLine().trim());
		for (int z=1; z<=nc; z++){
			String[] line = in.readLine().trim().split("\\s+");
			int n = Integer.parseInt(line[0]);
			int s = Integer.parseInt(line[1]);
			int p = Integer.parseInt(line[2]);
			
			int count = 0;
			
			for (int i = 0; i < n; i++)
			{
				int num = Integer.parseInt(line[3+i]);
				if (num>3*p-3) count++;
				else if ((num>=2)&&(num>=3*p-4)&&(s>0))
				{
					count++;
					s--;
				}
			}
			out.println(String.format("Case #%d: %d", z,count));
		}
		out.close();
	}
	
	
	
	
}

import java.io.*;
import java.util.LinkedList;
class firstgame21 
{
	BufferedReader br;
	PrintWriter pw;

	String input;
	int totalpass;

	public firstgame21()
	{
		try
		{
			br = new BufferedReader(new FileReader("B-small-attempt0.in"));
			pw = new PrintWriter(new BufferedWriter(new FileWriter("output1.txt")));		

			
			input = br.readLine();
			int count = Integer.parseInt(input);

			for (int x=1; x<= count; x++)
			{
				totalpass = 0;
				input = br.readLine();
				String data[] = input.split(" ");
				int people = Integer.parseInt(data[0]);
				int extra = Integer.parseInt(data[1]);
				int min = Integer.parseInt(data[2]);

				for (int y = 0; y< people ; y++ )
				{
					int p = Integer.parseInt(data[3+y]);
					int max;
					if (p%3==0)
					{
						 max = p/3;
				//System.out.println("max1:"+max);
						 if (max >= min)
						 {
							 totalpass++;
						 }
						 else if (max + 1 == min)
						 {
							 if (max == 0)
							 {
							 }
							 else if (extra > 0)
							 {
							 totalpass++;
							 extra-- ;
							 }
						 }
					}
					else if (p%3==1)
					{
						 max = (p/3) + 1;
				//System.out.println("max2:"+max);
						 if (max >= min)
						 {
							 totalpass++;
						 }
					}
					else if (p%3==2)
					{
						 max = (p/3) + 1;
				//System.out.println("max3:"+max);
						 if (max >= min)
						 {
							 totalpass++;
						 }
						 else if (max+1 == min)
						 {
							 if (extra > 0)
							 {
							 totalpass++;
							 extra-- ;
							 }
						 }
					}
				}

				System.out.println("Case #"+x+": "+totalpass);
				pw.println("Case #"+x+": "+totalpass);
			}
			// after end read
			pw.close();
		}
		catch (IOException e)
		{
			System.out.println(e);
		}	
	}
	public static void main(String[] args) 
	{
		new firstgame21();
	}
}

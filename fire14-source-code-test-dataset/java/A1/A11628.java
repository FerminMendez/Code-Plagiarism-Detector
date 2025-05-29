import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class a 
{
	public static void main(String[] args) throws IOException
	{
		BufferedReader in = new BufferedReader(new FileReader("B-small.in"));
		FileWriter fr = new FileWriter("small.out");
		
		int num = Integer.parseInt(in.readLine());
		
		for(int cases = 1 ; cases<=num ; cases++)
		{
			String []temp =  in.readLine().split(" ");
			//for (int i=0;i<temp.length;i++)
			int numberofgooglers = Integer.parseInt(temp[0]);
			int suprisingtriplets = Integer.parseInt(temp[1]);
			int maxvalue = Integer.parseInt(temp[2]);
			int availablesurprisingtriplets = suprisingtriplets;
			int result = 0;
			
			for (int i=0;i<numberofgooglers ; i++)
			{
				int score = Integer.parseInt(temp[i+3]);
				if(score >= ((maxvalue*3)-2)) 
				{
					result++;
				}
				else if((score >= ((maxvalue*3)-4)) && (availablesurprisingtriplets > 0) && (maxvalue > 1))
				{
					result++;
					availablesurprisingtriplets--;
				}
			}
			fr.write("Case #"+cases+": "+result+"\n");
			//System.out.println("Case #"+cases+": "+result);
		}
		fr.close();
	}
}

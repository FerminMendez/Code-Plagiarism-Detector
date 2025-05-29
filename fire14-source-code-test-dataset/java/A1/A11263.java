import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class DancingWithGooglers {

	public static void main(String[] args) throws IOException{
		FileReader inf = new FileReader("data/B-small.in"); 
		BufferedReader in = new BufferedReader(inf); 
		FileWriter outf = new FileWriter("result/B-small.out");  
		BufferedWriter out = new BufferedWriter(outf);  
		int numCases = Integer.parseInt(in.readLine());  
		int numGoogler = 0;
		int numSuprising = 0;
		int p = 0;
		int maxResult = 0;
		
		for(int index = 1; index <=numCases; index++)
		{
			/*Begin to get data*/
			String line = in.readLine();  
			String []tokens = line.split(" ");
			numGoogler = Integer.parseInt(tokens[0]);
			numSuprising = Integer.parseInt(tokens[1]);
			p = Integer.parseInt(tokens[2]);
			Integer [] scores = new Integer[numGoogler];
			int k = 0;
			maxResult = 0;
			for(int i = 3; i < tokens.length; i++)
			{
				scores[k++] = Integer.parseInt(tokens[i]);
			}
			/*End of getting data*/
			
			/*Reverse the order*/
			Arrays.sort(scores, Collections.reverseOrder());
			for(int i = 0; i < scores.length;i++)
			{
				if(scores[i] >= 3*p)
				{
					maxResult++;
				}
				else if(scores[i] < p)
				{
					continue;
				}
				else if((scores[i]>=(3*p - 2)) && (scores[i]<= (3*p -1)))
				{
					maxResult++;
				}
				else if((scores[i]>=(3*p - 4)) && (3*p - 4) > 0)
				{
					if(numSuprising > 0)
					{
						maxResult ++;
						numSuprising--;
					}
				}
				else
				{
					continue;
				}
			}
			System.out.println("Case #"+index+": "+maxResult);
			out.write("Case #"+index+": "+" "+maxResult);
			out.newLine();
			out.flush();
		}
		
	}
	
}

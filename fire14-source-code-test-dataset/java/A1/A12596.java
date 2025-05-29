package codejam;

import java.io.*;
import java.util.*;

public class DancingWithGooglers {
	
	public static void main(String[] args) throws IOException {
		BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
		int noOfTestCases = Integer.parseInt(inp.readLine());
		StringTokenizer str;
		int noOfGooglers;
		int noOfSurprises;
		int bandWidth;
		int currScore;
		ArrayList<Integer> results = new ArrayList<Integer>();
		
		for(int i=0;i<noOfTestCases;i++)
		{
			int num = 0;
			str = new StringTokenizer(inp.readLine());
			noOfGooglers = Integer.parseInt(str.nextToken());
			noOfSurprises = Integer.parseInt(str.nextToken());
			bandWidth = Integer.parseInt(str.nextToken());
			if(bandWidth == 0)
			{
				results.add(noOfGooglers);
				continue;
			}
			for(int j=0;j<noOfGooglers;j++)
			{
				 currScore = Integer.parseInt(str.nextToken());
				 if(currScore > (bandWidth - 1)*3)
				 {
					 num++;
					 continue;
				 }
				 if(bandWidth == 1)
					 continue;
				 if(noOfSurprises > 0 && currScore > ((bandWidth - 2)*3 + 1))
				 {
					 num++;
					 noOfSurprises--;
				 }
			}
			results.add(num);
		}
		
		ListIterator<Integer> itr = results.listIterator();
		int i=1;
		while(itr.hasNext())
		{
			System.out.println("Case #" + i + ": " + itr.next());
			i++;
		}
	}
}

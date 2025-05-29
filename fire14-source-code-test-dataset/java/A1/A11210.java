import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class ProblemB {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(new File(args[0]));
		int numberOfLines = Integer.parseInt(sc.nextLine());
		Scanner lineScan;
		int numberOfPeople =0, numberOfSurprising = 0, bestRes = 0;
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> triple;
		
		int score, count = 0;
		String line = " ";
		
		for (int i=0; i<numberOfLines;i++)
		{
			count = 0;
			line = sc.nextLine();
			lineScan = new Scanner(line);
			numberOfPeople = lineScan.nextInt();
			numberOfSurprising = lineScan.nextInt();
			bestRes = lineScan.nextInt();
			
			for (int j = 0; j< numberOfPeople; j++)
			{
				score = lineScan.nextInt();
				triple = new ArrayList<Integer>();
				if (score % 3 == 0)
				{
					
					if (score/3 < bestRes && score/3 + 1 >= bestRes && score > 0 && numberOfSurprising > 0)
					{
						triple.add(score/3 -1);
						triple.add(score/3);
						triple.add(score/3 +1);
						numberOfSurprising --;
					}
					else
					{
						for (int k = 0; k<3; k++)
							triple.add(score/3);
					}
					list.add(triple);
				}
				else
				{
					double mean = (double) score /3;
					double boundary = score/3 +0.5;
					if (mean > boundary )
					{
						if (score/3 + 2 == bestRes && numberOfSurprising >0)
						{
							triple.add(score/3);
							triple.add(score/3);
							triple.add(score/3 +2);
							numberOfSurprising--;
						}
						else
						{
							triple.add(score/3);
							triple.add(score/3 +1);
							triple.add(score/3 + 1);
						}
							
					}
					else
					{
						triple.add(score/3);
						triple.add(score/3);
						triple.add(score/3 +1);
					}
					
					list.add(triple);
						
					
				}
			}
			
			//System.out.println("Line " + line);
			for (ArrayList<Integer> tri: list)
			{
				if (tri.get(tri.size()-1) >= bestRes)
					count++;
				
			}

			System.out.printf("Case #%d: %d\n", i+1, count);
			
			list.clear();
							
		}
	}

}

package codejam;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProblemB_DancingWithTheGooglers {
	public static void main(String[] args) throws IOException 
	{
		Scanner scan = new Scanner(new File("c:/B-small-attempt0.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Googlers.out")));
		
		
		int N = Integer.valueOf(scan.nextLine());
		int id =1;
		while(scan.hasNextLine())
		{
			String letters = scan.nextLine();
			String[] letter = letters.split(" ");
			
			int peopleNum =  Integer.valueOf(letter[0]);
			int superiNum =  Integer.valueOf(letter[1]);
			int score =  Integer.valueOf(letter[2]);
			int[] scores = new int[peopleNum];
			for(int i=0;i<peopleNum;i++)
			{
				scores[i] = Integer.valueOf(letter[i+3]);
			}
			
			int reslut   = algorithm(peopleNum, superiNum, score, scores);
			out.println("Case #" + id + ": " + reslut);
			
			
			out.println();
			id++;
		}
		out.close();

	}
	
	public static int algorithm(int peopleNum, int superiNum, int score,int[] scores)
	{
		int num = 0;
		int highScores = score * 3 - 2;
		int lowScores  = score * 3 - 4;
		
		//the case score=1
		if(lowScores <= 0) lowScores = 1;
		
		for(int item : scores)
		{
			if(item >= highScores)
				num ++;
			else
			{
				if(superiNum > 0)
				{
					if(item >= lowScores)
					{
						num++;
						superiNum --;
					}
				}
			}
		}

		return num;
	}

}

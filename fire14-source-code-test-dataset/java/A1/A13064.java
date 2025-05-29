package qualification_round;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.*;

public class DancingWithGooglers {

	
	public static void main(String[] args)  throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input2.txt")));
		int inputSize = Integer.parseInt(br.readLine());
		 
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("output2.txt")));
		for(int x = 1 ; x <= inputSize ; x++ )
		{
			
			String line = br.readLine();
			String[] lineArray = line.split(" ");
			int n = Integer.parseInt(lineArray[0]);
			int s = Integer.parseInt(lineArray[1]);
			int p = Integer.parseInt(lineArray[2]);
			int array[] = new int[n];
			for (int i = 0 ; i< n ; i++)
			{
				array[i] = Integer.parseInt(lineArray[i + 3]);
			}
			bw.write("Case #"+x+": "+findP(n,s,p,array)+"\n");
		}
	bw.flush();
	bw.close();
	br.close();
		
		
		int j[] = {15, 13, 11};
		int i = findP(3,1,5,j);
		System.out.println(i);
	}
	
	public static int findP(int numberOfGooglers, int surprisingTriplets, int p, int totalScores[])
	{
		int answer = 0;
		
		int border0 = 0; 
		int border1 = 0 ; 
		int border2 = 0;
		
		int totalScore, best;
		if (p == 0)
		{
			return numberOfGooglers;
		}
		else
		{
			for(int i = 0 ; i < numberOfGooglers ; i ++)
			{
				totalScore = totalScores[i];
				if (totalScore == 0)
				{/*do nothing*/}
				else if( totalScore % 3 == 0 )
				{
					best = totalScore / 3;
					if (best >= p)
						answer += 1;
					else if(best == (p-1) )
						border0 += 1;
				}
				else if( totalScore % 3 == 1 )
				{
					best = ( totalScore + 2) / 3;
					if (best >= p)
						answer += 1;
					else if(best == (p-1) )
						border1 += 1;
				}
				else
				{
					best = (totalScore + 1) / 3;
					if (best >= p)
						answer += 1;
					else if(best == (p-1) )
						border2 += 1;
				}
			
			}
		}
		

		if(border0 >= surprisingTriplets)
		{
			border0 -= surprisingTriplets;
			answer += surprisingTriplets;
			surprisingTriplets = 0;
		}
		else
		{
			answer += border0;
			surprisingTriplets -= border0;
			border0 = 0;
		}
		
		if(border2 >= surprisingTriplets)
		{
			border2 -= surprisingTriplets;
			answer += surprisingTriplets;
			surprisingTriplets = 0;
		}
		else
		{
			answer += border2;
			surprisingTriplets -= border2;
			border2 = 0;
		}
		
		return answer;
	}

}

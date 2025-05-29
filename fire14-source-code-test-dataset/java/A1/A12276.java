package com.mohit.codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class DancingGooglers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			int noOfTests = 0;
			int noGooglers = 0;
			int surprises = 0;
			int exp_score = 0;
			int total_score = 0;
			int without_surprise = 0;
			int with_surprise = 0;
			
			int judges_score[] = new int[3];
			int some_temp = 0;
			
			FileInputStream fis = new FileInputStream("input.txt");
			DataInputStream din = new DataInputStream(fis);
			BufferedReader br = new BufferedReader(new InputStreamReader(din));
			
			FileWriter fstream = new FileWriter("out.txt");
			BufferedWriter out = new BufferedWriter(fstream);
			
			String strLine;
			strLine = br.readLine();
			if(strLine == null || strLine == "")
				return;
			
			strLine = strLine.trim();
			noOfTests = Integer.parseInt(strLine);
			
			int testNumber = 1;
			
			while(noOfTests>0)
			{
				String output = "";
				strLine = br.readLine();
				if(strLine == null || strLine == "" || strLine == "\n" )
					break;	
				strLine = strLine.trim().toLowerCase();
				
				String[] records= strLine.split(" ");
				noGooglers = Integer.parseInt(records[0]);
				surprises = Integer.parseInt(records[1]);
				exp_score = Integer.parseInt(records[2]);
				
				without_surprise = 0;
				with_surprise = 0;
				
				// loop to get the various scores and store it in array
				for (int i = 0; i < noGooglers; i++)
				{
					//logic to find score such that difference between them is not more than 1
					total_score = Integer.parseInt(records[2 + i + 1]);
					judges_score[0] = total_score / 3;
					judges_score[1] = (total_score - judges_score[0]) / 2;
					judges_score[2] = total_score - judges_score[0] - judges_score[1];
					
					// sort the judges score
					for (int k = 0;k<3;k++)
					{
						for (int l = k+1; l<3;l++)
						{
							if (judges_score [k] > judges_score [l])
							{
								some_temp = judges_score [k];
								judges_score [k] = judges_score [l];
								judges_score [l] = some_temp;
							}
						}
					}
					if (judges_score [2] >= exp_score)
						without_surprise ++;
					else if (judges_score [2] == (exp_score-1) && (total_score - judges_score [2] > 0) && (judges_score[1] == judges_score[2]))
						with_surprise ++;

				}
				if (with_surprise > surprises)
					with_surprise = surprises;
			
				out.write("Case #" + testNumber  + ": " + (without_surprise + with_surprise) + "\n");	
				testNumber ++;
				}
			br.close();
			out.close();
			}
		catch(IOException e)
		{
			System.out.print(e.getMessage());
		}
		finally
		{
		
		}

	}

}

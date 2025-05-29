package codejam.dancing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int  suprising, minScore;
	public static void main(String[] args){
		try {
			// open input file
			BufferedReader in = new BufferedReader ( new InputStreamReader (System.in));
			BufferedReader file = new BufferedReader (new FileReader(in.readLine()));
			// create output file
			FileWriter fstream = new FileWriter("output.out");
			BufferedWriter out = new BufferedWriter(fstream);
			
			// Variables
			StringTokenizer strtok;
			String str, tok;
			int entries, count, googlers, res, g_count,temp;
			
			// retrieve number of entries
			entries = new Integer(file.readLine());
			System.out.println("Entries : " + entries);
			
			count = 0;
			// read lines
			while (((str = file.readLine())!=null) & (count <= entries))
			{
				res = 0;
				strtok = new StringTokenizer(str);
				// number of googlers
				googlers = Integer.parseInt(strtok.nextToken());
				System.out.println("Googlers : "+ googlers);
				// number of suprising entries
				suprising = Integer.parseInt(strtok.nextToken());
				System.out.println("Suprising Scores : " + suprising);
				// minimum score
				minScore = Integer.parseInt(strtok.nextToken());
				System.out.println("Minimum Score : " + minScore);
				
				g_count = 0;
				while (g_count < googlers)
				{
					//temp = Integer.parseInt(strtok.nextToken());
					//System.out.println(temp);
					res += evalScore(Integer.parseInt(strtok.nextToken()));
					g_count++;
				}
				System.out.println("finished?");
				count++;
				out.write("Case #"+count+": "+res+"\n");
			}
			out.close();
		}
		catch(Exception e){
			
		}
	}
	
	public static int evalScore(int score)
	{
		// check for non suprising results
		System.out.print("["+ minScore + "|" + score+"]");
		if (score >= (3*minScore - 2))
		{
			System.out.print(" : 1\n");
			return 1;
		} else if (score == 0){
			System.out.print(" : 0\n");
			return 0;
		} else {
			// check for suprising results
			if (suprising > 0){
				if ((score < (3*minScore - 2))&(score >= (3*minScore - 4)))
				{
					suprising--;
					System.out.print(" : 1\n");
					return 1;
				}
			}
		}
		System.out.print(" : 0\n");
		return 0;
	}
}

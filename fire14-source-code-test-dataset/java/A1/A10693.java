import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


public class googler 
{

	int cases;
	int googlers;
	int surprises;
	int goal;
	int[] points;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		googler gag = new googler();

	}
	
	public googler()
	{
		parseInput();
	}
	
	//read in each case line by line.
	public void parseInput()
	{
		try
		{
			FileInputStream fstream = new FileInputStream("B-small-attempt4.in");
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			FileWriter fwstream = new FileWriter("Googlers.out");
			BufferedWriter out = new BufferedWriter(fwstream);
			
			
			cases = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < cases; i++)
			{
				solveCase(br.readLine(), i, out);
			}
			
			out.close();
			  
		}
		catch (Exception e)
		{//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	//parses variables for this case.
	public void solveCase(String caseArgs, int caseNum, BufferedWriter file) throws IOException
	{
		int y = 0; //the number of scores in this case above goal
		Scanner sc = new Scanner(caseArgs);
		googlers = sc.nextInt();
		surprises = sc.nextInt();
		goal = sc.nextInt();
		points = new int[googlers];
		int bestScore;
		// building the arrray of scores
		for (int i = 0; i < points.length; i++)
			points[i] = sc.nextInt();
				
		
		//System.out.println("N:" + googlers + " S:" + surprises + " P:" + goal + " " + Arrays.toString(points));
		for (int i = 0; i < points.length; i++)
		{

			if (unsurprising(points[i]))
			{
				y++; //chalk one up
				
			}
			else if (surprises > 0 && surprising(points[i]))
			{
				y++;
				surprises--;
			}
		}
		
		file.write("Case #" + (caseNum+1) + ": " + y + '\n');
		//System.out.println(" Case #" + (caseNum+1) + ": " + y);
	}
	
	
	//returns best score if unsurprising
	public boolean unsurprising(int total)
	{
		//System.out.println(goal);
		int min = goal*3;
		min = min - 2;
		if (min <= 0)
			min = goal;
		//System.out.println("min: " + min + " total: " + total);
		return (total >= min);
	}
	
	public boolean surprising(int total)
	{
		int min = goal*3;
		min = min - 4;
		if (min <= 0)
			min = goal;
		//System.out.println("Smin: " + min + " Stotal: " + total);
		return (total >= min);
	}
	
	
	

}

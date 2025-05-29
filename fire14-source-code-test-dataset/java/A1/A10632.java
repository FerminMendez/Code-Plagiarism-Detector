import java.awt.Container;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;


public class Dancing extends JFrame
{
	private final int WIDTH = 800;
	private final int HEIGHT = 400;
	private Container pane; 
	
	private String[] unformatted;
	private String[] formatted;
	private char[][] formattedCharArray;
	
	private int[] numberOfDancers;
	private int[] numberOfSurprises;
	private int[] theScoreToBeat;
	
	private int[][] theScores;
	private boolean[][] wasNatural;
	
	private int[] numberOfNaturalWinners;
	private int[] numberOfSurprisingWinners;
	private int[] numberOfWinners;
	
	private int numberOfLines;
	
	private int[] naturals = {0, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10}; 
	private int[] surprises = {0, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10, 10};
	
	private JTextArea input, output;
	
	
	
	private Scanner scanner;
	private PrintWriter out;
	
	
	public Dancing() throws IOException
	{
		pane = new Container();
		pane = getContentPane();
		
		scanner = new Scanner(new File("c:/users/Christopher/Desktop/input.in"));
		out = new PrintWriter(new FileWriter("c:/users/Christopher/Desktop/output.out")); 
		
		numberOfLines = Integer.parseInt(scanner.nextLine());
		
		
		unformatted = new String[numberOfLines];
		formatted = new String[numberOfLines];
		
		numberOfDancers = new int[numberOfLines];
		numberOfSurprises = new int[numberOfLines];
		theScoreToBeat = new int[numberOfLines];
		
		numberOfNaturalWinners = new int[numberOfLines];
		numberOfSurprisingWinners = new int[numberOfLines];
		numberOfWinners = new int[numberOfLines];
		
		input = new JTextArea(100, numberOfLines);
		input.setSize(300,200);
		input.setLocation (10, 10);
		
		output = new JTextArea(120, numberOfLines);
		output.setSize(300,200);
		output.setLocation(410, 10);
		
		pane.setLayout(null);
		pane.add(input);
		pane.add(output);
		
		theScores = new int[numberOfLines][];
		wasNatural = new boolean[numberOfLines][];		

		for (int i = 0; i < numberOfLines; i++)
		{
			numberOfDancers[i] = scanner.nextInt();
			numberOfSurprises[i] = scanner.nextInt();
			theScoreToBeat[i] = scanner.nextInt();
			
			input.append(numberOfDancers[i] + " " + numberOfSurprises[i] + " " + theScoreToBeat[i] + " ");
			
			theScores[i] = new int[numberOfDancers[i]];
			wasNatural[i] = new boolean[numberOfDancers[i]];
			
			for (int j = 0; j < numberOfDancers[i]; j++)
			{
				theScores[i][j] = scanner.nextInt();
				if (j < numberOfDancers[i] - 1)
					input.append(theScores[i][j] + " ");
				else
					input.append(theScores[i][j] + "\n");
			}
			
		}
		
		for (int i = 0; i < numberOfLines; i++)
		{
			numberOfWinners[i] = findWinners(i);
			output.append("Case #" + (i + 1) + ": " + numberOfWinners[i] + "\n");
			out.println("Case #" + (i + 1) + ": " + numberOfWinners[i] + "\n");
		}
		
		
		
	/*	for (int i = 0; i < numberOfLines; i++)
		{
			formatted[i] = new String(formattedCharArray[i]);
			formatted[i] = "Case #" + (i + 1) + ": " + formatted[i];
			output.append(formatted[i] + "\n");
			out.println(formatted[i]);
		}
		*/
		
		scanner.close();
		out.close();
		
		setVisible(true);
		setSize(WIDTH, HEIGHT);
		setTitle("Tongues");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String args[]) throws IOException
	{
		Dancing awesome = new Dancing();
	}
	
	int findWinners(int whichLine)
	{
		
		numberOfSurprisingWinners[whichLine] = 0;
		
		for (int i = 0; i < numberOfDancers[whichLine]; i++)
		{
			if (naturals[theScores[whichLine][i]] >= theScoreToBeat[whichLine])
			{
				numberOfNaturalWinners[whichLine]++;
				wasNatural[whichLine][i] = true;
			}
		}
		
		for (int i = 0; i < numberOfDancers[whichLine]; i++)
		{
			if (surprises[theScores[whichLine][i]] >= theScoreToBeat[whichLine] && wasNatural[whichLine][i] == false)
			{
				numberOfSurprisingWinners[whichLine]++;
			}
		}
		
		
		if (numberOfSurprisingWinners[whichLine] > numberOfSurprises[whichLine])
		{
			numberOfSurprisingWinners[whichLine] = numberOfSurprises[whichLine];
		}
		
		return numberOfNaturalWinners[whichLine] + numberOfSurprisingWinners[whichLine];
	}
}
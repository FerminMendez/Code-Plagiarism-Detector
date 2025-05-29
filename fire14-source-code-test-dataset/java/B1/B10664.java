import java.awt.Container;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JTextArea;


public class Recycling extends JFrame
{
	private final int WIDTH = 800;
	private final int HEIGHT = 400;
	private Container pane; 
	
	private int[] A;
	private int[] B;
	private int[] numberOfSolutions;
	
	private String[][] permutations;
	
	private int numberOfLines;
	private int lastI = 0;
	private int lastWorkingOnIt = 0;
	
	
	private JTextArea input, output;
	
	
	private Scanner scanner;
	private PrintWriter out, outDebug;
	
	
	public Recycling() throws IOException
	{
		pane = new Container();
		pane = getContentPane();
		
		scanner = new Scanner(new File("c:/users/Christopher/Desktop/input.in"));
		out = new PrintWriter(new FileWriter("c:/users/Christopher/Desktop/output.out")); 
		outDebug = new PrintWriter(new FileWriter("c:/users/Christopher/Desktop/debug.out")); 
		
		numberOfLines = Integer.parseInt(scanner.nextLine());
		
		A = new int[numberOfLines];
		B = new int[numberOfLines];
		numberOfSolutions = new int[numberOfLines];
		
		
		
		input = new JTextArea(100, numberOfLines);
		input.setSize(300,200);
		input.setLocation (10, 10);
		
		output = new JTextArea(120, numberOfLines);
		output.setSize(300,200);
		output.setLocation(410, 10);
		
		pane.setLayout(null);
		pane.add(input);
		pane.add(output);
		
		
		
		for (int i = 0; i < numberOfLines; i++)
		{
			A[i] = scanner.nextInt();
			B[i] = scanner.nextInt();
			
			numberOfSolutions[i] = findSolutions(i);
			
			input.append(A[i] + " " + B[i] + "\n");
			output.append("Case #" + (i + 1) + ": " + numberOfSolutions[i] + "\n");
			out.println("Case #" + (i + 1) + ": " + numberOfSolutions[i]);
		}
		
		
		
		
		
		scanner.close();
		out.close();
		outDebug.close();
		
		setVisible(true);
		setSize(WIDTH, HEIGHT);
		setTitle("Recycling");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
	}
	
	public static void main(String args[]) throws IOException
	{
		Recycling awesome = new Recycling();
	}
	
	
	
	int findSolutions(int whichLine)
	{
		int difference = B[whichLine] - A[whichLine] + 1;
		permutations = new String[difference][];
		int workingOnIt;
		
		int numberOfDigits;
		int whichEntry;
		
		for (int i = A[whichLine]; i < B[whichLine] + 1; i++)
		{
			whichEntry = i - A[whichLine];
			numberOfDigits = (int)Math.floor(Math.log10((double)i)) + 1;
			permutations[i - (A[whichLine])] = new String[numberOfDigits];
			
			for (int j = 0; j < numberOfDigits; j++)
			{
				
				permutations[whichEntry][j] = rotator(Integer.toString(i), j);
				
				workingOnIt = Integer.parseInt(permutations[whichEntry][j]);
				
				if (workingOnIt > i && workingOnIt <= B[whichLine] && permutations[whichEntry][j].charAt(0) != '0' && (i != lastI || workingOnIt != lastWorkingOnIt))
				{
					numberOfSolutions[whichLine]++;
					lastI = i;
					lastWorkingOnIt = workingOnIt;
				}
			}
		}
		
		return numberOfSolutions[whichLine];
	}
	
	
	
	
	String rotator(String original, int numberOfTimes)
	{
		char[] originalChar = original.toCharArray();
		
		char temp; 
		
		for (int i = 0; i < numberOfTimes; i++)
		{
			temp = originalChar[0];
			
			for (int j = 1; j < originalChar.length; j++)
			{
				originalChar[j - 1] = originalChar[j];
			}
			
			originalChar[originalChar.length - 1] = temp;
		}
		
		String rotatedString = new String(originalChar);
		
		return rotatedString;
	}
}
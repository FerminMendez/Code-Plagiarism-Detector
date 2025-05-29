import java.io.BufferedReader;
import java.util.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class program {
	public static void main(String args[])
	{
File inFile = new File("C-small-attempt0.in");


		try {
			Scanner scanner = new Scanner(inFile);
			int tmp = 0;
			int i = 1;
			tmp = scanner.nextInt();
			while(i <= tmp)
			{



				System.out.print("\nCase #" + i + ": " + Danc3.solveC(scanner.nextInt(), scanner.nextInt()));
				i++;
			}


		} catch (IOException e) {
			System.out.println("Exception Caught: " + e);
		}

	}



}
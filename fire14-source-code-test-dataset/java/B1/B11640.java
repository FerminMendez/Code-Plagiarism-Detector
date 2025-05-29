package codejam;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Recycled {

	public static void main(String[] args) throws IOException 
	{
		Scanner scan = new Scanner(new File("Recycled.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Recycled.out")));

		int N = Integer.valueOf(scan.nextLine());
		int id =1;
		while(scan.hasNextLine())
		{
			String letters = scan.nextLine();
			String[] letter = letters.split(" ");
			int A =  Integer.valueOf(letter[0]);
			int B =  Integer.valueOf(letter[1]);
			
			int result = RecycledAlgorithm(A, B);
			
			out.println("Case #" + id + ": " + result);
			id++;
		}
		out.close();
	}
	
	public static int RecycledAlgorithm(int A,int B)
	{
		int num = 0;
		for(int n=A; n<=B ;n++)
		{
			for(int m=n+1;m<=B;m++)
			{
				String allLetters = String.valueOf(n) + String.valueOf(n);
				String findLetters = String.valueOf(m);
				
				if(allLetters.contains(findLetters))
					num ++;
					
			}
		}
		return num;
	}

}

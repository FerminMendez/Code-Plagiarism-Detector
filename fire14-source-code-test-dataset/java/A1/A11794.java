/*
Sam1rm
Google Code Jam
*/
import java.io.*;
import java.util.*;

class ProblemB
{
    public static void main (String [] args) throws IOException 
    {
	String filename = args[0];  
	BufferedReader f = new BufferedReader(new FileReader(filename + ".in"));
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(filename + ".out")));
	int numberOfTests = Integer.parseInt(f.readLine());
	for(int n = 1; n <= numberOfTests; n++)
	    {
		int solution = 0;
		String input = f.readLine();
		solution = parseString(input);
		out.println("Case #" + n + ": " + solution);
	    }
	out.close();
	System.exit(0);
    }
    
    public static int parseString(String input1) {
	int solution = 0;
	String[] input = input1.split(" ");
	int N = Integer.parseInt(input[0]);
	int S = Integer.parseInt(input[1]);
	int P = Integer.parseInt(input[2]);
	for (int i = 0; i < input.length - 3; i++) {
	    int current = Integer.parseInt(input[i + 3]);
	    if (current >= (P * 3 - 2)) {
		solution++;
	    } else {
		if ((S > 0) && current >= (P * 3 - 4) && (P * 3 - 4 > 0)) {
		    S--;
		    solution++;
		}
	    }
	}
	return solution;
    }
}



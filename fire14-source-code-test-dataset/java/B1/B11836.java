/*
Sam1rm
Google Code Jam
*/
import java.io.*;
import java.util.*;

class ProblemC
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
		set = new HashSet<String>();
		out.println("Case #" + n + ": " + solution);
	    }
	out.close();
	System.exit(0);
    }
    
    public static int parseString(String input1) {
	String[] inputs = input1.split(" ");
	int solution = 0;
	int size = inputs[0].length();
	if (size == 0) {
	    return 0;
	}
	int A = Integer.parseInt(inputs[0]);
	int B = Integer.parseInt(inputs[1]);
	System.out.println("I'm processing between the range" + " A: " + A + " B: " + B);
	for (int i = A; i <= B; i++) {
	    solution += isRecycled(i + "", B + "", size);
	}
	return solution;
    }

    public static int isRecycled(String a, String b, int size) {
	int solution = 0;
	if (a.equals(b)) {
	    return 0;
	}
	String temp = a;
	for (int i = 0; i < size - 1; i++) {
	    temp = rotate1(temp);
	    int _a = Integer.parseInt(a);
	    int _b = Integer.parseInt(b);
	    int m = Integer.parseInt(temp);
	    if (m > _a && m <= _b && !(m == _a) && !set.contains(_a + " " + m)) {
		System.out.println(a + " " + m);
		solution++;
		set.add(_a + " " + m);
	    }
	}
	return solution;
    }

    public static String rotate1(String input) {
	return input.substring(1, input.length()) + input.substring(0, 1);
    }
    
    
    public static HashSet<String> set = new HashSet<String>();
}



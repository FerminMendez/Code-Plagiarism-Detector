
import java.io.BufferedReader;
import java.io.FileReader;

import java.io.BufferedWriter;
import java.io.FileWriter;

import java.io.IOException;

import java.util.HashMap;
import java.util.Vector;

public class Task3
{
    public static void main(String[] args)
    {	
	try
	    {
		readSolveAndWrite("C-small-attempt1.in", "output_file.txt");
	    }
	catch(IOException ioException) { System.err.println(ioException); }	
    }

    protected static void readSolveAndWrite(final String inputPath, final String outputFile) throws IOException
    {
	BufferedReader in = new BufferedReader(new FileReader(inputPath));
	BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));
	int n = Integer.parseInt(in.readLine());
	for(int i = 0; i < n; i++)
	    {
		final String inputLine = in.readLine();
	        final String outputLine = "Case #" + (i + 1) + ": " + solve(inputLine);

	        out.write(outputLine);
	        out.newLine();
	    }

        out.flush();
        out.close();
        in.close();
    }

    protected static int convertToInt(Vector<Integer> digits)
    {
	int result = 0;
	for(int i = digits.size() - 1; i >= 0; i--)
	    result = result*10 + digits.elementAt(i).intValue();
	 
	return result;
    }

    protected static Vector<Vector<Integer>> getPermutations(final int n)
    {
	Vector<Integer> base = new Vector<Integer>();
	int m = n;
	while(true)
	    {
		int digit = m % 10;

		base.add(new Integer(digit));
		m = m / 10;
		if(m == 0)
		    break;
	    }

	Vector<Vector<Integer>> permutations = new Vector<Vector<Integer>>();
	for(int i = 0; i < base.size(); i++)
	    {
		Vector<Integer> temp = new Vector<Integer>();
		for(int j = i; j < base.size(); j++)
		    temp.add(base.elementAt(j));
		    
		for(int j = 0; j < i; j++)
		    temp.add(base.elementAt(j));
 
		permutations.add(temp);
	    }
	return permutations;
    }

    protected static String solve(final String line)
    {
	HashMap<String, Integer> map = new HashMap<String, Integer>();

	String[] elements = line.split(" ");
	final int min = Integer.parseInt(elements[0]);
	final int max = Integer.parseInt(elements[1]);

	int result = 0;
	for(int i = min; i <= max; i++)
	    {
		Vector<Vector<Integer>> permutations = getPermutations(i);
		int current = convertToInt(permutations.elementAt(0));	
		for(int j = 1; j < permutations.size(); j++)
		    {
			int temp = convertToInt(permutations.elementAt(j));
			if(current < temp && min <= temp && temp <= max && null == map.get(new String(current + "" + temp)))
			    {
				result++;
				map.put(new String(current + "" + temp), new Integer(1));
				map.put(new String(temp + "" + current), new Integer(1));
			    }
		    }
  		    
	    }

	return "" + result;
    }

}
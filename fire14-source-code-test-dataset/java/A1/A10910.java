
import java.io.BufferedReader;
import java.io.FileReader;

import java.io.BufferedWriter;
import java.io.FileWriter;

import java.io.IOException;

public class Task2
{
    public static void main(String[] args)
    {
	try
	    {
		readSolveAndWrite("B-small-attempt4.in", "output_file.txt");
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

    protected static String solve(final String line)
    {
	String[] elements = line.split(" ");

	final int n = Integer.parseInt(elements[0]);
	int s = Integer.parseInt(elements[1]);
	final int p = Integer.parseInt(elements[2]);
	int array[] = new int[n];
	
	for(int i = 0; i < n; i++)
	    array[i] = Integer.parseInt(elements[3 + i]);

	int result = 0;
	for(int i = 0; i < n; i++)
	    {
		final int temp = array[i];

		if(temp < p)
		    continue;

		int a = temp / 3;
		int b = temp % 3;

		if(b == 0)
		    {
			if(a >= p)
			    result++;
			else if((s > 0) && (a + 1 >= p) && (a - 1 >= 0))
			    {
				s--;
				result++;
			    }
		    }
		else if(b == 1)
		    {
			if((a >= p) || (a + 1 >= p))
			    result++;
		    }
		else if(b == 2)
		    {
			if((a >= p) || (a + 1 >= p))
			    result++;
			else if((s > 0) && (a + 2 >= p))
			    {
				s--;
				result++;
			    }
		    }
	    }

	return ("" + result);
    }

}
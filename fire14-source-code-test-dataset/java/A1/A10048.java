import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * template class for code jam Contest
 * 
 * @author Tudor
 * 
 */

public class Main
{
    public static final String INPUT_FILE = "src/in.txt";
    public static final String OUTPUT_FILE = "out.txt";
    java.io.BufferedWriter br;

    /*
     * the number of tests
     */
    int tests;
    /*
     * the size of the test
     */
    int n;
    int s;
    int p;
    /*
     * the array
     */
    int[] notes;

    public static void main(String args[])
    {
	Main classMain = new Main();
	try
	{
	    Scanner scanner = new Scanner(new File(Main.INPUT_FILE));
	    classMain.br = new java.io.BufferedWriter(new FileWriter(Main.OUTPUT_FILE));
	    classMain.setData(scanner);

	} catch (FileNotFoundException e)
	{
	    e.printStackTrace();
	} catch (IOException e)
	{
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
    }

    /**
     * method to set the initial data and run the tests
     * @param br the reader obtained from file
     */
    
    public void setData(Scanner scanner)
    {
	try
	{
	    tests = scanner.nextInt();
	    // System.out.println("Tests " + tests);
	    for (int i = 0; i < tests; i++)
	    {
		n = scanner.nextInt();
		s = scanner.nextInt();
		p = scanner.nextInt();
		notes = new int[n];
		for (int j=0; j<n; j++)
		{
		    notes[j] = scanner.nextInt();
		}
		    
		solve(i + 1);
	    }
	    br.close();

	} catch (Exception e)
	{
	    e.printStackTrace();
	}
    }

    /**
     * method to solve the problem
     * @param testNr the index of the test
     */
    
    public void solve(int testNr)
    {
	int result = 0;
	try
	{
	    for (int i=0; i<n; i++)
	    {
		if (notes[i] >= (3 * p - 2))
		    result++;
		else
		    if (notes[i] >= (3 * p - 4))
			if (s > 0 && notes[i] > 0)
			{
			    result++;
			    s--;
			}
	    }
	    
	    
	    br.write("Case #" + testNr + ": " + result + "\n");
	} catch (IOException e)
	{
	    e.printStackTrace();
	}

    }
}

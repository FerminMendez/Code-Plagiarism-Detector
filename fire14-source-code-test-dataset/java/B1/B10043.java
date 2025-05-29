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
    int a, b;
    /*
     * the array
     */
    int[] tree;

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
		a = scanner.nextInt();
		b = scanner.nextInt();
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
	int digits = getDigits(a);
	
	for (int i=a; i<=b; i++)
	{
	    int number = i;
	    for (int d=0; d<digits-1; d++)
	    {
		number = number / 10 + (number % 10) * ((int)Math.pow(10, digits-1));
		if ((number != i) && (a <= number && number <= b))
		{
		    System.out.println(i + "    " + number);
		    result++;
		}
	    }
	}
	
	try
	{
	    
	    br.write("Case #" + testNr + ": " + (result / 2) + "\n");
	} catch (IOException e)
	{
	    e.printStackTrace();
	}

    }
    
    int getDigits(int x)
    {
	int digits = 0;
	while (x != 0)
	{
	    x = x / 10;
	    digits++;
	}
	
	return digits;
    }
}


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Charles
 */
public class RecycledNumbers
{

    static final String FILE_NAME = "C";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        ArrayList<String> values = readFile(FILE_NAME + ".in");
        int count = 1;

        PrintWriter outFile = new PrintWriter(new File(FILE_NAME + ".out"));
        for (String line : values)
        {
            String output = processAlgorithm(line, count++);
            System.out.println(output);
            outFile.println(output);
        }
        outFile.close();
    }

    /**
     * Reads the CodeJam files and returns the input as a List of String.
     *
     * @param fileName The name of the file to be read
     * @return the list containing the contents of the file.
     */
    public static ArrayList<String> readFile(String fileName)
    {
        ArrayList<String> results = new ArrayList<String>();
        try
        {
            Scanner inFile = new Scanner(new File(fileName));
            int numberOfLines = Integer.parseInt(inFile.nextLine());
            while (inFile.hasNextLine())
            {
                results.add(inFile.nextLine());
            }

            if (numberOfLines != results.size())
            {
                System.err.println("File size does not match...");
                System.exit(0);
            }

        } catch (FileNotFoundException ex)
        {
            System.err.println("File not found...");
            System.exit(0);
        }
        return results;
    }

    private static String processAlgorithm(String line, int caseNumber)
    {
        StringBuilder result = new StringBuilder("Case #" + caseNumber + ": ");

        Scanner scan = new Scanner(line);

        int low = scan.nextInt();
        int high = scan.nextInt();

        int count = 0;

        for (int current = low; current < high; current++)
        {
            String temp = String.valueOf(current);
            TreeSet<String> temps = new TreeSet<String>();
            for (int index = 0; index < temp.length(); index++)
            {
                temps.add(temp.substring(temp.length() - index)
                        + temp.substring(0, temp.length() - index));
            }

            for (int test = current + 1; test <= high; test++)
            {
                String testString = String.valueOf(test);
                if(temps.contains(testString))
                {
                    count++;
                }
            }
        }

        result.append(count);
        return result.toString();
    }
}

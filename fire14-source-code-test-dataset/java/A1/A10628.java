
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Charles
 */
public class DancingWithGooglers
{

    static final String FILE_NAME = "B";

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

        int numberOfDancers = scan.nextInt();
        int numberOfSuprises = scan.nextInt();
        int highestScore = scan.nextInt();

        int usedSuprises = 0;
        int count = 0;

        Dancer current;
        for (int index = 0; index < numberOfDancers; index++)
        {
            current = new Dancer(scan.nextInt());
            if (current.highScoreWithOutSuprise >= highestScore)
            {
                count++;
            }
            else if (current.highScoreWithSuprise >= highestScore
                    && usedSuprises < numberOfSuprises)
            {
                usedSuprises++;
                count++;
            }
        }
        
        result.append(count);
        return result.toString();
    }
}

class Dancer
{

    int highScoreWithSuprise;
    int highScoreWithOutSuprise;

    public Dancer(int score)
    {
        highScoreWithOutSuprise = highScoreWithSuprise = score / 3;
        int mod = score % 3;
        if (score > 0)
        {
            switch (mod)
            {
                case 0:
                    highScoreWithSuprise += 1;
                    break;
                case 1:
                    highScoreWithOutSuprise += 1;
                    highScoreWithSuprise += 1;
                    break;
                case 2:
                    highScoreWithOutSuprise += 1;
                    highScoreWithSuprise += 2;
                    break;
            }
        }
    }
}

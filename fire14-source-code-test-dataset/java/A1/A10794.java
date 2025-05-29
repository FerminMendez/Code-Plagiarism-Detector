package dancing_with_googlers;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.*;

public class ReadWriteTextFile {

    public static ArrayList<String> doReadTextFile(String filename) {
    	String inLine = null;
        ArrayList<String> inLines = new ArrayList<String>();
        try {

            // Create FileReader Object
            FileReader inputFileReader   = new FileReader(filename);

            // Create Buffered/PrintWriter Objects
            BufferedReader inputStream   = new BufferedReader(inputFileReader);
            
            
            while ((inLine = inputStream.readLine()) != null) {
                inLines.add(inLine);
            }
            inputStream.close();
        } catch (IOException e) {
            System.out.println("IOException:");
            e.printStackTrace();
        }
        
        return inLines;
    }
    
    public static void doWriteTextFile(ArrayList<String> result) {
        try {
            // output file names
            String outputFileName = "B-small.out";

            // Create FileReader Object
            FileWriter outputFileReader  = new FileWriter(outputFileName);

            // Create Buffered/PrintWriter Objects
            PrintWriter    outputStream  = new PrintWriter(outputFileReader);

            int i = 1;
            for (String s: result) {
            	outputStream.print("Case #" + i + ": ");
            	if (i<result.size())
            		outputStream.println(s);
            	else
            		outputStream.print(s);
            	i++;
            }
            
            
            
            outputStream.close();
        } catch (IOException e) {
            System.out.println("IOException:");
            e.printStackTrace();
        }
    }
}
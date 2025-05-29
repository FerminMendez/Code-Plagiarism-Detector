/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 *
 * @author Vale
 */
public class RecycledNumbers {
    
    public static void main(String[] args){
        String inputFile="/Users/Vale/Desktop/CodeJam/C-small-attempt1.in";
        String outputFile="/Users/Vale/Desktop/CodeJam/C-small-output1.txt";
        
        String[] lines=readAllLinesOfFile(inputFile);
        int numberOfCases=Integer.parseInt(lines[0]);
        String[] result=new String[numberOfCases];
        
        for (int i = 1; i <= numberOfCases; i++) {
            String currentLine=lines[i];
            int lowerValue=Integer.parseInt(currentLine.substring(0, currentLine.indexOf(" ")));
            int start=currentLine.indexOf(" ")+1;
            int upperValue=Integer.parseInt(currentLine.substring(start));
            int resultValue=0;
            for (int j = lowerValue; j < upperValue; j++) {
                for (int k = j+1; k < upperValue+1; k++) {
                    if(isRecycledPair(j, k))
                        resultValue++;
                }
            }
            result[i-1]="Case #"+i+": "+resultValue;
        }
        writeLinesToFile(outputFile, result);
    }
    
    public static int powerOf(int n, int i){
        if(i==1)
            return n;
        else
            return n*powerOf(n, i-1);
    }
    
    public static int digitsOf(int n){
        int result=0;
        while(n>0){
            result++;
            n/=10;
        }
        return result;
    }
    
    public static boolean isRecycledPair(int n, int m){
        int numberOfDigits=digitsOf(n);
        for (int digits = 1; digits < numberOfDigits; digits++) {
            int recycledPart=(n%powerOf(10, digits));
            int recycleValue=recycledPart*(powerOf(10, numberOfDigits-digits));
            int recycledNumber=(n/powerOf(10, digits))+recycleValue;
            if (recycledNumber==m)
                return true;
        }
        return false;
    }
    
    public static String[] readAllLinesOfFile(String file){
        try{
          // Open the file that is the first 
          // command line parameter
          FileInputStream fstream = new FileInputStream(file);
          // Get the object of DataInputStream
          DataInputStream in = new DataInputStream(fstream);
          BufferedReader br = new BufferedReader(new InputStreamReader(in));
          String strLine;
          //Read File Line By Line
          String[] result=new String[1000000];
          int index=0;
          while ((strLine = br.readLine()) != null)   {
              result[index++]=strLine;
          }
          //Close the input stream
          in.close();
          String[] newResult=java.util.Arrays.copyOf(result, index);
          return newResult;
        }catch (Exception e){//Catch exception if any
          System.err.println("Error: " + e.getMessage());
          return new String[] {};
        }
    }
    
    public static void writeLinesToFile(String filename, String[] linesToWrite) {
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(filename));
            for (int i = 0; i < linesToWrite.length; i++) {
                pw.println(linesToWrite[i]);
            }
            pw.flush();
            pw.close();
        } catch (Exception e) {
            throw new RuntimeException("Writing File \"" + filename + "\" Failed!");
        }
    }
}

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
public class DancingWithGooglers {
    
    
    public static void main(String[] args){
        String inputFile="/Users/Vale/Desktop/CodeJam/B-small-attempt4.in";
        String outputFile="/Users/Vale/Desktop/CodeJam/B-small-output4.txt";
        
        String[] lines=readAllLinesOfFile(inputFile);
        int numberOfCases=Integer.parseInt(lines[0]);
        String[] result=new String[numberOfCases];
        
        for (int i = 1; i <= numberOfCases; i++) {
            String currentLine=lines[i];
            int numberOfGooglers=Integer.parseInt(currentLine.substring(0, currentLine.indexOf(" ")));
            int start=currentLine.indexOf(" ")+1;
            int surprisingTriplets=Integer.parseInt(currentLine.substring(start, currentLine.indexOf(" ", start)));
            start=currentLine.indexOf(" ", start)+1;
            int valueOfP=Integer.parseInt(currentLine.substring(start, currentLine.indexOf(" ", start)));
            start=currentLine.indexOf(" ", start)+1;
            String totalPointsString=currentLine.substring(start);
            int[] totalPoints=getIntArrayFromSpaceSeperatedString(totalPointsString, numberOfGooglers);
            java.util.Arrays.sort(totalPoints);
            int resultValue=0;
            for (int j = totalPoints.length-1; j >=0 ; j--){
                if(valueOfP==1){
                    if(totalPoints[j]>0){
                        resultValue++;
                    }
                } else if(totalPoints[j]>3*valueOfP-3){
                    resultValue++;
                } else if(totalPoints[j]>3*valueOfP-5 && surprisingTriplets>0){
                    resultValue++;
                    surprisingTriplets--;
                }
            }
            result[i-1]="Case #"+i+": "+resultValue;
        }
        writeLinesToFile(outputFile, result);
    }
    
        public static String[] readAllLinesOfFile(String file) {
        try {
            // Open the file that is the first 
            // command line parameter
            FileInputStream fstream = new FileInputStream(file);
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Read File Line By Line
            String[] result = new String[1000000];
            int index = 0;
            while ((strLine = br.readLine()) != null) {
                result[index++] = strLine;
            }
            //Close the input stream
            in.close();
            String[] newResult = java.util.Arrays.copyOf(result, index);
            return newResult;
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
            return new String[]{};
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
    
    public static int[] getIntArrayFromSpaceSeperatedString(String numbers, int numberOfInts){
        numbers=numbers.trim();
        int[] result= new int[numberOfInts];
        int start=0;
        int end=numbers.indexOf(" ");
        for(int i=0; i<numberOfInts; i++){
            if(end!=-1){
                result[i]=Integer.parseInt(numbers.substring(start, end));
                start=end+1;
                end=numbers.indexOf(" ", start);
            } else{
                result[i]=Integer.parseInt(numbers.substring(start));
            }
        }
        return result;
    }

}

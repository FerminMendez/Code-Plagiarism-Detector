/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package recyclednumbers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;

/**
 *
 * @author Madhav
 */



public class RecycledNumbers {

    /**
     * @param args the command line arguments
     */
    
    public static HashSet<String> set;
    public static void main(String[] args) throws Exception {
        FileIO fileHandler = new FileIO();
        int totalTestCases = Integer.parseInt(fileHandler.readLine());

        for (int tc = 0; tc < totalTestCases; tc++) {
            set  = new HashSet<String>();
            String input = fileHandler.readLine();
            String nm[] = input.split(" ");
            int start = Integer.valueOf(nm[0]);
            int end = Integer.valueOf(nm[1]);
            for(int i=start; i<=end; i++){
                 String currVal = String.valueOf(i);
                 countPairs(currVal, start, end, nm);
            }
           
            fileHandler.writeLine(String.valueOf(set.size()));
        }
        fileHandler.closeFileIO();
    }
    
    public static void countPairs(String input, int start, int end, String[] nm){
        String clonedValue = new String(input);
        if(nm[1].length() <= 1)
            return;
        else{
            int length = input.length();
            for(int i=0; i<length;i++){
                String rotated = rotate(input);
                int calValue = Integer.valueOf(rotated);
                if(   rotated.charAt(0) != '0' && 
                        calValue <= end && 
                        calValue >= start && 
                        !rotated.equals(clonedValue)
                        ){
                    if(Integer.valueOf(clonedValue) < Integer.valueOf(rotated))
                       set.add(clonedValue+"-"+rotated);
                    else
                       set.add(rotated+"-"+clonedValue);
                }
                   
                input = rotated;
            }
        }
    }
    
    public static String rotate(String input){
        return input.substring(1) + input.charAt(0);
    }
    
    
}


/*
 * File IO is used to read and Write - Keep it simple.
 */
class FileIO {

    private FileReader inFileReader;
    private FileWriter outFileWriter;
    private BufferedReader br = null;
    private BufferedWriter bw = null;
    private int lineNumber = 1;

    public FileIO() throws Exception {
        inFileReader = new FileReader("C:\\CodeJam2012\\in.txt");
        br = new BufferedReader(inFileReader);

        outFileWriter = new FileWriter("C:\\CodeJam2012\\out.txt");
        bw = new BufferedWriter(outFileWriter);
    }

    public FileIO(String in, String out) throws Exception {
        inFileReader = new FileReader(in);
        br = new BufferedReader(inFileReader);

        outFileWriter = new FileWriter(out);
        bw = new BufferedWriter(outFileWriter);
    }

    /*
     * This procedure returns null if all the rows are read from input file.
     */
    public String readLine() throws Exception {
        return br.readLine();
    }

    /*
     * This procedure writes a line to output file as per the google codejam
     * standard
     */
    public void writeLine(String line) throws Exception {
        bw.write("Case #" + lineNumber + ": " + line + "\r\n");
        lineNumber++;
    }

    public void closeFileIO() throws Exception {
        br.close();
        bw.flush();
        bw.close();
    }
}
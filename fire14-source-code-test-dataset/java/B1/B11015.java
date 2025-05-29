/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author AlexR
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintResult {
    
    FileOutputStream fout;
    PrintStream fstream;
    
    public PrintResult(String filename) throws IOException
    {
            fout = new FileOutputStream(filename);
            fstream = new PrintStream(fout);
    }
    
    public void printLine(int caseNum, String line)
    {
        fstream.println("Case #" + (caseNum+1) + ": " + line);
    }
    
    public void close() throws IOException
    {
        fout.close();
    }
}

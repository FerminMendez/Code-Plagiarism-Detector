/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
    
/**
 * 
 * @author dannocz
 */
public class InputReader {
    
    public static Input readFile(String filename){
        try {
              
              /*  Sets up a file reader to read the file passed on the command
          77        line one character at a time */
              FileReader input = new FileReader(filename);
              
              /* Filter FileReader through a Buffered read to read a line at a
                 time */
              BufferedReader bufRead = new BufferedReader(input);
              
              String line;    // String that holds current file line
              int count = 0;  // Line number of count 
              ArrayList<String> cases= new ArrayList<String>();
              
              // Read first line
              line = bufRead.readLine();
              int noTestCases=Integer.parseInt(line);
              count++;
              
              // Read through file one line at time. Print line # and line
              while (count<=noTestCases){
                  //System.out.println("Reading. "+count+": "+line);
                  line = bufRead.readLine();
                  cases.add(line);
                  count++;
              }
              
              bufRead.close();
              
              return new Input(noTestCases,cases);
              
          }catch (ArrayIndexOutOfBoundsException e){
              /* If no file was passed on the command line, this expception is
              generated. A message indicating how to the class should be
              called is displayed */
              e.printStackTrace();        
  
          }catch (IOException e){
              // If another exception is generated, print a stack trace
              e.printStackTrace();
          }
        
        return null;
          
      }// end main
    }

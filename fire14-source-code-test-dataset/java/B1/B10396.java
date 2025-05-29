/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package rotatematrix;
import java.io.*;
/**
 *
 * @author FARHAN
 */
public class Main {

    /**
     * @param args the command line arguments
     */


    public static void main(String[] args) throws FileNotFoundException, IOException{
        // TODO code application logic here
      FileInputStream fstream = new FileInputStream("D:/test.in");
  // Get the object of DataInputStream
  DataInputStream in = new DataInputStream(fstream);
  BufferedReader br = new BufferedReader(new InputStreamReader(in));
  String strLine;
  //Read File Line By Line
 Combination c = new Combination();
 
  while ((strLine = br.readLine()) != null)   {
  // Print the content on the console
       int testCaseCount = Integer.parseInt(strLine);

       for(int i=0;i<testCaseCount;i++){
       strLine = br.readLine();
     String [] strArray = strLine.split(" ");

      int result= c.Tranverse(Integer.parseInt(strArray[0]), Integer.parseInt(strArray[1]));
           System.out.println("Case #"+(i+1)+": "+result);
      }

  }

 // System.out.println (strLine);
  
  //Close the input stream
  in.close();
   



    }

}

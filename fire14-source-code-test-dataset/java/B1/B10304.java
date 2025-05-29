/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package code_jam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

/**
 *
 * @author Neo
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    int line_counter=0;
      try{
  // Open the file that is the first
  // command line parameter
  FileInputStream fstream = new FileInputStream("textfile.txt");
  DataInputStream in = new DataInputStream(fstream);
  BufferedReader br = new BufferedReader(new InputStreamReader(in));
  FileWriter ostream = new FileWriter("output.txt");
  BufferedWriter out = new BufferedWriter(ostream);

  String strLine;
  //Read File Line By Line
  while ((strLine = br.readLine()) != null)   {
  // Print the content on the console
      if(line_counter==0){  
  } else{
        String delims = "[ ]+";
        String[] tokens = strLine.split(delims);
        int a =Integer.parseInt(tokens[0]);
        int b = Integer.parseInt(tokens[1]);
        if(a<10){

        out.write("\nCase #"+line_counter+": "+0);
        out.newLine();
        
        }
        if(a>9&&a<100){
        int output =0;
        for(int i=a;i<b+1;i++){

            int n = i;
            if(n%10==0){
                continue;
            }else{
                int b0 = n%10;
                int m = (b0*10)+((n-b0)/10);
                if(m>n&&m<b+1){
                output = output+1;
                }
            }
        }
        out.write("Case #"+line_counter+": "+output);
        out.newLine();
        }
       if(a>99&&a<999){

             int output =0;
             for(int i=a;i<b+1;i++){

                 int n = i;
                 if(n%100==0){
                 continue;
           }
           if(n%10==0){
                int b0 = (n/10)%10;
                int m = (b0*100)+((n-(b0*10))/100);
                if(m>n&&m<b+1){
                    output= output+1;
                }
           }
           else{
                int b0 = (n)%100;
                int m = (b0*10)+((n-b0)/100);
                if(m>n&&m<b+1){
                    
                    output= output+1;
                }
                 int c = n%10;
                int m1 = (c*100)+((n-c)/10);
                if(m1>n&&m1<b+1){
                    output= output+1;
                }
           }

       }
 out.write("Case #"+line_counter+": "+output);
 out.newLine();
              }
  }
      line_counter= line_counter+1;
  }
  //Close the input stream
  in.close();
  out.close();
    }catch (Exception e){//Catch exception if any
  System.err.println("Error: " + e.getMessage());
  }
     }

}

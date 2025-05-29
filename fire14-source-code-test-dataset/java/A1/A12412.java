/*
 * Program Name :- B.java
 * Author :- Happy Mittal
 * Created on 14 April, 2012
 *
 * 
 */

package googlecodejam11;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {
    /** Creates a new instance of B */
    public B() {
        try{
            // Open the input file 
            FileInputStream finstream = new FileInputStream("E:\\B-small-attempt0.in");
            // FileInputStream finstream = new FileInputStream("E:\\B-large-attempt0.in");
            //FileInputStream finstream = new FileInputStream("E:\\test-input.in");
            // Get the object of DataInputStream
            DataInputStream in = new DataInputStream(finstream);
                BufferedReader br = new BufferedReader(new InputStreamReader(in));
                
             // Create a output file 
            FileWriter foutstream = new FileWriter("E:\\B-small-output.in");
          //   FileWriter foutstream = new FileWriter("E:\\B-small-output.in");
              //FileWriter foutstream = new FileWriter("E:\\test-output.in");
                BufferedWriter bw = new BufferedWriter(foutstream);
                
            br.readLine(); // read the first line it contains no of cases
            String strLine;
            int caseno = 1;
            //Read File Line By Line
           // strLine = br.readLine();
            while ((strLine = br.readLine()) != null)   {
              // Print the content on the console
             // System.out.println (strLine);
              strLine = strLine.trim();
              int result = NoOFTriplets(strLine); 
              //System.out.println (result);
              String netresult = "Case #" + caseno + ": " + result ;
              bw.write(netresult);
              bw.newLine();
              caseno ++;
            }
            
            
            //Close the input stream
            in.close();
            //Close the output stream
            bw.close();
       
            }catch (Exception e){//Catch exception if any
              System.err.println("Error: " + e.getMessage());
            }
    }
     public static void main(String[] args) {
        // TODO code application logic here
        B b1 = new B();
           }
     public int NoOFTriplets(String str){
            String input[] = str.split(" ");
            int MaxGooglers = 0 ;
            int N = Integer.parseInt(input[0]);
            int S = Integer.parseInt(input[1]);
            int p = Integer.parseInt(input[2]);
           // int value[] = new int[N];
            for(int i=0;i<N;i++)
            {
                int score = Integer.parseInt(input[i+3]);
                if(score <= 1) 
                {
                    if(score >= p) MaxGooglers ++;
                    continue;
                }
                int div = score   / 3 ;
                int rem =  score % 3;
                //System.out.println ("Values  " + div + " --   " + rem);
                if(rem != 0 ) div ++;
                if (div >= p)
                {
                    MaxGooglers ++;
                    // System.out.println ("Hello1");
                }
                else if(S > 0 && rem != 1 && div + 1 >= p )
                {
                    // System.out.println (S + "Hello2");    
                    MaxGooglers ++;
                        S--;
                }
            }
            
           return MaxGooglers;
     }
}

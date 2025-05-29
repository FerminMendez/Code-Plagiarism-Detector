package com.googlejam;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

/**
 *
 * @author Faraz Ahmed Abbasi
 */
public class recycledNumebers {
    static String strLine = null;
    static int result = 0;
    static int start = 0;
    static int end = 0;
    
    private static boolean is_recycle_number(int d, int d1)
        {
            int len =   Integer.toString(d).length() - 1;
            //bool b = false;
            for (int i = String.valueOf(d).length() - 1; i >= 0; i--)
            {
                int r = d%10;
                d /= 10;
                d = (int) (r*( Math.pow(10,len)) + d);
                if (d == d1)
                {
                    return true;
                }
            }
            return false;

        }
      
  
 public static void main(String[] args) {
  
     try {
        
         FileInputStream fstream = new FileInputStream("input.in");
         DataInputStream in = new DataInputStream(fstream);
         BufferedReader br = new BufferedReader(new InputStreamReader(in));
         FileWriter ifstream = new FileWriter("output.txt");
         BufferedWriter out = new BufferedWriter(ifstream);

         int resultCounter = 1;
         int skip_value=0;       
                 
         while ((strLine = br.readLine()) != null) {
             if (skip_value < 1) {
                 skip_value ++;
                 continue;
             }
              result=0;           
             String[] record = new String[2];
             record=strLine.split(" ");
             start=  Integer.parseInt( record[0]);
             end=  Integer.parseInt( record[1]);
             
            // int count = 0;

                    for (int  i = start; i < end; i++)
                    {
                        for (int j = i+1; j <= end; j++)
                        {
                            if (is_recycle_number(i, j)) result++;
                        }
                    }  
             
             String output = "Case #" + resultCounter + ": " + result+"\n" ;
             System.out.println("Case #" + resultCounter + ": " + result);
             try {
                
                 out.write(output);
                

             } catch (Exception e) {
                 System.err.println("Error: " + e.getMessage());
             }
             
             resultCounter++;
         }
         
         in.close();
         out.close();
     } catch (Exception e) {// Catch exception if any
         System.err.println("Error: " + e.getMessage());
     }
     }
    
    
}
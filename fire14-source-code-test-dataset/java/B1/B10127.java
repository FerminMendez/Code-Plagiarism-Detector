/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package googlecodejam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Muhammad Zahran
 */
public class recycleNumber 
{
     public static void main(String[] args) throws IOException 
    {
        PrintWriter w =  new PrintWriter(new FileWriter("out.txt"));
        BufferedReader r = new BufferedReader(new FileReader("input.txt")); 
        int testcases = Integer.parseInt(r.readLine());
        for (int i = 0; i < testcases; i++) 
        {
            int result=0;
            
            String[] tokens = r.readLine().split(" "); 
            String strA = tokens[0];
            int a = Integer.parseInt(tokens[0]);
            int b = Integer.parseInt(tokens[1]);            
            String strB = tokens[1];
            
            int currentNo = a;
            while(true)
            {                      
                if(currentNo > b)
                    break;
                int scratch = currentNo;             
                String strScratch = String.valueOf(currentNo);
                
                for (int d = 1; d < strScratch.length(); d++) 
                {
                     String sub1 = strScratch.substring(strScratch.length()-d,strScratch.length()); //LSD
                     String sub2 = strScratch.substring(0,strScratch.length()-d); //MSD
                     
                    if(!sub1.substring(0, 1).equals("0"))
                    {
                        String strRotated = sub1+sub2;
                        if(!strRotated.equals(strScratch))
                        {
                            int rotated = Integer.parseInt(strRotated);
                            if(rotated <= b && rotated > scratch)
                            {
                              //  w.println(scratch + " : "+rotated);
                               // System.out.println(scratch + " : "+rotated); 
                                result++;
                            }
                        }                    
                    }        
                }
                      
               currentNo++;               
            }
              int asd = i+1;
              w.println("Case #" + asd + ": " + result);
              System.out.println("Case #" + asd + ": " + result);                                  
        }
        
         w.close();
    }
    
}

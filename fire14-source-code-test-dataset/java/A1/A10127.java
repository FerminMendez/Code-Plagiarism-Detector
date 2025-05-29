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
public class GooglersDance 
{
     
     public static void main(String[] args) throws IOException 
    {
        PrintWriter w =  new PrintWriter(new FileWriter("out.txt"));
        BufferedReader r = new BufferedReader(new FileReader("input.txt")); 
        
        String line = r.readLine();   
        int testcases = Integer.parseInt(line);
        for (int t = 0; t < testcases; t++) 
        {
                String[] tokens = r.readLine().split(" ");        
                int googlersCount = Integer.parseInt(tokens[0]);
                int surpCount = Integer.parseInt(tokens[1]);
                int p = Integer.parseInt(tokens[2]);

                int result = 0;

                number[] numberList = new number[googlersCount];        
                int cnt = 0;
                for (int i = 3; i < tokens.length; i++) 
                {                     
                    number n = new number();
                    n.num = Integer.parseInt(tokens[i]);
                    int scratch = n.num;
                    boolean next = true;

                     // NOT 3: 3x+2
                    if(next)
                    {  
                         scratch = n.num;
                         scratch -= 2;                
                         if(scratch%3==0)
                         {
                             int x = (scratch/3)+1;
                             int smallx = (scratch/3);
                             if(x>=p && x<=30 && smallx>=0)
                             {
                                  n.notSurp = true;
                                  next = false;
                             }
                         }

                    }
                     // NOT 2: 3x+1
                    if(next)
                    {  
                         scratch = n.num;
                         scratch -= 1;                
                         if(scratch%3==0)
                         {
                             int x = (scratch/3)+1;
                              int smallx = (scratch/3);
                            if(x>=p && x<=30 && smallx>=0)
                             {
                                  n.notSurp = true;
                                  next = false;
                             }
                         }
                    }            
                    //NOT 1: 3x
                    if(next)
                    {                
                         scratch = n.num;                              
                         if(scratch%3==0)
                         {
                             int x = (scratch/3);
                              int smallx = (scratch/3);
                             if(x>=p && x<=30 && smallx>=0)
                             {
                                  n.notSurp = true;                         
                             }
                         }               
                    }
                    next = true;                                  
                /////////////////////////////                 
                    // SURP 3: 3x+4
                    if(next)
                    {
                         scratch = n.num;
                         scratch -= 4;                
                         if(scratch%3==0)
                         {
                             int x = (scratch/3)+2;
                              int smallx = (scratch/3);
                             if(x>=p && x<=30 && smallx>=0)
                             {
                                  n.surp = true;
                                  next = false;
                             }
                         }
                    }
                     // SURP 2: 3x+3
                    if(next)
                    {
                         scratch = n.num;
                         scratch -= 3;                
                         if(scratch%3==0)
                         {
                             int x = (scratch/3)+2;
                              int smallx = (scratch/3);
                            if(x>=p && x<=30 && smallx>=0)
                             {
                                  n.surp = true;
                                  next = false;
                             }
                         }
                    }

                    // SURP 1: 3x+2
                    if(next)
                    {
                         scratch = n.num;
                         scratch -= 2;                
                         if(scratch%3==0)
                         {
                             int x = (scratch/3)+2;
                              int smallx = (scratch/3);
                             if(x>=p && x<=30 && smallx>=0)
                             {
                                  n.surp = true;
                                  next = false;
                             }
                         }
                    }  

                    numberList[cnt] = n;
                    cnt++;
                } 

                int dummyS = surpCount;
                for (int i = 0; i <numberList.length ; i++) 
                {
                    if(numberList[i].notSurp==false && numberList[i].surp==false)
                    {

                    }
                    else if(numberList[i].notSurp==false && numberList[i].surp==true && dummyS>0)
                    {
                        dummyS--;
                        result++;
                    }
                    else if(numberList[i].notSurp==true && numberList[i].surp==false)
                    {
                        result++;
                    }
                    else if(numberList[i].notSurp==true && numberList[i].surp==true)
                    {
                        result++;
                    }
                }
                int asd = t+1;
                w.println("Case #" + asd + ": " + result);
        }
        
        w.close();
        
    }
       
    
}

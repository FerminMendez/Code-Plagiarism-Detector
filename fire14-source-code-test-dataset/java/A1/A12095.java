/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cjam;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Administrator
 */
public class Cjam {

    /**
     * @param args the command line arguments
     */

    public  BufferedWriter output;
    public Scanner input;
    public int T;
    
    
    
     public Cjam()
        {
            
            
               try {
                            input = new Scanner(new FileReader("B-small-attempt0.in")); 
                           output = new BufferedWriter(new FileWriter(new File("b.out")));
                     } 
               catch (IOException ex) {
                          Logger.getLogger(Cjam.class.getName()).log(Level.SEVERE, null, ex);
                      }
                      
               T = input.nextInt();       
               
        }
    
    
    
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
       
        Cjam c = new Cjam();
        
        
       for(int i = 1; i <= c.T ; i++)
       {
           int N,S,p,ti[],b1,b2;
           int max1=0,max2=0,max3=0,max=0;
           
           N = c.input.nextInt();
           S = c.input.nextInt();
           p = c.input.nextInt();
           ti = new int[N];
           
           for(int j=0 ; j < N ; j++)
           {
               ti[j] = c.input.nextInt();
           }
           
           if(p > 1)
           {
                   b1 = 3*(p-1) - 1;
                   b2 = 3*(p-1) ;
                   
                   for(int k = 0 ; k < N ; k++ )
                   {
                       if( ti[k] > b2 )
                       {
                           max1++;
                       }
                               
                       else if( (ti[k]==b1) || (ti[k]==b2) )
                       {
                           max2++;
                       }
                       
                   }
                   
                   
                   
              if( max2 > S )
              {
                  max = max1 + S;
              }
              else
              {
                  max = max1 + max2;
              }
           
              
              
           }
           else if(p==1)
           {
               for(int k = 0 ; k < N ; k++ )
                   {
                      if(ti[k] >= 1)
                      {
                          max1++;
                      }
                      
                      max= max1;
                      
                   }
           }
           else if(p==0)
           {
               max = N;
           }
           
           
           
           
           
            try {
                c.output.append("Case #"+i+": "+max);
                
                
                if(i != c.T)  c.output.newLine();
            } catch (IOException ex) {
                Logger.getLogger(Cjam.class.getName()).log(Level.SEVERE, null, ex);
            }
           
           
 
       
       
       }
        try {
            c.output.close();
        } catch (IOException ex) {
            Logger.getLogger(Cjam.class.getName()).log(Level.SEVERE, null, ex);
        }
     c.input.close();
       
       
    }
}

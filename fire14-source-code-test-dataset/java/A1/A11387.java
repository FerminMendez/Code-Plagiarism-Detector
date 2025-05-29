/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import javax.print.DocFlavor.STRING;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;



/**
 *
 * @author Mansk
 */
public class JavaApplication4 {

    /**
     * @param args the command line arguments
     */
    

    
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        FileInputStream fstream = new FileInputStream("In.txt");
        
      DataInputStream in = new DataInputStream(fstream);
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
    
      
      
      FileOutputStream fos = new FileOutputStream("out.txt");
      
      BufferedOutputStream bos =new BufferedOutputStream(fos);
      
     
      
      
      String line;
     
   int num=0;
   int T=0;
   int S=0;
   int P=0;
   
   
   line= br.readLine();
   num= Integer.parseInt(line)  ;
     Scanner s= new Scanner(br);
     
     
        
        for (int i = 0; i <num ; i++) {
            
             String line2 = new String();
             int max=0;
                line=  s.next();
                 T=  Integer.parseInt(line)  ;
                
                line=  s.next();
                 S=  Integer.parseInt(line)  ;
                 
                     line=  s.next();
                 P=  Integer.parseInt(line)  ;
                
                int[] myarr ;
                myarr= new int[101] ;
            
            
             
            for (int j = 0; j < T; j++) {
                
                     line=  s.next();
                 myarr[j] =  Integer.parseInt(line)  ;
                 
                
            }
           
            for (int j = 0; j < T; j++) {
                int sum=myarr[j];
                
                
                
                if(sum>=(3*P))
                {  max ++;
                }
                
                else
                {
                int temp =sum/3;
                
                 int temp2=(sum -temp)/2;
                 
                 int temp1=sum-(temp2+temp);
                        
                 int temp3=temp;
                   if((temp1>=P)|(temp1>=P)|(temp1>=P))
                            
                        {
                        max ++;
                        }
                   
                   else {
                   temp1=P;
                   temp2= sum - (P + (sum-P)/2);
                   temp3= (sum-P)/2;
                   
                   if((((temp1-temp2)==1)&((temp2-temp3)==1))&(S!=0))
                   {
                   S--;                   
                   max++;                                
                   }
                   
                   else if(((temp2==temp3)&((temp1-temp2)==2)&(S!=0)))
                   {
                   S--;
                   max++;
                   }
                   else if((temp2==temp3)&((temp1-temp2)==1))
                   {
                   max++;
                   }
                   
                   
                   }
                
                
                
                }
                
            }
            
            
            
            line2="Case #"+(i+1)+": "+max+"\n"; 
            
             bos.write(line2.getBytes());
              bos.flush();
        }
            
        
    }
    
    
    
    
    
}

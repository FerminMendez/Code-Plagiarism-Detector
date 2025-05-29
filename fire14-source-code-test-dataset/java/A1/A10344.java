/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package b;
 

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author Leo
 */
public class B {

    
   
        
        
   
    public static void main(String[] args) throws FileNotFoundException, IOException {
       
  new B().run();
  }
    
    String inputFile = "txt.in";
     Scanner in;
	
     public void run() throws FileNotFoundException, IOException{
        in = new Scanner(new FileReader(inputFile));
		
        int c = in.nextInt();
        int i =0;
          for(i=1;i<=c;i++)
          {
          
           int N = in.nextInt();
           int S = in.nextInt();
           int P = in.nextInt();
          int[] T = new int[50];
          int best =0;
          int temp = 0;
          int comp1=0;
        int comp2=0;
        
   int comp=0;
   System.out.print(N + " " + S + " " + P );
           for(int j=0;j<N;j++)
           {
          T[j] = in.nextInt() ;
       
         System.out.print(" " + T[j]);
           }
            
            
         for(int v=0;v<N;v++){
             if(((T[v]>=3*P)|| is1part(T[v],P)) && (T[v]>0) ) comp1++;
             else
                 if(is2part(T[v],P) && (T[v]>0) && (comp2<S) &&  (S!=0)) comp2++;  
                
         
         }
         
      
         comp = comp1 + comp2;
         
              System.out.println( " Case #" + i + ": " + comp );
           
           }
          
          }

  public boolean is2part(int x,int p){
      boolean ok = false;
      int m = p-((x-p)/2);
      if(m==2 || m==-2) return true;
     return ok;
 }
  
   public boolean is1part(int x,int p){
      boolean ok = false;
      int m = p-((x-p)/2);
      if(m==1 || m==-1) return true;
     return ok;
 }
    }
     
     
     
    
    





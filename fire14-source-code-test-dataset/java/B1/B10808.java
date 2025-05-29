/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package actual;

import codejam.*;
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author atm
 */
public class PC {
   public static void main(String[] args) throws Exception {
       int Cases;
       int L,U;
       String words[];
       
        FileInputStream fstreamIN = new FileInputStream("F:\\codejam\\input\\C-small-attempt0.in");
        FileOutputStream fstreamOUT = new FileOutputStream("F:\\codejam\\output\\C-small-attempt0.out");
        
        Scanner in=new Scanner(fstreamIN);
        PrintWriter out=new PrintWriter(fstreamOUT);
        
        Cases=in.nextInt();
        
        for(int i=0;i<Cases;i++) // Cases loop
        {
            L=in.nextInt();
            U=in.nextInt();
            int ans=0;
            if(L==1000){
                ans=0;
            }else if(L<10){
                ans=0;
            }else if(L<100){
                
                for(int j=L;j<=U;j++){ 
                    if(revtwo(j)<=U){
                        if(revtwo(j)>j)
                            ans++;                        
                    }
                }
            } else {
                for(int j=L;j<=U;j++){ 
                    if(onedigcir(j)<=U){
                        if(onedigcir(j)>j)
                            ans++;                        
                    }
                    if(twodigcir(j)<=U){
                        if(twodigcir(j)>j)
                            if(onedigcir(j)!=twodigcir(j))
                                ans++;                        
                    }
                    
                }               
            } 
             out.printf("Case #%d: %d\n",i+1,ans);
        }
        out.close();
   }
   static int revtwo(int num){
       return (num%10)*10+(num/10);
   }
   static int onedigcir(int num)
   {
       int newnum;
       newnum=(num%10)*100+(num/10);
       return newnum;
   }
   static int twodigcir(int num)
   {
       int newnum;
       newnum=(num%100)*10+(num/100);
       
       return newnum;
   }
}

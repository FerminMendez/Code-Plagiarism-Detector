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
public class PB {
   public static void main(String[] args) throws Exception {
       int Cases;
       int N, P, S;
       String words[];
       
        FileInputStream fstreamIN = new FileInputStream("F:\\codejam\\input\\B-small-attempt1.in");
        FileOutputStream fstreamOUT = new FileOutputStream("F:\\codejam\\output\\B-small-attempt1.out");
        
        Scanner in=new Scanner(fstreamIN);
        PrintWriter out=new PrintWriter(fstreamOUT);
        
        Cases=in.nextInt();
        
        for(int i=0;i<Cases;i++) // Cases loop
        {
            N=in.nextInt();
            S=in.nextInt();
            P=in.nextInt();
            int tempS=S;
            int ans=0;
            for(int j=0;j<N;j++){
                int num=in.nextInt();
                if(P==0){
                    if(num>=0){
                        ans++;
                    }
                } else if(P==1){
                    if(num>0)
                        ans++;
                }else if(num>=(3*P - 2))
                        ans++;             
                else if(num>=(3*P - 4) && tempS!=0)
                {
                    ans++; tempS--;
                }
            }
            out.printf("Case #%d: %d\n",i+1,ans);
        }
        out.close();
   }
}

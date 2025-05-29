/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

/**
 *
 * @author imgps
 */
public class C {
    public static void main(String args[]) throws Exception{
        int A,B;
        int ctr = 0;
        int testCases;
        
        Scanner sc = new Scanner(new FileInputStream("C-small-attempt0.in "));
        testCases = sc.nextInt();
        int input[][] = new int[testCases][2];
        for(int i=0;i<testCases;i++)
        {
          //  System.out.print("Enter input A B: ");
            input[i][0] = sc.nextInt();
            input[i][1] = sc.nextInt();
            
        }
  

for(int k=0;k<testCases;k++){
      ctr = 0;
      A = input[k][0];
      B = input[k][1];
        for(int i = A;i<=B;i++){
            int num = i;
            int nMul = 1;
            int mul = 1; 
            int tnum = num/10;
            while(tnum > 0){
                mul = mul *10;
                tnum= tnum/10;
            }
            tnum = num;
            int n = 0;
            while(tnum > 0 && mul >= 10){
                nMul = nMul * 10;
                n = (num % nMul) * mul + (num / nMul);
                mul = mul / 10;
                tnum = tnum / 10;
                for(int m=num;m<=B;m++){
                    
                    if(n == m && m > num){
                        ctr++;
                    }
                }
                
                
                
         
            }
        }
        System.out.println("Case #"+(k+1)+": "+ctr);
        
    }
    }
}

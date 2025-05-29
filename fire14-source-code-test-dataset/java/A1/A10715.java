/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication2;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Mash
 */
public class B {
     public static void main(String[] args) throws IOException{
    Scanner in = new Scanner(new FileReader("C:\\ima\\ans.txt"));
    PrintWriter out=new PrintWriter(new FileWriter("C:\\ima\\input.txt"));
    int T,S,p,N,G[];
    T=in.nextInt();
    for(int i=1;i<=T;i++){
        N=in.nextInt();
        G=new int[N];
        S=in.nextInt();
        p=in.nextInt();
        for(int j=0;j<N;j++)G[j]=in.nextInt();
        Arrays.sort(G);
        if(p>1){
        int q=p*3-2;
        int s=p*3-4;
        int cnt=0;
        int pt=N-1;
        for(int j=N-1;j>=0;j--){
            if(G[j]>=q){cnt++;pt--;}
        }
        while(pt>=0&&G[pt]>=s&&S>0){
            cnt++;pt--;S--;
        }
        System.out.println("Case #"+i+": " +cnt);
    }else if(p==1){
        int m=0;
       for(m=0;m<N;m++){
          if(G[m]>0)break;
       }
       System.out.println("Case #"+i+": " +(N-m));
    }else if(p==0)System.out.println("Case #"+i+": "+N);
         }
    }

}

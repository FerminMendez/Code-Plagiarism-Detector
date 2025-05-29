/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gcj12_qb;

import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author youssefgamil
 */
public class Gcj12_qB {

    /**
     * @param args the command line arguments
     */
    public static int scores[]=new int[40];//10+10+10=30
    
    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        FileOutputStream out=new FileOutputStream("out.txt");
        int tc,i,j,k,T=sc.nextInt();
        
        int N,S,p,res;
        
        for(tc=1;tc<=T;tc++)
        {
            N=sc.nextInt();
            S=sc.nextInt();
            p=sc.nextInt();
            Arrays.fill(scores,0);
            res=0;
            
            for(i=0;i<N;i++)
                scores[sc.nextInt()]++;
            
            for(int h=0;h<N;h++)
            for(i=0;i<11;i++)
                for(j=i;j<11;j++)
                    for(k=j;k<11;k++)
                        if(scores[i+j+k]>0)
                        {
                            if(Math.abs(k-j)>2 || Math.abs(k-i)>2 || Math.abs(i-j)>2)
                                continue;
                            
                            
                            
                            if(Math.max(i,Math.max(j,k))>=p)
                            {
                                if(Math.abs(i-j)==2 || Math.abs(k-j)==2 || Math.abs(k-i)==2)
                                {
                                        if(S>0)
                                        {
                                            S--;
                                            res++;
                                            scores[i+j+k]--;
                                        }
                                }
                                else
                                {
//                                    res++;
//                                    scores[i+j+k]--;
                                }
                            }
                          //  System.out.println("Posible sol="+i+","+j+","+k+"\t\tS="+S);
                        }
            
            for(int h=0;h<N;h++)
            for(i=0;i<11;i++)
                for(j=i;j<11;j++)
                    for(k=j;k<11;k++)
                        if(scores[i+j+k]>0)
                        {
                            if(Math.abs(k-j)>2 || Math.abs(k-i)>2 || Math.abs(i-j)>2)
                                continue;
                            
                            
                            
                            if(Math.max(i,Math.max(j,k))>=p)
                            {
                                if(Math.abs(i-j)==2 || Math.abs(k-j)==2 || Math.abs(k-i)==2)
                                {
                                        if(S>0)
                                        {
//                                            S--;
//                                            res++;
//                                            scores[i+j+k]--;
                                        }
                                }
                                else
                                {
                                    res++;
                                    scores[i+j+k]--;
                                }
                            }
                          //  System.out.println("Posible sol="+i+","+j+","+k+"\t\tS="+S);
                        }
            
            
            res=Math.min(res,N);
            System.out.print(("Case #"+tc+": "+res+"\n"));
            out.write(("Case #"+tc+": "+res+"\n").getBytes());
        }
        out.close();
        // TODO code application logic here
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package competition;

/**
 *
 * @author Sriram
 */

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.PrintStream;

public class DancingWithGooglers_GCJ_2012 {
    
    public static void main(String args[]) throws Exception
    {
        Scanner in = new Scanner(new FileInputStream("f:\\input.in"));
        PrintStream out = new PrintStream("f:\\output.out");
        int T = in.nextInt();
        for(int i=0;i<T;i++)
        {
            int N = in.nextInt();
            int S = in.nextInt();
            int p = in.nextInt();
            int result = 0;
            int p1,p2,p3;
            int[] scores = new int[N];
            if(p>1)
            {
                p1 = (3*p)-4;
                p2 = p1+1;
            }
            else
            {
                p1 = p2 = p;
            }
            for(int j=0;j<N;j++)
            {
                scores[j] = in.nextInt();
            }
            for(int j=0;(j<N)&&(S>0);j++)
            {
                if(scores[j]==p1)
                {
                    result++;
                    S--;
                }
            }
            for(int j=0;(j<N)&&(S>0);j++)
            {
                if(scores[j]==p2)
                {
                    result++;
                    S--;
                }
            }
            for(int j=0;j<N;j++)
            {
                if(scores[j]>p2)
                {
                    result++;
                }
            }
            if(p == 0)
                result = scores.length;
            out.printf("Case #%d: %d\n",(i+1),result);
            
        }
    }
}

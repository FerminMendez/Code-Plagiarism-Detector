/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package testtc;

import java.util.Scanner;

/**
 *
 * @author root
 */
public class TestTc {

    
    public static void main(String[] args) {
//        String a = "yhesocvxduiglbkrztnwjpfmaq";
        Scanner in = new Scanner(System.in);
        int d = 1;
//        while(in.hasNext())
//        {
            int t = in.nextInt();
         
            while(t-- > 0 )
            {
                int res = 0;
                int n = in.nextInt();
                int s = in.nextInt();
                int p = in.nextInt();
                
//                int pp[] = new int[n];
                for(int i=0;i<n;i++)
                {
                    int ti = in.nextInt();
                    if(ti%3 == 0)
                    {
                        int k = ti/3;
                        
                        if(k>=p)
                        {
                            res++;
                            continue;
                        }
                        else if(s>0 && k!=0 && k+1>=p)
                        {
                            s--;
                            res++;
                            continue;
                        }
                    }
                    else if(ti%3 == 1)
                    {
                        int k = ti/3;
//                        if(k==0) continue;
//                        System.out.println(k);
                        int mx = k+1;
                        if(mx>=p)
                        {
                            res++;
                            continue;
                        }
                    }
                    else if(ti%3 == 2)
                    {
                        int k = ti/3;
                        if(k==0) continue;
//                        System.out.println(k);
                        int mx = k+1;
                        if(mx>=p)
                        {
                            res++;
                            continue;
                        }
                        if(s>0 && k!=0 && mx+1>=p)
                        {
                            s--;
                            res++;
                            continue;
                        }
                    }
                }
                
                System.out.println("Case #"+ (d++) +": " + res);
            }
//        }
    }
}

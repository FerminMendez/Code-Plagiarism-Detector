/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dancingwiththegooglers;

import java.util.*;
import java.io.*;
/**
 * Google Code Jam 2012
 * Problem B. Dancing With the Googlers
 * @author STEVEN GANTENG
 * step.v4n@gmail.com
 */
public class DancingWithTheGooglers {
    
    public static int cases;
    public static String result="";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            FileInputStream fin = new FileInputStream("B-small-attempt5.in");
            FileOutputStream fout = new FileOutputStream("B-small-attempt5.out");
            Scanner source = new Scanner(fin);
            cases = source.nextInt();
            Double t[] = new Double[100];
            int count=0;
            int a=1;
            for (int j=0;j<cases;j++)
            {
                
                int N = source.nextInt();
                int S = source.nextInt();
                double p = source.nextDouble();//System.out.println(p)
                Double tmp[] = new Double[3];                
                for (int i=0;i<N;i++)
                {
                    t[i]=source.nextDouble();
                    //System.out.print(t[i]+" ");
                    tmp[i] = t[i]/3;                                                                 
                }
                for (int k=0;k<N;k++)
                {                    
                    if (tmp[k]>=p)
                    {
                        count++;
                    }
                    else if (tmp[k]==0)
                    {
                        if (p>0)
                        {
                            
                        }
                    }
                    else if ((tmp[k]-p)>-0.7)
                    {
                        count++;
                    }
                    else if ((tmp[k]-p)>-1.34)
                    {
                        if (S==0)
                        {
                            
                        }
                        else if (S!=0)
                        {
                            count++;
                            S-=1;
                        }
                    }
                        
                    //System.out.print(tmp[k]+" ");
                }
                System.out.println();                
                result += "Case #"+a+": "+count+"\n";    
                a++;
                fout.write(result.getBytes());
                result="";
                count=0;
                System.out.println();                
                
            }
        } catch (IOException e)
        {
            
        }
        //System.out.print(0/3);
    }
}

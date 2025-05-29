/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package codejam.prparation;

import java.io.*;
import java.util.*;

/**
 *
 * @author HP
 */
public class DancingWithGooglers{

    /**
     * @param args the command line arguments
     */
    
    static int getLargest(List<Integer>L ,boolean[]S)
    {
        int max=0,o = 0;
        for(int i=0;i<L.size();i++)
        {
            if(L.get(i)>max && !S[i])
            {
                max = L.get(i);
                o=i;
            }
        }
        return o;
    }
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        
       
        int TestCases;
     
        File f = new File("Dancing.in");
        Scanner scan = new Scanner(f);
        TestCases = scan.nextInt();
        
        int[] Googlers = new int[TestCases];
        int[] Surprises = new int[TestCases];
        int[] P = new int[TestCases];
        int[] Results = new int[TestCases];
        List<List<Integer>> Final = new ArrayList<List<Integer>>();
        
        int i=0;
        while(i<TestCases)
        {
            List<Integer>tmp = new ArrayList<Integer>();
            Googlers[i] = scan.nextInt();
            Surprises[i] = scan.nextInt();
            P[i] = scan.nextInt();
            for(int j =0;j<Googlers[i];j++)
            {
                int t = Integer.valueOf(scan.nextInt());
                tmp.add(t);
            }
            Final.add(tmp);
            i++;
        }
        
        
        
       for(int a =0;a<TestCases;a++)
       {
           boolean[] checks = new boolean[Googlers[a]];
           List<Integer>mod = new ArrayList<Integer>();
           List<List<Integer>> temp = new ArrayList<List<Integer>>();
           for(int g=0;g<Googlers[a];g++)
           {
               List<Integer>L =new ArrayList<Integer>();
               int total = Final.get(a).get(g);
               int A,B,C;
               if(P[a]!=0)
                    mod.add(total%P[a]);
               if(total%3==0)
               {
                   A = total/3;
                   B=A;
                   C=A;
               }
               else
               {
                   if((total+1)%3==0)
                   {
                       A = total/3;
                       B = A+1;
                       C = A+1;
                   }
                   else
                   {
                       A = total/3;
                       B = A;
                       C = A+1;
                   }
               }
               if(A>=P[a]||B>=P[a]||C>=P[a])
                   checks[g]=true;
               L.add(A);
               L.add(B);
               L.add(C);
               temp.add(L);
          //------------------------------------
           }
           int surp=0;
               while(surp<Surprises[a])
               {
                   int X = getLargest(mod,checks);
                   
                   int diff = P[a]-temp.get(X).get(2);
                   temp.get(X).set(2, temp.get(X).get(2)+1);
                   temp.get(X).set(1, temp.get(X).get(1)-1);
                   checks[X]=true;
                   surp++;
               }
               for(int m =0;m<temp.size();m++)
               {
                   if(temp.get(m).get(0)>=P[a]||temp.get(m).get(1)>=P[a]||temp.get(m).get(2)>=P[a])
                       Results[a]++;
               }
       }
        
       
        
        
        
   
        FileWriter fstreamm = new FileWriter("Dancing.out");
        BufferedWriter out = new BufferedWriter(fstreamm);
        for(int t=0;t<TestCases;t++)
        {
            out.write("Case #"+(t+1)+": "+Results[t]);
            if(t!=TestCases-1)
                out.newLine();
        
        }
    
        out.close();
}
}

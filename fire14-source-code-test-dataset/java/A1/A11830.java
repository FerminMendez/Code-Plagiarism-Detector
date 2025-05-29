package gcj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Dancing{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br=new BufferedReader(new FileReader("c:/b.in"));
        BufferedWriter out=new BufferedWriter(new FileWriter("c:/out.txt"));
        String s;
        
        
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++)
        {s=br.readLine();
        String s2[]=s.split(" ");
        int n=Integer.parseInt(s2[0]);
        int sub=Integer.parseInt(s2[1]);
        int p=Integer.parseInt(s2[2]);
        int arr[]=new int[n];
        int res=0;
        for(int j=3;j<s2.length;j++)
        {
        //    System.out.println("A"+s2[j]);
            arr[j-3]=Integer.parseInt(s2[j]);
        }
        for(int j=0;j<n;j++)
        {   
            int v=arr[j];
            if(v==0)
            {
                if(p==0)
                    res++;
                continue;
            }
            if(v==1)
            {
                if(p==1||p==0)
                    res++;
                continue;
            }
            if(v==2)
            {
                if(p==1)
                    res++;
                else if(p==0&&sub>0)
                {
                    sub--;
                    res++;
                }
                continue;
            }
         //   System.out.println(v+" "+res);
            if(v%3==0)
            {
              if(v/3-1>=p||v/3>=p)
                  res++;
              else if(v/3+1>=p&&sub>0)
              {
                  sub--;
                  res++;
              }
              
            }
            if(v%3==1)
            {
                if(v/3>=p||v/3+1>=p)
                  res++;
                
            }
            if(v%3==2)
            {
              if(v/3+1>=p||v/3>=p)
                  res++;
              else if(v/3+2>=p&&sub>0)
              {
                  sub--;
                  res++;
              }
              
            }
        }
        
        out.write("Case #"+(i+1)+": "+res+"\n");
        }
        out.close();
    }
}

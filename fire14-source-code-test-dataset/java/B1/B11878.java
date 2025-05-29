package gcj;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Recycled {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br=new BufferedReader(new FileReader("c:/c.in"));
        BufferedWriter out=new BufferedWriter(new FileWriter("c:/out.txt"));
        String s;
      
        int t=Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++)
        {s=br.readLine();
        String s2[]=s.split(" ");
        int a=Integer.parseInt(s2[0]);
        int b=Integer.parseInt(s2[1]);
        int res=0;
        
        for(int j=a;j<=b;j++)
        { int arr[]=new int[10];
          int dupidx=0;
          if(j<=10)
              continue;
          s=Integer.toString(j);
          int l=s.length();
          while(l>0)
          {
              s=s.substring(s.length()-1)+s.substring(0,s.length()-1);
              if(s.charAt(0)=='0')
              {   l--;
                  continue;
              }
              else
              {
                  if(Integer.parseInt(s)==j)
                  { l--;
                  continue;
                  }
                  if(check(arr,dupidx,Integer.parseInt(s))&Integer.parseInt(s)>j&&Integer.parseInt(s)<=b&&Integer.parseInt(s)>=a)
                  {   
                      arr[dupidx]=Integer.parseInt(s);
                      dupidx++;
                      res++;
                  
                  }
              }
              l--;
          }
        }
        out.write("Case #"+(i+1)+": "+res+"\n");
        }
        out.close();
    }
    public static boolean check(int arr[],int maxid,int val)
    {
        for(int i=0;i<maxid;i++)
        {
            if(arr[i]==val)
                return false;
        }
        return true;
    }
}

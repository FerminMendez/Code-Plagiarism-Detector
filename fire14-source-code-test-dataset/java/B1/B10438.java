

import java.io.*;
import java.lang.*;
import java.math.*;
public class problem {
    public BufferedWriter outf;
    public BufferedWriter outft;
    DataInputStream bs;
   public problem(){
try{
            File in = new File("in.txt");
            outf = new BufferedWriter(new FileWriter("out.txt", true));
            outft = new BufferedWriter(new FileWriter("out1.txt", true));
            bs = new DataInputStream(new FileInputStream(in));

       }
catch(IOException e){}

   }
    void stack()
    {
        try{int ret=0;
            int a=new Integer(bs.readLine());
            for(int i=0;i<a;i++)
            {
                    String line=bs.readLine();

                    act(line);
                    int qw=i+1;
                    String s= Integer.toString(cnt);
                        outf.write("Case #"+qw+": "+s);
                    outf.newLine();
                    outf.flush();
            }





        }
        catch(IOException e){}
        return;
    }char[] comb,opp;int count = 1;char[] combine;
    int cnt;
    void act(String line)
    {
     cnt = 0;
     String[] nums = new String[2];
     nums = line.split(" ");
     String t = new String(nums[0]);
     int num_size = t.length();
     int lower = new Integer(nums[0]);
     int upper = new Integer(nums[1]);
     
     for(int i = lower,k = 0;i < upper;k++,i++)
     {
        int[] res = span(i,num_size);
        
        for(int j = 0;j<res.length;j++)
        {
          if(res[j]>i && res[j]<=upper && res[j]>=lower)
          {try{
              String S = "Case #"+Integer.toString(k)+"  "+Integer.toString(i)+": "+Integer.toString(res[j]);
              outft.write(S);
              outft.newLine();
              outft.flush();
              cnt++;}
           catch(IOException r)
                  {
               
           }
            }
        }
        }
 }

    int[] span(int num,int num_size)
    { 
         int[] res = new int[num_size];

        String rec = Integer.toString(num);
        char[] previous = new char[rec.length()];
        rec.getChars(0,rec.length(), previous, 0);

        res [0] = new Integer(rec); //store 1st
        for(int j = 1; j < num_size; j++)
        {
            char first = previous[0];
            for(int i = 0;i<num_size-1;i++)
            {
               previous[i] = previous[i+1];
            }
            previous[num_size-1] = first;
            String u = new String(previous);
            res[j] = new Integer(u);
        }
        return res;
    }
public static void main(String[] args) {
        problem m = new problem();
m.stack();
    }
}

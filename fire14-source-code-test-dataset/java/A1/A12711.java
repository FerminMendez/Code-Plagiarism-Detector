
package javaapplication6;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JavaApplication6 {

    public static void main(String[] args) {
        try
        {
            BufferedReader in = new BufferedReader(new FileReader("e:\\B-small-attempt0.in"));
            FileWriter out=new FileWriter("e:\\B-small-attempt0.txt");
            String ts=in.readLine();
            int T=Integer.parseInt(ts);
            int counter=0;
            String output="";
            
            for(int cases=1;cases<=T;cases++)
            {
                StringTokenizer st=new StringTokenizer(in.readLine());
                int N=Integer.parseInt(st.nextToken());
                int surprise=Integer.parseInt(st.nextToken());
                int passmarks=Integer.parseInt(st.nextToken());
            System.out.println("XXX"+N+":"+surprise+":"+passmarks);
                counter=0;
                output+="Case #"+cases+": ";
                for(int i=0;i<N;i++)
                {
                    int toll=Integer.parseInt(st.nextToken());
                    int tolldiv=toll/3;
                    int rem=toll%3;
                    if(tolldiv>=passmarks)
                    {
                        counter++;
                    }
                    else if(passmarks-tolldiv==1 && rem>0)
                    {
                        counter++;
                    }
                    else if(passmarks-tolldiv==1 && surprise>0 && tolldiv>0)
                    {
                        counter++;
                        surprise--;
                    }
                    else if(passmarks-tolldiv==2 && rem==2 && surprise>0)
                    {
                        counter++;
                        surprise--;
                    }
                }
            output=output+counter;
            if(cases!=T)
                output=output+"\n";
            }
                out.write(output);
                out.close();
            
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
}

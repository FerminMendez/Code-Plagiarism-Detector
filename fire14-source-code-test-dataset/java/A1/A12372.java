import java.io.*;
import java.util.*;

public class ProB 
{
    public static void main(String args[])
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader("E:\\test.txt"));
            int n;
            n= Integer.parseInt(br.readLine());
            
            //System.out.println(n);
            
            int casen=0,noofg,spec,max,i;
            String temp;
            String outp;
            outp="";
            String nos[];
            int tmp;
            int count;

            while( casen < n )
            {
                temp = br.readLine();
                nos = temp.split(" ");
                outp += "Case #"+(casen+1)+": ";
                
                noofg = Integer.parseInt(nos[0]);
                spec = Integer.parseInt(nos[1]);
                max = Integer.parseInt(nos[2]);

                count = 0;
                
                for(i=0;i<noofg;i++)
                {
                    tmp = Integer.parseInt(nos[i+3]);
                    
                    if( tmp / 3 >= max )
                        count++;
                    else if( tmp%3 == 1 && (tmp/3)+(tmp%3) >= max)
                    {
                        System.out.println("here2:" + tmp);
                        count++;
                    }
                    else if( tmp%3 == 2 && spec > 0 && (tmp%3)+(tmp/3) >= max )
                    {
                        System.out.println("here: " + tmp);
                        count++;
                        spec--;
                    }
                    else if( tmp%3 == 2 && ((tmp/3)+((tmp/3)+1)*2) == tmp && (tmp/3)+1>=max )
                    {
                        System.out.println("here3: " + tmp);
                        count++;
                    }
                    else if( tmp!=0 && tmp%3 == 0 && spec > 0 && (tmp/3)+1 >= max )
                    {
                        System.out.println("here1: " + tmp);
                        count++;
                        spec--;
                    }
                }
                outp += count;
                if( casen != n-1 )
                    outp += "\n";
                casen++;
            }
            System.out.println(outp);

            BufferedWriter bw = new BufferedWriter( new FileWriter("E:\\result.txt"));
            bw.write(outp);
            bw.close();
            br.close();
        }
        catch( Exception e )
        {
            e.printStackTrace();
        }
    }
}

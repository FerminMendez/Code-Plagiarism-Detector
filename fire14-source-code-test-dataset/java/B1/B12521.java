import java.util.*;
import java.io.*;
public class ProblemC
{
    public static void main(String arg[])throws IOException
    {
        FileReader fin=new FileReader(arg[0]);
        FileWriter fout=new FileWriter("Output.txt");
        Scanner src=new Scanner(fin);
        Scanner t1=new Scanner(src.nextLine());
        int cases=(t1.nextInt());
        int no=0;
        int ans=0;
        while(src.hasNext())
        {
            Scanner temp=new Scanner(src.nextLine());
            no++;
            ans=0;
            
            long A=temp.nextInt();
            long B=temp.nextInt();
            long t=A;
            while(t<=B)
            {
                int count=0;
                long n=t;
                do
                {
                    n=n/10;
                    count++;
                }while(n!=0);
                for(int i=1;i<count;i++)
                {
                    long power=(long)Math.pow(10,i);
                    long r=t%power;
                    long t2=t/power;
                    long n1=r*(long)Math.pow(10,count-i)+t2;
                    if(n1<=B&&n1>t)
                    ans++;
                }
                t++;
            }
            fout.write("Case #"+no+": "+ans+"\n");
            
        }
        fout.close();
    }
}
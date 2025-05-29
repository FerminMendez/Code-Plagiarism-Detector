import java.util.*;
import java.io.*;
public class Cat
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
            
            int A=temp.nextInt();
            int B=temp.nextInt();
            int t=A;
            while(t<=B)
            {
                int count=0;
                int n=t;
                do
                {
                    n=n/10;
                    count++;
                }while(n!=0);
                for(int i=1;i<count;i++)
                {
                    int power=(int)Math.pow(10,i);
                    int r=t%power;
                    int t2=t/power;
                    int n1=r*(int)Math.pow(10,count-i)+t2;
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

/*
ID: codeKNIGHT
LANG: JAVA
TASK: 
*/
import java.util.*;
import java.math.*;
import java.io.*;
class dancingWithGooglers
{
    public static void main(String args[])throws IOException
    {
        //Scanner in=new Scanner(System.in);
        Scanner in=new Scanner(new FileReader("C:\\Users\\Lokesh\\Desktop\\B-small-attempt0.in"));
        //PrintWriter out=new PrintWriter(System.out);
        //BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\Lokesh\\Desktop\\input.in"));
        PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("E:\\programss\\GCJ\\output.txt")));
        int t=in.nextInt(),test,i,j,k;
        int s,p,n,total;
        for(test=1;test<=t;test++)
        {
            n=in.nextInt();
            s=in.nextInt();
            p=in.nextInt();
            int max=n;
            int x=0,y=0;
            for(i=0;i<n;i++)
            {
                total=in.nextInt();
                if(total>=2&&total<=28)
                {
                    j=(total-2)/3+2;
                    k=(total+2)/3;
                    if(j<p&&k<p)
                    max--;
                    else if(j>=p&&k<p)
                    {
                        if(s>0)
                        s--;
                        else max--;
                    }
                    
                }
                else if(total<2)
                {
                    if(p>total)
                    max--;
                }
                
            }
            out.println("Case #"+test+": "+max);
        }
        out.flush();
        System.exit(0);
    } 
}

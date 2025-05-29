
/*
ID: codeKNIGHT
LANG: JAVA
TASK: 
*/
import java.util.*;
import java.math.*;
import java.io.*;
class recyledNumbers
{
    public static void main(String args[])throws IOException
    {
        //Scanner in=new Scanner(System.in);
        Scanner in=new Scanner(new FileReader("C:\\Users\\Lokesh\\Desktop\\C-small-attempt0.in"));
        //PrintWriter out=new PrintWriter(System.out);
        //BufferedReader br=new BufferedReader(new FileReader("C:\\Users\\Lokesh\\Desktop\\input.in"));
        PrintWriter out=new PrintWriter(new BufferedWriter(new FileWriter("E:\\programss\\GCJ\\output.txt")));
        int t=in.nextInt(),test,i,a,b,j;
        String s,s1,s2;
        for(test=1;test<=t;test++)
        {
            a=in.nextInt();
            b=in.nextInt();
            int c=0,k;
            
            for(i=a;i<=b;i++)
            {
                s=Integer.toString(i);
                int max=s.charAt(0);
                boolean stat=false;
                for(j=1;j<s.length();j++)
                {
                    if(s.charAt(j)>=max)
                    {
                        s1=s.substring(j,s.length());
                        s2=s.substring(0,j);
                        
                        k=Integer.parseInt(s1+s2);
                        if(k>i&&k<=b&&!stat)
                        {
                            c++;
                            
                        }
                        if(s1.equals(s2))
                        stat=true;
                    }
                }
                
            }
            out.println("Case #"+test+": "+c);
        }
        out.flush();
        System.exit(0);
    } 
}

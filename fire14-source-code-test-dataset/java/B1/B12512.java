import java.io.*;
import java.util.*;
class C3
{
    public static void main(String args[])throws IOException
    {
        FileReader fi = new FileReader("C-small-attempt3.in");
        Scanner in = new Scanner(fi);
        FileWriter fr = new FileWriter("C3-output.out");
        BufferedWriter bw = new BufferedWriter(fr);
        PrintWriter pw = new PrintWriter(bw);
        int T = in.nextInt();
        int ab[][] = new int[T][2];
        for(int i=0;i<T;i++)
        {
            ab[i][0] = in.nextInt();
            ab[i][1] = in.nextInt();
        }
        in.close();
        fi.close();
        for(int i=0;i<T;i++)
        {
            int A = ab[i][0];
            int B = ab[i][1];
            int c=0;
            for(int j=A;j<=B;j++)
            {
                int n = j;
                for(int k=n+1;k<=B;k++)
                {
                    int m = k;
                    if(recycle(n,m))
                    c++;
                }
            }
            pw.println("Case #"+(i+1)+": "+c);
        }
        pw.close();
        bw.close();
        fr.close();
    }
    static boolean recycle(int n,int m)
    {
        int tn =n;
        int c=0;
        while(tn>0)
        {
            tn= tn/10;
            c++;
        }
        tn=n;
        int tn2 = n;
        boolean flag = false;
        while(tn>0)
        {
            int d = tn%10;
            tn = tn/10;
            int tp = (int)Math.pow(10,c-1);
            tn2 = tn2/10;
            tn2 = tp*d+tn2;
            if(tn2==m)
            {
                flag = true;
                break;
            }
        }
        return flag;
    }
}

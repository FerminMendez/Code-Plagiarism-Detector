import java.io.*;
import java.util.*;
class Q2
{
    public static void main(String str[])throws IOException
    {
        FileReader fr=new FileReader("B-small-attempt0.in");
//        FileReader fr=new FileReader("B-large.in");
        BufferedReader br=new BufferedReader(fr);
        FileWriter fw=new FileWriter("output.txt");
        BufferedWriter bw=new BufferedWriter(fw);
        PrintWriter pw=new PrintWriter(bw);
        int T=Integer.parseInt(br.readLine());
        for(int i=1;i<=T;i++)
        {
            String s=br.readLine();
            StringTokenizer st=new StringTokenizer(s);
            int N=Integer.parseInt(st.nextToken());
            int S=Integer.parseInt(st.nextToken());
            int p=Integer.parseInt(st.nextToken());
            int Arr[][]=new int[N][4];
            for(int j=0;j<N;j++)
            {
                int num=Integer.parseInt(st.nextToken());
                int mod=num%3;
                Arr[j][0]=mod;
                Arr[j][3]=num;
                int n=num/3;
                if(mod==0)
                {
                    Arr[j][2]=n;
                    if(n>=p)
                        Arr[j][1]=1;
                    else
                        Arr[j][1]=0;
                }
                else
                {
                     Arr[j][2]=n+1;
                     if(n+1>=p)
                        Arr[j][1]=1;
                     else
                        Arr[j][1]=0;
                }
            }
            for(int j=0;j<N;j++)
            {
                if(S==0)
                    break;
                if(Arr[j][1]==0 && (Arr[j][0]==0 || Arr[j][0]==2) && (Arr[j][2]+1)>=p && (Arr[j][2]+1)<=Arr[j][3])
                {
                    S--;
                    Arr[j][1]=1;
                }
            }
            int sum=0;
            for(int j=0;j<N;j++)
            {
                sum+=Arr[j][1];
            }
            pw.println("Case #"+i+": "+sum);
        }
        pw.close();
        bw.close();
        fw.close();
        br.close();
        fr.close();
    }
}
               
                
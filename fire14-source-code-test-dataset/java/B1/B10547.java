import java.io.*;
import java.util.*;
class Q3
{
    public static void main(String str[])throws IOException
    {
 //       long time1=System.currentTimeMillis();
        FileReader fr=new FileReader("C-small-attempt0.in");
//        FileReader fr=new FileReader("C-large.in");
        BufferedReader br=new BufferedReader(fr);
        FileWriter fw=new FileWriter("output.txt");
        BufferedWriter bw=new BufferedWriter(fw);
        PrintWriter pw=new PrintWriter(bw);
        int T=Integer.parseInt(br.readLine());
        for(int i=1;i<=T;i++)
        {
            StringTokenizer st=new StringTokenizer(br.readLine());
            String A=st.nextToken();
            String B=st.nextToken();
            int l=A.length();
            int a=Integer.parseInt(A);
            int b=Integer.parseInt(B);
            int num=0;
//            int check[][]=new int[288][2];
//            int loop=0;
            for(int j=a;j<=b;j++)
            {
                String tmp=""+j;
                int cc[]=new int[B.length()];
                int index=0;
                for(int k=l-1;k>=1;k--)
                {
                    String tmp1=tmp.substring(k)+tmp.substring(0,k);
                    if(tmp1.charAt(0)=='0')
                    continue;
                    int t1=Integer.parseInt(tmp1);
                    if(t1>j && t1>=a && t1<=b)
                    {
                        int flag=0;
                        for(int kk=0;kk<index;kk++)
                        {
                            if(cc[kk]==t1)
                            flag=1;
                        }
                        if(flag==1)
                        continue;
                        cc[index++]=t1;
                        num++;
                    }
                }
            }
            pw.println("Case #"+i+": "+num);
  /*          for(int i1=0;i1<288;i1++)
        {
            for(int j=i1+1;j<288;j++)
            {
                if(check[j][0]==check[i1][0] && check[j][1]==check[i1][1])
                System.out.println(i1+"......................"+j+"................"+check[j][0]+".................."+check[j][1]);
            }
        }  */
        }
        
        pw.close();
        bw.close();
        fw.close();
        br.close();
        fr.close();
//        System.out.println(System.currentTimeMillis()-time1);
    }
}
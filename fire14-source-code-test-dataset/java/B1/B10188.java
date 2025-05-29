
/**
 *
 * @author Prasun
 */
import java.io.*;
public class C2012 {
    public static void main(String prsn[]) throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T,A,B, i,j, cnt=0,div, m, qsn, rem, CNo=1, n;
        T=Integer.parseInt(br.readLine());
        String[] line=null;
        //System.out.println(" " + Mul(T,1000));
        while(T>0)
        {
            line=br.readLine().split(" ");
            A=Integer.parseInt(line[0]);
            B=Integer.parseInt(line[1]);
            cnt=0;
            OUTER:
            for(i=A;i<B;i++)
            {
                for(j=i+1;j<=B;j++)
                {
                    n=length(i);
                    if(n<length(j))
                    {
                        continue OUTER;
                    }


                    div=(int)Math.pow(10,n-1);
                    m=i;
                    do
                    {
                        qsn=m/div;
                        rem=m%div;
                        if(rem==0)break;
                        m=(rem*10 + qsn); if(Mul(rem,div)>0) m=m* 10 * Mul(rem,div);
                        if(m==j)
                        {
                            cnt++;
                            //System.out.println( i + " : " + j + " == " + m);
                            break;
                        }
                        n--;
                    }while(n>0);
                }
            }
            System.out.println("Case #" + CNo + ": " + cnt);
            CNo++;
            T--;
        }
    }
    public static int length(int x)
    {
        int l=0;
        while(x>0)
        {
            x=x/10;
            l++;
        }
        return l;
    }
    public static int Mul(int x, int div)
    {
        int cnt=-1;
        while(div!=0 && (x/div) <= 0)
        {
            cnt++;
            div=div/10;
        }
        return cnt;
    }
}

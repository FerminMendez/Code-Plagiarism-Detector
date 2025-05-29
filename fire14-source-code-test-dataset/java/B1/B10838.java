import java.io.*;
/**
 *
 * @author ankush
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException {
        //System.out.println(Math.floor(Math.log10(11)));
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        int ans[]=new int[t];
        for(int i=0;i<t;i++)
        {
            String x=br.readLine();
            String r[]=new String[2];
            r=x.split(" ");
            int a=Integer.parseInt(r[0]);
            int b=Integer.parseInt(r[1]);
            int count=0;
            for(int j=a;j<=b;j++)
            {
                int p=j/10;
                int m=j%10;
                int q=(int)(Math.floor(Math.log10(j)))+1;
                for(int k=1;k<q;k++)
                {
                     int s=m*(int)(Math.pow(10.0,(q-1)*1.0))+p;
                     int n=(int)(Math.floor(Math.log10(s)))+1;
                    if(s>j && s<=b && n==q)
                    {
                        count++;
                     // System.out.println(j+" "+s+" "+count+" "+p+" "+q+" "+m);
                     }
                    m=s%10;
                    p=s/10;

                }
            }
            ans[i]=count;
        }
        for(int i=0;i<t;i++)
        {
            System.out.println("Case #"+(i+1)+": "+ans[i]);
        }
    }
}
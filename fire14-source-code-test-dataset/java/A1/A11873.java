import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

/**
 *
 * @author Sreesasanka G
 */
public class Dancers {
    public static void main(String args[])throws Exception
    {
        BufferedReader in = new BufferedReader(new FileReader("B_Small.in"));
        int cases = Integer.parseInt(in.readLine());
        
        for(int i=0;i<cases;i++)
        {
            StringTokenizer st = new StringTokenizer(in.readLine()," ");
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int[] a = new int[n];
            for(int j=0;j<n;j++)
            {
                a[j] = Integer.parseInt(st.nextToken());
            }
            System.out.println("Case #"+(i+1)+": "+maxPassers(n,s,p,a));
        }
    }
    public static int maxPassers(int n,int s,int p,int a[])
    {
        int count=0,help=0;
        for(int i=0;i<n;i++)
        {
            int quotient = a[i]/3;
            int remainder = a[i]%3;
            if(quotient >= p||((quotient == p-1&& remainder >=2)||(quotient == p-1&& remainder >=1)&&p-1>0))
            {
                count++;
            }
            else if(((quotient == p-1&& remainder >=0)&&p-1>0)||((quotient == p-2&& remainder >=2)&&p-2>=0))
            {
                help++;
            }
        }
        if(help>=s)
        {
            count += s;
        }
        else
        {
            count += help;
        }
        return count;
    }
}
package codejam03;
import java.io.*;
import java.util.StringTokenizer;
public class CodeJam03
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T,A,B;
        String temp1,temp2;
        int output,n;
        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++)
        {
            output = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            for(int j=A; j<B; j++)
            {
                temp1 = Integer.toString(j);
                for(int k=0; k<temp1.length(); k++)
                {
                    temp2 = temp1.substring(k+1) + temp1.substring(0, k+1);
                    n = Integer.parseInt(temp2);
                    if(n>j && Integer.parseInt(temp2)<=B) output++;
                    if(n==j) break;
                }
            }
            System.out.println("Case #" +(i+1) + ": " + output);
        }
    }
}

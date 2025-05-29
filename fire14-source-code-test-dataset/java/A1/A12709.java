package codejam02;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.StringTokenizer;
public class CodeJam02
{
    public static void main(String[] args)
    {
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int T,N,S,p,score;
            String input,output;
            int maxGooglers,temp ;
            T = Integer.parseInt(br.readLine());
            for (int i=0;i<T;i++)
            {
                maxGooglers = 0;
                temp = 0;
                input = br.readLine();
                StringTokenizer st = new StringTokenizer(input);
                N = Integer.parseInt(st.nextToken());
                S = Integer.parseInt(st.nextToken());
                p = Integer.parseInt(st.nextToken());
                for (int j=0; j<N; j++)
                {
                    score = Integer.parseInt(st.nextToken());
                    if(p<2)
                    {
                        if(score >= p) maxGooglers++;
                    }
                    else
                    {
                        if(score==(3*p-4)||score==(3*p-3))
                        {
                            temp++;
                        }
                        else if(score>(3*p-3))
                        {
                            maxGooglers++;
                        }
                    } 
                }
                if(temp<S) maxGooglers+=temp;
                else maxGooglers+=S;
                System.out.println("Case #" +(i+1) + ": " + maxGooglers);
            }
        }
        catch (IOException ex)
        {
            Logger.getLogger(CodeJam02.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



/**
 *
 * @author Shubham
 */
public class Dancers {

    public static void main(String a[]) throws IOException
    {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++)
        {
            String line = br.readLine();
            String[] ints = line.split(" ");
            int n = Integer.parseInt(ints[0]);
            int s = Integer.parseInt(ints[1]);
            int l = Integer.parseInt(ints[2]);
            int c=0;
            for(int j=3;j<3+n;j++)
            {
                int sum = Integer.parseInt(ints[j]);
                int r = sum - 3*l;
                int r2 = (sum-l)/2;
                if(r2>=0)
                {
                    if(r>=-2)
                    {
                        c++;
                    }
                    else if(r>=-4 && s>0)
                    {
                        c++;
                        s--;
                    }
                }                
            }
            System.out.println("Case #"+i+": "+c);
        }
    }
}


import java.util.Scanner;

public class Dance
{

    public static void main(String args[]) throws Exception
    {
        int N,S,T,p,ti;
        
        Scanner in = new Scanner( System.in );
        T = in.nextInt();
        int pos = 1;
        while( pos <= T )
        {
        
            N = in.nextInt(); // Number of idiots
            S = in.nextInt(); // Number of times a judge was biased
            p = in.nextInt(); // The best result we are looking for

            int count = 0;
            
            int test_1 = Math.max(p * 3 - 2 , p );
            int test_2 = Math.max( test_1 - 2 , p);
            
            for( int i = 0 ; i < N ;i++)
            {
                ti = in.nextInt();

                if( ti >= test_1 )
                {
                    count++;
                }else if( S > 0 && ti >= test_2 )
                {
                    S--;
                    count++;
                }
            }
            
            System.out.println("Case #" + pos + ": " + count);
            
            pos++;
        }
    }
}
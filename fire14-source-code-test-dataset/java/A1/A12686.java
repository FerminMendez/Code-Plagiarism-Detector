package ab.gcj;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Surprising {

    public static void main(String args[])
    {

        Surprising s = new Surprising();
    }

    public Surprising()
    {
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int numOfTests = Integer.parseInt(reader.readLine());
            for(int j = 0 ; j < numOfTests ; j++)
            {
            String[] tstr = reader.readLine().split(" ");
            int numGooglers = Integer.parseInt(tstr[0]);
            int surprising = Integer.parseInt(tstr[1]);
            int p = Integer.parseInt(tstr[2]);
            int [] t = new int[numGooglers];
            for(int i =0 ; i < t.length; i++)
            {
                t[i] = Integer.parseInt(tstr[i+3]);
            }

            System.out.println("Case #"+(j+1)+": "+test(numGooglers,surprising,p,t) );
            }
        }catch(Exception e)
        {

        }
    }

    public int test(int n , int s , int p, int[] t)
    {
        int count = 0 ;
        int surprising = s;

        for(int i = 0 ; i < t.length; i++)
        {
            if(t[i] == 0 )
            {
                if(p == 0) count++;
                continue;
            }
            int a = t[i]/3;
            int b  = a * 3;
            int rem = t[i] - b;
            if(a >= p) {

                count++;
            }
            else
            {
                if((surprising != 0) && rem == 0 && (a + 1 >= p)) {
                    surprising--;
                    count++;
                    continue;
                }
                if( rem == 1 && a+1 >=p)
                {
                    count++;
                }
                if(rem == 2)
                {
                    if(a + 1 >= p )
                    {
                        count++;
                        continue;
                    }
                    if(surprising != 0 && a+2 >=p)
                    {
                        surprising--;
                        count++;
                    }
                }
            }


        }

        return count;

    }
}

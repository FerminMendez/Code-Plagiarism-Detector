/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package googlecodejam;

/**
 *
 * @author Bhanu
 */

import java.util.*;

public class DancingGooglers {

public static void main(String arg[]) throws Exception
{

    int s1[] = {0,1,2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
 int    h1[] = {0,1,1, 1, 2, 2, 2, 3, 3, 3, 4,  4,  4,  5,  5,  5,  6,  6,  6,  7,  7,  7,  8,  8,  8,  9,  9,  9, 10, 10,  10};
  int   s2[]   = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28};
   int  h2[]  = {2, 2, 2, 3, 3, 3, 4, 4, 4,   5,  5,  5,  6,  6,  6,  7,  7,  7,  8,  8,  8,  9,  9,  9,  10, 10,10};

   /*TreeSet<Integer> st = new TreeSet<Integer>();
    st.add(0);
    int low = 0;
    int high = 1;
    for(;high <= 10;)
    {
        st.add(high + 2 * low);

       // System.out.println("Adding " + low +" :"+  low + ": " +  high);
        st.add(2* high +  low);
        //System.out.println("Adding " + low +" :"+  high + ": " +  high);

        st.add(3 *high );
        //System.out.println("Adding " + high +" :"+  high + ": " +  high);

        low = high;
        high++;

       
    }

     System.out.println(st);
*/
   
     /*TreeSet<Integer> st1 = new TreeSet<Integer>();

     for(int i = 2 ;i <= 10; i++)
     {
        st1.add(i + (i -2) + (i -2));
        System.out.println("Adding " + (i - 2) + " " + (i - 2) + " " + i);

        st1.add(i + (i -1) + (i -2));
        System.out.println("Adding " + (i - 2) + " " + (i - 1) + " " + i);

        st1.add(i + (i ) + (i -2));
        System.out.println("Adding " + (i - 2) + " " + (i ) + " " + i);

     }
     System.out.println(st1);
     System.out.println(st1.size());
      *
      */


   java.io.BufferedReader bin = new java.io.BufferedReader(new java.io.InputStreamReader (System.in));
  int T = Integer.parseInt( bin.readLine() );
  for(int i = 1; i <= T ; i++)
  {
            String[] split = bin.readLine().split(" ");
            int N = Integer.parseInt(split[0]);
            int S = Integer.parseInt(split[1]);
            int p = Integer.parseInt(split[2]);

            int tot[] = new int[N];

            for(int k = 3; k < split.length;k++)
            {
                tot[k - 3] = Integer.parseInt(split[k]);
            }

            Arrays.sort(tot);
              int count = 0;

            for(int k = N  -1 ; k >= 0 ; k--)
            {
                int t = tot[k];
                boolean n1 = false;
                boolean n2 = false;
                if(h1[t] >= p) n1 = true;

                if( t >= 2 && t <= 28)
                {
                    if( S > 0 && h2[t-2] >= p) n2 = true;
                }

                if(n1 == false && n2 == false){

                }
                else if(n1 == false && n2 == true)
                {
                   count++;
                    S--;
                }
                else if(n1 == true && n2 == false)
                {
                    count++;
                }
                else if(n1 == true && n2 == true)
                {
                    count++;
                   
                }
            }

              System.out.println("Case #" + i + ": " + count);
  }

}

}

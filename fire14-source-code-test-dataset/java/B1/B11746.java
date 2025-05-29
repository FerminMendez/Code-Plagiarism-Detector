   import java.io.*;
   import java.util.*;

   public class Recycle
   {
      static int total;
		static Set<Integer> set;
      public static void main(String[] codejam) throws Exception
      {
         BufferedReader br = new BufferedReader (new FileReader ("recycle.in"));
         PrintStream ps = new PrintStream (new FileOutputStream ("recycle.out"));
         int t = Integer.parseInt(br.readLine());
         for(int l=1;l<=t;l++)
         {
            String[] in = br.readLine().split(" ");
            int first = Integer.parseInt(in[0]);
            int last = Integer.parseInt(in[1]);
            total = 0;
            for(int i=first;i<last;i++)
            {
               rotate(i, first, last);
            }
            ps.println("Case #" + l + ": " + total);
         
         }
      }
      public static void rotate(int m, int a, int b)
      {
			int q = 0;
         int n = m;
         String number = "" + m;
			set = new TreeSet<Integer>();
         for(int i=0;i<number.length()-1;i++)
         {
            String temp = number.substring(number.length()-1, number.length()) + number.substring(0, number.length()-1);
            m = Integer.parseInt(temp);
            if(("" + m).length() == number.length())
            {
               if(m <=b && m > a && m > n && !set.contains(m))
               {
						set.add(m);
                  total++;
               }
            }
            number = temp;
         }
      }
   }
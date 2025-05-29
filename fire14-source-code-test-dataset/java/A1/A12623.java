   import java.io.*;
   import java.util.*;

   public class goog {
      static int surprise;
      public static void main (String [] args) throws Exception {
         BufferedReader f = new BufferedReader(new FileReader("goog.in"));
         PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("goog.out")));
         int N = Integer.parseInt(f.readLine());
         for(int i = 0; i<N; i++){
            String s = f.readLine();
            StringTokenizer st = new StringTokenizer(s);
            int[] hi = new int[Integer.parseInt(st.nextToken())];
            surprise = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            for(int j = 0; j<hi.length; j++)
               hi[j] = Integer.parseInt(st.nextToken());
            Arrays.sort(hi);
            int count = 0;
            for(int j = hi.length-1; j>=0; j--)
               if(could(hi[j], p))
                  count++;
            out.println("Case #"+(i+1)+": "+count);
         }
         out.close();
         System.exit(0);
      }
      public static boolean could(int i, int greq){
         int[] t = new int[]{Math.max(0, greq-1), Math.max(0, greq-1), greq};
         int sum = 0;
         for(int e:t)
            sum+=e;
         if(sum<=i)
            return true;
         if(surprise>0){
            surprise--;
            t = new int[]{Math.max(0, greq-2), Math.max(0, greq-2), greq};
            sum = 0;
            for(int e:t)
               sum+=e;
            if(sum<=i)
               return true;
         }
         return false;
         // if(i>=3*(greq-1)+1)
            // return true;
         // if(greq == 2){
            // if(greq<2)
               // return false;
            // if(surprise>0)
            // {
               // surprise--;
               // return true;
            // }
            // return false;
         // }
         // if(i<Math.max(greq, 3*(greq-2)+2))
            // return false;
         // if(surprise>0)
         // {
            // surprise--;
            // return true;
         // }
         // return false;
      }
   }
   import java.io.*;
   import java.util.*;
   public class dancing
   {
      public static void main(String[] args) throws Exception
      {
         BufferedReader reader = new BufferedReader(new FileReader("B-small-attempt0.in"));
         PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("B-small.out")));
         int cases = Integer.parseInt(reader.readLine());
         for(int x = 0; x < cases; x++)
         {
            int count = 0;
            String next = reader.readLine();
            StringTokenizer token = new StringTokenizer(next);
            int N = Integer.parseInt(token.nextToken()); 
            int S = Integer.parseInt(token.nextToken());
            int p = Integer.parseInt(token.nextToken());
            int[] array = new int[N];
            for(int y = 0; y < N; y++)
               array[y] = Integer.parseInt(token.nextToken());
            for(int y = 0; y < N; y++)
            {
               if(array[y] == 0 && p != 0){
               }
               else if(array[y] >= 28)
               {
                  if(p <= 10)
                     count++;
               }
               else if(array[y]%3 == 1)
               {
                  if(array[y]/3 + 1 >= p)
                     count++;
               }
               else if(array[y]%3 == 2)
               {
                  if(array[y]/3 + 1 >= p)
                     count++;
                  else if(array[y]/3 + 2 >= p)
                     if(S > 0)
                     {
                        S--;
                        count++;
                     }
               }
               else if(array[y]%3 == 0)
                  if(array[y]/3 >= p)
                     count++;
                  else if(array[y]/3 + 1 >= p)
                     if(S > 0)
                     {
                        S--;
                        count++;
                     }
            }
            out.println("Case #" + (x + 1) + ": " + count);
         }
         out.close();
      }
   }
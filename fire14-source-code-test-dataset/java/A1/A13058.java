   import java.io.*;
   import java.util.*;
    public class DancingWithGooglers
   {
       public static void main(String[] args) throws Exception
      {
         //BufferedReader br = new BufferedReader(new FileReader("test.in"));
         PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("out.txt")));
         BufferedReader br = new BufferedReader(new FileReader("B-small-attempt1.in"));
         int numCases = Integer.parseInt(br.readLine());
         for(int c = 1; c <= numCases; c++)
         {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            int numSurprise = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int answer = 0;
            for(int a = 0; a < n; a++)
            {
               int t = Integer.parseInt(st.nextToken());
               int x = t/3; t-= x;
               int y = t/2;
               int z = t-y;
               if(Math.max(Math.max(x, y), z) >= p && z-x < 2)
                  answer++;
               else if(x < y && y == z)
               {
                  if(Math.min(Math.min(x, y), z) + 2 >= p && numSurprise > 0)
                  {
                     answer++; 
                     numSurprise--;
                  }
               }
               else if(x < y && y < z && numSurprise > 0 && z >= p)
               {
                  answer++;
                  numSurprise--;
               }
               else if(x == y && y < z)
               {
                  // if(Math.min(Math.min(x, y), z) + 1 >= p && numSurprise > 0)
                  // {
                     // answer++; 
                     // numSurprise--;
                  // }
               }
               else if(x == y && y == z)
               {
                  if(x > 0 && z+1 >= p && numSurprise > 0)
                  {
                     answer++; 
                     numSurprise--;
                  }
               }
                  
            }
            out.println("Case #" + c + ": " + answer);
         }
         out.close();
      }
   }
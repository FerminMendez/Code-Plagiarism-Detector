   import java.util.*;
   import java.io.*;
   
   public class rcycn
   {
      public static void main(String[] args) throws Exception
      {
         BufferedReader inputer = new BufferedReader(new FileReader("rcycn.in"));
         PrintWriter outputer = new PrintWriter(new BufferedWriter(new FileWriter("rcycn.out")));
         
         int T = Integer.parseInt(inputer.readLine());
         for(int i = 0; i < T; i++)
         {
            StringTokenizer st = new StringTokenizer(inputer.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int answer = 0;
            
            if(B >= 10)
               for(int n = A; n <= B; n++)
                  for(String m = rotate(String.valueOf(n)); Integer.parseInt(m) != n; m = rotate(String.valueOf(m)))
                     if(Integer.parseInt(m) <= B && Integer.parseInt(m) > n)
                        answer++;
            
            outputer.println("Case #" + (i + 1) + ": " + answer);
         }
         
         outputer.close();
         inputer.close();
      }
      
      public static String rotate(String n)
      {
         return n.substring(n.length() - 1) + n.substring(0, n.length() - 1);
      }
   }
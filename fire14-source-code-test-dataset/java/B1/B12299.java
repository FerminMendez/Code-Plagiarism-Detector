//Shreyas Garg
//sgbasketball3
   import java.io.*;
   import java.util.*;
   import java.lang.*;
   public class Recycle
   {
      public static int count = 0;
      public static int MAX = 0;
      public static int MIN = 0;
      public static Set<Pair> set = new HashSet<Pair>();
      public static void main(String[] args) throws Exception
      {
         Scanner sc = new Scanner(new File("C-small-attempt0.in.txt"));
         PrintStream outfile = new PrintStream(new FileOutputStream("recycle.out.txt"));
         int N = sc.nextInt();
         for(int y = 0; y < N; y++)
         {
            int A = sc.nextInt();
            int B = sc.nextInt();
            MIN = A;
            MAX = B;
            if( A < 10 && B < 10)
               outfile.println("Case #" + (y+1) + ": 0");
            else
            {
               for(int x = A; x < B; x++)
                  findPossibilities(x);
               outfile.println("Case #" + (y+1) + ": " + set.size());
               set = new HashSet<Pair>();
            }
         }
      }
      public static void findPossibilities(int y)
      {
         String s = Integer.toString(y);
         for(int x = 1; x < s.length(); x++)
         {
            String one = s.substring(x);
            String two = s.substring(0,x);
            String com = one + two;
            int temp = i(com);
            com = Integer.toString(temp);
            if(temp > MIN && temp <= MAX && temp > y)
            {
               //System.out.println(s + " " + com);
               count++;
               set.add(new Pair(y,temp));
            }
         }
      
      }
      public static int i(String s)
      {
         return Integer.parseInt(s);
      }
   }
   class Pair
   {
      public int x;
      public int y;
      public Pair(int one, int two)
      {
         x = one;
         y = two;
      }
      public boolean equals(Object z)
      {
         if(hashCode() == z.hashCode())
            return true;
         return false;
      }
      public int hashCode()
      {
         String one = Integer.toString(x);
         String two = Integer.toString(y);
         return (one + two).hashCode();
      }
   }
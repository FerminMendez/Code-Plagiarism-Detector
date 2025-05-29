import java.io.*;
import java.util.*;

public class RecycledNumbers
{
   static int start, end;
   public static void main(String[] args) throws IOException
   {
      Scanner scan = new Scanner(new File("c_small.in"));
      
      int numCases = scan.nextInt();
      for (int z = 1; z <= numCases; z++)
      {
         start = scan.nextInt();
         end = scan.nextInt();
         int count = 0;
         for (int i = start; i <= end; i++)
         {
            String rep = i + "";
            Set<String> done = new HashSet<String>();
            for (int j = 0; j < rep.length(); j++)
            {
               String res = eval(rep, j);
               if (res != null && !done.contains(res))
               {
                  done.add(res);
                  count++;
               }
            }
         }
         System.out.println("Case #"+z+": " + count);
      }
   }
   
   static String eval(String rep, int ind)
   {
      String part1 = rep.substring(0, ind);
      String part2 = rep.substring(ind, rep.length());
      
      String two = part2 + part1;
      
      int twoVal = Integer.valueOf(two);
      if (two.charAt(0) != '0' && two.compareTo(rep) > 0 && twoVal <= end)
      {
         //System.out.println(rep + " " + two);
         return two;
      }
      return null;
   }
}

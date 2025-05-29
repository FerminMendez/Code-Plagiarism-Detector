import java.util.*;
import java.lang.*;

public class recyce{
   
   public static int count(int A, int B)
   {      
      HashSet<Integer> set;
      int count = 0;
      int n = (int) Math.log10(A)+1; 
      for(int num = A; num <= B; num++)
      {
         int rem = num;
         int base = 1;
         set = new HashSet<Integer>();
         for(int k = 1; k < n; k++)
         {
            base *= 10;
            int love = rem/base + (num%base)*((int)Math.pow(10.,n-k));
            if(love > num && love >= A && love <= B)
            {
                if(!set.contains(love))
                {
                    set.add(love);
                    count++;
               // System.out.println(num + " " + love);
                }
            }
         }
      }
      return count;
   }


   public static void main(String[] args)
   {
      Scanner in = new Scanner(System.in);
      int T = in.nextInt();

      int A,B;
      for(int i = 0; i < T; i++)
      {
         A = in.nextInt();
         B = in.nextInt();
         System.out.println("Case #" + (i+1) + ": " + count(A,B));
      }

   }

}

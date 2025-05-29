import java.util.Scanner;
import java.util.HashSet;

public class Recycle
{
  public static void main(String[] args)
  {
    Scanner in = new Scanner(System.in);
    
    int nums = in.nextInt();
    
    for (int p = 0; p < nums; p++)
    {
      
      int a = in.nextInt();
      int b = in.nextInt();
      
      int length = (a + "").length();
      int pairs = 0;
      int numRepeats = 0;
      
      for (int f = a; f <= b; f++)
      {
        int temp = f;
        int save = temp;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < length; i++)
        {
          // bring to front
          int last = temp % 10;
          temp = temp / 10;
          temp += last * Math.pow(10, length - 1);
          
          if (temp > save && temp >= a && temp <= b && !set.contains(temp))
          {
            pairs++;
            set.add(temp);
          }
        }
        

      }
      System.out.println("Case #" + (p + 1) + ": " + (pairs  - numRepeats));
    }
  }
}
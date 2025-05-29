import java.util.*;
import java.io.*;

public class Recycle
{
  public static boolean sameNumbers(int n, int m, int length, int i)
  {
    
    char[] nArray = (n + "").toCharArray();
    char[] mArray = (m + "").toCharArray();
    for (int j = 0; j < length; j++)
    {
      //System.out.println(j + " " + i + " " + m + " " + mArray.length);
      if (Arrays.binarySearch(nArray, mArray[i]) == -1) return false;
      
    }

    return true;
  }
  public static boolean check(int n, int m, int a, int b, int i)
  {

    if (n > m) return false;
    else if (n == m) return false;
    else if (n < a) return false;
    else if (m > b) return false;
   // else if (!sameNumbers(n,m,(n + "").length(), i)) return false;
    // System.out.println(n + " " + m);
    return true;
  }
  public static void main (String []args) throws IOException
  {
    final String INPUT_FILE = "C-small-attempt0.in";
    final String OUTPUT_FILE = "out3.out";
    
    BufferedReader input = new BufferedReader(new FileReader(INPUT_FILE));
    PrintWriter out = new PrintWriter(new FileWriter(OUTPUT_FILE));
    
    int repeats = Integer.parseInt(input.readLine());
    
    for (int j = 0; j < repeats; j++)
    {
      StringTokenizer g = new StringTokenizer(input.readLine());  
      
      int count = 0;
      int a = Integer.parseInt(g.nextToken());
      int b = Integer.parseInt(g.nextToken());
      int aLength =  (a + "").length();
      if (aLength == 1) out.println("Case #" + (j + 1) + ": 0");
      else 
      {
        int arrayCounter = 0;
        for (int k = a; k < b; k++)
        {
          for (int i = 1; i < aLength;i++)
          {
            String kString =  k + "";
            
            //System.out.println(a + " " + aLength + " " + i);
            
            String mString1 = kString.substring(i,aLength);
            String mString2 = kString.substring(0,i);
            
            //System.out.println(kString + " " + mString1 + " " + mString2);
            
            int m = Integer.parseInt(mString1 + mString2);
            
            if (check(k,m,a,b,i))
            {
              count++;
            }
          }
        }
        out.println("Case #" + (j + 1) + ": " + count);
      }
    }
    out.close();
    input.close();
  }
}
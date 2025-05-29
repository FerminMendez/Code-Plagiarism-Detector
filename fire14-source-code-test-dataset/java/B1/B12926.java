import java.io.*;
import java.util.Scanner;

public class recycledNumbers
{
  
  public static void main(String[] args) throws IOException
  {
    
    File file = new File("in.txt");
    Scanner input = null;
    try
    {
      input = new Scanner(file);
    }
    catch(IOException e){}
    
    int T = input.nextInt();
    
    for (int i = 0; i < T; i++)
    {
      int A = input.nextInt();
      int B = input.nextInt();
      
      String n, m;
      int solution = 0;
      
      for (int j = A; j < B; j++)
      {
        n = Integer.toString(j);
        for (int k = j + 1; k <= B; k++)
        {
          m = Integer.toString(k);
          for (int l = 0; l < n.length(); l++)
          {
            n = n.substring(n.length() - 1) + n.substring(0, n.length() - 1);
            if (n.equals(m))
            {
              solution++;
              break;
            }
          }
        } 
      }
      System.out.println("Case #" + (i + 1) + ": " + solution);
    }
    
  }
  
}
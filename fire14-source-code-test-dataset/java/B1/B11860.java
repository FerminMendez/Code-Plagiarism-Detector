/**
 * 
 */
package org.mikeyin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author yincrash
 *
 */
public class RecycledNumbers
{
  // from stackoverflow, exponentiation by squaring
  public static int ipow(int base, int exp)
  {
      int result = 1;
      while (exp != 0)
      {
          if ((exp & 1) != 0)
              result *= base;
          exp >>= 1;
          base *= base;
      }

      return result;
  }
  

  /**
   * @param args
   */
  public static void main(String[] args)
  {

    try
    {
      Scanner file = new Scanner(new File(args[0]));
      int testCases = file.nextInt();
      file.nextLine();
      int currentCase = 1;
      final PrintStream ps = new PrintStream(new File("numbers.out"));
      while (currentCase <= testCases) {
        final int a = file.nextInt();
        final int b = file.nextInt();
        
        ps.append("Case #").print(currentCase);
        ps.append(": ");        
        ps.println(numRecycled(a, b));
        
        currentCase++;
      }
    } catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
  }
  
  private static class Pair {
    private int n,m;
    public Pair(int n, int m) {
      this.n = n;
      this.m = m;
    }
    @Override
    public int hashCode()
    {
      final int prime = 31;
      int result = 1;
      result = prime * result + m;
      result = prime * result + n;
      return result;
    }
    @Override
    public boolean equals(Object obj)
    {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Pair other = (Pair) obj;
      if (m != other.m)
        return false;
      if (n != other.n)
        return false;
      return true;
    }
    @Override
    public String toString()
    {
      return new StringBuilder("(").append(n).append(',').append(m).append(')').toString();
    }
  }

  private static int numRecycled(int a, int b)
  {
    HashSet<Pair> recycledPairs = new HashSet<Pair>(); 
    for (int i = a; i < b; i++) {
      int numDigits = (int) (Math.floor(Math.log10(i))) + 1;
      int current = i;
      for (int j = 0; j < numDigits - 1; j++) {
        int digit = current % 10;
        current = current / 10 + (digit * ipow(10, (numDigits - 1)));
        if (current > i && current <= b)
          recycledPairs.add(new Pair(i, current));
      }
    }
    return recycledPairs.size();
  }
}

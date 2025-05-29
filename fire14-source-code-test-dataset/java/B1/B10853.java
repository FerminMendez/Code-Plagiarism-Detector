// Skeleton program used for reading and outputing the results
// Part3 program

import java.util.*;

public class part3
{


  public static void main(String args[])
  {
    Scanner scanner = new Scanner(System.in);

    int number = scanner.nextInt();
    
    for (int i = 0; i < number; i++)
    {
      doMagic(scanner.nextInt(), scanner.nextInt(), i + 1);
    }
  }

  private static void doMagic(int lower, int upper, int caseNumber)
  {
    if (lower >= 10)
    {
      int count = 0;
      for (int number = lower; number <= upper; number++)
      {
	for (int i = number + 1; i <= upper; i++)
        {
          String numberString = Integer.toString(number);
	  String iString = Integer.toString(i);

	  boolean found = false;
	  for (int shift = 1; shift < iString.length() && !found; shift++)
	  {
	    String shiftedString = iString.substring(shift)
	                           + iString.substring(0, shift);
	    
	    if (numberString.equals(shiftedString))
	    {
	      count++;
	      found = true;
	    }
	  }
        }
      }

      System.out.println("Case #" + caseNumber + ": " + count);
    }
    else
    {
      System.out.println("Case #" + caseNumber + ": 0");
    }
  }

}

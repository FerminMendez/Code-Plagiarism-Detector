/**
 * 
 */
package org.mikeyin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author yincrash
 *
 */
public class DancingWithGooglers
{

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
      final PrintStream ps = new PrintStream(new File("dancers.out"));
      while (currentCase <= testCases) {
        final int numGooglers = file.nextInt();
        final int numSurprises = file.nextInt();
        final int atLeastScore = file.nextInt();
        
        ArrayList<Integer> totalScores = new ArrayList<Integer>(numGooglers);
        
        for (int i = 0; i < numGooglers; i++) {
          totalScores.add(file.nextInt());
        }
        
        ps.append("Case #").print(currentCase);
        ps.append(": ");

        ps.println(getMaxPossibleWithAtLeastScore(totalScores, numSurprises, atLeastScore));
        
        currentCase++;
      }
    } catch (FileNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  private static int getMaxPossibleWithAtLeastScore(
      ArrayList<Integer> totalScores, int numSurprises, int atLeastScore)
  {
    int maxPossible = 0;
    for (int score : totalScores) {
      int mean = score / 3;
      int remainder = score % 3;
      
      switch (remainder) {
        case 2:
          if (mean + 1 >= atLeastScore) {
            maxPossible++;
          }
          else if (numSurprises > 0 && mean + 2 >= atLeastScore) {
            numSurprises--;
            maxPossible++;
          }
          break;
        case 1:
          if (mean + 1 >= atLeastScore) {
            maxPossible++;
          }
          break;
        case 0:
          if (mean >= atLeastScore)
            maxPossible++;
          else if (numSurprises > 0 && mean != 0 && mean + 1 >= atLeastScore) {
            numSurprises--;
            maxPossible++;
          }
          break;
      }
    }
    
    return maxPossible;
  }

}

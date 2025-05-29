package com.google.code.codejam._2012.qualification;

import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Problem
 * 
 * Do you ever become frustrated with television because you keep seeing the same things, recycled
 * over and over again? Well I personally don't care about television, but I do sometimes feel that
 * way about numbers.
 * 
 * Let's say a pair of distinct positive integers (n, m) is recycled if you can obtain m by moving
 * some digits from the back of n to the front without changing their order. For example, (12345,
 * 34512) is a recycled pair since you can obtain 34512 by moving 345 from the end of 12345 to the
 * front. Note that n and m must have the same number of digits in order to be a recycled pair.
 * Neither n nor m can have leading zeros.
 * 
 * Given integers A and B with the same number of digits and no leading zeros, how many distinct
 * recycled pairs (n, m) are there with A ≤ n < m ≤ B?
 * 
 * The RecycledNumbers is the second problem.
 * 
 * <p>
 * Apr 14, 2012 9:25:48 PST AM
 * </p>
 * 
 * @author Marcello de Sales (marcello.desales@gmail.com)
 * 
 */
public class RecycledNumbers extends CommandLineClient {

  /**
   * Input
   * 
   * The first line of the input gives the number of test cases, T. T test cases follow. Each test
   * case consists of a single line containing the integers A and B.
   * 
   * Output
   * 
   * For each test case, output one line containing "Case #x: y", where x is the case number
   * (starting from 1), and y is the number of recycled pairs (n, m) with A ≤ n < m ≤ B.
   * 
   * Limits
   * 
   * 1 ≤ T ≤ 50. A and B have the same number of digits.
   * 
   * Small dataset
   * 
   * 1 ≤ A ≤ B ≤ 1000.
   * 
   * Large dataset
   * 
   * 1 ≤ A ≤ B ≤ 2000000.
   * 
   * Sample
   * 
   * 
   * Input
   * 4 1 9 10 40 100 500 1111 2222 
   * Output
   * Case #1: 0 Case #2: 3 Case #3: 156 Case #4: 287
   * 
   * @param args the input arguments from the stdin.
   */
  public static void main(String[] args) {
    try {
      new RecycledNumbers().execute(args);
      System.exit(0);

    } catch (Throwable t) {
      t.printStackTrace();
      System.exit(1);
    }
  }

  @Override
  public void process(Scanner input, PrintWriter output) throws Exception {
    int numberOfTestCases = Integer.valueOf(input.nextLine());

    StringBuilder builder = null;

    for (int testIndex = 0; testIndex < numberOfTestCases; testIndex++) {
      int numberOfPairs = 0;

      output.printf("Case #%d: ", testIndex + 1);

      // get the value of A and B
      String[] aAndB = input.nextLine().split(" ");

      // if the number is only one digit, then leave as it is zero.
      if (aAndB[0].length() == 1 || aAndB[1].length() == 1) {
        output.printf("%d\n", numberOfPairs);
        continue;
      }

      // the inputs A and B
      int a = Integer.valueOf(aAndB[0]);
      int b = Integer.valueOf(aAndB[1]);

      // caching the current results to avoid counting the same value twice.
      Set<String> resultsSoFar = new HashSet<>();

      // Generating all the numbers between a and b, inclusive [a, b]
      String[] ranges = new String[b - a];
      for (int i = 0, rangeValue = a; i < ranges.length; i++) {
        ranges[i] = String.valueOf(rangeValue++);
      }

      String n = "";
      String m = "";

      for (int i = 0; i < ranges.length; i++) {
        n = ranges[i];
        m = ranges[i];

        int length = String.valueOf(ranges[i]).length();
        for (int j = 0; j < length; j++) {
          // rotate number m
          String stringValue = String.valueOf(m);
          builder = new StringBuilder();
          builder.append(stringValue.charAt(stringValue.length() - 1));
          builder.append(stringValue.subSequence(0, stringValue.length() - 1));

          m = builder.toString();

          // a recycle pair is one such that A ≤ n < m ≤ B
          if (a <= Integer.valueOf(n) && Integer.valueOf(n) < Integer.valueOf(m)
              && Integer.valueOf(m) <= b) {
            if (!resultsSoFar.contains(n + m)) {
              resultsSoFar.add(n+m);
              numberOfPairs++;
            }
            //output.printf("%s, %s count: %d \n", n, m, numberOfPairs); // could see the repeated value!!!
          }
        }
      }
      output.printf("%d\n", numberOfPairs);
    }
  }
}

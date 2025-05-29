
package de.ivu.swa.jam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 0 - 10 Maximal 2 auseinander, also 7..9
 * 
 */
public class App2 {

  private static final String INPUT_FILE  = "c:/jam/input2.txt";

  private static final String OUTPUT_FILE = "c:/jam/output.txt";

  public static void main(String[] args) {
    List<String> lines = readFile();

    List<String> result = new ArrayList<String>();

    for (int i = 1; i < lines.size(); i++) {
      result.add(getResult(lines.get(i)));
    }

    writeFileAsCase(result);

    //    List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(29, 20, 8, 18,
    //        18, 21));
    //    getMaxResults(2, numbers);
  }

  private static String getResult(String line) {
    // TODO Auto-generated method stub
    List<Integer> numbers = new ArrayList<Integer>();
    List<String> split = new ArrayList<String>(Arrays.asList(line.split(" ")));

    int numberOfGooglers = Integer.valueOf(split.get(0));
    int numberOfSurprisingCases = Integer.valueOf(split.get(1));
    int higherThanThis = Integer.valueOf(split.get(2));

    for (int i = 3; i < split.size(); i++) {
      numbers.add(Integer.valueOf(split.get(i)));
    }
    return getMaxResults(numberOfSurprisingCases, higherThanThis, numbers);
  }

  // what is the maximum number of Googlers that could have had a best result of at least p
  // you want to know how many Googlers could have gotten a best result of 8 or better
  private static String getMaxResults(int numberOfSurprisingCases,
      int higherThanThis, List<Integer> numbers) {
    //    Collections.sort(numbers);
    System.out.println("------------");

    System.out.println("numberOfSurprisingCases: " + numberOfSurprisingCases
        + " -> " + numbers);

    int countSuprisingCases = 0;
    int countGreaterAs = 0;

    for (Integer integer : numbers) {
      TripletResult tripletResult = new TripletResult(integer, higherThanThis);

      if (tripletResult.isHigherWithoutSrprise()) {
        countGreaterAs++;
      } else if ((countSuprisingCases < numberOfSurprisingCases)
          && (tripletResult.canBeHigherWithSuprise())) {
        countGreaterAs++;
        countSuprisingCases++;
      }
    }

    System.out.println("------------");
    return String.valueOf(countGreaterAs);
  }

  private static class TripletResult {

    private static final int MIN = 0;

    private static final int MAX = 10;

    public final int         result;

    public final int         higherThanThis;

    public TripletResult(int result, int higherThanThis) {
      System.out.println("New TripletResult [result=" + result
          + ",higherThanThis=" + higherThanThis + "]");

      this.result = result;
      this.higherThanThis = higherThanThis;
    }

    public boolean isHigherWithoutSrprise() {
      // 29 - 8 = 21
      // 18 = 2*9;
      if (this.result - this.higherThanThis >= (2 * (this.higherThanThis - 1))) {
        System.out.println("isHigherWithoutSrprise == true");
        return true;
      } else {
        System.out.println("isHigherWithoutSrprise == false");
        return false;
      }
    }

    public boolean canBeHigherWithSuprise() {
      // 

      if (this.result < this.higherThanThis) {
        return false;
      }

      int restOfOtherTwoNumbers = this.result - this.higherThanThis;
      int refNumber = 2 * (this.higherThanThis - 2);
      System.out.println("[restOfOtherTwoNumbers=" + restOfOtherTwoNumbers
          + ",refNumber=" + refNumber + "]");
      if (restOfOtherTwoNumbers >= refNumber) {
        System.out.println("canBeHigher ~~ true");
        return true;
      } else {
        System.out.println("canBeHigher == false");
        return false;
      }
    }
  }

  private static void writeFileAsCase(List<String> lines) {

    List<String> caseLines = new ArrayList<String>();
    for (int i = 0; i < lines.size(); i++) {
      // +1 to not print the index, but the number of the list-entry
      caseLines.add(convertToCase(i + 1, lines.get(i)));
    }

    System.out.println();
    for (String string : caseLines) {
      System.out.println(string);

    }
    writeFile(caseLines);
  }

  private static String convertToCase(int i, String string) {
    return String.format("Case #%d: %s", i, string);
  }

  private static void writeFile(List<String> lines) {

    deleteFile();

    try {
      PrintWriter writer = new PrintWriter(new FileWriter(OUTPUT_FILE));
      for (int i = 0; i < lines.size(); i++) {
        writer.print(lines.get(i));
        if (i != lines.size() - 1) {
          writer.print("\n");
        }
      }
      writer.flush();
      writer.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void deleteFile() {
    File file = new File(OUTPUT_FILE);
    if (file.exists()) {
      file.delete();
    }
  }

  private static List<String> readFile() {

    List<String> lines = new ArrayList<String>();

    try {
      BufferedReader in = new BufferedReader(new FileReader(INPUT_FILE));
      String str;
      while ((str = in.readLine()) != null) {
        lines.add(str);
      }
      in.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return lines;

  }
}

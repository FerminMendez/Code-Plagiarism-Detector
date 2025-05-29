package codejam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/*
 import lib.tuple.Pair;
 import lib.tuple.Tuple;
 import lib.util.StringUtil;
 */

public class CodeJam2012RQC {

  static final String fileIn = "/Users/jhorwitz/Documents/workspace/test/src/codejam/data/RQ-C-in.txt"; //"data/in.txt";
  static final String fileOut = "/Users/jhorwitz/Documents/workspace/test/src/codejam/data/RQ-C-out.txt"; //"data/out.txt";

  public static void main(String[] args) throws Exception {
    BufferedReader r = new BufferedReader(new FileReader(fileIn));
    BufferedWriter w = new BufferedWriter(new FileWriter(fileOut));
    String line = r.readLine();
    int T = Integer.parseInt(line);
    for (int caseNum = 1; caseNum <= T; caseNum++) {
      line = r.readLine();
      String str = "Case #" + caseNum + ": " + solve(line);
      w.write(str + "\n");
      System.out.println(str);
    }
    w.close();
    r.close();
  }

  private static int solve(String line) {
    String[] stringVerOfAAndB = line.split(" ");
    int A = Integer.parseInt(stringVerOfAAndB[0]);
    int B = Integer.parseInt(stringVerOfAAndB[1]);
    int digits = stringVerOfAAndB[0].length(); // == stringVerOfAAndB[1] (guaranteed by GCJ)
    int numRecycledPairsTimesTwo = 0; // each pair will be counted twice--we then simply divide by 2 in the end
    int rotatedNum;

    for (int curNum=A; curNum<=B; ++curNum) {
      for (int rot=1; rot<=digits; ++rot) {
        rotatedNum = rotate(curNum, rot, digits);
        if (A<=rotatedNum && rotatedNum<=B && isFirstSuchRotation(curNum,rotatedNum,rot,digits)) {
          ++numRecycledPairsTimesTwo;
        }
      }
    }
    return numRecycledPairsTimesTwo/2;
  }

  private static boolean isFirstSuchRotation(int numToRotate, int rotatedNum, int rot1, int digits) {
    for (int rot2=0; rot2<rot1; ++rot2) {
      if (rotatedNum == rotate(numToRotate, rot2, digits)) {
        return false;
      }
    }
    return true;
  }
  
  private static int rotate(int numToRotate, int rot, int digits) {
    char[] startString = Integer.toString(numToRotate).toCharArray();
    char[] endString = new char[digits];
    int indexIntoStartString;

    for (int i=0; i<digits; ++i) {
      indexIntoStartString = (i-rot) % digits;
      if (indexIntoStartString < 0) { // "%" isn't quite "mod"--silly negative cases
        indexIntoStartString += digits;
      }
      endString[i] = startString[indexIntoStartString];
    }

    return Integer.parseInt(new String(endString));
  }
}
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

public class CodeJam2012RQB {

  static final String fileIn = "/Users/jhorwitz/Documents/workspace/test/src/codejam/data/RQ-B-in.txt"; //"data/in.txt";
  static final String fileOut = "/Users/jhorwitz/Documents/workspace/test/src/codejam/data/RQ-B-out.txt"; //"data/out.txt";

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
    String[] inputLineAsAnArray = line.split(" ");
    int N = Integer.parseInt(inputLineAsAnArray[0]);
    int S = Integer.parseInt(inputLineAsAnArray[1]);
    int p = Integer.parseInt(inputLineAsAnArray[2]);
    int[] t = new int[N];
    int numGooglersWithMaxScoreGreaterThanP = 0;

    for (int i=0; i<N; ++i) { // fill t array--separate for loop from below solely for debug purposes
      t[i] = Integer.parseInt(inputLineAsAnArray[3+i]);
    }

    for (int iGoogler=0; iGoogler<N; ++iGoogler) {
      int tBy3 = t[iGoogler]/3;
      switch(t[iGoogler] % 3) {
        case 0:
          if(tBy3 >= p && 0<=tBy3 && tBy3<=10) { // no need for a surprising triplet for this Googler to get p or more
            ++numGooglersWithMaxScoreGreaterThanP;
          } else if(tBy3+1 == p && 0<=tBy3-1 && tBy3+1<=10) {  // a surprising triplet is needed for this Googler to get a p or more -- "use" one if there's one left
            if(S>0) {
              ++numGooglersWithMaxScoreGreaterThanP;
              --S;
            }
          }
          // if neither of those cases, then not valid triplet (surprising or otherwise) could give this Googler a p or more
          break;
        case 1:
          if(tBy3 + 1 >= p && 0<=tBy3 && tBy3+1<=10) { // no need for a surprising triplet for this Googler to get p or more
            ++numGooglersWithMaxScoreGreaterThanP;
          } // for this case (1 mod 3), a surprising triplet will have the same max as a non-surprising one
          // so otherwise, then not valid triplet (surprising or otherwise) could give this Googler a p or more
          break;
        case 2:
          if(tBy3 + 1 >= p && 0<=tBy3 && tBy3+1<=10) { // no need for a surprising triplet for this Googler to get p or more
            ++numGooglersWithMaxScoreGreaterThanP;
          } else if(tBy3 + 2 == p && 0<=tBy3 && tBy3+2<=10) {  // a surprising triplet is needed for this Googler to get a p or more -- "use" one if there's one left
            if(S>0) {
              ++numGooglersWithMaxScoreGreaterThanP;
              --S;
            }
          }
          // if neither of those cases, then not valid triplet (surprising or otherwise) could give this Googler a p or more
          break;
        // default left out since there better only be the three listed cases!
      }
    }

    return numGooglersWithMaxScoreGreaterThanP;
  }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BMain {

  /**
   * @param args
   * @throws IOException 
   * @throws NumberFormatException 
   */
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    int casesCnt = Integer.parseInt(reader.readLine());

    for (int i = 0; i < casesCnt; i++) {
      String line = reader.readLine();
      solve(i + 1, line);
    }
    
//    int[] sIdx = {0,1,2};
//    int[] sIdx = {0,3,4};
//    int[] sIdx = {};
//    int size = 5;
//    System.out.println(Arrays.toString(sIdx));
//    for (int i = 0; i < 16; i++) {
//      boolean ok = nextSurprises(sIdx, size);
//      if (!ok) break;
//      System.out.println(Arrays.toString(sIdx));
//    }
  }
  
  private static void solve(int caseN, String line) {
    final StringTokenizer tokens = new StringTokenizer(line);
    final int nGooglers = Integer.parseInt(tokens.nextToken());
    final int surprises = Integer.parseInt(tokens.nextToken());
    final int pMinScore = Integer.parseInt(tokens.nextToken());
    final int[] scores = new int[nGooglers];
    for (int i = 0; i < scores.length; i++) {
      scores[i] = Integer.parseInt(tokens.nextToken());
    }

    int result = 0;

    int[] suprIdx = initSurprises(surprises, nGooglers);
mainloop:
    do {
      int resultTmp = 0;
      boolean[] isSurprise = new boolean[nGooglers];
      for (int i : suprIdx) {
        isSurprise[i] = true;
        if (scores[i]<2)
          continue mainloop;
      }
      for (int i = 0; i < scores.length; i++) {
        for (int best = pMinScore; best <= 10; best++) {
          int tripleBest = 3 * best;
          if (isSurprise[i]) {
            // if surprise .. -2,-3,-4
            if (scores[i] <= tripleBest - 2 && scores[i] >= tripleBest - 4) {
              resultTmp++;
            }
          } else {
            // if !surprise .. sum = 3*best -0,-1,-2
            if (scores[i] <= tripleBest && scores[i] >= tripleBest - 2) {
              resultTmp++;
            }
          }
        }
      }
      if (resultTmp > result)
        result = resultTmp;
    } while (nextSurprises(suprIdx, nGooglers));
    System.out.printf("Case #%d: %d%n", caseN, result);
  }
  
  private static int[] initSurprises(int surprCnt, int googlers) {
    int [] result = new int[surprCnt];
    for (int i = 1; i < result.length; i++) {
      result[i] = result[i-1] + 1;
    }
    return result;
  }
  
  private static boolean nextSurprises(int[] sIdx, int googlers) {
    int i = sIdx.length - 1;
    boolean overflow = true;
    while (i >= 0 && overflow) {
      if (sIdx[i] >= googlers - 1 - (sIdx.length - i - 1)) {
        // overflow
        i--;
      } else {
        // no overflow
        overflow = false;
        //inc idx
        sIdx[i]++;
        // fix remaining indexes
        for (int y = i + 1; y < sIdx.length; y++) {
          sIdx[y] = sIdx[y - 1] + 1;
        }
        return true;
      }
    }
    return false;
  }
}

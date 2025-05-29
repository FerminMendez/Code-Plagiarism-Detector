package googleCodeJam;

import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.FileReader;

public class DancingWithTheGooglers {
  private static final int MAXN = 128;
  
  private static int inc0(int num, int p) {
    if (num == 0) {
      return (p == 0) ? 1 : 0;
    }
    int t = num / 3;
    int m = num % 3;
    return ((m == 0 && t >= p) || (m == 1 && t+1 >= p) || (m == 2 && t+1 >= p)) ? 1 : 0;
  }
  
  private static int inc1(int num, int p) {
    if (num == 0) {
      return 0;
    }
    int t = num / 3;
    int m = num % 3;
    return ((m == 0 && t+1 <= 10 && t+1 >= p) || (m == 1 && t+1 >= p) || (m == 2 && t+2 <= 10 && t+2 >= p)) ? 1 : 0;
  }
  
  public static void main(String[] args) throws Exception {
    if (args.length == 1) {
      int[] g = new int[MAXN];
      int[][] f = new int[MAXN][MAXN];
      
      // opening the input
      BufferedReader in = new BufferedReader(new FileReader(args[0]));
      
      // reading the number of test cases
      String line = null;
      int numberOfTestCases = ((line = in.readLine()) != null) ? Integer.parseInt(line) : 0;
      for (int t = 0; t < numberOfTestCases; t ++) {
        line = in.readLine();
        out.print("Case #" + (t+1) + ": ");
        
        // parsing input
        String[] input = line.split(" ");
        int n = Integer.parseInt(input[0]); 
        int s = Integer.parseInt(input[1]);
        int p = Integer.parseInt(input[2]);
        for (int i = 0; i < n; i ++) {
          g[i] = Integer.parseInt(input[3 + i]);
        }
        
        // computation
        f[0][0] = inc0(g[0], p);
        for (int i = 1; i < n; i ++) {
          f[i][0] = f[i-1][0] + inc0(g[i], p);
        }
        if (s > 0) {
          f[0][1] = inc1(g[0], p);
        }
        for (int i = 1; i < n; i ++) {
          for (int j = 1; j <= i+1 && j <= s; j ++) {
            f[i][j] = Math.max(f[i-1][j-1] + inc1(g[i], p), f[i-1][j] + inc0(g[i], p));
          }
        }
        out.println(f[n-1][s]);
      }
      
      // closing the input
      in.close();
    } else {
      // show the usage
      System.err.println("Using: java googleCodeJam.DancingWithThegooglers input");
    }
  }

}

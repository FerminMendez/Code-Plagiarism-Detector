import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class CMain {

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
  }

  private static void solve(int caseN, String line) {
    final StringTokenizer tokens = new StringTokenizer(line);
    final int A = Integer.parseInt(tokens.nextToken());
    final int B = Integer.parseInt(tokens.nextToken());
    int result = solveInner(A, B);
    System.out.printf("Case #%d: %d%n", caseN, result);
  }
  
  private static int solveInner(int A, int B) {
    class Pair {
      public Pair(int x, int y) {
        if (x < y) {
          this.x = x;
          this.y = y;
        } else {
          this.x = y;
          this.y = x;
        }
      }
      final int x;
      final int y;
      @Override
      public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
      }
      @Override
      public boolean equals(Object obj) {
        if (this == obj)
          return true;
        if (obj == null)
          return false;
        if (getClass() != obj.getClass())
          return false;
        Pair other = (Pair) obj;
        if (x != other.x)
          return false;
        if (y != other.y)
          return false;
        return true;
      }
    }
    Set<Pair> results = new HashSet<Pair>();
    for (int num = A; num <= B; num++) {
      // max chunk size = floor(log(number))
      final int numLen = digits(num);
      for (int chunkLength = 1; chunkLength < numLen; chunkLength++) {
        int recycled = recycle(num, numLen, chunkLength);
        if (recycled != num && recycled >= A && recycled <= B
            && digits(recycled) == numLen) {
          results.add(new Pair(num, recycled));
        }
      }
    }
    return results.size();
  }
  
  private static int digits(int num) {
    return 1 + (int) Math.log10(num);
  }

  private static int recycle(int num, int numLength, int endChunkLength) {
    int base = (int) Math.pow(10, endChunkLength);
    int result = (num % base) * ((int) Math.pow(10, numLength - endChunkLength)) + num / base;
    return result;
  }

}

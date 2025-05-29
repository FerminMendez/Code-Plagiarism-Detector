import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Main {

  public static void main (String[] args) throws IOException {
    Writer writer = new FileWriter("/home/a/dev/codejam-2012/B-submit.txt");
    Scanner scanner = new Scanner(new File("/home/a/dev/codejam-2012/A-dev.txt"));
    int n_cases = scanner.nextInt();
    scanner.nextLine();
    for (int i = 0; i < n_cases; ++i) {
      int N = scanner.nextInt();
      int S = scanner.nextInt();
      int p = scanner.nextInt();
      int [] scores = new int[N];
      for (int j = 0; j < scores.length; ++j) {
        scores[j] = scanner.nextInt();
      }
      Main main = new Main();
      writer.write("Case #" + (i + 1) + ": " + main.solve(S, p, scores) + "\n");
    }
    writer.close();
  }
  
  public int solve (int S, int p, int [] scores) {
    int count = 0;
    for (int score : scores) {
      int mod = score % 3;
      int max;
      if (mod == 0) {
        max = score / 3;
        if (max >= p) {
          ++count; continue;
        }
        if (score < 3) {
          continue;
        }
        if (max < p - 1) {
          continue;
        }
        if (S > 0) {
          --S; ++count; continue;
        }
      } else if (mod == 1) {
        max = (score - 1) / 3 + 1;
        if (max >= p) {
          ++count; continue;
        }
        continue;
      } else if (mod == 2) {
        max = (score - 2) / 3 + 1;
        if (max >= p) {
          ++count; continue;
        }
        if (max < p - 1) {
          continue;
        }
        if (S > 0) {
          --S; ++count; continue;
        }
      }
    }
    return count;
  }

}

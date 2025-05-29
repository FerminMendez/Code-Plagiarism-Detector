import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * @author Max Loewenthal
 */
public class B {

  public void solve(Scanner input, StringBuilder buffer) {
    int N = input.nextInt();
    int surprisingScores = input.nextInt();
    int p = input.nextInt();

    int candidates = 0;
    int surprisingCandidates = 0;

    for (int i = 0; i <N; i++) {
      int total = input.nextInt();

      if (total >= 3*p - 2 && total >= p) {
        candidates = candidates + 1;
      }
      else if (total >= 3*p - 4 && total >= p) {
        surprisingCandidates = surprisingCandidates + 1;
      }
    }

    buffer.append(Integer.toString(candidates + Math.min(surprisingCandidates, surprisingScores)));
  }

  public static void main(String[] args) {
    try {
      InputStream input = System.in;
      OutputStream output = System.out;

      if (args.length > 0) {
        input = new FileInputStream(new File(args[0]));
      }

      if (args.length > 1) {
        File outputFile = new File(args[1]);

        if (outputFile.exists()) {
          throw new Exception("Output file already exists");
        }

        output = new FileOutputStream(new File(args[1]));
      }

      Scanner scanner = new Scanner(input);
      PrintWriter writer = new PrintWriter(output);

      B a = new B();

      int count = scanner.nextInt();
      scanner.nextLine();

      for (int i = 0; i < count; i++) {
        StringBuilder result = new StringBuilder();
        a.solve(scanner, result);


        writer.println("Case #" + (i + 1) + ": " + result.toString());
      }

      writer.close();
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}

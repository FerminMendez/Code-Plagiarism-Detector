package birgit.vera.schmidt.googlecodejam2012.qual;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class B {
  public static void main(String[] args) {
    try {
      String filename = "B-small-attempt0";
      BufferedReader in = new BufferedReader(new FileReader(new File(filename + ".in")));
      PrintStream out = new PrintStream(new FileOutputStream(new File(filename + ".out")));

      int t = Integer.parseInt(in.readLine());

      for (int i = 0; i < t; i++) {
        out.println("Case #" + (i+1) + ": " + calcCase(in.readLine()));
      }

    } catch (IOException e) {
      // Just crash.
      e.printStackTrace();
    }
  }

  private static int calcCase(String line) {
    String[] parts = line.split(" ");
    int n = Integer.parseInt(parts[0]);
    int s = Integer.parseInt(parts[1]);
    int p = Integer.parseInt(parts[2]);
    int[] g = new int[n];
    for (int i = 0; i < n; i++) {
      g[i] = Integer.parseInt(parts[i+3]);
    }

    int ok = 0;
    int okWithSurprising = 0;
    int notOk = 0;

    int limitOkWithoutSurprising = 3*p-2;
    int limitOkWithSurprising = Math.max(3*p-4, 2);

    for (int score : g) {
      if (score >= limitOkWithoutSurprising) {
        ok++;
      } else if (score >= limitOkWithSurprising) {
        okWithSurprising++;
      } else {
        notOk++;
      }
    }

    return ok + Math.min(okWithSurprising, s);
  }
}

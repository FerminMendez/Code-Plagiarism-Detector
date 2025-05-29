package de.pat.dev.y2012.qualification.c;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * @author pat.dev@alice.de
 * @since 17.04.12
 */
public class Main {
  public static void main(String[] args) {
  try {
    BufferedReader reader = new BufferedReader(new FileReader(args[0]));
    long numberOfTestCases = nextLong(reader);
    for (int i = 0; i < numberOfTestCases; i++) {
      RecycledNumber recycledNumber = toRecycledNumber(reader.readLine().trim());
      System.out.printf("Case #%d: %d\n", i + 1, recycledNumber.pairs().size());
    }
  } catch (IOException e) {
    e.printStackTrace();
  }
}

  private static RecycledNumber toRecycledNumber(String line) {
    String[] values = line.split("\\s+");
    return new RecycledNumber(toLong(values[0]),toLong(values[1]));
  }


  private static long toLong(String value) {
    return Long.parseLong(value);
  }

  private static long nextLong(BufferedReader reader) throws IOException {
    return toLong(reader.readLine().trim());
  }
}

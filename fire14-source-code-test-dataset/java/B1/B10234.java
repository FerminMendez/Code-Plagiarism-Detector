import java.util.Scanner;

public class C2 {

  /**
   * @param args
   */
  public static void main(String[] args) {
    new C2();
  }

  int a, b, nbrDigits;
  // All numbers that we have already seen
  boolean[] seen;

  C2() {
    Scanner sc = new Scanner(System.in);
    int nbrCases = sc.nextInt();
    for (int i = 1; i <= nbrCases; ++i) {
      sc.nextLine();
      System.out.print("Case #" + i + ": ");

      a = sc.nextInt();
      b = sc.nextInt();
      nbrDigits = nbrDigits(a);

      seen = new boolean[b + 1];
      for (int j = 0; j <= b; ++j) {
        seen[j] = false;
      }

      int result = 0;
      for (int j = a; j <= b; ++j) {
        result += nbrRecycledLocal(j);
      }
      System.out.println(result);
    }
  }

  /**
   * Get the number of recycled pairs starting from the given number
   * 
   * @param start
   *          the number to start from
   * @return the number of recycled pairs between a and b
   */
  int nbrRecycledLocal(int start) {
    if (seen[start]) {
      return 0;
    }
    seen[start] = true;

    byte[] parts = separate(start);
    int hits = 0;

    for (int i = 1; i < nbrDigits; ++i) {
      int recycled = getRecycled(parts, i);

      if (recycled != start && recycled >= a && recycled <= b && !seen[recycled]) {
        ++hits;
        seen[recycled] = true;
      }
    }

    if (hits <= 1) {
      return hits;
    }

    int res = 1;
    for (int i = 2; i <= hits; ++i) {
      res += i;
    }
    return res;
  }

  /**
   * Get the number of digits in the given number
   * 
   * @param number
   *          the number
   * @return the number of digits in the number
   */
  int nbrDigits(int number) {
    int digits = 0;
    while (number != 0) {
      number /= 10;
      digits++;
    }
    return digits;
  }

  /**
   * Separate the given number into its digits
   * 
   * @param start
   *          the number
   * @return an array with the digits of the number
   */
  byte[] separate(int start) {
    byte[] res = new byte[nbrDigits];

    for (int i = 0; i < nbrDigits; ++i) {
      res[nbrDigits - 1 - i] = (byte) (start % 10);
      start = start / 10;
    }

    return res;
  }

  /**
   * Get the recycled number given the start number and the number of steps to
   * move the digits
   * 
   * @param start
   *          the original number in digits
   * @param steps
   *          the steps to take
   * @return the recycled number
   */
  int getRecycled(byte[] start, int steps) {
    int res = 0;
    int factor = 1;
    int size = start.length;

    for (int i = 0; i < size; ++i) {
      int pos = (size - 1 - i + steps) % size;
      res += factor * start[pos];
      factor *= 10;
    }

    return res;
  }
}

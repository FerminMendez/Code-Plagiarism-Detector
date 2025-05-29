//Edwin Lunando template for online algorithm contest
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

//  class node implements Comparable<node> {
//
//    public int a;
//    public int b;
//
//    public int compareTo(node a) {
//      if (a.b == this.b) {
//        return a.a - this.a;
//      } else {
//        return a.b - this.b;
//      }
//    }
//
//    public node(int a, int b) {
//      this.a = a;
//      this.b = b;
//    }
//  }
  private void solve() throws IOException {
    int n = nextInt();
    for (int x = 0; x < n; x++) {
      int count = 0;
      int N = nextInt(), s = nextInt(), p = nextInt();
      int[] t = new int[N];
      for (int y = 0; y < N; y++) {
        t[y] = nextInt();
        if (t[y] >= p * 3) {
          count++;
        } else if (t[y] >= (p * 3) - 2 && t[y] != 0) {
          count++;
        } else if (t[y] >= (p * 3) - 4 && s > 0 && t[y] != 0 ) {
          count++;
          s--;
        }
      }
      System.out.println("Case #" + (int) (x + 1) + ": " + count);
    }
  }

  public static void main(String[] args) {
    try {
      br = new BufferedReader(new InputStreamReader(System.in));
      //br = new BufferedReader(new FileReader("input.txt"));
      out = new PrintWriter(System.out);
      //out = new PrintWriter(new BufferedWriter(new FileWriter("output.txt")));
      new Main().solve();
      out.close();
    } catch (Throwable e) {
      System.out.println(e);
      System.exit(239);
    }
  }
  static BufferedReader br;
  static StringTokenizer st;
  static PrintWriter out;

  static String nextToken() throws IOException {
    while (st == null || !st.hasMoreTokens()) {
      String line = br.readLine();
      if (line == null) {
        return null;
      }
      st = new StringTokenizer(line);
    }
    return st.nextToken();
  }

  static int nextInt() throws IOException {
    return Integer.parseInt(nextToken());
  }

  static long nextLong() throws IOException {
    return Long.parseLong(nextToken());
  }

  static double nextDouble() throws IOException {
    return Double.parseDouble(nextToken());
  }

  static int[] nextIntArray(int n) throws IOException {
    int[] temp = new int[n];
    for (int x = 0; x < n; x++) {
      temp[x] = nextInt();
    }
    return temp;
  }

  static long[] nextLongArray(int n) throws IOException {
    long[] temp = new long[n];
    for (int x = 0; x < n; x++) {
      temp[x] = nextLong();
    }
    return temp;
  }

  static String[] nextArray(int n) throws IOException {
    String[] temp = new String[n];
    for (int x = 0; x < n; x++) {
      temp[x] = nextToken();
    }
    return temp;
  }
}

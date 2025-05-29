import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public class Cj2012_qr_c_java {
  // <Common Declarations>
  // private static final String IN_FILE = "test.in";
  private static final String IN_FILE = "test_small.in";
  // private static final String IN_FILE = "test_large.in";
  private static final String OUT_FILE = IN_FILE + ".out";
  private static final DateFormat DATE_FORMAT = new SimpleDateFormat("HH:mm.ss");

  private static long lBeginTimeMillis;
  private static BufferedReader bufferedReader;
  private static PrintWriter printWriter;

  private static int nNbCases, nIndexCase;

  // </Common Declarations>

  // <Specific Declarations>
  // ...
  private static int A, B;

  private static long N;
  // private static char ;
  // private static boolean ;
  private static String strA, strB;

  // </Specific Declarations>

  private static void begin() throws Exception {
    // <Common Commands>
    lBeginTimeMillis = System.currentTimeMillis();
    System.out.println(Cj2012_qr_c_java.class.toString());
    System.out.println("Begin: "
        + DATE_FORMAT.format(new Date(lBeginTimeMillis)) + ".");

    bufferedReader = new BufferedReader(new FileReader(IN_FILE));
    printWriter = new PrintWriter(new BufferedWriter(new FileWriter(OUT_FILE)));
    // </Common Commands>

    // <Specific Commands>
    // ...

    // StringTokenizer strTokenizer = new
    // StringTokenizer(bufferedReader.readLine(), " ");
    //
    // bufferedReader.readLine()
    nNbCases = Integer.parseInt(bufferedReader.readLine());

    // </Specific Commands>
  }

  private static void end() throws Exception {
    // <Specific Commands>
    // ...
    // </Specific Commands>

    // <Common Commands>
    bufferedReader.close();
    printWriter.close();

    long lEndTimeMillis = System.currentTimeMillis();
    System.out.println("End:   " + DATE_FORMAT.format(new Date(lEndTimeMillis))
        + ".");
    System.out.println((lEndTimeMillis - lBeginTimeMillis) + ".");
    // </Common Commands>
  }

  private static void readCase() throws Exception {
    // <Specific Commands>
    // ...

    StringTokenizer strTokenizer = new StringTokenizer(
        bufferedReader.readLine(), " ");
    //
    // bufferedReader.readLine()
    // strTokenizer.nextToken()
    strA = strTokenizer.nextToken();
    strB = strTokenizer.nextToken();
    A = Integer.parseInt(strA);
    B = Integer.parseInt(strB);

    // </Specific Commands>
  }

  private static void processCase() {
    // <Specific Commands>
    N = 0;
    for (int i = A; i < B; i++) {
      String str = Integer.toString(i);
      for (int j = 1; j < str.length(); j++) {
        String str1 = str.substring(0, str.length() - j);
        String str2 = str.substring(str.length() - j, str.length());
        int n = Integer.parseInt(str2 + str1);
        N += n > i && n <= B ? 1 : 0;
      }
    }

    // </Specific Commands>
  }

  private static void writeCase(int nIndexCase) throws Exception {
    // <Common Commands>
    printWriter.print("Case #");
    printWriter.print(nIndexCase + 1);
    printWriter.print(":");
    // </Common Commands>

    // <Specific Commands>
    // ...

    printWriter.print(" ");
    printWriter.print(N);
    printWriter.println();

    // </Specific Commands>
  }

  public static void main(String[] args) throws Exception {
    // <Common Commands>
    begin();
    for (nIndexCase = 0; nIndexCase < nNbCases; nIndexCase++) {
      readCase();
      processCase();
      writeCase(nIndexCase);
    }
    end();
    // </Common Commands>
  }

  static long fact(int n) {
    long l = n < 0 ? -1 : 1;
    n *= l;
    while (n > 1)
      l *= n--;
    return l;
  }

  static int pgcd(int N, int M) {
    if (N < M)
      return pgcd(M, N);
    if (N % M == 0)
      return M;
    return pgcd(N % M, M);
  }
}

class A_class {
  boolean b;
  int i;
  double d;
  String str;

  public A_class(boolean b, int i, double d, String str) {
    this.b = b;
    this.i = i;
    this.d = d;
    this.str = str;
  }
}

class Item implements Comparable<Item> {
  public int n, p;

  Item(int n, int p) {
    this.n = n;
    this.p = p;
  }

  public int compareTo(Item o) {
    return this.p - o.p;
  }
}

import java.io.BufferedReader;
import java.io.FileReader;


public class C {

  private boolean isR(int a, int b) {

    char[] sa = String.valueOf(a).toCharArray();
    char[] sb = String.valueOf(b).toCharArray();

    if (sa.length != sb.length) return false;
    int n = sa.length;

    for (int i = 1; i < n; i++) {
      boolean ok = true;
      for (int k = 0; k < n; k++) {
        char c = sb[(k + i) % n];
        if (c != sa[k]) {
          ok = false;
          break;
        }
      }
      if (ok) return true;
    }

    return false;
  }

  int count(int a, int b) {
    int c = 0;
    for (int i = a; i < b; i++) {
      for (int j = i + 1; j <= b; j++) {
        if (isR(i, j)) {
          c++;
        }
      }
    }
    return c;
  }

  private void main2(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new FileReader(args[0]));
    String line = br.readLine();
    int count = Integer.parseInt(line);
    for (int i = 0; i < count; i++) {
      line = br.readLine();
      int s = line.indexOf(' ');
      int a = Integer.parseInt(line.substring(0, s));
      int b = Integer.parseInt(line.substring(s + 1));
      System.out.println("Case #" + (i + 1) + ": " + count(a, b));
    }
    br.close();
  }

  public static void main(String[] args) throws Exception {
    new C().main2(args);
  }


}

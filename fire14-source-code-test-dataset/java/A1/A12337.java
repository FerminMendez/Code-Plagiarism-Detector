import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;


public class B {

  void main2(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new FileReader(args[0]));
    String line = br.readLine();
    int count = Integer.parseInt(line);
    for (int i = 0; i < count; i++) {
      line = br.readLine();

      // 3 1 5 15 13 11
      StringTokenizer st = new StringTokenizer(line, " ", false);
      int n = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      int p = Integer.parseInt(st.nextToken());

      int[] t = new int[n];
      for (int j = 0; j < n; j++) {
        t[j] = Integer.parseInt(st.nextToken());
      }

      System.out.println("Case #" + (i + 1) + ": " + max(n, s, p, t));
    }
    br.close();
  }


  private int max(int n, int s, int p, int[] t) {
    int max = 0;

    for (int i = 0; i < n; i++) {

      int r = t[i] % 3;
      int k = t[i] / 3;
      int b = 0;
      int bs = 0;
      switch (r) {
      case 0:
        b = k;
        bs = t[i] == 0 ? 0 : k + 1;
        break;
      case 1:
        b = k + 1;
        bs = t[i] == 1 ? -1 : k + 1;
        break;
      case 2:
        b = k + 1;
        bs = k + 2;
      }

      if (b >= p) {
        max++;
      } else if (bs >= p && s > 0) {
        max++;
        s--;
      }

    }
    return max;
  }



  public static void main(String[] args) throws Exception {
    new B().main2(args);
  }
}

import java.io.*;
import java.util.*;

public class Main implements Runnable {
  BufferedReader br;
  StringTokenizer st;
  int n, s, p, ans;
  int[] t;
  
  public class Googler implements Comparable<Googler> {
    int total, a, b, c;
    
    public Googler(int total) {
      this.total = total;
      a = total / 3;
      b = (total - total / 3) / 2;
      c = total - a - b;
    }
    
    public int compareTo(Googler g) {
      return g.total - this.total;
    }
  }
  
  public void run() {
    try {
      br = new BufferedReader(new InputStreamReader(System.in));
      int caseNo = Integer.parseInt(br.readLine());
      
      for (int i = 1; i <= caseNo; i++) {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        t = new int[n];
        Googler[] googler = new Googler[n];
        for (int j = 0; j < n; j++) {
          t[j] = Integer.parseInt(st.nextToken());
          googler[j] = new Googler(t[j]);
        }
        
        Arrays.sort(googler);
        ans = 0;
        for (int j = 0; j < n; j++)
          if (googler[j].c >= p)
            ans++;
        
        for (int j = 0; j < n && s > 0; j++)
          if (googler[j].total > 0 && googler[j].c < p && !((googler[j].a == googler[j].b) && (googler[j].b < googler[j].c))) {
            googler[j].b--;
            googler[j].c++;
            if (googler[j].c == p) {
              ans++;
              s--;
            }
          }
        
        System.out.println("Case #" + i + ": " + ans);
      }
    }
    catch (Exception e) {
    }
  }
  
  public static void main(String[] args) {
    new Thread(new Main()).start();
  }
}

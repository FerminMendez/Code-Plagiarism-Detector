import java.io.*;
import java.util.*;

public class Main implements Runnable {
  Scanner in = new Scanner(System.in);
  HashMap map;
  long[] cnt = new long[2000000];
  
  public Integer[] findPartner(int n) {
    ArrayList<Integer> arr = new ArrayList<Integer>();
    String num = String.valueOf(n);
    for (int i = 1; i < num.length(); i++) {
      String s = num.substring(i);
      s += num.substring(0, i);
      arr.add(Integer.parseInt(s));
    }
    return (Integer[]) arr.toArray(new Integer[arr.size()]);
  }
  
  public void run() {
    int a, b, c, t = in.nextInt();
    long ans;
    
    for (int i = 1; i <= t; i++) {
      a = in.nextInt();
      b = in.nextInt();
      c = 0;
      
      Arrays.fill(cnt, 0);
      map = new HashMap();
      
      for (int j = a; j <= b; j++) {
        if (!map.containsKey(j)) {
          c++;
          Integer[] arr = findPartner(j);
          map.put(j, c);
          for (int k = 0; k < arr.length; k++)
            if (arr[k] >= a && arr[k] <= b)
              map.put(arr[k], c);
        }
      }
      
      for (int j = a; j <= b; j++)
        cnt[(Integer)map.get(j)]++;
      
      ans = 0l;
      for (int j = 1; j <= c; j++)
        ans += (cnt[j] - 1l) * cnt[j] / 2;
      
      System.out.println("Case #" + i + ": " + ans);
    }
  }
  
  public static void main(String[] args) {
    new Thread(new Main()).start();
  }
}
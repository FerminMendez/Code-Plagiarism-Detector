import java.io.*;
import java.util.*;

public class DancingWithGooglers {

  public static class Googlers {

    public int T;
    public int surp;
    public boolean surprising;
    public boolean pSurprising;
    public boolean antiSurprising;
    public boolean pAntiSurprising;

    public Googlers(int T, int surp) {
      this.T = T;
      this.surp = surp;
    }

    public void set(int a, int b, int c) {
      if (c >= 0 && (a + b + c) == T) {
        int diff = (Math.max(a, Math.max(b, c)) - Math.min(a, Math.min(b, c)));
        if (diff <= 2) {
          if (diff == 2) {
            if (a >= surp || b >= surp || c >= surp) {
              pSurprising = true;
            } else {
              surprising = true;
            }
          } else {
            if (a >= surp || b >= surp || c >= surp) {
              pAntiSurprising = true;
            } else {
              antiSurprising = true;
            }
          }
        }
      }
    }
  }

  public static void main(String... args) throws IOException {
//    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    BufferedReader reader = new BufferedReader(new FileReader("B-small-attempt0.in"));
//    PrintWriter writer = new PrintWriter(System.out);
    PrintWriter writer = new PrintWriter("B-small-attempt0.out");

    int len, cases = Integer.parseInt(reader.readLine());
    List<Googlers> satisfied = new ArrayList<Googlers>();
    List<Googlers> unsatisfied = new ArrayList<Googlers>();
    String[] inputs;
    int N, S, p;
    for (int i = 1; i <= cases; i++) {
      inputs = reader.readLine().split(" ");
      p = Integer.parseInt(inputs[1]);
      S = Integer.parseInt(inputs[2]);
      satisfied.clear();
      unsatisfied.clear();
      for (int j = 3; j < inputs.length; j++) {
        int t = Integer.parseInt(inputs[j]);
        Googlers googlers = new Googlers(t, S);

        for (int k = 0; k <= 10; k++) {
          int till = k + 2 > 10 ? 10 : k + 2;
          for (int l = k; l <= till; l++) {
            googlers.set(k, l, (t - (k + l)));
          }
        }
        if (googlers.pAntiSurprising) {
          satisfied.add(googlers);
        } else {
          unsatisfied.add(googlers);
        }
      }
      int pSurprising = 0;
      if (p > 0) {
        for (Iterator<Googlers> iter = unsatisfied.iterator(); iter.hasNext(); ) {
          Googlers googlers = iter.next();
          if (googlers.pSurprising) {
            pSurprising++;
            iter.remove();
            p--;
            if (p <= 0) break;
          }
        }
      }
      if(p > 0){
        for (Iterator<Googlers> iter = unsatisfied.iterator(); iter.hasNext(); ) {
          Googlers googlers = iter.next();
          if (googlers.surprising) {
            iter.remove();
            p--;
            if (p <= 0) break;
          }
        }
      }
      if(p > 0){
        for (Iterator<Googlers> iter = satisfied.iterator(); iter.hasNext(); ) {
          Googlers googlers = iter.next();
          if (googlers.pSurprising) {
            iter.remove();
            pSurprising++;
            p--;
            if (p <= 0) break;
          }
        }
      }
      if(p > 0){
        for (Iterator<Googlers> iter = satisfied.iterator(); iter.hasNext(); ) {
          Googlers googlers = iter.next();
          if (googlers.surprising) {
            iter.remove();
            p--;
            if (p <= 0) break;
          }
        }
      }

      if(p > 0){
        writer.print("Case #" + i + ": 0");
      }else {
        writer.print("Case #" + i + ": " + (satisfied.size() + pSurprising));
      }
      writer.println();
    }
    writer.flush();
  }


}

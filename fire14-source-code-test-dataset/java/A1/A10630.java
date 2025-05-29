import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class GoogleDancers {
   private static final List<Case> cases = new ArrayList<Case>();

   public static void main(String[] args) throws IOException {
      // sanityCheck();
      readInFile("src/resources/dancers/B-small-attempt0.in");
      FileWriter fstream = new FileWriter("src/resources/dancers/B-small-attempt0.ou");
      BufferedWriter out = new BufferedWriter(fstream);

      for (int i = 0; i < cases.size(); i++) {
         String msg = "Case #" + (i + 1) + ": " + cases.get(i).getResult() + "\n";
         out.write(msg);
         System.out.print(msg);
      }
      out.close();
   }

   protected static void readInFile(String path) throws NumberFormatException, IOException {
      DataInputStream in = new DataInputStream(new FileInputStream(path));
      BufferedReader br = new BufferedReader(new InputStreamReader(in));
      int lines = Integer.parseInt(br.readLine());
      for (int i = 0; i < lines; i++) {
         cases.add(new Case(br.readLine()));
      }
      in.close();
   }
}

class Case {
   protected int             N;
   protected int             S;
   protected int             p;
   protected TreeSet<Dancer> dancers = new TreeSet<Dancer>();

   public Case(String line) {
      StringTokenizer tokenizer = new StringTokenizer(line);
      N = Integer.parseInt(tokenizer.nextToken());
      S = Integer.parseInt(tokenizer.nextToken());
      p = Integer.parseInt(tokenizer.nextToken());
      for (int i = 0; i < N; i++) {
         dancers.add(new Dancer(Integer.parseInt(tokenizer.nextToken())));
      }
   }

   public int getResult() {
      System.out.println(this);
      int ctr = 0;
      for (Dancer d : dancers) {
         if (d.expected.max() >= p) {
            ctr += 1;
         } else if ((d.surprising != null) && (d.surprising.max() >= p) && (d.surprising.max() >= d.expected.max()) && (S > 0)) {
            ctr += 1;
            S -= 1;
         }
         System.out.println(d);
      }
      return ctr;
   }

   @Override
   public String toString() {
      return "N=" + N + ", S=" + S + ", p=" + p;
   }
}

class Dancer implements Comparable<Dancer> {
   Triplet expected;
   Triplet surprising;

   protected Dancer(int score) {
      expected = Triplet.expected(score);
      surprising = Triplet.surprising(score);
   }

   protected int max() {
      if (surprising == null) {
         return expected.max();
      } else {
         return Math.max(expected.max(), surprising.max());
      }
   }

   @Override
   public int compareTo(Dancer arg0) {
      if (max() < arg0.max()) {
         return 1;
      } else {
         return -1;
      }
   }

   @Override
   public String toString() {
      return expected.toString() + ", " + surprising;
   }
}

/**
 * "Note: this class has a natural ordering that is inconsistent with equals."
 */
class Triplet implements Comparable<Triplet> {
   protected boolean isSurprising = false;
   protected int     t1, t2, t3;

   protected Triplet(int t1, int t2, int t3) {
      this.t1 = t1;
      this.t2 = t2;
      this.t3 = t3;
      isSurprising = (Math.abs(t1 - t2) >= 2) || (Math.abs(t2 - t3) >= 2) || (Math.abs(t1 - t3) >= 2);
   }

   protected static Triplet expected(int score) {
      if (score == 0) {
         return new Triplet(0, 0, 0);
      } else if (score % 3 == 0) {
         return new Triplet(score / 3, score / 3, score / 3);
      } else if (score % 3 == 1) {
         return new Triplet(score / 3, score / 3, score / 3 + 1);
      } else {
         return new Triplet(score / 3, score / 3 + 1, score / 3 + 1);
      }
   }

   protected static Triplet surprising(int score) {
      if (score < 2) {
         return null;
      } else if (score % 3 == 0) {
         return new Triplet(score / 3 - 1, score / 3, score / 3 + 1);
      } else if (score % 3 == 1) {
         return new Triplet(score / 3 - 1, score / 3 + 1, score / 3 + 1);
      } else {
         return new Triplet(score / 3, score / 3, score / 3 + 2);
      }
   }

   public int max() {
      return Math.max(t1, Math.max(t2, t3));
   }

   @Override
   public int compareTo(Triplet arg0) {
      if (max() < arg0.max()) {
         return 1;
      } else {
         return -1;
      }
   }

   @Override
   public String toString() {
      return String.format("(%s, %s, %s) %s [Total=%s]", t1, t2, t3, ((isSurprising) ? "*" : " "), (t1 + t2 + t3));
   }
}